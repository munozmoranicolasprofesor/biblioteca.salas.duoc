package biblioteca.salas.duoc.biblioteca.salas.duoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ResponseEntity<List<TipoSala>> listar(){
        List<TipoSala> tiposSalas = tipoSalaService.findAll();
        if(tiposSalas.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tiposSalas);
    }

    @PostMapping
    public ResponseEntity<TipoSala> guardar(@RequestBody TipoSala tipoSala){
        TipoSala tipoSalaNuevo = tipoSalaService.save(tipoSala);
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoSalaNuevo);
    }
}
