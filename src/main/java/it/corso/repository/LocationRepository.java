package it.corso.repository;

import org.springframework.data.repository.CrudRepository;

import it.corso.model.Location;

public interface LocationRepository extends CrudRepository<Location, Integer>{
    
}
