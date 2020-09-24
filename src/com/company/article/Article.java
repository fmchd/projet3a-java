package com.company.article;

import com.company.personne.Personne;

public class Article implements IPublicite, ISolde {
    protected String nom;
    protected float prix;
    protected int tauxSolde;
    protected Object proprietaire;


    Article(String nom, float prix, int tauxSolde){
        this.nom = nom;
        this.prix = prix;
        this.tauxSolde = tauxSolde;
        this.proprietaire = null;
    }

    Article(String nom, float prix){
        this.nom = nom;
        this.prix = prix;
        this.tauxSolde = 0;
        this.proprietaire = null;
    }

    boolean enSolde(){
        return !(tauxSolde == 0);
    }

    public Object getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Object proprietaire) {
        this.proprietaire = proprietaire;
    }

    public float getPrix() {
        return prix;
    }

    @Override
    public void faitDeLaPub() {
        if(this.proprietaire == null)
            System.out.println("Venez acheter le produit "+this.nom);
        if(this.proprietaire.getClass().getName().equals("com.company.article.Magasin")){
            Magasin magasin = (Magasin) this.proprietaire;
            // Magasin magasin = Magasin.class.cast(this.proprietaire);
            System.out.println("Le magasin " + magasin.getNom() + " vous propose de venir acheter " + this.nom);
        }
        if(this.proprietaire.getClass().getName().equals("com.company.personne.Personne")){
            Personne personne = (Personne) this.proprietaire;
            // Personne personne = Personne.class.cast(this.proprietaire);
            System.out.println(personne.getPrenom() + " fait du bouche à oreille sur le produit " + this.nom);
        }
    }

    public String getNom() {
        return nom;
    }


    @Override
    public float getTaux() {
        return this.tauxSolde;
    }

    @Override
    public void lancerSolde(int taux) {
        this.tauxSolde = taux;
    }

    @Override
    public void stopSolde() {
        this.tauxSolde = 0;
    }
}
