package com.example.mappers;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.example.dto.EmailDTO;
import com.example.model.Email;

/**
 * Simple map to entity/DTO {@link Email}
 * 
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 11/03/2018 19:46:00
 */
@Mapper(componentModel = "spring")
public interface EmailMapper {

	/**
	 * to DTO
	 * 
	 * @param email entity
	 * @return dto
	 */
	@Mappings({ @Mapping(target = "person", ignore = true) })
	EmailDTO toDTO(Email email);

	/**
	 * convert list email entity to list {@link EmailDTO}
	 * 
	 * @param email entities
	 * @return dtos
	 */
	@IterableMapping(qualifiedByName = "toDto")
	List<EmailDTO> entitiesToDTOs(List<Email> email);

}