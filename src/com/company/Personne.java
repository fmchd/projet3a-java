package com.company;

public class Personne {

    private String nom;
    private String prenom;
    private String numSecu;
    private int anneeNaissance;
    private char sexe;
    private int deptNaissance;
    private CompteBanq compteBanq;


    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNumSecu() {
        return numSecu;
    }

    public int getAnneeNaissance() {
        return anneeNaissance;
    }

    public char getSexe() {
        return sexe;
    }

    public int getDeptNaissance() {
        return deptNaissance;
    }

    public void setNumSecu(String numSecu) {
        this.numSecu = numSecu;
        this.sexe = sexe(numSecu);
        this.deptNaissance = deptNaissance(numSecu);
        this.anneeNaissance = anneeNaissance(numSecu);
    }

    public void setAnneeNaissance(int anneeNaissance) {
        this.anneeNaissance = anneeNaissance;
    }

    public void setSexe(char sexe) {
        this.sexe = sexe;
    }

    public void setDeptNaissance(int deptNaissance) {
        this.deptNaissance = deptNaissance;
    }



    public Personne(String nom,String prenom){
        this.nom = nom;
        this.prenom = prenom;
        this.anneeNaissance = 1800;
        this.sexe = ' ';
        this.deptNaissance = 0;
        this.numSecu = "";
        this.compteBanq = null;
    }

    public Personne(String nom, String prenom, String numSecu, CompteBanq compteBanq){
        this.nom = nom;
        this.prenom = prenom;
        this.anneeNaissance = anneeNaissance(numSecu);
        this.sexe = sexe(numSecu);
        this.deptNaissance = deptNaissance(numSecu);
        this.numSecu = numSecu;
        this.compteBanq = compteBanq;
    }

    public Personne(String nom,String prenom, CompteBanq compteBanq){
        this.nom = nom;
        this.prenom = prenom;
        this.anneeNaissance = 1800;
        this.sexe = ' ';
        this.deptNaissance = 0;
        this.numSecu = "";
        this.compteBanq = compteBanq;
    }


    private int anneeNaissance(String numSecu){
        if ( Integer.parseInt(numSecu.substring(1,3)) > 20){
            return Integer.parseInt("19" + numSecu.substring(1,3));
        }else{
            return Integer.parseInt("20" + numSecu.substring(1,3));
        }
    }

    private char sexe(String numSecu){
        if(Integer.parseInt(numSecu.substring(0,1)) == 1){
            return 'H';
        }else{
            return 'F';
        }
    }

    private int deptNaissance(String numSecu){
        return Integer.parseInt(numSecu.substring(5,6));
    }

    public int calculAge(){
        return 2020 - this.anneeNaissance;
    }

    @Override
    public String toString() {
        String personne = "";
        personne += "Personne{" + "\n"
                + "     nom='" + nom + "\n"
                + "     prenom='" + prenom + '\n';
        if (!this.numSecu.equals("")){
            personne += "     numSecu='" + numSecu + '\n';
        }
        if (!(this.anneeNaissance == 1800)){
            personne += "     anneeNaissance=" + anneeNaissance + '\n';
        }
        if (!(this.sexe == ' ')){
            personne += "     sexe=" + sexe + '\n';
        }
        if (!(this.deptNaissance == 0)){
            personne += "     deptNaissance=" + deptNaissance + '\n';
        }
        if (!(this.compteBanq == null)){
            personne += "     " +  compteBanq.toString();
        }
        personne += '}';

        return personne;
    }


    public void setCompteBanq(CompteBanq compteBanq) {
        this.compteBanq = compteBanq;
    }

    public CompteBanq getCompteBanq() {
        return compteBanq;
    }
}
