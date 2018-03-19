package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.Contact;
import com.example.dto.PhoneDTO;
import com.example.mappers.PhoneMapper;
import com.example.model.Person;
import com.example.model.Phone;
import com.example.repository.PhoneRepository;
import com.example.service.PhoneService;

/**
 * 
 * impl of {@link PhoneService}
 * 
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio Garcia</a>
 * @version
 * @sinse 18/03/2018 17:07:58
 */
@Service
public class PhoneServiceImpl implements PhoneService {

	@Autowired
	private transient PhoneRepository phoneRepository;

	@Autowired
	private transient PhoneMapper phoneMapper;

	@Override
	public List<Contact> findContactByPerson(Long idPerson) {
		Person person = new Person();
		person.setCode(idPerson);
		List<Phone> phones = phoneRepository.findByPerson(person);

		List<PhoneDTO> dtos = phoneMapper.entitiesToDTOs(phones);
		List<Contact> result = new ArrayList<>(dtos);
		return result;

	}

}
