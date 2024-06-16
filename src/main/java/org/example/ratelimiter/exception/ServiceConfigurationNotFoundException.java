package org.example.ratelimiter.exception;

public class ServiceConfigurationNotFoundException extends RuntimeException {
    String message;

    public ServiceConfigurationNotFoundException(String message1) {
        this.message = message1;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
