package fr.fms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.fms.entities.OrdersItem;



public interface OrdersItemRepository extends JpaRepository<OrdersItem,Long>{

	
}
