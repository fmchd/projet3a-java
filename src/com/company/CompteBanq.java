package com.company;

import java.util.Scanner;

public class CompteBanq {

    private String num;
    private Personne client;
    private float solde;
    private float decouvertAutorise;
    private String code1;
    private String code2;

    public void setSolde(float solde, String code1) {
        if (this.code1.equals(code1))
            this.solde = solde;
    }

    public void setDecouvertAutorise(float decouvertAutorise, String code2) {
        if (this.code2.equals(code2))
            this.solde = solde;
    }


    public String getNum() {
        return num;
    }

    public Personne getClient() {
        return client;
    }

    public float getSolde() {
        return solde;
    }

    public float getDecouvertAutorise() {
        return decouvertAutorise;
    }

    public String getCode1() {
        return code1;
    }

    public String getCode2() {
        return code2;
    }


    public CompteBanq(String num, Personne client, String code1, String code2){
        this.num = num;
        this.client = client;
        this.code1 = code1;
        this.code2 = code2;
        this.solde = 0;
        this.decouvertAutorise = 0;
    }

    public void versement(String code1, float montant){
        if(this.code1 == code1) {
            this.solde += montant;
        }
    }

    public void retrait(String code1, float montant){
        if ((montant < solde + this.decouvertAutorise) & this.code1 == code1){
            this.solde -= montant;
        }
        if ((montant < solde + this.decouvertAutorise))
            System.out.println("Solde insuffisant");
    }

    public void actions(){
        Scanner entree = new Scanner(System.in);
        while (true){
            System.out.println("Effectuer une action : versement (1) - retrait (2) - quitter (3)");
            int choix = entree.nextInt();
            switch (choix) {
                case 1 -> {
                    System.out.println("Entrer votre code :");
                    String code = entree.nextLine();
                    code = entree.nextLine();
                    if (code.equals(this.code1)) {
                        System.out.println("Entrer le montant à verser (en €):");
                        int montant = entree.nextInt();
                        versement(code1, montant);
                        System.out.println("Nouveau solde :" + this.solde + "€");
                    }else{
                        System.out.println("Code erroné, veuillez recommencer.");
                    }
                }
                case 2 -> {
                    System.out.println("Entrer son code :");
                    String code = entree.nextLine();
                    code = entree.nextLine();
                    if (code.equals(this.code1)) {
                        System.out.println("Entrer le montant à retirer (en €):");
                        int montant = entree.nextInt();
                        retrait(code1, montant);
                        System.out.println("Nouveau solde :" + this.solde + "€");
                    }else{
                        System.out.println("Code erroné, veuillez recommencer.");
                    }
                }
                case 3 -> {
                    return;
                }
            }

        }
    }

    @Override
    public String toString() {
        return "CompteBanq{" +
                "num='" + num + '\'' +
                ", client=" + client +
                ", solde=" + solde +
                ", decouvertAutorise=" + decouvertAutorise +
                ", code1='" + code1 + '\'' +
                ", code2='" + code2 + '\'' +
                '}';
    }
}
