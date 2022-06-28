package fr.fms.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.fms.entities.Orders;
import fr.fms.entities.OrdersItem;



public interface OrdersItemRepository extends JpaRepository<OrdersItem,Long>{
public Optional<OrdersItem> findById(Long orderItem);
	
}
