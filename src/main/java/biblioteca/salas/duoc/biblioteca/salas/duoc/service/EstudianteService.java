package biblioteca.salas.duoc.biblioteca.salas.duoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Estudiante;
import biblioteca.salas.duoc.biblioteca.salas.duoc.repository.EstudianteRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    public List<Estudiante> findAll(){
        return estudianteRepository.findAll();
    }

    public Estudiante findById(Integer id){
        return estudianteRepository.findById(id).get();
    }

    public Estudiante save(Estudiante estudiante){
        return estudianteRepository.save(estudiante);
    }

    public void delete(Integer id){
        estudianteRepository.deleteById(id);
    }
}
