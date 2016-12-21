package com.film.producer.response;

import java.util.List;

public class FilmResponse {

    private final long filmId;
    private final String title;
    private final List<ActorResponse> actors;

    private FilmResponse(final Builder builder) {
        this.filmId = builder.filmId;
        this.title = builder.title;
        this.actors = builder.actors;
    }

    public static final class Builder {

        private long filmId;
        private String title;
        private List<ActorResponse> actors;

        public FilmResponse build() {
            return new FilmResponse(this);
        }

        public Builder withFilmId(long filmId) {
            this.filmId = filmId;
            return this;
        }

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withActors(List<ActorResponse> actors) {
            this.actors = actors;
            return this;
        }
    }

    public long getFilmId() {
        return filmId;
    }

    public String getTitle() {
        return title;
    }

    public List<ActorResponse> getActors() {
        return actors;
    }
}
