package co.edu.uco.publiuco.service.facade.pais.implementation;

import co.edu.uco.publiuco.dto.PaisDTO;
import co.edu.uco.publiuco.service.domain.PaisDomain;
import co.edu.uco.publiuco.service.facade.pais.RegistrarPaisFacade;
import co.edu.uco.publiuco.service.mapper.MapperToDomain;
import co.edu.uco.publiuco.service.usecase.pais.RegistrarPais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegistrarPaisFacadeImpl implements RegistrarPaisFacade {

    @Autowired
    private RegistrarPais useCase;

    @Override
    public void execute(PaisDTO dto) {
        MapperToDomain<PaisDTO,PaisDomain> map = new MapperToDomain<>();
        PaisDomain domain = map.mapToDomain(dto, PaisDomain.class);
        useCase.execute(domain);
    }
}
