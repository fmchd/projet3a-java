package com.company.exception;

public class pasDeCompteBancaireException extends Exception {
    public pasDeCompteBancaireException(){
        super();
        System.out.println("La personne n'a pas de compte bancaire. Ouvrez lui en un pour effectuer une telle action");
    }
}
