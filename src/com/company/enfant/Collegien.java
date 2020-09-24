package com.company.enfant;

public class Collegien extends Enfant implements IScolaire {

    private final static String[] tableau = {"6eme", "5eme", "4eme", "3eme"};
    private String niveau;
    private boolean examen;

    Collegien(String nom, String prenom) {
        super(nom, prenom);
    }

    Collegien(String nom, String prenom, String niveaux, boolean examen) {
        super(nom, prenom);
        this.niveau = niveau;
        this.examen = grand();
    }

    @Override
    public boolean petit() {
        return this.niveau == this.tableau[0];
    }

    @Override
    public boolean moyen() {
        return !(petit() || grand());
    }

    @Override
    public boolean grand() {
        return this.niveau == this.tableau[this.tableau.length-1];
    }
}