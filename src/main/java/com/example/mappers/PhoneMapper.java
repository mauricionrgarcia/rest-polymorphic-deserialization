package com.example.mappers;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.example.dto.PhoneDTO;
import com.example.model.Phone;

/**
 * Simple map to entity/DTO {@link Phone}
 * 
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 11/03/2018 19:46:00
 */
@Mapper(componentModel = "spring")
public interface PhoneMapper {

	/**
	 * to DTO
	 * 
	 * @param Phone entity
	 * @return dto
	 */
	@Mappings({ @Mapping(target = "person", ignore = true) })
	PhoneDTO toDTO(Phone Phone);

	/**
	 * to DTO
	 * 
	 * @param Phone entity
	 * @return dto
	 */
	@Mappings({ @Mapping(target = "person", ignore = true) })
	Phone toEntity(PhoneDTO phoneDTO);

	/**
	 * convert list Phone entity to list {@link PhoneDTO}
	 * 
	 * @param phone entities
	 * @return dtos
	 */
	@IterableMapping(qualifiedByName = "toDto")
	List<PhoneDTO> entitiesToDTOs(List<Phone> phone);

}