package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.Contact;
import com.example.dto.EmailDTO;
import com.example.mappers.EmailMapper;
import com.example.model.Email;
import com.example.model.Person;
import com.example.repository.EmailRepository;
import com.example.service.EmailService;

/**
 * 
 * impl of {@link EmailService}
 * 
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio Garcia</a>
 * @version
 * @sinse 18/03/2018 19:10:11
 */
@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private transient EmailRepository repository;

	@Autowired
	private transient EmailMapper mapper;

	@Override
	public List<Contact> findContactByPerson(Long idPerson) {
		Person person = new Person();
		person.setCode(idPerson);
		List<Email> phones = repository.findByPerson(person);

		List<EmailDTO> dtos = mapper.entitiesToDTOs(phones);
		List<Contact> result = new ArrayList<>(dtos);
		return result;

	}

}
