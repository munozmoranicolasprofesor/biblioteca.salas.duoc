package biblioteca.salas.duoc.biblioteca.salas.duoc;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.context.SpringBootTest;

import biblioteca.salas.duoc.biblioteca.salas.duoc.model.TipoSala;
import biblioteca.salas.duoc.biblioteca.salas.duoc.repository.TipoSalaRepository;
import biblioteca.salas.duoc.biblioteca.salas.duoc.service.TipoSalaService;

@SpringBootTest
public class TipoSalaServiceTest {

    @InjectMocks
    private TipoSalaService tipoSalaService;

    @Mock
    private TipoSalaRepository tipoSalaRepository;

    @Test
    public void testFindAll() {
        when(tipoSalaRepository.findAll()).thenReturn(List.of(new TipoSala(1, "Laboratorio")));

        List<TipoSala> tipos = tipoSalaService.findAll();
        assertNotNull(tipos);
        assertEquals(1, tipos.size());
    }

    @Test
    public void testFindById() {
        Integer id = 1;
        TipoSala tipoSala = new TipoSala(id, "Laboratorio");
        when(tipoSalaRepository.findById(id)).thenReturn(Optional.of(tipoSala));

        TipoSala found = tipoSalaService.findById(id);
        assertNotNull(found);
        assertEquals(id, found.getId_tipo());
    }

    @Test
    public void testSave() {
        TipoSala tipoSala = new TipoSala(1, "Laboratorio");
        when(tipoSalaRepository.save(tipoSala)).thenReturn(tipoSala);

        TipoSala saved = tipoSalaService.save(tipoSala);
        assertNotNull(saved);
        assertEquals("Laboratorio", saved.getNombre());
    }

    @Test
    public void testDeleteById() {
        Integer id = 1;
        doNothing().when(tipoSalaRepository).deleteById(id);

        tipoSalaService.delete(id);
        verify(tipoSalaRepository, times(1)).deleteById(id);
    }
}
