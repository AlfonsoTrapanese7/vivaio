package it.corso.service;

import java.util.List;

import it.corso.model.Nursery;

public interface NurseryService {
    List<Nursery> getAllNursery();
    Nursery getPlant(Integer id);
}
