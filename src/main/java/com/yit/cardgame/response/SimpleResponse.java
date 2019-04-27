package com.yit.cardgame.response;

public class SimpleResponse {
    private String id;
    private int code;
    private String message;

    public SimpleResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public SimpleResponse(String id, int code, String message) {
        this.id = id;
        this.code = code;
        this.message = message;
    }
}
