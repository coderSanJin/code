package com.sanjin.custom_exception.exercise;

public class MyException extends Exception{

    String message;

    public MyException(String ErrorMessage){
        message = ErrorMessage;
    }
}
