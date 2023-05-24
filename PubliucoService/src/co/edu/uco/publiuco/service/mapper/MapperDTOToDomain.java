package co.edu.uco.publiuco.service.mapper;

import org.modelmapper.ModelMapper;

public class MapperDTOToDomain<T,D> {

    private static final ModelMapper mapper = new ModelMapper();

    public D mapToDomain(T dto, Class<D> clase){
        return mapper.map(dto, clase);
    }

}
