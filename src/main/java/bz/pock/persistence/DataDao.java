package bz.pock.persistence;

import bz.pock.model.Data;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DataDao extends CrudRepository<Data, Long> {
    /**
     * Retourne la donnée contenue en base de donnée.
     *
     * @param id id de la donnée
     * @return la donnée si trouvée sinon null
     */
    Optional<Data> findById(Long id);

    @Override
    Data save(Data data);
}
