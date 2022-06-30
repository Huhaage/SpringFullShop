package fr.fms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.fms.entities.Customer;
import fr.fms.entities.Orders;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.fms.entities.Customer;
import fr.fms.entities.User;

public interface CustomerRepository extends JpaRepository<Customer,Long>{
	public Customer findCustomerById(Long idCustomer);
	public List<Customer> findAllCustomerByUser(User user);
	public Customer findByOrders(Orders order);
}
