/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.ciclo3.Service;

import co.usa.ciclo3.ciclo3.Repository.MessageRepository;
import co.usa.ciclo3.ciclo3.model.Message;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
/**
 *
 * @author MARIANA
 */
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    
    public List<Message> getAll(){
        return messageRepository.getAll();
    }
    
    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }
    
    public Message save(Message message){
        if(message.getId() == null){
            return messageRepository.save(message);
        }else{
            Optional<Message> aux = messageRepository.getMessage((int) message.getId());
            if(aux.isPresent()){
                return message;
            }else{
                return messageRepository.save(message);
            }
        }
    }

    public Message update(Message message){
        if(message.getId() != null){
            Optional<Message> c = messageRepository.getMessage((int) message.getId());
            if(c.isPresent()){
                if(message.getName() != null){
                    c.get().setName(message.getName());
                }
                if(message.getDescription() != null){
                    c.get().setDescription(message.getDescription());
                }
                if(message.getCines() != null){
                    c.get().setCines(message.getCines());
                }
                messageRepository.save(c.get());
                return c.get();
            }else{
                return message;
            }
            }else{
                return message;
            }      
        }
    
    public boolean delete(int id){
        boolean flag = false;
        Optional<Message> c = messageRepository.getMessage(id);
        if(c.isPresent()){
            messageRepository.delete(c.get());
        }
        return flag;
        }
}
