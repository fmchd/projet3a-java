package com.company;

public class Electromenager extends Article{
    private String dureeFonctionnement;
    private boolean assurance;
    private boolean sortiCarton;

    Electromenager(String nom, float prix, int tauxSolde, String dureeFonctionnement, boolean assurance){
        super(nom, prix, tauxSolde);
        this.dureeFonctionnement = dureeFonctionnement;
        this.assurance = assurance;
        this.sortiCarton = false;
    }
}
