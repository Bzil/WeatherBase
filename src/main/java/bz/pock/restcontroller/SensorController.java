package bz.pock.restcontroller;

import bz.pock.restcontroller.dto.SensorDTO;
import bz.pock.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/sensor")
public class SensorController {

    @Autowired
    private SensorService sensorService;

    /*
     * curl -X TRACE http://localhost:8080/api/sensor/ping
	 */
    @RequestMapping(value = "/ping", method = RequestMethod.TRACE)
    public String ping() {
        return "Hello, ping from SensorController";
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<SensorDTO> getSensor(@PathVariable(value = "id") Long id) {
        return sensorService.getSensor(id)
                .map(s -> ResponseEntity.ok(SensorDTO.to(s)))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
