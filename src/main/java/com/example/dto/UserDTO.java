package com.example.dto;

import java.io.Serializable;

/**
 * DTO mapping to user entity
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 01/03/2018 23:42:05
 */
public class UserDTO implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4519786174371697648L;

	/**
	 * identifier
	 */
	private Long code;

	/**
	 * name
	 */
	private String name;

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
