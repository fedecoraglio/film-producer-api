package com.film.producer.controller;

import com.film.producer.converter.ActorConverter;
import com.film.producer.core.model.data.ActorData;
import com.film.producer.core.service.ActorService;
import com.film.producer.exception.FilmProducerApiException;
import com.film.producer.request.CreateActorData;
import com.film.producer.response.ActorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/actors")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @Autowired
    private ActorConverter actorConverter;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ActorResponse>> getAllActors() throws FilmProducerApiException {
        final List<ActorResponse> actors;
        try {
            actors = actorConverter.converter(actorService.getAll());
        } catch (final Exception ex) {
            ex.printStackTrace();
            throw new FilmProducerApiException(FilmProducerApiException.ExceptionTypeData.ACTOR_NOY_FOUND);
        }
        return new ResponseEntity<>(actors, HttpStatus.OK);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ActorResponse> getActorById(@PathVariable final long id) {
        final ActorData actorData = actorService.getById(id);
        final ActorResponse actor = actorConverter.converter(actorData);
        return new ResponseEntity<>(actor, HttpStatus.OK);
    }


    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ActorResponse> updateActor(@PathVariable final long id,
                                                     @RequestBody final CreateActorData createActorData) {
        final ActorData actorData = actorService.updateActor(id, createActorData.getFirstName(),
                createActorData.getLastName());
        final ActorResponse actor = actorConverter.converter(actorData);
        return new ResponseEntity<>(actor, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ActorResponse> createActor(@RequestBody final CreateActorData createActorData) {
        final ActorData actorData = actorService.saveActor(createActorData.getFirstName(), createActorData.getLastName());
        final ActorResponse actor = actorConverter.converter(actorData);;
        return new ResponseEntity<>(actor, HttpStatus.OK);
    }
}