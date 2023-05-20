package co.edu.uco.publiuco.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Pais") //El nomnbre en como se va a poner en la base de datos
public class PaisEntity {
    @Id
    @Column(name = "codigo") // Se puede obviar si es lo mismo como esta el atributo y el tipo de variable
    private UUID codigo;
    //@Column (name = "nombre")  -> // Se puede obviar si es lo mismo como esta el atributo y el tipo de variable
    private String nombre;
}
