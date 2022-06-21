package fr.fms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.fms.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

	Category findByDescription(String string);

}
