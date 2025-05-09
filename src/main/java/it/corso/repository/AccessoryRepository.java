package it.corso.repository;

import org.springframework.data.repository.CrudRepository;

import it.corso.model.Accessory;

public interface AccessoryRepository extends CrudRepository<Accessory,Integer> {

}
