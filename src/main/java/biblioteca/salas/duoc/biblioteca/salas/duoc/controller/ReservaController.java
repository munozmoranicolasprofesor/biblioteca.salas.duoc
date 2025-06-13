package biblioteca.salas.duoc.biblioteca.salas.duoc.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Estudiante;
import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Reserva;
import biblioteca.salas.duoc.biblioteca.salas.duoc.service.EstudianteService;
import biblioteca.salas.duoc.biblioteca.salas.duoc.service.ReservaService;

@RestController
@RequestMapping("api/v1/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping
    public List<Reserva> getAllReservas() {
        return reservaService.findAll();
    }

    @GetMapping("/{id}")
    public Reserva getReservaById(@PathVariable Integer id) {
        return reservaService.findById(id);
    }

    @GetMapping("estudiantes/{id_estudiante}")
    public List<Reserva> getReservaByEstudiante(@PathVariable Integer id_estudiante) {
        Estudiante estudiante = estudianteService.findById(id_estudiante);
        return reservaService.findByEstudiante(estudiante);
    }

    @GetMapping("/{id_estudiante}/{fechaSolicitada}")
    public List<Reserva> getReservaById(@PathVariable Integer id_estudiante,@PathVariable String fechaSolicitada) {
        Estudiante estudiante = estudianteService.findById(id_estudiante);
        fechaSolicitada = fechaSolicitada.replaceFirst(":(?=[0-9]{2}$)", "");

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        Date fechaSolitadaDate;
        try {
            fechaSolitadaDate = formato.parse(fechaSolicitada);
        } catch (ParseException e) {
            fechaSolitadaDate = new Date();
        }
        return reservaService.findByEstudianteAndFechaSolicitada(estudiante,fechaSolitadaDate);
    }

    @PostMapping
    public Reserva createReserva(@RequestBody Reserva reserva) {
        return reservaService.save(reserva);
    }

    @PutMapping("/{id}")
    public Reserva updateReserva(@PathVariable Integer id, @RequestBody Reserva reserva) {
        reserva.setId(id);
        return reservaService.save(reserva);
    }

    @DeleteMapping("/{id}")
    public void deleteReserva(@PathVariable Integer id) {
        reservaService.delete(id);
    }
}
