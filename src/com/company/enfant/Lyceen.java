package com.company.enfant;

public class Lyceen extends Enfant implements IScolaire {

    private final static String[] tableau = {"2nd", "1ere", "Terminale"};
    private String niveau;
    private boolean examen;

    Lyceen(String nom, String prenom) {
        super(nom, prenom);
    }

    Lyceen(String nom, String prenom, String niveau) {
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
