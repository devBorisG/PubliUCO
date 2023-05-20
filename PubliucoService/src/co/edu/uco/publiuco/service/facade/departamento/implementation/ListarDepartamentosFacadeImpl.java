package co.edu.uco.publiuco.service.facade.departamento.implementation;

import co.edu.uco.publiuco.dto.DepartamentoDTO;
import co.edu.uco.publiuco.service.facade.departamento.ListarDepartamentosFacade;
import co.edu.uco.publiuco.service.usecase.departamento.ListarDepartamentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ListarDepartamentosFacadeImpl implements ListarDepartamentosFacade {

    @Autowired
    private ListarDepartamentos useCase;

    @Override
    public List<DepartamentoDTO> execute(Optional<DepartamentoDTO> dto) {
        return null;
    }
}
