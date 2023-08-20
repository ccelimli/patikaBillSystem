package com.patika.utilities.results;

public class Result {
    private Boolean success;
    private String message;

    public Result(Boolean success){
        this.success=success;
    }

    public Result(String message){
        this.message=message;
    }

    public Result (Boolean success, String message){
        this.success=success;
        this.message=message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
