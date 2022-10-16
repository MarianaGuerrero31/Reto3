/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Web;

import co.usa.ciclo3.ciclo3.Service.CineService;
import co.usa.ciclo3.ciclo3.model.Cine;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Cine")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

/**
 *
 * @author MARIANA
 */
public class CineController {
    @Autowired
    private CineService cineService;
    
    @GetMapping("/all")
    public List<Cine> getCines(){
        return cineService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Cine> getCine(@PathVariable("id") int id){
        return cineService.getCine(id);   
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cine save(@RequestBody Cine cine){
        return cineService.save(cine);
    }
    
    @PutMapping("/update")
    public Cine update(@RequestBody Cine cine){
        return cineService.update(cine);
    }
    
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id){
        return cineService.delete(id);
    }  
}
