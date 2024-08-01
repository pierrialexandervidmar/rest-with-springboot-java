package br.com.erudio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.OK)
    public List<Person> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Person findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Person create(@RequestBody Person person) {
        return service.create(person);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public Person update(@RequestBody Person person) {
        return service.update(person);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
    }
    
}
