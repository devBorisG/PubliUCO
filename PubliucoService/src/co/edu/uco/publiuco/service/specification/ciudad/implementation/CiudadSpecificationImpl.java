package co.edu.uco.publiuco.service.specification.ciudad.implementation;

import co.edu.uco.publiuco.service.domain.CiudadDomain;
import co.edu.uco.publiuco.service.specification.ciudad.CiudadSpecification;
import co.edu.uco.publiuco.service.usecase.ciudad.ListarCiudades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CiudadSpecificationImpl implements CiudadSpecification {

    @Autowired
    private ListarCiudades listarCiudades;

    @Override
    public boolean isSatisfied(CiudadDomain domain) {
        boolean state = true;
        // 1 que no exista con el mismo id
        // 2 que no exista con el mismo nombre para el mismo departamento
        if (!listarCiudades.execute(Optional.of(domain)).isEmpty()) state = false;
        return state;
        // 3 que el dominio cumpla con todas la reglas de intregridad:
        // Cualquier longitud pero la regla es que el nombre puede tener solamente letras y espacios
        // Los nombres de la cidad, dpto y pais son obligatorios
        // El departamento en una ciudad es obligatorio
        // El pais en un departamente es obligatorio

    }
}
