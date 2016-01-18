package bz.pock.restcontroller.impl;

import bz.pock.model.Sensor;
import bz.pock.restcontroller.SensorController;
import bz.pock.restcontroller.dto.DataDTO;
import bz.pock.restcontroller.dto.SensorDTO;
import bz.pock.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/sensor")
public class SensorControllerImpl implements SensorController {
    private static final DateTimeFormatter FORMATER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

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

    @Override
    @RequestMapping(path = "/{name}", method = RequestMethod.POST)
    public ResponseEntity<SensorDTO> addData(@PathVariable("name") String name, @RequestBody List<DataDTO> datas) {
        // si le capteur est présent, on ajoute les datas, on sauvegarde et ton le transforme en DTO. Sinon NotFound
        return sensorService.getSensor(name)
                .map(s -> ResponseEntity.ok(
                        SensorDTO.to(sensorService.save(Sensor.builder(s).addDatas(
                                // conversion des dto en data
                                datas.stream().map(DataDTO::from).collect(Collectors.toSet())
                        ).build()))
                ))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    @RequestMapping(path = "/{name}/{from}/{to}", method = RequestMethod.POST)
    public ResponseEntity<SensorDTO> getData(@PathVariable("name") String name, @PathVariable("name") String from, @PathVariable("name") String to) {
        return  sensorService.getSensor(name, LocalDate.parse(from, FORMATER), LocalDate.parse(to, FORMATER))
                .map(s -> ResponseEntity.ok(SensorDTO.to(s)))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
