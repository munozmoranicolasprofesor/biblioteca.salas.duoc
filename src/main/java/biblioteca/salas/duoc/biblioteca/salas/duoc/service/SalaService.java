package biblioteca.salas.duoc.biblioteca.salas.duoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Sala;
import biblioteca.salas.duoc.biblioteca.salas.duoc.repository.SalaRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class SalaService {

    @Autowired
    private SalaRepository salaRepository;

    public List<Sala> findAll(){
        return salaRepository.findAll();
    }

    public Sala findById(Integer id){
        return salaRepository.findById(id).get();
    }

    public Sala save(Sala sala){
        return salaRepository.save(sala);
    }

    public void delete(Integer id){
        salaRepository.deleteById(id);
    }
}
