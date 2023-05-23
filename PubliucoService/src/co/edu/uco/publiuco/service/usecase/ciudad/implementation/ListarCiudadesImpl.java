package co.edu.uco.publiuco.service.usecase.ciudad.implementation;

import co.edu.uco.publiuco.entity.CiudadEntity;
import co.edu.uco.publiuco.repository.ciudad.CiudadRepository;
import co.edu.uco.publiuco.service.domain.CiudadDomain;
import co.edu.uco.publiuco.service.mapper.MapperToEntity;
import co.edu.uco.publiuco.service.usecase.ciudad.ListarCiudades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ListarCiudadesImpl implements ListarCiudades {

    @Autowired
    private CiudadRepository repository;

    @Override
    public List<CiudadDomain> execute(Optional<CiudadDomain> domain) {
        MapperToEntity<CiudadDomain, CiudadEntity> map = new MapperToEntity<>();
        if (domain.isPresent()){
            CiudadEntity entity = map.mapToEntity(domain.get(), CiudadEntity.class);
            Optional<CiudadEntity> byId = repository.findById(entity.getCodigo());
        }else{
            List<CiudadEntity> all = repository.findAll();
        }
        return null;
    }
}
