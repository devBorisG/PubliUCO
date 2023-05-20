package co.edu.uco.publiuco.service.facade.ciudad.implementation;

import co.edu.uco.publiuco.dto.CiudadDTO;
import co.edu.uco.publiuco.entity.CiudadEntity;
import co.edu.uco.publiuco.service.domain.CiudadDomain;
import co.edu.uco.publiuco.service.facade.ciudad.RegistrarCiudadFacade;
import co.edu.uco.publiuco.service.mapper.MapperToDomain;
import co.edu.uco.publiuco.service.usecase.ciudad.RegistrarCiudad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegistrarCiudadFacadeImpl implements RegistrarCiudadFacade {

    @Autowired
    private RegistrarCiudad useCase;

    @Override
    public void execute(CiudadDTO dto) {
        MapperToDomain<CiudadDTO, CiudadDomain> map = new MapperToDomain<>();
        // TODO: Aqui es donde sirve el assembler pasra llevar de DTO a Domain
        CiudadDomain domain = map.mapToDomain(dto, CiudadDomain.class);
        useCase.execute(domain);
    }
}
