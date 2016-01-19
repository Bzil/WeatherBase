package bz.pock.persistence;

import bz.pock.model.Sensor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SensorDao extends CrudRepository<Sensor, Long> {

    /**
     * Retourne le capteur contenu en base de donnée.
     *
     * @param id id du capteur
     * @return le capteur si trouvée sinon null
     */
    Optional<Sensor> findById(Long id);

    /**
     * Retourne le capteur contenu en base de donnée.
     *
     * @param name nom du capteur
     * @return le capteur si trouvée sinon null
     */
    Optional<Sensor> findByName(String name);

    @Override
    Sensor save(Sensor sensor);
}
