package com.company.personne;


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
