package it.corso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.model.Nursery;
import it.corso.repository.NurseryRepository;

@Service
public class NurseryServiceImpl implements NurseryService{

    @Autowired
    private NurseryRepository nurseryRepository;

    @Override
    public List<Nursery> getAllNursery() {
        return (List<Nursery>) nurseryRepository.findAll();    
    }

    @Override
    public Nursery getPlant(Integer id) {
        return nurseryRepository.findById(id).get();
    }

    @Override
    public void activateDisableNursery(Integer id, String operation) {
        if (operation.equals("activate")) {
            nurseryRepository.activateNursery(id);
        } else if (operation.equals("disable")) {
            nurseryRepository.disableNursery(id);
        }

    }

    

}
