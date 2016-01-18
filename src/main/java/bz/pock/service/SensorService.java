package bz.pock.service;


import bz.pock.model.Sensor;

import java.time.LocalDate;
import java.util.Optional;

public interface SensorService {

    /**
     * Donne le capteur correspondant à un identifiant.
     *
     * @param id identifiant de la donnée
     * @return le capteur sinon null
     */
    default Optional<Sensor> getSensor(Long id) {
        throw new UnsupportedOperationException();
    }

    /**
     * Donne le capteur correspondant à un nom.
     *
     * @param name nom du capteur
     * @return le capteur sinon null
     */
    default Optional<Sensor> getSensor(String name) {
        throw new UnsupportedOperationException();
    }

    /**
     * Donne le capteur correspondant à un nom, avec les données entres 2 dates.
     *
     * @param name nom du capteur
     * @param from date de début de la période
     * @param to   date de fin de la périonde
     * @return le capteur sinon null
     */
    default Optional<Sensor> getSensor(String name, LocalDate from, LocalDate to) {
        throw new UnsupportedOperationException();
    }

    /**
     * Sauvegarde un capteur.
     *
     * @param sensor capteur à enregister
     * @return le capteur en base
     */
    Sensor save(Sensor sensor);
}
