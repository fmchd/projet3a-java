package com.company.enfant;

public class Enfant {

    private String nom;
    private String prenom;
    private int anneeNaissance;
    private char sexe;
    private int deptNaissance;

    Enfant(String nom, String prenom, int anneeNaissance, char sexe, int deptNaissance){
        this.nom = nom;
        this.prenom = prenom;
        this.anneeNaissance = anneeNaissance;
        this.sexe = sexe;
        this.deptNaissance = deptNaissance;
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

}
