
package fr.fms.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Stagiaires09
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String name;
	@NotNull
	private String firstName;
	@NotNull
	private String address;
	@NotNull
	private String phone;
	@OneToMany(mappedBy="customer")
	private Collection<Orders> orders;

	
	
	public Customer(Long id, @NotNull String name, @NotNull String firstName, @NotNull String address,
			@NotNull String phone) {
		super();
		this.id = id;
		this.name = name;
		this.firstName = firstName;
		this.address = address;
		this.phone = phone;
	}
	
	

	@ManyToOne
	private User user;

}
