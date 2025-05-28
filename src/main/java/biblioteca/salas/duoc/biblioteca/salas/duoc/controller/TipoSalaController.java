package biblioteca.salas.duoc.biblioteca.salas.duoc.controller;

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

import biblioteca.salas.duoc.biblioteca.salas.duoc.model.TipoSala;
import biblioteca.salas.duoc.biblioteca.salas.duoc.service.TipoSalaService;

@RestController
@RequestMapping("api/v1/tiposalas")
public class TipoSalaController {

    @Autowired
    private TipoSalaService tipoSalaService;

    @GetMapping
    public List<TipoSala> getAllTipoSalas() {
        return tipoSalaService.findAll();
    }

    @GetMapping("/{id}")
    public TipoSala getTipoSalaById(@PathVariable Integer id) {
        return tipoSalaService.findById(id);
    }

    @PostMapping
    public TipoSala createTipoSala(@RequestBody TipoSala tipoSala) {
        return tipoSalaService.save(tipoSala);
    }

    @PutMapping("/{id}")
    public TipoSala updateTipoSala(@PathVariable Integer id, @RequestBody TipoSala tipoSala) {
        tipoSala.setId_tipo(id);
        return tipoSalaService.save(tipoSala);
    }

    @DeleteMapping("/{id}")
    public void deleteTipoSala(@PathVariable Integer id) {
        tipoSalaService.delete(id);
    }
}
