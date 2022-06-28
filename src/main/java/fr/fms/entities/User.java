package fr.fms.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String login;
	private String password;
	
	@OneToMany(mappedBy="user")
	private Collection<Customer> customers;

	/**
	 * @param id
	 * @param login
	 * @param password
	 */
	public User(Long id, String login, String password) {
		this.id = id;
		this.login = login;
		this.password = password;
	}
	
	
}
