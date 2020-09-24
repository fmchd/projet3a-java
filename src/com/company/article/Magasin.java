package com.company.article;

import com.company.article.Article;
import com.company.article.IPublicite;

import java.util.ArrayList;

public class Magasin implements IPublicite {
    private String nom;
    private String adresse;
    private int nbrVendeurs;
    private ArrayList<Article> articles;
    private float caisse;

    public Magasin(String nom, String adreese, int nbrVendeurs, float caisse){
        this.nom = nom;
        this.adresse = adreese;
        this.nbrVendeurs = nbrVendeurs;
        this.caisse = caisse;
        this.articles = new ArrayList<Article>();
    }

    public String getNom() {
        return nom;
    }

    public void setCaisse(float caisse) {
        this.caisse = caisse;
    }

    public float getCaisse() {
        return caisse;
    }

    @Override
    public void faitDeLaPub() {
        System.out.println("De nombreux produits à vendre, n'hésitez pas à passer chez" + this.nom);
    }
}