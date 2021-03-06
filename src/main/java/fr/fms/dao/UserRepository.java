package fr.fms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.fms.entities.Users;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
	public Users findByMail(String mail);
}
