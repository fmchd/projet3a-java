package com.company.article;

import com.company.personne.Personne;

public interface IVendrePiece {
    void estAchete(Magasin magasin);
    void estRembourse(Magasin magasin);
    void estAchete(Personne personne);
}
