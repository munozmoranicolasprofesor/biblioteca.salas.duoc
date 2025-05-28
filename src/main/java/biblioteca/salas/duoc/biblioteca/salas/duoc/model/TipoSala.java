package biblioteca.salas.duoc.biblioteca.salas.duoc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tipo_sala")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoSala {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id_tipo;

    @Column(nullable=false)
    private String nombre;

}
