/**
 * 
 */
package fr.fms.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@IdClass(OrdersItemId.class)
public class OrdersItem {
//	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long orderItemId;
	@Id
	@ManyToOne
	private Orders orders;
	@Id
	@ManyToOne
	private Article article;
	@Min(1)
	private int quantity=1;
	
	public OrdersItem(Orders orders, @Min(1) int quantity) {
		this.orders = orders;
		this.quantity = quantity;
	}

	
}
