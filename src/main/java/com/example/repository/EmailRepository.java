package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Email;
import com.example.model.Person;

/**
 * Repository {@link Email}
 * 
 * @author <a href="mailto:mauricionrgarcia@gmailcom">Mauricio Garcia</a>
 * @version
 * @sinse 14/03/2018 21:50:31
 */
@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {
	/**
	 * @param code: code identifier
	 * @return {@link Optional} {@link Email}
	 */
	Optional<Email> findByCode(Long code);

	@Override
	default void deleteInBatch(Iterable<Email> arg0) {
		arg0.forEach(email -> {
			email.setActive("N");
		});
		saveAll(arg0);
	}

	@Modifying(clearAutomatically = true)
	@Query("update Email email set email.active = 'N' where email in (?1)")
	void deleteEmails(List<Email> emails);

	/**
	 * FInd email by person
	 * 
	 * @param person
	 * @return
	 */
	List<Email> findByPerson(Person person);

}
