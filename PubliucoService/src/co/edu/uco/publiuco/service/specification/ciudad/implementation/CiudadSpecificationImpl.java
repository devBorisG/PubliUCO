package co.edu.uco.publiuco.service.specification.ciudad.implementation;

import co.edu.uco.publiuco.service.domain.CiudadDomain;
import co.edu.uco.publiuco.service.specification.ciudad.CiudadSpecification;

public class CiudadSpecificationImpl implements CiudadSpecification {

    @Override
    public boolean isSatisfied(CiudadDomain domain) {
        // 1 que no exista con el mismo id
        // 2 que no exista con el mismo nombre para el mismo departamento
        // 3 que el dominio cumpla con todas la reglas de intregridad:
        // Cualquier longitud pero la regla es que el nombre puede tener solamente letras y espacios
        // Los nombres de la cidad, dpto y pais son obligatorios
        // El departamento en una ciudad es obligatorio
        // El pais en un departamente es obligatorio
        return false;
    }
}
