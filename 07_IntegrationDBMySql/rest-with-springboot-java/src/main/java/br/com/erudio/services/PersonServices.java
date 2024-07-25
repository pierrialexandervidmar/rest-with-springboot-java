package br.com.erudio.services;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import java.util.logging.Logger;

import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.entities.Person;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	PersonRepository repository;

	public List<Person> findAll() {
		logger.info("Fin1ding one person!");
		return repository.findAll();
	}
	
	public Person findById(Long id) {
		logger.info("Finding one person!");
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
	}

	public Person create(Person person) {
		logger.info("Creating one person!");
		return repository.save(person);
	}

	public Person update(Person person) {
		logger.info("Update one person!");
		var entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No Records found for this ID"));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());

		return repository.save(entity);
	}

	public Person delete(Long id) {
		logger.info("Delete one person!");
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Records found for this ID"));

		return repository.delete(entity);
	}
}
