package biblioteca.salas.duoc.biblioteca.salas.duoc.assemblers;


import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import biblioteca.salas.duoc.biblioteca.salas.duoc.controller.CarreraControllerV2;
import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Carrera;


@Component
public class CarreraModelAssembler implements RepresentationModelAssembler<Carrera, EntityModel<Carrera>> {

    @Override
    @NonNull
    public EntityModel<Carrera> toModel(Carrera carrera) {
        return EntityModel.of(carrera,
                linkTo(methodOn(CarreraControllerV2.class).getCarreraByCodigo(carrera.getCodigo())).withSelfRel(),
                linkTo(methodOn(CarreraControllerV2.class).getAllCarreras()).withRel("carreras"));
    }
}