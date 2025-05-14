package it.corso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.model.Accessory;
import it.corso.repository.AccessoryRepository;

@Service
public class AccessoryServiceImpl implements AccessoryService {

    @Autowired
    private AccessoryRepository accessoryRepository;

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



}
