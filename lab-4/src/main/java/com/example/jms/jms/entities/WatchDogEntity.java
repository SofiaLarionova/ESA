package com.example.jms.jms.entities;

import jakarta.persistence.*;
import org.springframework.util.Assert;

@Entity
@Table(name = "events")
public class WatchDogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String object;

    @Enumerated(EnumType.STRING)
    private EventType eventType;

    public WatchDogEntity() {

    }

    public WatchDogEntity(String object, EventType eventType) {
        Assert.notNull(eventType, "object must not be null");
        this.object = object;
        this.eventType = eventType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    @Override
    public String toString() {
        return "WatchDogEntity{" +
                "id=" + id +
                ", object='" + object + '\'' +
                ", eventType=" + eventType +
                '}';
    }
}