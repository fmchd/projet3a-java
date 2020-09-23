package com.company;


public class Main {

    public static void main(String[] args) {
	    Personne Georges = new Personne("Dupont", "Georges");

	    CompteBanq compteBanqDeGeorges = new CompteBanq("1",Georges,"1234","5678");
        System.out.println(Georges);
        System.out.println(compteBanqDeGeorges);

        compteBanqDeGeorges.actions();



        EleveDigital Luke = new EleveDigital("LKDJKSJD", 2018, 2020, "SKY", "Luke");
        System.out.println(Luke);
    }
}
