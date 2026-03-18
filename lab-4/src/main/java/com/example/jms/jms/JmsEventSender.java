package com.example.jms.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class JmsEventSender {
    private final JmsTemplate jmsTemplate;

    @Autowired
    public JmsEventSender(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendEvent(String topic, Object event) {
        jmsTemplate.convertAndSend(topic, event);
    }
}