package com.sandeep.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by abhishek on 11/3/18.
 */
// Exception(Checked) || Error(Unchecked) Read!
//Constructor Chaining Read !
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends Exception {
    public NotFoundException(String message) {
        super(message);
    }
}
