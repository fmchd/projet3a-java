package com.company;

public class NonIntException extends Exception {

    NonIntException()
    {
        super();
        System.out.println("Veuillez entrez un entier");
    }
}
