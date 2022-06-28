package fr.fms.entities;

import java.io.Serializable;
import java.util.Objects;


import javax.persistence.ManyToOne;

public class OrdersItemId implements Serializable{
	private static final long serialVersionUID = 1L;
	private  Long orders;	
	private Long article;
	
	public OrdersItemId(Long orders, Long article) {
		
		this.orders = orders;
		this.article = article;
	}

	public OrdersItemId() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(article, orders);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdersItemId other = (OrdersItemId) obj;
		return Objects.equals(article, other.article) && Objects.equals(orders, other.orders);
	}
}
