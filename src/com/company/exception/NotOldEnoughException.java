package com.company.exception;

public class NotOldEnoughException extends Exception {

    public NotOldEnoughException()
    {
        super();
        System.out.println("La personne n'est pas assez agée pour effectuer cette action");
    }
}
