package biblioteca.salas.duoc.biblioteca.salas.duoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Carrera;
import jakarta.transaction.Transactional;

import biblioteca.salas.duoc.biblioteca.salas.duoc.repository.CarreraRepository;

@Service
@Transactional
public class CarreraService {

    @Autowired
    private CarreraRepository carreraRepository;

    public List<Carrera> findAll(){
        return carreraRepository.findAll();
    }

    public Carrera findById(Integer id){
        return carreraRepository.findById(id).get();
    }

    public Carrera save(Carrera carrera){
        return carreraRepository.save(carrera);
    }

    public void delete(Integer id){
        carreraRepository.deleteById(id);
    }
}
