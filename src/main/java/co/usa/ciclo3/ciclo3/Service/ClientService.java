/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.ciclo3.Service;

import co.usa.ciclo3.ciclo3.Repository.ClientRepository;
import co.usa.ciclo3.ciclo3.model.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
/**
 *
 * @author MARIANA
 */
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    
    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    
    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }
    
    public Client save(Client client){
        if(client.getId() == null){
            return clientRepository.save(client);
        }else{
            Optional<Client> aux = clientRepository.getClient((int) client.getId());
            if(aux.isPresent()){
                return client;
            }else{
                return clientRepository.save(client);
            }
        }
    }

    public Client update(Client client){
        if(client.getId() != null){
            Optional<Client> c = clientRepository.getClient((int) client.getId());
            if(c.isPresent()){
                if(client.getName() != null){
                    c.get().setName(client.getName());
                }
                if(client.getDescription() != null){
                    c.get().setDescription(client.getDescription());
                }
                if(client.getCines() != null){
                    c.get().setCines(client.getCines());
                }
                clientRepository.save(c.get());
                return c.get();
            }else{
                return client;
            }
            }else{
                return client;
            }      
        }
    
    public boolean delete(int id){
        boolean flag = false;
        Optional<Client> c = clientRepository.getClient(id);
        if(c.isPresent()){
            clientRepository.delete(c.get());
        }
        return flag;
        }
}
