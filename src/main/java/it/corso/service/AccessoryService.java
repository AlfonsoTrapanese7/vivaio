package it.corso.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import it.corso.model.Accessory;
import it.corso.model.Category;

public interface AccessoryService {

    List<Accessory> getAllAccessory();
    Accessory getAccessoryById(Integer id);
    void activateDisableAccessory(Integer id, String operation);
    List<Category> getAllCategory();
    void saveAccessoryAndPhoto(Accessory accessory, MultipartFile photo);
    void deleteAccessoryById(Integer id);

}
