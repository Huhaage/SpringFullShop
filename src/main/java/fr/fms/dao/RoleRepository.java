/**
 * 
 */
package fr.fms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.fms.entities.Role;

/**
 * @author CHJCS
 *
 */
public interface RoleRepository extends JpaRepository<Role,Long> {
	
}
