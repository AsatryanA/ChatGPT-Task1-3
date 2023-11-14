package com.example.chatgpt_task123.exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(Class<?> entityClass, Long entityId) {
        super(entityClass.getSimpleName() + " not found with id: " + entityId);
    }
}
