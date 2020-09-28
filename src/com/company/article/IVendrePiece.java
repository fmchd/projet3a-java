package com.company.article;

import com.company.enfant.Enfant;
import com.company.personne.Personne;
import com.company.exception.NotOldEnoughException;

public interface IVendrePiece {
    void estAchete(Magasin magasin);
    void estRembourse(Magasin magasin);
    void estAchete(Personne personne) throws NotOldEnoughException;
    void estAchete(Enfant enfant) throws NotOldEnoughException;
}
