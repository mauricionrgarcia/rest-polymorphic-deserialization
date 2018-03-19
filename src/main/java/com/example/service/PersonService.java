package com.example.service;

import com.example.dto.PersonDTO;

/**
 * Interface to person service.
 * 
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio Garcia</a>
 * @version
 * @sinse 14/03/2018 21:50:00
 */
public interface PersonService {

	/**
	 * find a specific Person by:
	 * 
	 * @param code: code identifier
	 * @return Person
	 */
	PersonDTO find(Long code);

	/**
	 * save a new Person
	 * 
	 * @param person person
	 */
	PersonDTO savePerson(PersonDTO person);

}
