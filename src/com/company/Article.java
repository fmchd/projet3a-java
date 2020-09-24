package com.company;

import java.util.Objects;

public class Article implements IPublicite{
    private String nom;
    private float prix;
    private int tauxSolde;
    private Object proprietaire;


    Article(String nom, float prix, int tauxSolde){
        this.nom = nom;
        this.prix = prix;
        this.tauxSolde = tauxSolde;
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
    public String faitDeLaPub() {
        if(this.proprietaire == null)
            return "Venez acheter le produit "+this.nom;
        if(this.proprietaire.getClass().getName().equals("Magasin")){
            Magasin magasin = Magasin.class.cast(this.proprietaire);
            return "Le magasin " + magasin.getNom() + " vous propose de venir acheter " + this.nom;
        }
        if(this.proprietaire.getClass().getName().equals("Personne")){
            Personne personne = Personne.class.cast(this.proprietaire);
            return personne.getPrenom() + " fait du bouche à oreille sur le produit " + this.nom;
        }
        return null;
    }

    public String getNom() {
        return nom;
    }

    public int getTauxSolde() {
        return tauxSolde;
    }
}
