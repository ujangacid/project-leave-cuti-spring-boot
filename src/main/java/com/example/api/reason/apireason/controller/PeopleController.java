package com.example.api.reason.apireason.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.api.reason.apireason.model.People;
import com.example.api.reason.apireason.service.PeopleService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("api/people")
public class PeopleController {
    @Autowired
    private PeopleService peopleService;

    @PostMapping("/")
    public ResponseEntity<People> create(
        @RequestBody People data
    ){
        // String message = "nip aleready exist";
        // for(People people:peopleService.list()){
        //     if (people.getNip() == data.getNip()) {
        //         return ResponseEntity.ok(body);
        //     }
        // }
        return ResponseEntity.ok().body(peopleService.create(data));
    }

    @GetMapping("/")
    public ResponseEntity<List<People>> list(){
        return ResponseEntity.ok().body(peopleService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<People> getById(
        @PathVariable("id") int id
    ){
        return ResponseEntity.ok().body(peopleService.getById(id));
    }

    @PutMapping("/")
    public ResponseEntity<People> update(
        @RequestBody People data
    ){
                // String message = "nip aleready exist";
        // for(People people:peopleService.list()){
        //     if (people.getNip() == data.getNip()) {
        //         return ResponseEntity.ok(body);
        //     }
        // }
        return ResponseEntity.ok().body(peopleService.update(data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
        @PathVariable("id") int id
    ){
        String message = "message: id "+id+" not found";
        for (People people : peopleService.list()) {
            if (people.getId() == (id)) {
                message = "message: id "+id+" deleted";
            }
        }
        peopleService.delete(id);
        return ResponseEntity.ok().body(message);
    }
    
}
