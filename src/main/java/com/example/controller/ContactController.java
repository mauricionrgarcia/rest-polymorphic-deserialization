package com.example.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.Contact;
import com.example.enums.ContactType;
import com.example.model.Person;
import com.example.service.ContactService;

/**
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio Garcia</a>
 * @version
 * @sinse 15/03/2018 21:41:52
 */
@RestController
@RequestMapping("/api/contact")
public class ContactController {

	/**
	 * appContext
	 */
	@Autowired
	private ApplicationContext appContext;

	/**
	 * save a new {@link Person}
	 * 
	 * @param PersonDTO {@link Person}
	 * @return {@link ResponseEntity}
	 * @throws BusinessException
	 */
	@GetMapping("/{type}/{personID}")
	public ResponseEntity<List<Contact>> findConcatsByPerson(@PathVariable("type") String type,
			@PathVariable("personID") Long person) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ContactType contactType = ContactType.parse(type);
		ContactService service = appContext.getBean(contactType.getService());
		List<Contact> result = service.findContactByPerson(person);
		return ResponseEntity.ok(result);
	}

}
