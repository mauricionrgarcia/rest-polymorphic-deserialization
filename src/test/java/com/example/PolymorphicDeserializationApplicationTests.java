package com.example;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.dto.Contact;
import com.example.dto.EmailDTO;
import com.example.dto.PhoneDTO;
import com.example.enums.ContactType;
import com.example.model.Email;
import com.example.model.Person;
import com.example.model.Phone;
import com.example.repository.EmailRepository;
import com.example.repository.PersonRepository;
import com.example.repository.PhoneRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
@WebAppConfiguration
public class PolymorphicDeserializationApplicationTests {

	/**
	 * WebApplicationContext
	 */
	@Autowired
	private transient WebApplicationContext context;
	/**
	 * ObjectMapper
	 */
	@Autowired
	private transient ObjectMapper objectMapper;
	/**
	 * PhoneRepository
	 */
	@Autowired
	private PhoneRepository phoneRepository;
	/**
	 * EmailRepository
	 */
	@Autowired
	private EmailRepository emailRepository;
	/**
	 * PersonRepository
	 */
	@Autowired
	private PersonRepository personRepository;
	/**
	 * MockMvc
	 */
	private MockMvc mvc;
	/**
	 * Person
	 */
	private Person person;
	/**
	 * phones
	 */
	private Iterable<Phone> phones;
	/**
	 * emails
	 */
	private Iterable<Email> emails;

	/**
	 * setup and mocks
	 */
	@Before
	public void setup() {
		this.person = createPerson();
		this.emails = createEmails(person);
		this.phones = createPhones(person);

		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	/**
	 * delete all mocks
	 */
	@After
	public void clean() {
		emailRepository.deleteInBatch(this.emails);
		phoneRepository.deleteInBatch(this.phones);
		personRepository.delete(this.person);
	}

	/**
	 * find by default request
	 * 
	 * @throws Exception
	 */
	@Test
	public void findAllDefaultContact() throws Exception {

		UriComponentsBuilder builder = UriComponentsBuilder.newInstance().pathSegment("api/contact", "default",
				person.getCode().toString());

		MvcResult result = mvc.perform(get(builder.build().toUri())).andReturn();
		String content = result.getResponse().getContentAsString();
		Contact[] contact = objectMapper.readValue(content, Contact[].class);
		Assert.assertTrue(contact[0] instanceof EmailDTO);

	}

	/**
	 * find by phone requests
	 * 
	 * @throws Exception
	 */
	@Test
	public void findAllPhoneContact() throws Exception {
		UriComponentsBuilder builder = UriComponentsBuilder.newInstance().pathSegment("api/contact",
				ContactType.PHONE.name(), person.getCode().toString());

		MvcResult result = mvc.perform(get(builder.build().toUri())).andReturn();
		String content = result.getResponse().getContentAsString();
		Contact[] contact = objectMapper.readValue(content, Contact[].class);
		Assert.assertTrue(contact[0] instanceof PhoneDTO);
	}

	/**
	 * find by email requests
	 * 
	 * @throws Exception
	 */
	@Test
	public void findAllEmailContact() throws Exception {
		UriComponentsBuilder builder = UriComponentsBuilder.newInstance().pathSegment("api/contact",
				ContactType.EMAIL.name(), person.getCode().toString());

		MvcResult result = mvc.perform(get(builder.build().toUri())).andReturn();
		String content = result.getResponse().getContentAsString();
		Contact[] contact = objectMapper.readValue(content, Contact[].class);
		Assert.assertTrue(contact[0] instanceof EmailDTO);
	}

	/**
	 * @return createPerson
	 */
	private Person createPerson() {
		Person person = new Person();
		person.setName("Person Teste");
		return personRepository.save(person);
	}

	/**
	 * create Phones
	 * 
	 * @param person Person
	 * @return
	 */
	private List<Phone> createPhones(Person person) {
		Phone phone = new Phone();
		phone.setCode(1L);
		phone.setNumber("123412345");
		phone.setPerson(person);

		List<Phone> phones = Arrays.asList(phone);
		return phoneRepository.saveAll(phones);
	}

	/**
	 * create Email
	 * 
	 * @param person Person
	 * @return
	 */
	private List<Email> createEmails(Person person) {
		Email email = new Email();
		email.setCode(1L);
		email.setEmail("teste@emailteste.com");
		email.setPerson(person);

		List<Email> emails = Arrays.asList(email);
		return emailRepository.saveAll(emails);

	}

}
