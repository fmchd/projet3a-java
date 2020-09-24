package com.company.eleve;

public class Note {

    private String intitule;
    private float note;
    private int nbreCredits;
    private boolean validation;

    Note(String intitule, float note, int nbreCredits){
        this.intitule = intitule;
        this.note = note;
        this.nbreCredits = nbreCredits;
        this.validation = note > 10;
    }

    public boolean getValidation() {
        return validation;
    }

    public int getNbreCredits() {
        return nbreCredits;
    }
}
