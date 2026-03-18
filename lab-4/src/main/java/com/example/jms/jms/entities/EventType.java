package com.example.jms.jms.entities;

public enum EventType {
    SAVE,
    DELETE;

    public boolean is(String typeName) {
        return typeName.contains(name().toLowerCase());
    }
}