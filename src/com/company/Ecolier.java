package com.company;

public class Ecolier extends Enfant implements Scolaire{

    private final static String[] tableau = {"CP", "CE1", "CE2", "CM1", "CM2"};
    private String niveau;

    Ecolier(String nom, String prenom){
        super(nom,prenom);
    }

    Ecolier(String nom, String prenom, String niveau){
        super(nom,prenom);
        this.niveau = niveau;
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
