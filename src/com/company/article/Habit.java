package com.company.article;

import com.company.personne.Personne;

public class Habit extends Article implements IPublicite, IVendrePiece {
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
            if(this.proprietaire.getClass().getName().equals("com.company.article.Magasin")){
                Magasin magasin = (Magasin) this.proprietaire;
                // Magasin magasin = Magasin.class.cast(this.proprietaire);
                System.out.println("Le magasin " + magasin.getNom() + " vous propose de venir acheter " + this.nom + " qui vient de " + this.provenance);
            }
            if(this.proprietaire.getClass().getName().equals("com.company.personne.Personne")){
                Personne personne = (Personne) this.proprietaire;
                // Personne personne = Personne.class.cast(this.proprietaire);
                System.out.println(personne.getPrenom() + " fait du bouche à oreille sur le produit " + this.nom + " qui vient de " + this.provenance);
            }
        }
    }

    @Override
    public void estAchete(Personne personne) {
        if(this.proprietaire.getClass().getName().equals("com.company.article.Magasin") && !(personne.getCompteBanq() == null)){
            Magasin magasin = (Magasin) this.proprietaire;
            // Magasin magasin = Magasin.class.cast(this.proprietaire);
            this.setProprietaire(personne);
            personne.getCompteBanq().paiement((1-this.tauxSolde) * this.prix);
            magasin.setCaisse(magasin.getCaisse() + (1-this.tauxSolde) * this.prix);
        }
    }

    @Override
    public void estAchete(Magasin magasin) {
        if(this.proprietaire == null){
            this.proprietaire  = magasin;
            magasin.setCaisse(magasin.getCaisse() - (1-this.tauxSolde) * this.prix);
        }
    }

    @Override
    public void estRembourse(Magasin magasin) {
        if(this.proprietaire.getClass().getName().equals("com.company.personne.Personne")){
            Personne personne = (Personne) this.proprietaire;
            // Personne personne = Personne.class.cast(this.proprietaire);
            this.setProprietaire(magasin);
            personne.getCompteBanq().versement((1-this.tauxSolde) * this.prix);
            magasin.setCaisse(magasin.getCaisse() - (1-this.tauxSolde) * this.prix);
        }
    }
}
