package com.film.producer.converter;

import com.film.producer.core.model.data.ActorData;
import com.film.producer.response.ActorResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public final class ActorConverter {

    public List<ActorResponse> converter(final List<ActorData> actorsData) {
        final List<ActorResponse> actors;
        if(actorsData != null && actorsData.size() > 0) {
            actors = new ArrayList<>(actorsData.size());
            for(final ActorData actorData: actorsData) {
                actors.add(new ActorResponse.Builder()
                        .withId(actorData.getId())
                        .withFirstName(actorData.getFirstName())
                        .withLastName(actorData.getLastName())
                        .build());
            }
        } else {
            actors = new ArrayList<>(0);
        }
        return actors;
    }

    public ActorResponse converter(final ActorData actorData) {
        ActorResponse actor = null;
        if(actorData != null) {
            actor = new ActorResponse.Builder().
                    withId(actorData.getId())
                    .withFirstName(actorData.getFirstName())
                    .withLastName(actorData.getLastName())
                    .build();
        }
        return actor;
    }
}
