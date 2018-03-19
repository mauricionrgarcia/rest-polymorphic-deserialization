package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.User;

/**
 * Repository {@link User}
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 14/03/2018 21:51:19
 */
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * @param email e-mail
	 * @return {@link User}
	 */
	Optional<User> findByEmail(String email);

}
