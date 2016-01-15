package bz.pock.service;


import bz.pock.model.Data;

import java.util.Optional;

public interface DataService {
    /**
     * Donne la donnée correspondant à un identifiant.
     *
     * @param id identifiant de la donnée
     * @return la donnée sinon null
     */
    default Optional<Data> getData(Long id) {
        throw new UnsupportedOperationException();
    }

    /**
     * Sauvergarde d'une donnée.
     *
     * @param data donnée à enregistrée
     * @return la donnée à enregistrée
     */
    default Data save(Data data) {
        throw new UnsupportedOperationException();
    }
}
