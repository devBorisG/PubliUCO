package co.edu.uco.publiuco.service.usecase.ciudad.implementation;

import co.edu.uco.publiuco.entity.CiudadEntity;
import co.edu.uco.publiuco.repository.ciudad.CiudadRepository;
import co.edu.uco.publiuco.service.domain.CiudadDomain;
import co.edu.uco.publiuco.service.mapper.MapperToEntity;
import co.edu.uco.publiuco.service.specification.ciudad.CiudadSpecification;
import co.edu.uco.publiuco.service.usecase.ciudad.RegistrarCiudad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrarCiudadImpl implements RegistrarCiudad {

    @Autowired
    private CiudadRepository repository;

    @Autowired
    private CiudadSpecification specification;

    @Override
    public void execute(CiudadDomain domain) {
        // TODO: Crear las reglas de negocio
        // Specification patter o un Validator Pattern (Se pueden combinar los dos)
        // 1 que no exista con el mismo id
        // 2 que no exista con el mismo nombre para el mismo departamento
        // 3 que el dominio cumpla con todas la reglas de intregridad:
            // Cualquier longitud pero la regla es que el nombre puede tener solamente letras y espacios
            // Los nombres de la cidad, dpto y pais son obligatorios
            // El departamento en una ciudad es obligatorio
            // El pais en un departamente es obligatorio
        specification.isSatisfied(domain);
        // TODO: Aqui se debe crear el ensamblador -> Posiblemente ayude el uso de DataMapper for java
        MapperToEntity<CiudadDomain,CiudadEntity> map = new MapperToEntity<>();
        CiudadEntity entity = map.mapToEntity(domain, CiudadEntity.class);
        repository.save(entity);
    }
}
