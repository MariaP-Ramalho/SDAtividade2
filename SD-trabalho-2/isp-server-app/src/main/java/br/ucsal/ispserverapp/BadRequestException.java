package br.ucsal.ispserverapp;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}