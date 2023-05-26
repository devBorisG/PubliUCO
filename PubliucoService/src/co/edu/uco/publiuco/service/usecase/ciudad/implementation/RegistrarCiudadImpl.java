package co.edu.uco.publiuco.service.usecase.ciudad.implementation;

import co.edu.uco.publiuco.crosscutting.exceptions.PubliUCOCustomException;
import co.edu.uco.publiuco.crosscutting.exceptions.service.ServiceCustomException;
import co.edu.uco.publiuco.entity.CiudadEntity;
import co.edu.uco.publiuco.repository.ciudad.CiudadRepository;
import co.edu.uco.publiuco.service.domain.CiudadDomain;
import co.edu.uco.publiuco.service.mapper.MapperToEntity;
import co.edu.uco.publiuco.service.specification.ciudad.CiudadSpecification;
import co.edu.uco.publiuco.service.usecase.ciudad.RegistrarCiudad;
import jakarta.persistence.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrarCiudadImpl implements RegistrarCiudad {

    @Autowired
    private CiudadRepository repository;

    @Autowired
    private CiudadSpecification specification;

    @Override
    public void execute(CiudadDomain domain) {
        try{
            specification.isSatisfied(domain);
            MapperToEntity<CiudadDomain, CiudadEntity> mapperToEntity = new MapperToEntity<>();
            CiudadEntity entity = mapperToEntity.mapToEntity(domain, CiudadEntity.class);
            repository.save(entity);
        }catch (ServiceCustomException exception){
            throw ServiceCustomException.createUserException(exception.getUserMessage());
        }catch (PersistenceException exception){
            throw ServiceCustomException.wrapException(exception.getMessage(),ServiceCustomException.createUserException("a"));
        }

    }
}
