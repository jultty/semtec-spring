package com.semtec.api;

public class TermoNotFoundException extends RuntimeException {
    TermoNotFoundException(Integer id) {
        super("Termo não encontrado com o ID " + id);
    }
}
