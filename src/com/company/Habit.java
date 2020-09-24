package com.company;

public class Habit extends Article implements IPublicite{
    private String provenance;
    Habit(String nom, float prix, int tauxSolde, String provenance){
        super(nom, prix, tauxSolde);
        this.provenance = provenance;
    }

    @Override
    public void faitDeLaPub() {
        {
            if(this.proprietaire == null)
                System.out.println("Venez acheter le produit "+this.nom + " qui vient de " + this.provenance);
            if(this.proprietaire.getClass().getName().equals("com.company.Magasin")){
                Magasin magasin = (Magasin) this.proprietaire;
                // Magasin magasin = Magasin.class.cast(this.proprietaire);
                System.out.println("Le magasin " + magasin.getNom() + " vous propose de venir acheter " + this.nom + " qui vient de " + this.provenance);
            }
            if(this.proprietaire.getClass().getName().equals("com.company.Personne")){
                Personne personne = (Personne) this.proprietaire;
                // Personne personne = Personne.class.cast(this.proprietaire);
                System.out.println(personne.getPrenom() + " fait du bouche à oreille sur le produit " + this.nom + " qui vient de " + this.provenance);
            }
        }
    }
}
