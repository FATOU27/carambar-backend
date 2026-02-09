package com.Carambar.Carambar.exception;

public class BlagueNotFoundException extends RuntimeException {
    public BlagueNotFoundException(Long id) {
        super("Blague introuvable avec l'id : " + id);
    }
}
