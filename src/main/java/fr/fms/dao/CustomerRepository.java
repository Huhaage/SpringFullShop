package fr.fms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.fms.entities.Customer;
import fr.fms.entities.User;

public interface CustomerRepository extends JpaRepository<Customer,Long>{
	public Customer findCustomerById(Long idCustomer);
	public List<Customer> findAllCustomerByUser(User user);
}
