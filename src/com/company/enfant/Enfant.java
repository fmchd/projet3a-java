package com.company.enfant;

import com.company.personne.Personne;

public class Enfant {

    protected String nom;
    protected String prenom;
    protected int anneeNaissance;
    protected char sexe;
    protected int deptNaissance;
    protected Personne parent;
    protected float argentPoche;


    Enfant(String nom, String prenom, int anneeNaissance, char sexe, int deptNaissance){
        this.nom = nom;
        this.prenom = prenom;
        this.anneeNaissance = anneeNaissance;
        this.sexe = sexe;
        this.deptNaissance = deptNaissance;
        this.parent = null;
        this.argentPoche = 0;
    }

    Enfant(String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;
        this.anneeNaissance = 1800;
        this.sexe = ' ';
        this.deptNaissance = 0;
    }

    public int age(){
        return 2020 - anneeNaissance;
    }

    public void setParent(Personne parent) {
        this.parent = parent;
    }

    public void recevoirArgent(Personne parent, float montant){
        if(this.parent.equals(parent)){
            parent.getCompteBanq().paiement(montant);
            this.argentPoche += montant;
        }
    }

    public void paiement(float montant){
        if(this.argentPoche > montant){
            this.argentPoche -= montant;
        }
    }
}
