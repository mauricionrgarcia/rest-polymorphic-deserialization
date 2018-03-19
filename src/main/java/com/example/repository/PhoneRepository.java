package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Email;
import com.example.model.Person;
import com.example.model.Phone;

/**
 * Repository {@link Email}
 * 
 * @author <a href="mailto:mauricionrgarcia@gmailcom">Mauricio Garcia</a>
 * @version
 * @sinse 14/03/2018 22:02:06
 */
@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {

	/**
	 * @param code: code identifier
	 * @return {@link Optional} {@link Email}
	 */
	Optional<Email> findByCode(Long code);

	/**
	 * FInd phone by person
	 * 
	 * @param person
	 * @return
	 */
	List<Phone> findByPerson(Person person);

}
