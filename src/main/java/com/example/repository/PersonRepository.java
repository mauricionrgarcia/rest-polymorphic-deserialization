package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Person;

/**
 * Repository {@link Person}
 * 
 * @author <a href="mailto:mauricionrgarcia@gmailcom">Mauricio Garcia</a>
 * @version
 * @sinse 14/03/2018 21:51:00
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

	/**
	 * find a specific Person by:
	 * 
	 * @param code: code identifier
	 * @return {@link Optional} {@link Person}
	 */
	Optional<Person> findByCode(Long code);
}
