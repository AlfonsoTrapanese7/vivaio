package it.corso.repository;

import org.springframework.data.repository.CrudRepository;

import it.corso.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer>{

}
