package com.piloto.autenticacao.error;

public class ExceptionDetails {

    private String message;

    public ExceptionDetails() {
    }

    public String getMessage() {
        return message;
    }

    public static final class ExceptionDetailsBuilder {
        private String message;

        private ExceptionDetailsBuilder() {
        }

        public static ExceptionDetailsBuilder newBuilder() {
            return new ExceptionDetailsBuilder();
        }

        public ExceptionDetailsBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ExceptionDetails build() {
            ExceptionDetails exceptionDetails = new ExceptionDetails();
            exceptionDetails.message = this.message;
            return exceptionDetails;
        }
    }

}
