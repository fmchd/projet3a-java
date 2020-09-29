package com.company;


import com.company.article.Electromenager;
import com.company.article.Magasin;
import com.company.article.Primeur;
import com.company.banque.CompteBanq;
import com.company.banque.WriteToFile;
import com.company.exception.pasEntre0et100Exception;
import com.company.personne.IATOS;
import com.company.personne.Personne;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, pasEntre0et100Exception {
	    Personne Georges = new Personne("Dupont", "Georges");
	    IATOS Jean = new IATOS("12/02/2002", 2, "Tété", "Jean", 1200,3);
	    Georges.setCompteBanq(new CompteBanq("1", "1234", "4567", 130, 0));


	    Electromenager machineAlaver = new Electromenager("Machine à laver", 250,0,"0",true);


	    Magasin carrefour = new Magasin("Carrefour", "12891 rue de France", 2, 104920f);

	    Primeur carottes = new Primeur("Carotte", 3.3f, 0, new String[]{"Vitamines A", "Vitamines B"}, 5);

	    machineAlaver.estAchete(carrefour);

		machineAlaver.estAchete(Jean);

		Jean.setCompteBanq(new CompteBanq("2","1234", "1234", 430,0));
		machineAlaver.estAchete(Jean);
		machineAlaver.faitDeLaPub();

		carottes.faitDeLaPub();
	    carottes.estAchete(carrefour);
	    carottes.faitDeLaPub();
	    Primeur carottesAchete = (Primeur) carottes.estAchete(Georges, 2);
        System.out.println(carottesAchete);


        System.out.println(Georges);

        carottes.lancerSolde(110);


		WriteToFile file = new WriteToFile();
		file.exportToCSV("test.csv");

    }
}
