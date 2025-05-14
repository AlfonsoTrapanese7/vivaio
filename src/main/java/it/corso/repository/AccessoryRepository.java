package it.corso.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.corso.model.Accessory;
import jakarta.transaction.Transactional;

public interface AccessoryRepository extends CrudRepository<Accessory,Integer> {

@Transactional
@Modifying
@Query(value = "UPDATE accessory SET is_active = 1 WHERE id = ?1;", nativeQuery = true)
void activateAccessory(Integer id);

@Transactional
@Modifying
@Query(value = "UPDATE accessory SET is_active = 0 WHERE id = ?1;", nativeQuery = true)
void disableAccessory(Integer id);


}
