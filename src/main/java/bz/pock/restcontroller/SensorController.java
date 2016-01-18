package bz.pock.restcontroller;


import bz.pock.restcontroller.dto.DataDTO;
import bz.pock.restcontroller.dto.SensorDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SensorController {

    /**
     * Ping.
     * curl -X TRACE http://localhost:8080/api/sensor/ping
     *
     * @return ping value
     */
    String ping();

    /**
     * obtention d'un capteur.
     *
     * @param id id du capteur
     * @return le json correspondant au capteur
     */
    ResponseEntity<SensorDTO> getSensor(Long id);

    /**
     * Ajoute une liste de donnée au capteur.
     *
     * @param name  nom du capteur
     * @param datas liste des mesures
     * @return le json correspondant au capteur
     */
    ResponseEntity<SensorDTO> addData(String name, List<DataDTO> datas);

    /**
     * Donne la liste des données relative à un capteur entre deux dates
     *
     * @param name le nom du capteur
     * @param from la date de début (pattern yyyy-MM-dd)
     * @param to   la date de fin (pattern yyyy-MM-dd)
     * @return le json correspondant au capteur
     */
    ResponseEntity<SensorDTO> getData(String name, String from, String to);
}
