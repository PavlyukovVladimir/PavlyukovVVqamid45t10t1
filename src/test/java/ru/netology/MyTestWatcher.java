package ru.netology;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class MyTestWatcher implements TestWatcher {
    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        System.out.print("Тест " + context.getTestClass().get().getName() + "#" + context.getTestMethod().get().getName() + " был отменен!\uD83D\uDE4C\"");
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        System.out.println("Тест " + context.getTestClass().get().getName() + "#" + context.getTestMethod().get().getName() + " пройден!\uD83D\uDC4C");
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        System.out.println("Тест " + context.getTestClass().get().getName() + "#" + context.getTestMethod().get().getName() + " был прерван!\uD83E\uDD37");
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        System.out.println("Тест " + context.getTestClass().get().getName() + "#" + context.getTestMethod().get().getName() + " был провален!\uD83D\uDC4E");
    }
}
