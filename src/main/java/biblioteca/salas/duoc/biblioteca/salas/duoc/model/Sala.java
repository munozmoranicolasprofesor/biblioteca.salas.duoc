package biblioteca.salas.duoc.biblioteca.salas.duoc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="sala")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sala {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable=false)
    private String nombre;

    @Column(nullable=false)
    private Integer capacidad;

    @Column(nullable=false)
    private Integer id_instituto;

    @ManyToOne    
    @JoinColumn(name = "id_tipo", nullable = false)
    private TipoSala tipoSala;
}
