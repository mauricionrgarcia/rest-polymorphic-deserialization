package com.example.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.example.dto.PersonDTO;
import com.example.model.Person;

/**
 * Simple map to entity/DTO {@link Person}
 * 
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 02/03/2018 00:00:44
 */
@Mapper(componentModel = "spring", uses = {})
public interface PersonMapper {

	/**
	 * convert person entity to {@link PersonDTO} ignore Address
	 * 
	 * @param person entity
	 * @return dto
	 */
	PersonDTO toDTO(Person person);

	/**
	 * convert person dto to entity
	 * 
	 * @param dto dto
	 * @return entity
	 */
	@Mappings({ @Mapping(target = "phones", ignore = true), @Mapping(target = "emails", ignore = true) })
	Person toEntity(PersonDTO dto);

	/**
	 * convert list person entity to list {@link PersonDTO}
	 * 
	 * @param person entities
	 * @return dtos
	 */
	List<PersonDTO> entitiesToDTOs(List<Person> people);

}