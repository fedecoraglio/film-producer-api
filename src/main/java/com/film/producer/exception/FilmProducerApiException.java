package com.film.producer.exception;

public class FilmProducerApiException extends RuntimeException {

    private final ExceptionTypeData exceptionTypeData;

    public FilmProducerApiException(final ExceptionTypeData exceptionTypeData) {
        this.exceptionTypeData = exceptionTypeData;
    }

    public ExceptionTypeData getExceptionTypeData() {
        return exceptionTypeData;
    }

    public enum ExceptionTypeData {
        ACTOR_NOY_FOUND("actor.not.found");

        private final String messagePrefixKey;

        ExceptionTypeData(final String messageKey) {
            this.messagePrefixKey = messageKey;
        }

        public String getCode() {
            return this.messagePrefixKey + ".code";
        }

        public String getDescription() {
            return this.messagePrefixKey + ".description";
        }

    }
}
