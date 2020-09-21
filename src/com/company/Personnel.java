package com.company;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


abstract class Personnel extends Personne{

    protected String dateEntrée;
    protected float tempsTravail;

    Personnel(String dateEntree, float tempsTravail, String nom, String prenom){
        super(nom, prenom);
        this.dateEntrée = dateEntree;
        this.tempsTravail = tempsTravail;
    }

    public abstract float calculSalaire();

}
