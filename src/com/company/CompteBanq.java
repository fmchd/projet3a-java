package com.company;

import java.util.Scanner;


public class CompteBanq {

    private String num;
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


    public CompteBanq(String num, String code1, String code2){
        this.num = num;
        this.code1 = code1;
        this.code2 = code2;
        this.solde = 0;
        this.decouvertAutorise = 0;
    }

    public CompteBanq(String num, String code1 , String code2, float solde, float decouvertAutorise){
        this.num = num;
        this.code1 = code1;
        this.code2 = code2;
        this.solde = solde;
        this.decouvertAutorise = decouvertAutorise;
    }

    public void versement(float montant){
        Scanner code1 = new Scanner(System.in);
        if(this.code1.equals(code1.next()) ) {
            this.solde += montant;
        }
    }

    public void retrait(String code1, float montant){
        if ((montant > solde + this.decouvertAutorise)) {
            System.out.println("Solde insuffisant");
        }else{
            if (this.code1.equals(code1)){
                this.solde -= montant;
            }else{
                System.out.println("Code eronné");
            }
        }
    }

    public void paiement(float prix){
        System.out.println("Veuillez saisir votre code :");
        Scanner entree = new Scanner(System.in);
        retrait(entree.nextLine(), prix);
    }


    @Override
    public String toString() {
        return "CompteBanq{" + '\n' +
                "       num='" + num + '\n' +
                "       solde=" + solde + '\n' +
                "       decouvertAutorise=" + decouvertAutorise + '\n' +
                "       code1='" + code1 + '\n' +
                "       code2='" + code2 + '\n' +
                '}';
    }
}
