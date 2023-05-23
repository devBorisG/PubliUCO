package co.edu.uco.publiuco.repository.ciudad;

import co.edu.uco.publiuco.entity.CiudadEntity;

import java.util.List;

public interface CiudadRepositoryCustom {
    List<CiudadEntity> findCustom(CiudadEntity ciudadEntity);
}
