package bz.pock.restcontroller;


import bz.pock.restcontroller.dto.DataDTO;
import org.springframework.http.ResponseEntity;

public interface DataController {
    /**
     * Ping.
     * curl -X TRACE http://localhost:8080/api/data/ping
     *
     * @return ping value
     */
    String ping();

    /**
     * obtention d'une donnée.
     *
     * @param id id de la donnée
     * @return le json correspondant à la donnée
     */
    ResponseEntity<DataDTO> getData(Long id);

    /**
     * Sauvegarde en base une donnée.
     *
     * @param data donnée
     * @return @return le json correspondant à la donnée enregistrée
     */
    ResponseEntity<DataDTO> save(DataDTO data);
}
