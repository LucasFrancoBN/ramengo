package com.rvbrasil.ramengo.ramengo.exceptions.handlerException;

import com.rvbrasil.ramengo.ramengo.exceptions.ErrorException;
import com.rvbrasil.ramengo.ramengo.exceptions.ForbiddenException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerException {
  @ExceptionHandler(ErrorException.class)
  public ResponseEntity<ErrorException> errorException(ErrorException e) {
    HttpStatus status = HttpStatus.BAD_REQUEST;
    return ResponseEntity.status(status).body(e);
  }

  @ExceptionHandler(AssertionError.class)
  public ResponseEntity<AssertionError> customAssertionException(AssertionError e) {
    HttpStatus status = HttpStatus.BAD_REQUEST;
    return ResponseEntity.status(status).body(e);
  }

  @ExceptionHandler(ForbiddenException.class)
  public ResponseEntity<ForbiddenException> forbiddenException(ForbiddenException e) {
    HttpStatus status = HttpStatus.FORBIDDEN;
    return ResponseEntity.status(status).body(e);
  }
}
