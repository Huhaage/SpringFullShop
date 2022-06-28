package fr.fms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.fms.entities.Customer;
import fr.fms.entities.Orders;
import fr.fms.entities.OrdersItem;

public interface OrdersRepository extends JpaRepository<Orders,Long>{

	public void  save(OrdersItem orderItem);
	public List<Orders> findAllByCustomerOrderByDateDesc(Customer customer);

}
