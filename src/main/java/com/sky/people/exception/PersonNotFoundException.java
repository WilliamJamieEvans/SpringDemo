package com.sky.people.exception;
//this page is for 404

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Person not found with that id")
public class PersonNotFoundException extends RuntimeException {

}
