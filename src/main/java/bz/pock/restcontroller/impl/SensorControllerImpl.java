package bz.pock.restcontroller.impl;

import bz.pock.restcontroller.SensorController;
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
public class SensorControllerImpl implements SensorController {

    @Autowired
    private SensorService sensorService;

    @Override
    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public String ping() {
        return "Hello, ping from SensorController";
    }

    @Override
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<SensorDTO> getSensor(@PathVariable(value = "id") Long id) {
        return sensorService.getSensor(id)
                .map(s -> ResponseEntity.ok(SensorDTO.to(s)))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
