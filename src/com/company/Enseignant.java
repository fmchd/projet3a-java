package com.company;

public class Enseignant extends Personnel {

    private String echelon;
    private final float fixe;
    final static private float prime = 1000;
    final static float taux = 1.2f;
    private int decharges;
    private int tempsATravailler;
    private int tempsTravaille;

    Enseignant(String dateEntree, float tempsTravail, String echelon, int decharges, String nom, String prenom, int tempsTravaille){
        super(dateEntree, tempsTravail, nom, prenom);
        this.echelon = echelon;
        if (this.echelon.equals("PRAG"))
        {
            tempsATravailler = 192;
            fixe = 1;
        }
        else if (this.echelon.equals("MDC"))
        {
            tempsATravailler = 384;
            fixe = 2;
        }
        else
        {
            tempsATravailler = 96;
            fixe = 3;
        }
        this.decharges = decharges;
        this.tempsTravaille = tempsTravaille;
    }

    @Override
    public float calculSalaire() {
        float salaire = 0f;
        salaire += tempsTravail/100*fixe;  // calcul le fixe
        int heureSupp = tempsTravaille - decharges - tempsATravailler;
        if (heureSupp >= 0)
        {
            salaire += prime + heureSupp*taux; // ajoute la prime si le temps à travailler est effectué et les heures supp payées
        }

        return salaire;
    }
}
