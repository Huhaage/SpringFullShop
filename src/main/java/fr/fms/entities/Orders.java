/**
 * 
 */
package fr.fms.entities;

import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Orders {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	@ManyToOne
	private Customer customer;
	private Date date;
	private double amount;
	@OneToMany(mappedBy="orders")
	private Collection<OrdersItem> ordersItem;
	
	public Orders(Long orderId, Customer customer, Date date, double amount) {
		this.orderId = orderId;
		this.customer = customer;
		this.date = date;
		this.amount = amount;
	}
		
		
}
