package com.company.article;

import com.company.enfant.Enfant;
import com.company.personne.Personne;

public interface IVendreKilo {
    void estAchete(Magasin magasin);
    Article estAchete(Personne personne, float poids);
    Article estAchete(Enfant enfant, float poids);
}
