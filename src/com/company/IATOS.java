package com.company;

public class IATOS extends Personnel {
    private float fixe;
    private float heureSupp;
    private float taux;

    IATOS(String dateEntree, float tempsTravail, String nom, String prenom, float fixe, float heureSupp, float taux){
        super(dateEntree, tempsTravail, nom, prenom);
        this.fixe = fixe;
        this.heureSupp = heureSupp;
        this.taux = taux;
    }

    @Override
    public float calculSalaire() {
        return this.fixe + this.taux * this.heureSupp;
    }
}
