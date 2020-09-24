package com.company.personne;

public class IATOS extends Personnel {
    private float fixe;
    private float heureSupp;
    private final static float taux = 1.2f;

    IATOS(String dateEntree, float tempsTravail, String nom, String prenom, float fixe, float heureSupp){
        super(dateEntree, tempsTravail, nom, prenom);
        this.fixe = fixe;
        this.heureSupp = heureSupp;
    }

    @Override
    public float calculSalaire() {
        return this.fixe + this.taux * this.heureSupp * this.taux;
    }
}
