package com.film.producer.response;

public class Error {

    private final String code;
    private final String message;

    public Error(final Builder builder) {
        this.code = builder.code;
        this.message = builder.message;
    }

    public static final class Builder {
        private String code;
        private String message;

        public Error build() {
            return new Error(this);
        }

        public Builder withCode(String code) {
            this.code = code;
            return this;
        }

        public Builder withMessage(String message) {
            this.message = message;
            return this;
        }
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
