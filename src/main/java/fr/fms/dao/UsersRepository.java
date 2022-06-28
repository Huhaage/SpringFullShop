package fr.fms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.fms.entities.User;

@Repository
public interface UsersRepository extends JpaRepository<User,Long> {
	//@Query("select A.id, A.description, A.price from Article A JOIN Category C ON (A.category = C.id) WHERE C.id = :x")
	//public Long findUsersIdContainsMail(String mail);
}
