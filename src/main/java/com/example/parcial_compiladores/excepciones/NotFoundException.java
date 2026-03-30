package com.example.parcial_compiladores.excepciones;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message){
        super(message);
    }
}