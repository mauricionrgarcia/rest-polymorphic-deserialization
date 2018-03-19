package com.example.service;

import java.util.List;

import com.example.dto.Contact;

/**
 * 
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio Garcia</a>
 * @version
 * @sinse 15/03/2018 21:39:57
 */
public interface ContactService {

	List<Contact> findContactByPerson(Long idPerson);

}
