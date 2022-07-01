package fr.fms.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SQLDelete(sql = "UPDATE article SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Article {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=2,max=50)
	private String description;
	
	@NotNull
	private String brand;
	
	@DecimalMin("50")
	private double price;
	
	@NotNull
	private String imgUrl;

	@ManyToOne
	private Category category;
	

	@Min(1)
	private int quantity=1;
	
	private boolean deleted = Boolean.FALSE; 
	
	@OneToMany(mappedBy="article")
	private Collection<OrdersItem> ordersItem;

	public Article(Long id, @NotNull @Size(min = 2, max = 50) String description, @NotNull String brand,
			@DecimalMin("50") double price, @NotNull String imgUrl, Category category, @Min(1) int quantity) {
		super();
		this.id = id;
		this.description = description;
		this.brand = brand;
		this.price = price;
		this.imgUrl = imgUrl;
		this.category = category;
		this.quantity = quantity;
	}

	public Article(Long id, @NotNull @Size(min = 2, max = 50) String description, @NotNull String brand,
			@DecimalMin("50") double price, @NotNull String imgUrl, Category category, @Min(1) int quantity,
			Collection<OrdersItem> ordersItem) {
		super();
		this.id = id;
		this.description = description;
		this.brand = brand;
		this.price = price;
		this.imgUrl = imgUrl;
		this.category = category;
		this.quantity = quantity;
		this.ordersItem = ordersItem;
	}
	
	
}
