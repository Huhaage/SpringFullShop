package fr.fms.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.fms.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long>{
	public Optional<Customer> findById(Long id);
	public List<Customer> findAllCustomerByUserId(Long idUser);
}
