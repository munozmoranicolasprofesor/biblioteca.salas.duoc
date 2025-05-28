package biblioteca.salas.duoc.biblioteca.salas.duoc;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Carrera;
import biblioteca.salas.duoc.biblioteca.salas.duoc.repository.CarreraRepository;
import biblioteca.salas.duoc.biblioteca.salas.duoc.service.CarreraService;

@SpringBootTest
public class CarreraServiceTest {

    @InjectMocks
    private CarreraService carreraService;

    @Mock
    private CarreraRepository carreraRepository;

    @Test
    public void testFindAll() {
        when(carreraRepository.findAll()).thenReturn(List.of(new Carrera(1, "Ingeniería")));

        List<Carrera> carreras = carreraService.findAll();

        assertNotNull(carreras);
        assertEquals(1, carreras.size());
    }

    @Test
    public void testFindByCodigo() {
        Integer codigo = 56;
        Carrera carrera = new Carrera(codigo, "Ingeniería");

        when(carreraRepository.findById(codigo)).thenReturn(Optional.of(carrera));

        Carrera found = carreraService.findById(codigo);

        assertNotNull(found);
        assertEquals(codigo, found.getCodigo());
    }

    @Test
    public void testSave() {
        Carrera carrera = new Carrera(1, "Ingeniería");

        when(carreraRepository.save(carrera)).thenReturn(carrera);

        Carrera saved = carreraService.save(carrera);

        assertNotNull(saved);
        assertEquals("Ingeniería", saved.getNombre());
    }

    @Test
    public void testDeleteByCodigo() {
        Integer codigo = 1;

        doNothing().when(carreraRepository).deleteById(codigo);

        carreraService.delete(codigo);

        verify(carreraRepository, times(1)).deleteById(codigo);
    }
}