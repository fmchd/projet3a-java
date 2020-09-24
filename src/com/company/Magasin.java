package com.company;

import java.util.ArrayList;

public class Magasin {
    private String nom;
    private String adresse;
    private int nbrVendeurs;
    private ArrayList<Article> articles;
    private float caisse;

    Magasin(String nom, String adreese, int nbrVendeurs, float caisse){
        this.nom = nom;
        this.adresse = adreese;
        this.nbrVendeurs = nbrVendeurs;
        this.caisse = caisse;
        this.articles = new ArrayList<Article>();
    }

    public String getNom() {
        return nom;
    }
}