package fr.fms.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.fms.entities.OrdersItem;



public interface OrdersItemRepository extends JpaRepository<OrdersItem,Long>{
   
    @Query("SELECT o FROM OrdersItem o WHERE o.orders.orderId= :id")
    public List<OrdersItem> findAllOrdersItemsByOrdersOrderId(@Param("id") Long id );

	
}
