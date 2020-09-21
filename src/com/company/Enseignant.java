package com.company;

public class Enseignant extends Personnel {

    private float fixe;
    private String echelon;
    final private float prime = 1000;
    private int heureSupp;
    private int decharges;

    Enseignant(String dateEntree, float tempsTravail, float fixe, String echelon, int heureSupp, int decharges, String nom, String prenom){
        super(dateEntree, tempsTravail, nom, prenom);
    }

    @Override
    public float calculSalaire() {
        float salaire = fixe;

        return salaire;
    }
}
