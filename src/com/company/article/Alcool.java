package com.company.article;

import com.company.enfant.Enfant;
import com.company.exception.NotOldEnoughException;
import com.company.exception.pasDeCompteBancaireException;
import com.company.personne.Personne;

public class Alcool extends Article implements IVendrePiece, IPublicite{

    private int volume;
    private float degres;

    Alcool(String nom, float prix, int tauxSolde, int volume, float degres){
        super(nom, prix, tauxSolde);
        this.volume = volume;
        this.degres = degres;
    }

    @Override
    public void estAchete(Personne personne){
        if(this.proprietaire.getClass().getName().equals("com.company.article.Magasin") && !(personne.getCompteBanq() == null)){
            try {
                if (personne.calculAge() >= 18) {
                    Magasin magasin = (Magasin) this.proprietaire;
                    // Magasin magasin = Magasin.class.cast(this.proprietaire);
                    this.setProprietaire(personne);
                    try {
                        if (!(personne.getCompteBanq() == null)) {
                            personne.getCompteBanq().paiement((1 - this.tauxSolde) * this.prix);
                            magasin.setCaisse(magasin.getCaisse() + (1 - this.tauxSolde) * this.prix);
                        } else {
                            throw new pasDeCompteBancaireException();
                        }
                    }catch (pasDeCompteBancaireException e){}
                } else {
                    throw new NotOldEnoughException();
                }
            }
            catch(NotOldEnoughException e){
                System.out.println("Veuillez grandir avant d'essayer d'acheter un tel article");
            }
        }
    }

    @Override
    public void estAchete(Enfant enfant){
        if(this.proprietaire.getClass().getName().equals("com.company.article.Magasin")){
            try {
                if (enfant.age() >= 18) {
                    Magasin magasin = (Magasin) this.proprietaire;
                    // Magasin magasin = Magasin.class.cast(this.proprietaire);
                    this.setProprietaire(enfant);
                    enfant.paiement((1 - this.tauxSolde) * this.prix);
                    magasin.setCaisse(magasin.getCaisse() + (1 - this.tauxSolde) * this.prix);
                } else {
                    throw new NotOldEnoughException();
                }
            }
            catch (NotOldEnoughException e){
                System.out.println("Veuillez grandir avant d'essayer d'acheter un tel article");
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


    public void faitDeLaPub() {
        if(this.proprietaire == null)
            System.out.println("Venez acheter le produit "+this.nom + "avec lequel vous pouvez prendre une garantie !");
        if(this.proprietaire.getClass().getName().equals("com.company.article.Magasin")){
            Magasin magasin = (Magasin) this.proprietaire;
            // Magasin magasin = Magasin.class.cast(this.proprietaire);
            System.out.println("Le magasin " + magasin.getNom() + " vous propose de venir acheter " + this.nom  + "à consommer avec modération");
        }
        if(this.proprietaire.getClass().getName().equals("com.company.personne.Personne")){
            Personne personne = (Personne) this.proprietaire;
            // Personne personne = Personne.class.cast(this.proprietaire);
            System.out.println(personne.getPrenom() + " fait du bouche à oreille sur le produit " + this.nom + "à consommer avec modération");
        }
    }



}
