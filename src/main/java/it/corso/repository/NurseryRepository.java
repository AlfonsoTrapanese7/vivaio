package it.corso.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.corso.model.Nursery;
import jakarta.transaction.Transactional;

public interface NurseryRepository extends CrudRepository<Nursery,Integer>{
    @Modifying
    @Transactional
    @Query(value = "UPDATE nursery SET is_active = 1 WHERE id = ?1;", nativeQuery = true)
    void activateNursery(Integer id);
    @Modifying
    @Transactional
    @Query(value = "UPDATE nursery SET is_active = 0 WHERE id = ?1;", nativeQuery = true)
    void disableNursery(Integer id);
}
