package co.edu.uco.publiuco.service.usecase.pais.implementation;

import co.edu.uco.publiuco.entity.PaisEntity;
import co.edu.uco.publiuco.repository.PaisRepository;
import co.edu.uco.publiuco.service.domain.PaisDomain;
import co.edu.uco.publiuco.service.mapper.MapperToEntity;
import co.edu.uco.publiuco.service.usecase.pais.RegistrarPais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrarPaisImpl implements RegistrarPais {

    @Autowired
    private PaisRepository repository;

    @Override
    public void execute(PaisDomain domain) {
        //TODO: realizar Implementación validaciones
        // Crear ensamblador
        MapperToEntity<PaisDomain,PaisEntity> map = new MapperToEntity<>();
        PaisEntity entity = map.mapToEntity(domain,PaisEntity.class);
        // Realizar validaciones
        repository.save(entity);
    }
}
