package com.varNcremenet.authenticateservice.exception;

public class UserException extends Exception{

    public UserException(String ex){
        super(ex);
    }

    public UserException(String ex, Throwable err){
        super(ex,err);
    }

}
