package biblioteca.salas.duoc.biblioteca.salas.duoc.service;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Carrera;
import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Estudiante;
import biblioteca.salas.duoc.biblioteca.salas.duoc.repository.EstudianteRepository;

@SpringBootTest
public class EstudianteServiceTest {

    @InjectMocks
    private EstudianteService estudianteService;

    @Mock
    private EstudianteRepository estudianteRepository;

    @Test
    public void testFindAll(){
        when(estudianteRepository.findAll()).thenReturn(List.of(new Estudiante(1,"11.111.111-1","Juanito Correa","jcorrea@duoc.cl",'D',11111111,new Carrera())));

        List<Estudiante> estudiantes = estudianteService.findAll();
        assertNotNull(estudiantes);
        assertEquals(1, estudiantes.size());
    }

    @Test
    void testFindAll2() {
        Estudiante estudiante = new Estudiante(1,"11.111.111-1", "Juanito Correa", "jcorrea@duoc.cl", 'D', 11111111, new Carrera());
        when(estudianteRepository.findAll()).thenReturn(List.of(estudiante));

        List<Estudiante> result = estudianteService.findAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Juanito Correa", result.get(0).getNombres());
        verify(estudianteRepository).findAll();
    }


}