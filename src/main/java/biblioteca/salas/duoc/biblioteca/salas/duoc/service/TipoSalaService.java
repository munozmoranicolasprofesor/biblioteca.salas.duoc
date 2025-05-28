package biblioteca.salas.duoc.biblioteca.salas.duoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biblioteca.salas.duoc.biblioteca.salas.duoc.model.TipoSala;
import biblioteca.salas.duoc.biblioteca.salas.duoc.repository.TipoSalaRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class TipoSalaService {

    @Autowired
    private TipoSalaRepository tipoSalaRepository;

    public List<TipoSala> findAll(){
        return tipoSalaRepository.findAll();
    }

    public TipoSala findById(Integer id){
        return tipoSalaRepository.findById(id).get();
    }

    public TipoSala save(TipoSala tipoSala){
        return tipoSalaRepository.save(tipoSala);
    }

    public void delete(Integer id){
        tipoSalaRepository.deleteById(id);
    }
}
