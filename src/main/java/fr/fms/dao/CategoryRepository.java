package fr.fms.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.fms.entities.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {
	Category findByDescription(String string);
	Page<Category> findByDescriptionContains(String description, Pageable pageable);
}
