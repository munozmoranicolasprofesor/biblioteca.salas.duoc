package biblioteca.salas.duoc.biblioteca.salas.duoc.service;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Estudiante;
import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Reserva;
import biblioteca.salas.duoc.biblioteca.salas.duoc.repository.ReservaRepository;
import jakarta.transaction.Transactional;


@Service
@Transactional
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> findAll(){
        return reservaRepository.findAll();
    }

    public List<Reserva> findByEstudianteAndFechaSolicitada(Estudiante estudiante,Date fechaSolicitada){
        return reservaRepository.findAllByEstudianteAndFechaSolicitada(estudiante, fechaSolicitada);
    }

    public List<Reserva> findByEstudiante(Estudiante estudiante){
        return reservaRepository.findAllByEstudiante(estudiante);
    }

    public Reserva findById(Integer id){
        return reservaRepository.findById(id).get();
    }

    public Reserva save(Reserva reserva){
        return reservaRepository.save(reserva);
    }

    public void delete(Integer id){
        reservaRepository.deleteById(id);
    }
}
