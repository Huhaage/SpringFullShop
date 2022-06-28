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
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author CHJCS
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Role {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String role;
	
	@ManyToMany
	@JoinTable(
			name = "user_role",
			joinColumns = {@JoinColumn(name = "roleId")},
			inverseJoinColumns = {@JoinColumn(name = "userId")})
	private List<Users> users;

	/**
	 * @param id
	 * @param role
	 */
	public Role(Long id, String role) {
		super();
		this.id = id;
		this.role = role;
	}
}
