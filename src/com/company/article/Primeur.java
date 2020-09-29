package com.company.article;

import com.company.enfant.Enfant;
import com.company.exception.NotOldEnoughException;
import com.company.personne.Personne;

public class Primeur extends Article implements IVendreKilo, IPublicite {
    private String[] nutriments;
    private float kilo;

    public Primeur(String nom, float prix, int tauxSolde, String[] nutriments, float kilos){
        super(nom, prix, tauxSolde);
        this.nutriments = nutriments;
        this.kilo = kilos;
    }

    @Override
    public void estAchete(Magasin magasin) {
        if(this.proprietaire == null){
            this.setProprietaire(magasin);
            magasin.setCaisse(magasin.getCaisse() - this.kilo * (1-this.tauxSolde) * this.prix);
        }
    }
    @Override
    public Article estAchete(Personne personne, float poids) {
        if(this.proprietaire == null){
            System.out.println("EXCEPTION");
        }
        else if(this.proprietaire.getClass().getName().equals("com.company.article.Magasin") ){
            if(this.kilo > poids) {
                Primeur primeur = new Primeur(this.nom, this.prix, this.tauxSolde, this.nutriments, poids);
                primeur.setProprietaire(personne);
                this.kilo -= poids;
                personne.getCompteBanq().paiement(poids * (1-this.tauxSolde) * this.prix);
                return primeur;
            }
        }
        return null;
    }

    @Override
    public Article estAchete(Enfant enfant, float poids) {
        if(this.proprietaire.getClass().getName().equals("com.company.article.Magasin")) {
            try {
                if(enfant.age() >= 10) {
                    if (this.kilo > poids) {
                        Primeur primeur = new Primeur(this.nom, this.prix, this.tauxSolde, this.nutriments, poids);
                        primeur.setProprietaire(enfant);
                        this.kilo -= poids;
                        enfant.paiement(poids * (1 - this.tauxSolde) * this.prix);
                        return primeur;
                    }
                }else{
                    throw new NotOldEnoughException();
                }
            }catch(NotOldEnoughException e){}
        }
        return null;
    }

    @Override
    public void faitDeLaPub() {
        String texte = "";
        if(this.proprietaire == null){
            texte += "Venez acheter le produit "+this.nom;
            if (nutriments.length > 0) {
                texte += " avec ";
                for (int i = 0; i < nutriments.length; i++){
                    texte += nutriments[i];
                    if (i < nutriments.length - 1)
                        texte += ", ";
                    else
                        texte += ".";
                }
                System.out.println(texte);;
            }
        }
        else if(this.proprietaire.getClass().getName().equals("com.company.article.Magasin")){
            Magasin magasin = (Magasin) this.proprietaire;
            // Magasin magasin = Magasin.class.cast(this.proprietaire);
            texte += "Le magasin " + magasin.getNom() + " vous propose de venir acheter " + this.nom;
            if (nutriments.length > 0) {
                texte += " avec ";
                for (int i = 0; i < nutriments.length; i++){
                    texte += nutriments[i];
                    if (i < nutriments.length - 1)
                        texte += ", ";
                    else
                        texte += ".";
                }
            }
            System.out.println(texte);
        }
        else if(this.proprietaire.getClass().getName().equals("com.company.personne.Personne")
                || this.proprietaire.getClass().getName().equals("com.company.personne.IATOS")
                || this.proprietaire.getClass().getName().equals("com.company.personne.Enseignant")){
            Personne personne = (Personne) this.proprietaire;
            // Personne personne = Personne.class.cast(this.proprietaire);
            texte = personne.getPrenom() + " fait du bouche à oreille sur le produit " + this.nom;
            if (nutriments.length > 0) {
                texte += " avec ";
                for (int i = 0; i < nutriments.length; i++){
                    texte += nutriments[i];
                    if (i < nutriments.length - 1)
                        texte += ", ";
                    else
                        texte += ".";
                }

            }
            System.out.println(texte);;
        } else if(this.proprietaire.getClass().getName().equals("com.company.personne.Enfant")
                || this.proprietaire.getClass().getName().equals("com.company.personne.Lyceen")
                || this.proprietaire.getClass().getName().equals("com.company.personne.Collegien")){
            Enfant enfant = (Enfant) this.proprietaire;
            // Personne personne = Personne.class.cast(this.proprietaire);
            texte = enfant.getPrenom() + " fait du bouche à oreille sur le produit " + this.nom;
            if (nutriments.length > 0) {
                texte += " avec ";
                for (int i = 0; i < nutriments.length; i++){
                    texte += nutriments[i];
                    if (i < nutriments.length - 1)
                        texte += ", ";
                    else
                        texte += ".";
                }

            }
            System.out.println(texte);;
        }
    }
}
