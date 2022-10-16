/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.ciclo3.Service;

import co.usa.ciclo3.ciclo3.Repository.CineRepository;
import co.usa.ciclo3.ciclo3.model.Cine;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
/**
 *
 * @author MARIANA
 */
public class CineService {
    @Autowired
    private CineRepository cineRepository;
    
    public List<Cine> getAll(){
        return cineRepository.getAll();
    }
    
    public Optional<Cine> getCine(int id){
        return cineRepository.getCine(id);
    }
    
    public Cine save(Cine cine){
        if(cine.getId() == null){
            return cineRepository.save(cine);
        }else{
            Optional<Cine> aux = cineRepository.getCine(cine.getId());
            if(aux.isPresent()){
                return cine;
            }else{
                return cineRepository.save(cine);
            }
        }
    }

    public Cine update(Cine cine){
        if(cine.getId() != null){
            Optional<Cine> c = cineRepository.getcine(cine.getId());
            if(c.isPresent()){
                if(cine.getName() != null){
                    c.get().setName(cine.getName());
                }
                if(cine.getDescription() != null){
                    c.get().setDescription(cine.getDescription());
                }
                if(cine.getCines() != null){
                    c.get().setCines(cine.getCines());
                }
                cineRepository.save(c.get());
                return c.get();
            }else{
                return cine;
            }
            }else{
                return cine;
            }      
        }
    
    public boolean delete(int id){
        boolean flag = false;
        Optional<Cine> c = cineRepository.getCine(id);
        if(c.isPresent()){
            cineRepository.delete(c.get());
        }
        return flag;
        }
    
}
