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

import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Carrera;
import biblioteca.salas.duoc.biblioteca.salas.duoc.service.CarreraService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/v1/carreras")
@Tag(name="Carreras",description="Operaciones relacionadas con las carreras")
public class CarreraController {

    @Autowired
    private CarreraService carreraService;

    @GetMapping
    @Operation(summary="Obtener todas las carreras", description="Obtiene una lista de todas las carreras")
    public List<Carrera> getAllCarreras() {
        return carreraService.findAll();
    }

    @GetMapping("/{id}")
    public Carrera getCarreraByCodigo(@PathVariable Integer codigo) {
        return carreraService.findById(codigo);
    }

    @PostMapping
    public Carrera createCarrera(@RequestBody Carrera carrera) {
        return carreraService.save(carrera);
    }

    @PutMapping("/{codigo}")
    @Operation(summary="Actualizar una carrera",description="Actualiza una carrera existente")
    @ApiResponses(value={@ApiResponse(responseCode="200",description="Carrera actualizada exitosamente",content=@Content(mediaType="application/json",schema=@Schema(implementation=Carrera.class))),@ApiResponse(responseCode="404", description="Carrera no encontrada")})
    public Carrera updateCarrera(@PathVariable Integer codigo, @RequestBody Carrera carrera) {
        carrera.setCodigo(codigo);
        return carreraService.save(carrera);
    }

    @DeleteMapping("/{codigo}")
    public void deleteCarrera(@PathVariable Integer codigo) {
        carreraService.delete(codigo);
    }
}
