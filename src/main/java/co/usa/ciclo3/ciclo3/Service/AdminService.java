/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.ciclo3.Service;

import co.usa.ciclo3.ciclo3.Repository.AdminRepository;
import co.usa.ciclo3.ciclo3.model.Admin;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
/**
 *
 * @author MARIANA
 */
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
    
    public List<Admin> getAll(){
        return adminRepository.getAll();
    }
    
    public Optional<Admin> getAdmin(int id){
        return adminRepository.getAdmin(id);
    }
    
    public Admin save(Admin category){
        Admin admin = null;
        if(admin.getId() == null){
            return adminRepository.save(admin);
        }else{
            Optional<Admin> aux = adminRepository.getAdmin((int) admin.getId());
            if(aux.isPresent()){
                return admin;
            }else{
                return adminRepository.save(admin);
            }
        }
    }

    public Admin update(Admin admin){
        if(admin.getId() != null){
            Optional<Admin> c = adminRepository.getAdmin((int) admin.getId());
            if(c.isPresent()){
                if(admin.getName() != null){
                    c.get().setName(admin.getName());
                }
                if(admin.getDescription() != null){
                    c.get().setDescription(admin.getDescription());
                }
                if(admin.getCines() != null){
                    c.get().setCines(admin.getCines());
                }
                adminRepository.save(c.get());
                return c.get();
            }else{
                return admin;
            }
            }else{
                return admin;
            }      
        }
    
    public boolean delete(int id){
        boolean flag = false;
        Optional<Admin> c = adminRepository.getAdmin(id);
        if(c.isPresent()){
            adminRepository.delete(c.get());
        }
        return flag;
        }
}
