package co.edu.uco.publiuco.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Departamento")
public class DepartamentoEntity {
    @Id
    private UUID codigo;
    @ManyToOne
    @JoinColumn(name = "pais") //llave foranea de la tabla Pais
    private PaisEntity pais;
    @Column(name = "nombre") // Se puede obviar si es lo mismo como esta el atributo y el tipo de variable
    private String nombre;
}
