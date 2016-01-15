package bz.pock.restcontroller;

import bz.pock.model.Data;
import bz.pock.restcontroller.dto.DataDTO;
import bz.pock.restcontroller.exception.NotFoundException;
import bz.pock.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("api/data")
public class DataController {

    @Autowired
    private DataService dataService;


    // curl -X TRACE http://localhost:8080/api/data/ping
    @RequestMapping(value = "/ping", method = RequestMethod.TRACE)
    public String ping() {
        return "Hello, ping from DataController";
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<DataDTO> getData(@PathVariable(value = "id") Long id) {
        return dataService.getData(id)
                .map(d -> ResponseEntity.ok(DataDTO.to(d)))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<DataDTO> save(@PathVariable(value = "id") DataDTO data) {
        Data res = dataService.save(DataDTO.from(data));
        URI uri = URI.create("/api/data/" + res.getId());
        return ResponseEntity.created(uri).body(DataDTO.to(res));
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleTodoNotFound(NotFoundException ex) {
    }
}
