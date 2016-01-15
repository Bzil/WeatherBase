package bz.pock.restcontroller;


import bz.pock.restcontroller.dto.SensorDTO;
import org.springframework.http.ResponseEntity;

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
}
