package com.gdavidben.javalab.designpatterns.creational.factorymethod.sms;

import com.gdavidben.javalab.designpatterns.creational.factorymethod.Notification;
import com.gdavidben.javalab.designpatterns.creational.factorymethod.NotificationFactory;

public class SmsNotificationFactory extends NotificationFactory {

    @Override
    public Notification createNotification() {
        return new SmsNotification();
    }
}
