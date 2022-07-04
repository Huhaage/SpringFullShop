package fr.fms.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.websocket.OnError;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Category {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String description;

	@NotNull
	private String imgUrl;
	
	@OneToMany(mappedBy = "category")
	private Collection<Article> articles;

	/**
	 * @param id
	 * @param description
	 * @param imgUrl
	 */
	public Category(Long id, @NotNull String description, @NotNull String imgUrl) {
		this.id = id;
		this.description = description;
		this.imgUrl = imgUrl;
	}
	
	
}
