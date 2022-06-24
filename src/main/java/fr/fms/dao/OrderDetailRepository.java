package fr.fms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.fms.entities.Admin;
import fr.fms.entities.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {

}
