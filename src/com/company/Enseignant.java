package com.company;

public class Enseignant extends Personnel {

    private int echelon;
    final static private float prime = 1000;
    final static float taux = 1.2f;
    private int decharges;
    private int tempsATravailler;
    private int tempsTravaille;

    Enseignant(String dateEntree, float tempsTravail, String echelon, int decharges, String nom, String prenom, int tempsTravaille){
        super(dateEntree, tempsTravail, nom, prenom);
        if (echelon.equals("PRAG"))
        {
            this.echelon = 0;
            tempsATravailler = 192;
        }
        else if (echelon.equals("MDC"))
        {
            this.echelon = 1;
            tempsATravailler = 384;
        }
        else
        {
            this.echelon = 2;
            tempsATravailler = 96;
        }
        this.decharges = decharges;
        this.tempsTravaille = tempsTravaille;
    }

    @Override
    public float calculSalaire() {
        float salaire = 0;
        int fixe;
        switch(echelon)
        {
            case 0:
                fixe = 3;
                break;
            case 1:
                fixe = 2;
                break;
            case 2:
                fixe = 1;
                break;
            default:
                fixe=0;
                break;
        }
        salaire += tempsTravail/100*fixe;  // calcul le fixe
        int heureSupp = tempsTravaille - decharges - tempsATravailler;
        if (heureSupp >= 0)
        {
            salaire += prime + heureSupp*taux; // ajoute la prime si le temps à travailler est effectué et les heures supp payées
        }

        return salaire;
    }
}
