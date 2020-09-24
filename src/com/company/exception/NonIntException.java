package com.company.exception;

public class NonIntException extends Exception {

    NonIntException()
    {
        super();
        System.out.println("Veuillez entrez un entier");
    }
}
