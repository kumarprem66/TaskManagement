package com.placement.crash.TastManagement.exception;

import com.placement.crash.TastManagement.entity.User;

public class UserException extends RuntimeException{

    public UserException(String message){
        super(message);
    }
}
