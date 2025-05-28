package biblioteca.salas.duoc.biblioteca.salas.duoc;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Carrera;
import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Estudiante;
import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Reserva;
import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Sala;
import biblioteca.salas.duoc.biblioteca.salas.duoc.model.TipoSala;
import biblioteca.salas.duoc.biblioteca.salas.duoc.repository.CarreraRepository;
import biblioteca.salas.duoc.biblioteca.salas.duoc.repository.EstudianteRepository;
import biblioteca.salas.duoc.biblioteca.salas.duoc.repository.ReservaRepository;
import biblioteca.salas.duoc.biblioteca.salas.duoc.repository.SalaRepository;
import biblioteca.salas.duoc.biblioteca.salas.duoc.repository.TipoSalaRepository;
import net.datafaker.Faker;

@Component
public class DataLoader implements CommandLineRunner{

    @Autowired
    private CarreraRepository carreraRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private SalaRepository salaRepository;

    @Autowired
    private TipoSalaRepository tipoSalaRepository;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        Random random = new Random();

        //limpiar datos antes
        reservaRepository.deleteAll();
        salaRepository.deleteAll();
        estudianteRepository.deleteAll();
        carreraRepository.deleteAll();
        tipoSalaRepository.deleteAll();
        
        // Generar tipos de sala
        for (int i = 0; i < 3; i++) {
            TipoSala tipoSala = new TipoSala();
            //tipoSala.setIdTipo(i + 1);
            tipoSala.setNombre(faker.book().genre());
            tipoSalaRepository.save(tipoSala);
        } 
        
        // Generar carreras
        for (int i = 0; i < 5; i++) {
            Carrera carrera = new Carrera();
            //carrera.setCodigo(faker.code().asin());
            carrera.setNombre(faker.educator().course());
            carreraRepository.save(carrera);
        }

        List<Carrera> carreras = carreraRepository.findAll();
        
        // Generar estudiantes
        for (int i = 0; i < 50; i++) {

            Estudiante estudiante = new Estudiante();
            //estudiante.setId(i + 1);
            estudiante.setRun(faker.idNumber().valid());
            estudiante.setNombres(faker.name().fullName());
            estudiante.setCorreo(faker.internet().emailAddress());
            estudiante.setJornada(faker.options().option("D", "N").charAt(0));
            estudiante.setTelefono(faker.number().numberBetween(100000000, 999999999));
            estudiante.setCarrera(carreras.get(random.nextInt(carreras.size())));
            estudianteRepository.save(estudiante);
        }
        
        // Generar salas 
        for (int i = 0; i < 10; i++) {
            Sala sala = new Sala();
            //sala.setCodigo(i + 1);
            sala.setNombre(faker.university().name());
            sala.setCapacidad(faker.number().numberBetween(10, 100));
            sala.setId_instituto(faker.number().randomDigit());
            sala.setTipoSala(tipoSalaRepository.findAll().get(random.nextInt(3)));
            salaRepository.save(sala);
        }

        List<Estudiante> estudiantes = estudianteRepository.findAll();
        List<Sala> salas = salaRepository.findAll();
        
        // Generar reservas
        for (int i = 0; i < 20; i++) {
            Reserva reserva = new Reserva();
            //reserva.setId(i + 1);
            reserva.setEstudiante(estudiantes.get(random.nextInt(estudiantes.size())));
            reserva.setSala(salas.get(random.nextInt(salas.size())));
            reserva.setFecha_solicitada(new Date());
            reserva.setHora_solicitada(new Date());
            reserva.setHora_cierre(new Date(System.currentTimeMillis() + faker.number().numberBetween(3600000, 7200000))); // 1-2 horas más
            reserva.setEstado(faker.number().numberBetween(0, 2));
            reservaRepository.save(reserva);
        }
    }
}
