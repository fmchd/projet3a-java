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
        if(this.proprietaire == null){
            this.proprietaire  = magasin;
            magasin.setCaisse(magasin.getCaisse() - this.prix);
        }
    }

    @Override
    public void estAchete(Personne personne) {
        if(this.proprietaire.getClass().getName().equals("com.company.Magasin") && !(personne.getCompteBanq() == null)){
            Magasin magasin = (Magasin) this.proprietaire;
            // Magasin magasin = Magasin.class.cast(this.proprietaire);
            this.setProprietaire(personne);
            personne.getCompteBanq().paiement(this.prix);
            magasin.setCaisse(magasin.getCaisse() + this.prix);
        }
    }

    @Override
    public void estRembourse(Magasin magasin) {
        if(this.proprietaire.getClass().getName().equals("com.company.Personne")){
            Personne personne = (Personne) this.proprietaire;
            // Personne personne = Personne.class.cast(this.proprietaire);
            this.setProprietaire(magasin);
            personne.getCompteBanq().versement(this.prix);
            magasin.setCaisse(magasin.getCaisse() - this.prix);
        }
    }

    @Override
    public void faitDeLaPub() {
        if(this.proprietaire == null)
            System.out.println("Venez acheter le produit "+this.nom + "avec lequel vous pouvez prendre une garantie !");
        if(this.proprietaire.getClass().getName().equals("com.company.Magasin")){
            Magasin magasin = (Magasin) this.proprietaire;
            // Magasin magasin = Magasin.class.cast(this.proprietaire);
            System.out.println("Le magasin " + magasin.getNom() + " vous propose de venir acheter " + this.nom  + "avec lequel vous pouvez prendre une garantie !");
        }
        if(this.proprietaire.getClass().getName().equals("com.company.Personne")){
            Personne personne = (Personne) this.proprietaire;
            // Personne personne = Personne.class.cast(this.proprietaire);
            System.out.println(personne.getPrenom() + " fait du bouche à oreille sur le produit " + this.nom + "avec lequel vous pouvez prendre une garantie !");
        }
    }
}
