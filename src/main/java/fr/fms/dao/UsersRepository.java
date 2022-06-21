package fr.fms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.fms.entities.User;

@Repository
public interface UsersRepository extends JpaRepository<User,Long> {

}
