package com.company.article;

import com.company.enfant.Enfant;
import com.company.exception.NotOldEnoughException;
import com.company.exception.pasDeCompteBancaireException;
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
        try {
            if (!(personne.getCompteBanq() == null)) {
                if (this.proprietaire.getClass().getName().equals("com.company.article.Magasin")) {
                    Magasin magasin = (Magasin) this.proprietaire;
                    // Magasin magasin = Magasin.class.cast(this.proprietaire);
                    this.setProprietaire(personne);
                    magasin.setCaisse(magasin.getCaisse() + (1 - this.tauxSolde) * this.prix);
                }
            } else {
                throw new pasDeCompteBancaireException();
            }
        } catch (pasDeCompteBancaireException e) {}
    }

    @Override
    public void estAchete(Enfant enfant) {
        if(this.proprietaire.getClass().getName().equals("com.company.article.Magasin")){
            try {
                if (enfant.age() >= 10) {
                    Magasin magasin = (Magasin) this.proprietaire;
                    // Magasin magasin = Magasin.class.cast(this.proprietaire);
                    this.setProprietaire(enfant);
                    enfant.paiement((1 - this.tauxSolde) * this.prix);
                    magasin.setCaisse(magasin.getCaisse() + (1 - this.tauxSolde) * this.prix);
                } else {
                    throw new NotOldEnoughException();
                }
            }catch(NotOldEnoughException e){
            }
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
