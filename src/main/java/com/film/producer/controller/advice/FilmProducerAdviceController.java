package com.film.producer.controller.advice;

import com.film.producer.core.model.exception.ActorException;
import com.film.producer.exception.FilmProducerApiException;
import com.film.producer.response.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Properties;

@ControllerAdvice
public class FilmProducerAdviceController {

    @Autowired
    private Properties errorProperties;

    @ExceptionHandler(FilmProducerApiException.class)
    @ResponseBody
    public ResponseEntity<Error> handleFilmProducerApiException(final FilmProducerApiException ex) {
        final Error error = new Error.Builder()
                .withCode(errorProperties.getProperty(ex.getExceptionTypeData().getCode()))
                .withMessage(errorProperties.getProperty(ex.getExceptionTypeData().getDescription())).build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ActorException.class)
    @ResponseBody
    public ResponseEntity<Error> handleFilmProducerApiException(final ActorException ex) {
        final Error error = new Error.Builder()
                .withCode(errorProperties.getProperty(ex.getType().getCode()))
                .withMessage(errorProperties.getProperty(ex.getType().getDescription())).build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
