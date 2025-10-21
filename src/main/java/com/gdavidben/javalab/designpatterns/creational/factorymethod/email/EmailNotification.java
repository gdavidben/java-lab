package com.gdavidben.javalab.designpatterns.creational.factorymethod.email;

import com.gdavidben.javalab.designpatterns.creational.factorymethod.Notification;

public class EmailNotification implements Notification {

    @Override
    public void notifyUser() {
        IO.println("Sending an E-mail notification.");
    }
}
