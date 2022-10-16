/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.ciclo3.Service;

import co.usa.ciclo3.ciclo3.Repository.ScoreRepository;
import co.usa.ciclo3.ciclo3.model.Score;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
/**
 *
 * @author MARIANA
 */
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;
    
    public List<Score> getAll(){
        return scoreRepository.getAll();
    }
    
    public Optional<Score> getScore(int id){
        return scoreRepository.getScore(id);
    }
    
    public Score save(Score score){
        if(score.getId() == null){
            return scoreRepository.save(score);
        }else{
            Optional<Score> aux = scoreRepository.getScore((int) score.getId());
            if(aux.isPresent()){
                return score;
            }else{
                return scoreRepository.save(score);
            }
        }
    }

    public Score update(Score score){
        if(score.getId() != null){
            Optional<Score> c = scoreRepository.getScore((int) score.getId());
            if(c.isPresent()){
                if(score.getName() != null){
                    c.get().setName(score.getName());
                }
                if(score.getDescription() != null){
                    c.get().setDescription(score.getDescription());
                }
                if(score.getCines() != null){
                    c.get().setCines(score.getCines());
                }
                scoreRepository.save(c.get());
                return c.get();
            }else{
                return score;
            }
            }else{
                return score;
            }      
        }
    
    public boolean delete(int id){
        boolean flag = false;
        Optional<Score> c = scoreRepository.getScore(id);
        if(c.isPresent()){
            scoreRepository.delete(c.get());
        }
        return flag;
        }
    
}
