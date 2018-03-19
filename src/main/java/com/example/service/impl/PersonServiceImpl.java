package com.example.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.dto.PersonDTO;
import com.example.mappers.PersonMapper;
import com.example.model.Person;
import com.example.repository.PersonRepository;
import com.example.service.PersonService;

/**
 * implementation of inteface {@link PersonService}.
 * 
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio Garcia</a>
 * @version
 * @sinse 14/03/2018 21:50:11
 */
@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonMapper personMapper;

	/**
	 * Person Repository
	 */
	@Autowired
	private transient PersonRepository personRepository;

	public PersonDTO find(Long code) {
		Optional<Person> optional = personRepository.findByCode(code);
		Person entity = optional.orElseThrow(() -> new EmptyResultDataAccessException(1));
		PersonDTO dto = personMapper.toDTO(entity);
		return dto;
	}

	@Override
	public PersonDTO savePerson(PersonDTO person) {
		Person entity = personMapper.toEntity(person);
		Person personEntity = personRepository.save(entity);
		return personMapper.toDTO(personEntity);
	}

}
