package com.varNcrement.notificationservice.document;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Notification {

    private String id;
    private String state;
    private Date date;
    private String message;

    public Notification(String id, String state, Date date, String message) {
        this.id = id;
        this.state = state;
        this.date = date;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
