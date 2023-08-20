package com.patika.utilities.results;

public class SuccessDataResult<T> extends DataResult<T> {
    public SuccessDataResult(T data){
        super(true,data);
    }

    public SuccessDataResult(T data, String message){
        super(true,message,data);
    }

    public SuccessDataResult(String message){
        super(true,message,null);
    }

    public SuccessDataResult(boolean success, String message, T data){
        super(true, message, data);
    }
}
