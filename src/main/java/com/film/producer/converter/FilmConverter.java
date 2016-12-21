package com.film.producer.converter;

import com.film.producer.core.model.data.FilmData;
import com.film.producer.response.FilmResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FilmConverter {

    @Autowired
    private ActorConverter actorConverter;

    public List<FilmResponse> convert(final List<FilmData> films) {
        final List<FilmResponse> filmsResponse;
        if(films != null && films.size() > 0) {
            filmsResponse = new ArrayList<>(films.size());
            for(final FilmData film: films) {
                final FilmResponse filmResponse = new FilmResponse.Builder()
                        .withFilmId(film.getFilmId())
                        .withTitle(film.getTitle())
                        .withActors(actorConverter.converter(film.getActors()))
                        .build();
                filmsResponse.add(filmResponse);
            }
        } else {
            filmsResponse = new ArrayList<>(0);
        }
        return filmsResponse;
    }
}
