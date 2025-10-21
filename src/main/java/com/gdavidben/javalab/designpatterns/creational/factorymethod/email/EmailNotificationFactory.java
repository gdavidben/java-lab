package com.gdavidben.javalab.designpatterns.creational.factorymethod.email;

import com.gdavidben.javalab.designpatterns.creational.factorymethod.Notification;
import com.gdavidben.javalab.designpatterns.creational.factorymethod.NotificationFactory;

public class EmailNotificationFactory extends NotificationFactory {

    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}
