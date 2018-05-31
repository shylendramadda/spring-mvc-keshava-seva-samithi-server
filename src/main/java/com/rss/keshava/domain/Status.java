package com.rss.keshava.domain;

public class Status {

    private String message;
    private int code;
    private Long entityId;
    private Object entity;

    public Status(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Status(int code, String message, Long entityId, Object entity) {
        this.code = code;
        this.message = message;
        this.entityId = entityId;
        this.entity = entity;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public Object getEntity() {
        return entity;
    }

    public void setEntity(Object entity) {
        this.entity = entity;
    }
}
