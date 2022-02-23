package com.semtec.api;

public class TermoNotFoundException extends RuntimeException {
    TermoNotFoundException(Long id) {
        super("Termo não encontrado com o ID " + id);
    }
}
