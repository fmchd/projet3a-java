package com.company.banque;


import com.company.personne.Personne;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteToFile {
    public void exportToCSV(String fileName) throws IOException {
        try {
            FileWriter writer = new FileWriter(fileName);
            ArrayList<Personne> listPersonnes = Personne.getListPersonnes();
            int i = 0;
            writer.append("compte_bancaire, client_nom, client_prenom, numero, solde, decouvert_autorise, code1, code2\n");
            for(Personne personne : listPersonnes){
                if(!(personne.getCompteBanq() == null)){
                    i++;
                    writer.append(Integer.toString(i) + ", "
                            + personne.getNom() + ", "
                            + personne.getPrenom() + ", "
                            + personne.getCompteBanq().getNum() + ", "
                            + personne.getCompteBanq().getSolde() + ", "
                            + personne.getCompteBanq().getDecouvertAutorise() + ", "
                            + personne.getCompteBanq().getCode1() + ", "
                            + personne.getCompteBanq().getCode2());
                    writer.append("\n");
                }
            }
            writer.flush();
            writer.close();

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
