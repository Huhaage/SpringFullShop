package fr.fms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.fms.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	//public Long findUsersIdContainsMail(String mail);
}