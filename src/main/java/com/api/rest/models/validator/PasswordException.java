package com.api.rest.models.validator;

public class PasswordException extends Exception {
    public PasswordException() {
        super("Password invalida: debe tener letra Mayuscula, letras minúsculas y dos numeros");
    }
    public PasswordException(String message) {
        super("Password invalida: debe tener letra Mayuscula, letras minúsculas y dos numeros : "+message);
    }
}
