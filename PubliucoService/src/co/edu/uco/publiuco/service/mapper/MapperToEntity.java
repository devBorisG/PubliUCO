package co.edu.uco.publiuco.service.mapper;

import org.modelmapper.ModelMapper;

public class MapperToEntity<D,E> {

    private static final ModelMapper mapper = new ModelMapper();

    public E mapToEntity(D domain, Class<E> clase){
        return mapper.map(domain, clase);
    }
}
