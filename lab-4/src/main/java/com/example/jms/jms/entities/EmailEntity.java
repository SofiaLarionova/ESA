package com.example.jms.jms.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "emails")
public class EmailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "recipient", nullable = false)
    private String to;

    @Column(nullable = false)
    private String body;

    public EmailEntity() {
    }

    public EmailEntity(String to, String body) {
        this.to = to;
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "EmailEntity{" +
                "id=" + id +
                ", to='" + to + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}