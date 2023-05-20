package co.edu.uco.publiuco.service.facade.ciudad.implementation;

import co.edu.uco.publiuco.dto.CiudadDTO;
import co.edu.uco.publiuco.service.facade.ciudad.ListarCiudadesFacade;
import co.edu.uco.publiuco.service.usecase.ciudad.ListarCiudades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ListarCiudadesFacadeImpl implements ListarCiudadesFacade {

    @Autowired
    private ListarCiudades useCase;

    @Override
    public List<CiudadDTO> execute(Optional<CiudadDTO> domain) {
        return null;
    }
}
