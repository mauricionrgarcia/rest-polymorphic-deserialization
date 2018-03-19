package com.example.dto;

import java.util.List;

/**
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio Garcia</a>
 * @version
 * @sinse 11/03/2018 19:42:36
 */
public class ContactDTO {

	private Long code;
	private PersonDTO person;
	private List<PhoneDTO> phones;
	private List<EmailDTO> emails;

	/**
	 * @return the code
	 */
	public Long getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(Long code) {
		this.code = code;
	}

	/**
	 * @return the emails
	 */
	public List<EmailDTO> getEmails() {
		return emails;
	}

	/**
	 * @param emails the emails to set
	 */
	public void setEmails(List<EmailDTO> emails) {
		this.emails = emails;
	}

	/**
	 * @return the person
	 */
	public PersonDTO getPerson() {
		return person;
	}

	/**
	 * @param person the person to set
	 */
	public void setPerson(PersonDTO person) {
		this.person = person;
	}

	/**
	 * @return the phones
	 */
	public List<PhoneDTO> getPhones() {
		return phones;
	}

	/**
	 * @param phones the phones to set
	 */
	public void setPhones(List<PhoneDTO> phones) {
		this.phones = phones;
	}

}
