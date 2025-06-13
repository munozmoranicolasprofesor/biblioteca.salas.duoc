package biblioteca.salas.duoc.biblioteca.salas.duoc.model;


import java.util.Date;

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
@Table(name="reserva")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_estudiante", nullable = false)
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "codigo_sala", nullable = false)
    private Sala sala;

    @Column(nullable=false)
    private Date fechaSolicitada;

    @Column(nullable=false)
    private Date horaSolicitada;
        
    @Column(nullable=false)
    private Date horaCierre;

    @Column(nullable=false)
    private Integer estado;
}
