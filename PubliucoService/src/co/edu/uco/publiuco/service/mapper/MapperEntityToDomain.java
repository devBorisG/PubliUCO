package co.edu.uco.publiuco.service.mapper;

import org.modelmapper.ModelMapper;

public class MapperEntityToDomain<E,D> {

    private static final ModelMapper mapper = new ModelMapper();

    public D mapToDomain(E entity, Class<D> clase){
        return mapper.map(entity,clase);
    }
}
