package it.corso.service;

import java.util.List;

import it.corso.model.Accessory;

public interface AccessoryService {

    List<Accessory> getAllAccessory();
    Accessory getAccessoryById(Integer id);
    void activateDisableAccessory(Integer id, String operation);
}
