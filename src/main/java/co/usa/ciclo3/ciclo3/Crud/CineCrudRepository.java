/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.usa.ciclo3.ciclo3.Crud;

import co.usa.ciclo3.ciclo3.model.Cine;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;


/**
 *
 * @author MARIANA
 */
public interface CineCrudRepository extends CrudRepository<Cine, Integer> {

    public Optional<Cine> findById(int id);
    
}
