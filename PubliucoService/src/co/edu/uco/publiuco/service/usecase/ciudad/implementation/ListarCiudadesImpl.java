package co.edu.uco.publiuco.service.usecase.ciudad.implementation;

import co.edu.uco.publiuco.service.domain.CiudadDomain;
import co.edu.uco.publiuco.service.usecase.ciudad.ListarCiudades;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListarCiudadesImpl implements ListarCiudades {
    @Override
    public List<CiudadDomain> execute(Optional<CiudadDomain> domain) {
        return null;
    }
}
