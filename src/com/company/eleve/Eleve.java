package com.company.eleve;

import com.company.personne.Personne;

public class Eleve extends Personne {

    private String ine;
    private int promo;
    private int annee;



    Eleve(String ine, int promo, int annee, String nom, String prenom){
        super(nom, prenom);
        this.ine = ine;
        this.promo = promo;
        this.annee = annee;

    }

    @Override
    public String toString() {
        return "Eleve{" +
                "ine='" + ine + '\'' +
                ", promo=" + promo +
                ", annee=" + annee +
                '}';
    }

}
