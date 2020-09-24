package com.company;


public class Main {

    public static void main(String[] args) {
	    Personne Georges = new Personne("Dupont", "Georges");
	    Georges.setCompteBanq(new CompteBanq("1", "1234", "4567", 130, 0));

	    Magasin carrefour = new Magasin("Carrefour", "12891 rue de France", 2, 104920f);

	    Primeur carottes = new Primeur("Carotte", 3.3f, 0, new String[]{"Vitamines A", "Vitamines B"}, 5);


	    carottes.faitDeLaPub();
	    carottes.estAchete(carrefour);
	    carottes.faitDeLaPub();
	    Primeur carottesAchete = (Primeur) carottes.estAchete(Georges, 2);
        System.out.println(carottesAchete);


        System.out.println(Georges);

    }
}
