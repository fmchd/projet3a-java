package com.company;

public class Habit extends Article{
    private String provenance;
    Habit(String nom, float prix, int tauxSolde, String provenance){
        super(nom, prix, tauxSolde);
        this.provenance = provenance;
    }
}
