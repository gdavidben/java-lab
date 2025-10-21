package com.gdavidben.javalab.designpatterns.creational.factorymethod;

import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void test() {
        final var factory = NotificationFactoryProvider.getFactory(NotificationType.EMAIL);
        final var notification = factory.createNotification();

        notification.notifyUser();
    }
}
