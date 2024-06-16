package org.example.dto;

public class BaseResponse {

    String message;

    public BaseResponse(String message) {

        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
