package com.company;

public class Primeur extends Article implements IVendreKilo, IPublicite{
    private String[] nutriments;
    private float kilo;

    Primeur(String nom, float prix, int tauxSolde, String[] nutriments, float kilos){
        super(nom, prix, tauxSolde);
        this.nutriments = nutriments;
        this.kilo = kilos;
    }

    @Override
    public void estAchete(Magasin magasin) {
        if(this.getProprietaire() == null){
            this.setProprietaire(magasin);
            magasin.setCaisse(magasin.getCaisse() - this.kilo * this.prix);
        }
    }
    @Override
    public Article estAchete(Personne personne, float poids) {
        if(this.getProprietaire().getClass().getName().equals("com.company.Magasin")){
            if(this.kilo > poids) {
                Primeur primeur = new Primeur(this.getNom(), this.getPrix(), this.getTauxSolde(), this.nutriments, poids);
                primeur.setProprietaire(personne);
                this.kilo -= poids;
                personne.getCompteBanq().paiement(poids * this.prix);
                return primeur;
            }else{
                System.out.println("EXCEPTION");
            }
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
        else if(this.proprietaire.getClass().getName().equals("com.company.Magasin")){
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
        else if(this.proprietaire.getClass().getName().equals("com.company.Personne")){
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
        }
    }
}
