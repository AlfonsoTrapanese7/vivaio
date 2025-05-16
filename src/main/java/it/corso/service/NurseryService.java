package it.corso.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import it.corso.model.Location;
import it.corso.model.Nursery;
import it.corso.model.Type;

public interface NurseryService {
    List<Nursery> getAllNursery();
    Nursery getPlant(Integer id);
    void activateDisableNursery(Integer id, String operation);
    List<Type> getAllType();
    List<Location> getAllLocation();
    void saveNurseryAndPhoto(Nursery nursery, MultipartFile photo);
}
