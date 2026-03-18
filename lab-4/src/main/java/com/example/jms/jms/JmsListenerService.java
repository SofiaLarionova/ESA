package com.example.jms.jms;

import com.example.jms.jms.entities.EmailEntity;
import com.example.jms.jms.entities.WatchDogEntity;
import com.example.jms.jms.repository.EmailRepository;
import com.example.jms.jms.repository.WatchDogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class JmsListenerService {
    private static final Logger logger = LoggerFactory.getLogger(JmsListenerService.class);
    private final EmailRepository emailRepository;

    private final WatchDogRepository watchDogRepository;

    public JmsListenerService(EmailRepository emailRepository, WatchDogRepository watchDogRepository) {
        this.emailRepository = emailRepository;
        this.watchDogRepository = watchDogRepository;
    }


    @JmsListener(destination = "email")
    public void receiveEmail(EmailEntity email) {
        logger.info("Received email: {}", email);
        emailRepository.save(email);
    }

    @JmsListener(destination = "event")
    public void receiveWatcherEvent(WatchDogEntity event) {
        logger.info("Received event: {}", event);
        watchDogRepository.save(event);
    }
}