package biblioteca.salas.duoc.biblioteca.salas.duoc.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Estudiante;
import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
    
    List<Reserva> findAllByEstudianteAndFechaSolicitada(Estudiante estudiante,Date fechaSolicitada);
    List<Reserva> findAllByEstudiante(Estudiante estudiante);
}
