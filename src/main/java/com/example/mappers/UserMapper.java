package com.example.mappers;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import com.example.dto.UserDTO;
import com.example.model.User;

/**
 * Simple map to entity/DTO {@link User}
 * 
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 11/03/2018 19:46:00
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

	/**
	 * to DTO
	 * 
	 * @param User entity
	 * @return dto
	 */
	UserDTO toDTO(User User);

	/**
	 * convert list User entity to list {@link UserDTO}
	 * 
	 * @param User entities
	 * @return dtos
	 */
	@IterableMapping(qualifiedByName = "toDto")
	List<UserDTO> entitiesToDTOs(List<User> User);

}