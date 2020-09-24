package com.company;

public class Primeur extends Article implements IVendreKilo{
    private String[] nutriments;
    private float kilo;

    Primeur(String nom, float prix, int tauxSolde, String[] nutriments, float kilos){
        super(nom, prix, tauxSolde);
        this.nutriments = nutriments;
        this.kilo = kilos;
    }

    @Override
    public void estAchete(Magasin magasin, float poids) {
        if(this.getProprietaire() == null){
            this.setProprietaire(magasin);
            this.kilo = poids;
        }
    }
    @Override
    public void estAchete(Personne personne, float poids) {
        if(this.getProprietaire().getClass().getName().equals("Magasin")){
            if(this.kilo > poids) {
                Primeur primeur = new Primeur(this.getNom(), this.getPrix(), this.getTauxSolde(), this.nutriments, poids);
                primeur.setProprietaire(personne);
                this.kilo -= poids;
            }else{
                System.out.println("EXCEPTION");
            }
        }
    }
}
