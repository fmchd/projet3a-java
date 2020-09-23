package com.company;

import java.util.Objects;

public class Article {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Float.compare(article.prix, prix) == 0 &&
                tauxSolde == article.tauxSolde &&
                Objects.equals(nom, article.nom) &&
                Objects.equals(proprietaire, article.proprietaire);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prix, tauxSolde, proprietaire);
    }
}
