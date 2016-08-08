package ua.skillsup.gelius.controllers;

import java.util.List;

public class JSONResponse {

    private String code;
    private String message;
    private Object result;

    public JSONResponse() {
        this.code = "";
        this.message = "";
        this.result = "";
    }

    public JSONResponse(String code, String message, Object result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public JSONResponse(String code, String message) {
        this.code = code;
        this.message = message;
        this.result = "";
    }

    public <T> JSONResponse(List<T> result, String listName) {
        if (result.isEmpty()) {
            this.code = "204";
            this.message = "List of " + listName + " is empty!";
            this.result = "";
        } else {
            this.code = "200";
            this.message = "OK!";
            this.result = result;
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
