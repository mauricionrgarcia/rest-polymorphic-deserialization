package com.example.enums;

import com.example.service.ContactService;
import com.example.service.EmailService;
import com.example.service.PhoneService;

/**
 * Strategy to load {@link ContactService} from {@link ContactType}
 * 
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio Garcia</a>
 * @version
 * @sinse 18/03/2018 16:44:01
 */
public enum ContactType {

	PHONE(PhoneService.class), EMAIL(EmailService.class);

	/**
	 * ContactService
	 */
	private Class<? extends ContactService> service;

	/**
	 * Contructor
	 * 
	 * @param service ContactService
	 */
	private ContactType(Class<? extends ContactService> service) {
		this.service = service;
	}

	/**
	 * @return {@link ContactService}
	 */
	public Class<? extends ContactService> getService() {
		return service;
	}

	/**
	 * parse String to {@link ContactType}
	 * 
	 * @param key identifier
	 * @return ContactType
	 */
	public static ContactType parse(String key) {
		try {
			return ContactType.valueOf(key);
		} catch (java.lang.IllegalArgumentException e) {
			return getDefault();
		}
	}

	/**
	 * @return default {@link ContactType}
	 */
	public static ContactType getDefault() {
		return ContactType.EMAIL;
	}

}
