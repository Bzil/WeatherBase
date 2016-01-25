package bz.pock.restcontroller.impl;

import bz.pock.annotation.Log;
import bz.pock.model.Data;
import bz.pock.restcontroller.DataController;
import bz.pock.restcontroller.dto.DataDTO;
import bz.pock.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("api/data")
public class DataControllerImpl implements DataController {

    @Autowired
    private DataService dataService;

    @Log
    @Override
    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public String ping() {
        return "Hello, ping from DataController";
    }

    @Override
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<DataDTO> getData(@PathVariable(value = "id") Long id) {
        return dataService.getData(id)
                .map(d -> ResponseEntity.ok(DataDTO.to(d)))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<DataDTO> save(@RequestBody DataDTO data) {
        Data res = dataService.save(DataDTO.from(data));
        URI uri = URI.create("/api/data/" + res.getId());
        return ResponseEntity.created(uri).body(DataDTO.to(res));
    }
}
