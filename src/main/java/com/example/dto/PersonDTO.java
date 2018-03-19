package com.example.dto;

/**
 * DTO to mapping Person entity<br>
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 11/03/2018 19:44:40
 */
public class PersonDTO {

	/**
	 * identifier
	 */
	private Long code;

	/**
	 * name
	 */
	private String name;

	/**
	 * @param code
	 */
	public PersonDTO(Long code) {
		super();
		this.code = code;
	}

	/**
	 * no args
	 */
	public PersonDTO() {
		super();
	}

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PersonDTO [code=" + code + ", name=" + name + "]";
	}

}