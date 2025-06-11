package biblioteca.salas.duoc.biblioteca.salas.duoc.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.MediaTypes;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import biblioteca.salas.duoc.biblioteca.salas.duoc.assemblers.CarreraModelAssembler;
import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Carrera;
import biblioteca.salas.duoc.biblioteca.salas.duoc.service.CarreraService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/v2/carreras")
@Tag(name="Carreras",description="Operaciones relacionadas con las carreras")
public class CarreraControllerV2 {

    @Autowired
    private CarreraService carreraService;

    @Autowired
    private CarreraModelAssembler assembler;

    @GetMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public CollectionModel<EntityModel<Carrera>> getAllCarreras() {
        List<EntityModel<Carrera>> carreras = carreraService.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(carreras,linkTo(methodOn(CarreraControllerV2.class).getAllCarreras()).withSelfRel());
    }

    @GetMapping(value = "/{codigo}", produces = MediaTypes.HAL_JSON_VALUE)
    public EntityModel<Carrera> getCarreraByCodigo(@PathVariable Integer codigo) {
        Carrera carrera = carreraService.findById(codigo);
        return assembler.toModel(carrera);
    }

    @PostMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<EntityModel<Carrera>> createCarrera(@RequestBody Carrera carrera) {
        Carrera newCarrera = carreraService.save(carrera);
        return ResponseEntity
                .created(linkTo(methodOn(CarreraControllerV2.class).getCarreraByCodigo(newCarrera.getCodigo())).toUri())
                .body(assembler.toModel(newCarrera));
    }

    @PutMapping(value = "/{codigo}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<EntityModel<Carrera>> updateCarrera(@PathVariable Integer codigo, @RequestBody Carrera carrera) {
        carrera.setCodigo(codigo);
        Carrera updatedCarrera = carreraService.save(carrera);
        return ResponseEntity
                .ok(assembler.toModel(updatedCarrera));
    }

    @DeleteMapping(value = "/{codigo}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<?> deleteCarrera(@PathVariable Integer codigo) {
        carreraService.delete(codigo);
        return ResponseEntity.noContent().build();
    }

}
