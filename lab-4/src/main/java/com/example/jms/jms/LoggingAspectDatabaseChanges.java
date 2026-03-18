package com.example.jms.jms;

import com.example.jms.jms.entities.EmailEntity;
import com.example.jms.jms.entities.EventType;
import com.example.jms.jms.entities.WatchDogEntity;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
public class LoggingAspectDatabaseChanges {
    private final JmsEventSender jmsEventSender;

    public LoggingAspectDatabaseChanges(JmsEventSender jmsEventSender) {
        this.jmsEventSender = jmsEventSender;
    }

    private void sendJmsEvent(String name, String retVal) {
        EventType eventType = determineEventType(name);
        if (eventType != null) {
            WatchDogEntity event = new WatchDogEntity(retVal, eventType);
            EmailEntity email = new EmailEntity("test@example.ru",
                    String.format("EventType: %s, Value: %s", eventType.name(), retVal));
            jmsEventSender.sendEvent("event", event);
            jmsEventSender.sendEvent("email", email);
        }
    }

    private EventType determineEventType(String methodName) {
        if (EventType.SAVE.is(methodName)) {
            return EventType.SAVE;
        } else if (EventType.DELETE.is(methodName)) {
            return EventType.DELETE;
        }
        return null;
    }

    @AfterReturning(pointcut = "execution(* com.example.jms.repository.*Repository.*(..))", returning = "retVal")
    public void trackDatabaseBookChanges(JoinPoint joinPoint, Object retVal) {
        String changeDetails = formatMethodDetails(joinPoint, retVal != null ? retVal.toString() : null);
        String methodName = joinPoint.getSignature().getName();
        sendJmsEvent(methodName, changeDetails);
    }

    public static String formatMethodDetails(JoinPoint joinPoint, Object returnValue) {
        String arguments = Arrays.stream(joinPoint.getArgs())
                .map(arg -> arg != null ? arg.toString() : "null")
                .collect(Collectors.joining(", "));

        String returnVal = returnValue != null ? returnValue.toString() : "null";

        return String.format("Arguments: [%s], Return Value: %s", arguments, returnVal);
    }
}