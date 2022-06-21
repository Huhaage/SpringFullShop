package fr.fms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.fms.entities.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long>  {

}
