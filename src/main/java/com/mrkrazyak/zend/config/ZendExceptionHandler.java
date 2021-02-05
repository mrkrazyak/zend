package com.mrkrazyak.zend.config;

import com.mrkrazyak.zend.entity.response.ErrorMessage;
import com.mrkrazyak.zend.entity.response.ZendResponse;
import com.mrkrazyak.zend.exceptions.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ZendExceptionHandler {

    Logger logger = LoggerFactory.getLogger(ZendExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ZendResponse> handleAllExceptions(Exception ex) {
        logger.error("Unhandled Exception encountered", ex);
        ZendResponse response = new ZendResponse();
        response.setError(new ErrorMessage("Internal Server Error"));
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<ZendResponse> handleNotFoundException(NotFoundException ex) {
        ZendResponse response = new ZendResponse();
        response.setError(new ErrorMessage("Resource not found: " + ex.getLocalizedMessage()));
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
