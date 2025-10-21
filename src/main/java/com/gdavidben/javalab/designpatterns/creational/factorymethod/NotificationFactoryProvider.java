package com.gdavidben.javalab.designpatterns.creational.factorymethod;

import com.gdavidben.javalab.designpatterns.creational.factorymethod.email.EmailNotificationFactory;
import com.gdavidben.javalab.designpatterns.creational.factorymethod.sms.SmsNotificationFactory;

public class NotificationFactoryProvider {

    private NotificationFactoryProvider() {
    }

    public static NotificationFactory getFactory(final NotificationType type) {
        return switch (type) {
            case EMAIL -> new EmailNotificationFactory();
            case SMS -> new SmsNotificationFactory();
        };
    }
}
