package com.company.article;

import com.company.exception.pasEntre0et100Exception;

public interface ISolde {
    float getTaux();
    void lancerSolde(int taux) throws pasEntre0et100Exception;
    void stopSolde();
}
