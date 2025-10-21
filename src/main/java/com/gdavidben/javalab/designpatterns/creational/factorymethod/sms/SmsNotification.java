package com.gdavidben.javalab.designpatterns.creational.factorymethod.sms;

import com.gdavidben.javalab.designpatterns.creational.factorymethod.Notification;

public class SmsNotification implements Notification {

    @Override
    public void notifyUser() {
        IO.println("Sending a SMS notification.");
    }
}
