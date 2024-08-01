package br.com.erudio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import br.com.erudio.entities.Person;
import br.com.erudio.services.PersonServices;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonServices service;

    @GetMapping()
    public List<Person> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping()
    public Person create(@RequestBody Person person) {
        return service.create(person);
    }

    @PutMapping()
    public Person update(@RequestBody Person person) {
        return service.update(person);
    }

    @DeleteMapping()
    public void delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
    }
    
}
