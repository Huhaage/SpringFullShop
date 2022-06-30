package fr.fms.entities;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
public class Users {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String mail;

	@NotNull
	private String password;
	
	@OneToMany(mappedBy="user")
	private Collection<Customer> customers;

	@NotNull
	private Boolean active;
	
	@ManyToMany
	@JoinTable(
			name = "user_role",
			joinColumns = {@JoinColumn(name = "usersId")},
			inverseJoinColumns = {@JoinColumn(name = "roleId")})
	private List<Role> role;
	
	/**
	 * @param id
	 * @param login
	 * @param password
	 */
	public Users(Long id, String mail, String password) {
		this.id = id;
		this.mail = mail;
		this.password = password;
	}

	/**
	 * @param id
	 * @param mail
	 * @param password
	 * @param active
	 */
	public Users(Long id, @NotNull String mail, @NotNull String password, @NotNull Boolean active) {
		this.id = id;
		this.mail = mail;
		this.password = password;
		this.active = active;
	}
	
	/**
	 * @param id
	 * @param mail
	 */
	public Users(Long id, @NotNull String mail) {
		this.id = id;
		this.mail = mail;
	}
	
}
