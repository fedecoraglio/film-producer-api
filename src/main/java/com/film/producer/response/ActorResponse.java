package com.film.producer.response;

public class ActorResponse {

    private final long id;

    private final String firstName;

    private final String lastName;

    public ActorResponse(final Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }

    public static final class Builder {
        private long id;
        private String firstName;
        private String lastName;

        public ActorResponse build() {
            return new ActorResponse(this);
        }
        public Builder withId(long id) {
            this.id = id;
            return this;
        }

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
