package com.film.producer.controller;

import com.film.producer.converter.FilmConverter;
import com.film.producer.core.service.FilmService;
import com.film.producer.response.FilmResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/films")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @Autowired
    private FilmConverter filmConverter;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FilmResponse>> getFilms() {
        final List<FilmResponse> films = filmConverter.convert(filmService.getAllFilms());
        return new ResponseEntity<>(films, HttpStatus.OK);
    }
}
