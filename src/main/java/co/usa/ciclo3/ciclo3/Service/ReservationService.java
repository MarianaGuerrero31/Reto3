/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.ciclo3.Service;

import co.usa.ciclo3.ciclo3.Repository.ReservationRepository;
import co.usa.ciclo3.ciclo3.model.Reservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
/**
 *
 * @author MARIANA
 */
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    
    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    
    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }
    
    public Reservation save(Reservation reservation){
        if(reservation.getId() == null){
            return reservationRepository.save(reservation);
        }else{
            Optional<Reservation> aux = reservationRepository.getReservation(reservation.getId());
            if(aux.isPresent()){
                return reservation;
            }else{
                return reservationRepository.save(reservation);
            }
        }
    }

    public Reservation update(Reservation reservation){
        if(reservation.getId() != null){
            Optional<Reservation> c = reservationRepository.getReservation(reservation.getId());
            if(c.isPresent()){
                if(reservation.getName() != null){
                    c.get().setName(reservation.getName());
                }
                if(reservation.getDescription() != null){
                    c.get().setDescription(reservation.getDescription());
                }
                if(reservation.getCines() != null){
                    c.get().setCines(reservation.getCines());
                }
                reservationRepository.save(c.get());
                return c.get();
            }else{
                return reservation;
            }
            }else{
                return reservation;
            }      
        }
    
    public boolean delete(int id){
        boolean flag = false;
        Optional<Reservation> c = reservationRepository.getReservation(id);
        if(c.isPresent()){
            reservationRepository.delete(c.get());
        }
        return flag;
        }
    
}
