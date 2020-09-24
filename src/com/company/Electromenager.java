package com.company;

public class Electromenager extends Article implements IVendrePiece{
    private String dureeFonctionnement;
    private boolean assurance;
    private boolean sortiCarton;

    Electromenager(String nom, float prix, int tauxSolde, String dureeFonctionnement, boolean assurance){
        super(nom, prix, tauxSolde);
        this.dureeFonctionnement = dureeFonctionnement;
        this.assurance = assurance;
        this.sortiCarton = false;
    }

    @Override
    public void estAchete(Magasin magasin) {
        if(this.getProprietaire().getClass().)
    }

    @Override
    public void estAchete(Personne personne) {

    }

    @Override
    public void estRembourse(Magasin magasin) {

    }
}
