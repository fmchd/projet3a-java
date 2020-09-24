package com.company;

import java.util.Objects;

public class Article implements IPublicite{
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
        if(this.proprietaire.getClass().getName().equals("com.company.Magasin")){
            Magasin magasin = (Magasin) this.proprietaire;
            // Magasin magasin = Magasin.class.cast(this.proprietaire);
            System.out.println("Le magasin " + magasin.getNom() + " vous propose de venir acheter " + this.nom);
        }
        if(this.proprietaire.getClass().getName().equals("com.company.Personne")){
            Personne personne = (Personne) this.proprietaire;
            // Personne personne = Personne.class.cast(this.proprietaire);
            System.out.println(personne.getPrenom() + " fait du bouche à oreille sur le produit " + this.nom);
        }
    }

    public String getNom() {
        return nom;
    }

    public int getTauxSolde() {
        return tauxSolde;
    }
}
