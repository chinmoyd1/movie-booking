package com.varNcrement.notificationservice.dao;

import com.varNcrement.notificationservice.document.Notification;

import java.util.List;

public interface NotificationDAO<T, I> {

    public void create(T t);

    public List<Notification> getAll();
}
