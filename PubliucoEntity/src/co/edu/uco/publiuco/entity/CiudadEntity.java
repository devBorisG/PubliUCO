package co.edu.uco.publiuco.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Ciudad")
public class CiudadEntity {
    @Id
    @Column(name = "codigo") // Se puede obviar si es lo mismo como esta el atributo y el tipo de variable
    private UUID codigo;
    @ManyToOne
    @JoinColumn(name = "departamento") //llave foranea de la tabla Departamento
    private DepartamentoEntity departamento;
    // @Column(name = "nombre") // Se puede obviar si es lo mismo como esta el atributo y el tipo de variable
    private String nombre;

}
