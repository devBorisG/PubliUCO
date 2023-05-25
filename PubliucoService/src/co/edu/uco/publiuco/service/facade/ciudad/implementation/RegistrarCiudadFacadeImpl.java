package co.edu.uco.publiuco.service.facade.ciudad.implementation;

import co.edu.uco.publiuco.dto.CiudadDTO;
import co.edu.uco.publiuco.service.domain.CiudadDomain;
import co.edu.uco.publiuco.service.facade.ciudad.RegistrarCiudadFacade;
import co.edu.uco.publiuco.service.mapper.MapperDTOToDomain;
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
        MapperDTOToDomain<CiudadDTO, CiudadDomain> mapperDTOToDomain = new MapperDTOToDomain<>();
        CiudadDomain domain = mapperDTOToDomain.mapToDomain(dto, CiudadDomain.class);
        useCase.execute(domain);
    }
}
