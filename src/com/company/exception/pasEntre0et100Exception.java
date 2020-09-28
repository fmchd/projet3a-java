package com.company.exception;

public class pasEntre0et100Exception extends Exception {

    public pasEntre0et100Exception(){
        super();
        System.out.println("La valeur entrée n'est pas comprise entre 0 et 100.");
    }
}
