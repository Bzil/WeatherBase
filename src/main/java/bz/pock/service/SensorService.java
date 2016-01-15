package bz.pock.service;


import bz.pock.model.Sensor;

import java.util.Optional;

public interface SensorService {

    /**
     * Donne le capteur correspondant à un identifiant.
     *
     * @param id identifiant de la donnée
     * @return la donnée sinon null
     */
    default Optional<Sensor> getSensor(Long id) {
        throw new UnsupportedOperationException();
    }
}
