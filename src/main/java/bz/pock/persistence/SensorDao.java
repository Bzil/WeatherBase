package bz.pock.persistence;

import bz.pock.model.Sensor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SensorDao extends MongoRepository<Sensor, Long> {

    /**
     * Retourne la donnée contenue en base de donnée.
     *
     * @param id id de la donnée
     * @return la donnée si trouvée sinon null
     */
    Optional<Sensor> findById(Long id);

    @Override
    Sensor save(Sensor data);
}
