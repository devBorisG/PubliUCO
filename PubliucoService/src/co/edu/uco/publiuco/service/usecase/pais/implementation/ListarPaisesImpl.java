package co.edu.uco.publiuco.service.usecase.pais.implementation;

import co.edu.uco.publiuco.service.domain.PaisDomain;
import co.edu.uco.publiuco.service.usecase.pais.ListarPaises;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListarPaisesImpl implements ListarPaises {
    @Override
    public List<PaisDomain> execute(Optional<PaisDomain> domain) {
        return null;
    }
}
