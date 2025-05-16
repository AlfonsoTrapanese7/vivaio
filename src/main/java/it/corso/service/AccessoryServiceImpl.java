package it.corso.service;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import it.corso.model.Accessory;
import it.corso.model.Category;
import it.corso.repository.AccessoryRepository;
import it.corso.repository.CategoryRepository;

@Service
public class AccessoryServiceImpl implements AccessoryService {

    @Autowired
    private AccessoryRepository accessoryRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<Accessory> getAllAccessory() {
        return (List<Accessory>) accessoryRepository.findAll();
    }

    @Override
    public Accessory getAccessoryById(Integer id) {
        return accessoryRepository.findById(id).get();
    }

    @Override
    public void activateDisableAccessory(Integer id, String operation) {
        if(operation.equals("activate")){
            accessoryRepository.activateAccessory(id);
        }else if(operation.equals("disable")){
            accessoryRepository.disableAccessory(id);
        }
    }

    @Override
    public List<Category> getAllCategory() {
       return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public void saveAccessoryAndPhoto(Accessory accessory, MultipartFile photo) {
        if (photo != null && !photo.isEmpty()) {
            try {
                String format = photo.getContentType();
                String codedPhoto = "data:" + format + ";base64," + Base64.getEncoder().encodeToString(photo.getBytes());
                accessory.setPhoto(codedPhoto);  
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        accessoryRepository.save(accessory);

    }



}
