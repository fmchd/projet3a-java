package com.company.eleve;

import java.util.ArrayList;

public class EleveDigital extends Eleve {

    private ArrayList<Note> notes;

    EleveDigital(String ine, int promo, int annee, String nom, String prenom){
        super(ine, promo, annee, nom, prenom);
    }

    public void ajouteNote(Note note){
        this.notes.add(note);
    }

    public boolean aToutValide() {
        for (int i = 0; i < notes.size(); i++) {
            if (!notes.get(i).getValidation())
                return false;
        }
        return true;
    }

    public int totalCreditsObtenus(){
        int credits = 0;
        for (int i = 0 ; i < notes.size() ; i++){
            if (notes.get(i).getValidation())
                credits += notes.get(i).getNbreCredits();
        }
        return credits;
    }




}



