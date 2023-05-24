package co.edu.uco.publiuco.service.usecase.ciudad.implementation;

import co.edu.uco.publiuco.entity.CiudadEntity;
import co.edu.uco.publiuco.repository.ciudad.CiudadRepository;
import co.edu.uco.publiuco.service.domain.CiudadDomain;
import co.edu.uco.publiuco.service.mapper.MapperEntityToDomain;
import co.edu.uco.publiuco.service.mapper.MapperToEntity;
import co.edu.uco.publiuco.service.usecase.ciudad.ListarCiudades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ListarCiudadesImpl implements ListarCiudades {

    @Autowired
    private CiudadRepository repository;

    @Override
    public List<CiudadDomain> execute(Optional<CiudadDomain> domain) {
        List<CiudadEntity> result;
        List<CiudadDomain> convertResult = new ArrayList<>();
        MapperToEntity<CiudadDomain, CiudadEntity> mapperToEntity = new MapperToEntity<>();
        MapperEntityToDomain<CiudadEntity, CiudadDomain> mapperEntityToDomain = new MapperEntityToDomain<>();
        if (domain.isPresent()){
            CiudadEntity entity = mapperToEntity.mapToEntity(domain.get(), CiudadEntity.class);
            result = repository.findCustom(entity);
        }else{
            result = repository.findAll();
        }
        result.forEach(value -> convertResult.add(mapperEntityToDomain.mapToDomain(value, CiudadDomain.class)));
        return convertResult;
    }
}
