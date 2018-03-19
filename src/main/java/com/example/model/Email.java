package com.example.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * Entity to mapping TB_EMAIL<br>
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 14/03/2018 22:00:13
 */
@Entity
@Table(name = "TB_EMAIL")
@EntityListeners(AuditingEntityListener.class)
@SQLDelete(sql = "UPDATE TB_EMAIL SET ID_ACTIVE = 'N' WHERE PK_EMAIL = ?")
public class Email implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4730901328686557841L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_EMAIL")
	private Long code;

	@ManyToOne
	@JoinColumn(name = "FK_PERSON")
	private Person person;

	@Column(name = "TX_EMAIL")
	private String email;

	@Column(name = "ID_ACTIVE")
	private String active;

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
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the active
	 */
	public String getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(String active) {
		this.active = active;
	}

}
