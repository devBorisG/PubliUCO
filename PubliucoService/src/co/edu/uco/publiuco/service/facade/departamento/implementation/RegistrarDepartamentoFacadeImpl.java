package co.edu.uco.publiuco.service.facade.departamento.implementation;

import co.edu.uco.publiuco.dto.DepartamentoDTO;
import co.edu.uco.publiuco.service.domain.DepartamentoDomain;
import co.edu.uco.publiuco.service.facade.departamento.RegistrarDepartamentoFacade;
import co.edu.uco.publiuco.service.mapper.MapperToDomain;
import co.edu.uco.publiuco.service.usecase.departamento.RegistrarDepartamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegistrarDepartamentoFacadeImpl implements RegistrarDepartamentoFacade {

    @Autowired
    private RegistrarDepartamento useCase;

    @Override
    public void execute(DepartamentoDTO dto) {
        MapperToDomain<DepartamentoDTO,DepartamentoDomain> map = new MapperToDomain<>();
        DepartamentoDomain domain = map.mapToDomain(dto, DepartamentoDomain.class);
        useCase.execute(domain);
    }
}
