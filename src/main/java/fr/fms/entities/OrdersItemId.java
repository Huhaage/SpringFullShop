package fr.fms.entities;

import java.io.Serializable;

import javax.persistence.ManyToOne;

public class OrdersItemId implements Serializable{
	private  Orders orders;	
	private Article article;
	
	public OrdersItemId(Orders orders, Article article) {
		super();
		this.orders = orders;
		this.article = article;
	}
	

}
