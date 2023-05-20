package co.edu.uco.publiuco.service.usecase.departamento.implementation;

import co.edu.uco.publiuco.entity.DepartamentoEntity;
import co.edu.uco.publiuco.repository.DepartamentoRepository;
import co.edu.uco.publiuco.service.domain.DepartamentoDomain;
import co.edu.uco.publiuco.service.mapper.MapperToEntity;
import co.edu.uco.publiuco.service.usecase.departamento.RegistrarDepartamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrarDepartamentoImpl implements RegistrarDepartamento {

    @Autowired
    private DepartamentoRepository repository;

    @Override
    public void execute(DepartamentoDomain domain) {
        //TODO: Realizar Implementación
        // Crear el ensamblador
        MapperToEntity<DepartamentoDomain,DepartamentoEntity> map = new MapperToEntity<>();
        DepartamentoEntity entity = map.mapToEntity(domain,DepartamentoEntity.class);
        repository.save(entity);
    }
}
