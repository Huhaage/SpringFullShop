package fr.fms.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.fms.entities.Article;
import fr.fms.entities.Category;

public interface ArticleRepository extends JpaRepository<Article,Long> {
	Page<Article> findByDescriptionContains(String description, Pageable pageable);
	List<Article> findByCategoryId(Long id);
	Page<Article> findByCategoryId(Long categoryId, Pageable pageable);
}
