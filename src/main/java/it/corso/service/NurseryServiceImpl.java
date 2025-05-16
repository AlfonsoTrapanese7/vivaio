package it.corso.service;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import it.corso.model.Location;
import it.corso.model.Nursery;
import it.corso.model.Type;
import it.corso.repository.LocationRepository;
import it.corso.repository.NurseryRepository;
import it.corso.repository.TypeRepository;

@Service
public class NurseryServiceImpl implements NurseryService{

    @Autowired
    private NurseryRepository nurseryRepository;

    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private LocationRepository locationRepository;

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

    @Override
    public List<Type> getAllType() {
        return (List<Type>) typeRepository.findAll();
    }

    @Override
    public List<Location> getAllLocation() {
        return (List<Location>) locationRepository.findAll();
    }

    @Override
    public void saveNurseryAndPhoto(Nursery nursery, MultipartFile photo) {
        if (photo != null && !photo.isEmpty()) {
            try {
                String format = photo.getContentType();
                String codedPhoto = "data:" + format + ";base64," + Base64.getEncoder().encodeToString(photo.getBytes());
                nursery.setPhoto(codedPhoto);  
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        nurseryRepository.save(nursery);
    }

    @Override
    public void deleteNurseryById(Integer id) {
        nurseryRepository.deleteById(id);
    }

    


    

}
