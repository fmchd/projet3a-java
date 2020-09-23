package com.company;

public class Primeur extends Article{
    private String[] nutriments;
    private float kilo;

    Primeur(String nom, float prix, int tauxSolde, String[] nutriments){
        super(nom, prix, tauxSolde);
        this.nutriments = nutriments;
    }
}
