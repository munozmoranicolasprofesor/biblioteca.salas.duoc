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
@Table(name="estudiante")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estudiante {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false)
    private String run;

    @Column(nullable=false)
    private String nombres;

    @Column(nullable=false)
    private String correo;

    @Column(nullable=false)
    private Character jornada;
        
    @Column(nullable=false)
    private Integer telefono;

    @ManyToOne
    @JoinColumn(name = "codigo_carrera", nullable = false)
    private Carrera carrera;
}
