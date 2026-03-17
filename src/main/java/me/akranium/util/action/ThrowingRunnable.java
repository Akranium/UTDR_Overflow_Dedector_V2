package me.akranium.util.action;

@FunctionalInterface
public interface ThrowingRunnable {
    void run() throws Exception;
}
