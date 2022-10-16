/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.ciclo3.Repository;

import co.usa.ciclo3.ciclo3.Crud.CineCrudRepository;
import co.usa.ciclo3.ciclo3.model.Cine;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
/**
 *
 * @author MARIANA
 */
public class CineRepository {
    @Autowired
    private CineCrudRepository cineCrudRepository;
    
    public List<Cine> getAll(){
        return (List<Cine>) cineCrudRepository.findAll();
    }
    
    public Optional<Cine> getcine(int id){
        return cineCrudRepository.findById(id);
    }
    
    public Cine save(Cine cine){
        return cineCrudRepository.save(cine);
    }
    
    public void delete(Cine cine){
        cineCrudRepository.delete(cine);
    }

    public Optional<Cine> getCine(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
