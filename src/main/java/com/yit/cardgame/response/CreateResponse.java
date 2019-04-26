package com.yit.cardgame.response;

public class CreateResponse {
    private String id;
    private int code;
    private String message;

    public CreateResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public CreateResponse(String id, int code, String message) {
        this.id = id;
        this.code = code;
        this.message = message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
