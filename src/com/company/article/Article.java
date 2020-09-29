package com.company.article;

import com.company.enfant.Enfant;
import com.company.personne.Personne;
import com.company.exception.pasEntre0et100Exception;

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
        if(this.proprietaire.getClass().getName().equals("com.company.personne.Personne")
                || this.proprietaire.getClass().getName().equals("com.company.personne.IATOS")
                || this.proprietaire.getClass().getName().equals("com.company.personne.Enseignant")){
            Personne personne = (Personne) this.proprietaire;
            // Personne personne = Personne.class.cast(this.proprietaire);
            System.out.println(personne.getPrenom() + " fait du bouche à oreille sur le produit " + this.nom);
        }
        if(this.proprietaire.getClass().getName().equals("com.company.personne.Enfant")
                || this.proprietaire.getClass().getName().equals("com.company.personne.Collegien")
                || this.proprietaire.getClass().getName().equals("com.company.personne.Lyceen")){
            Enfant enfant = (Enfant) this.proprietaire;
            System.out.println(enfant.getPrenom() + " fait du bouche à oreille sur le produit " + this.nom);

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
    public void lancerSolde(int taux) throws pasEntre0et100Exception {
        try {
            if (taux >= 0f && taux <= 100)
                this.tauxSolde = taux;
            else
                throw new pasEntre0et100Exception();
        }
        catch (pasEntre0et100Exception e){
            System.out.println("Veuillez réessayer avec une autre valeur");
        }
    }

    @Override
    public void stopSolde() {
        this.tauxSolde = 0;
    }
}
