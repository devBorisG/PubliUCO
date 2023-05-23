package co.edu.uco.publiuco.repository.ciudad.implementation;

import co.edu.uco.publiuco.crosscutting.helper.UUIDHelper;
import co.edu.uco.publiuco.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.publiuco.entity.CiudadEntity;
import co.edu.uco.publiuco.repository.ciudad.CiudadRepositoryCustom;
import co.edu.uco.publiuco.crosscutting.helper.ObjectHelper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CiudadRepositoryImpl implements CiudadRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CiudadEntity> findCustom(CiudadEntity ciudadEntity) {
        var sqlBuilder = new StringBuilder();
        final var parameters = new ArrayList<Object>();

        createSelectFrom(sqlBuilder);
        createWhere(sqlBuilder, ciudadEntity, parameters);
        createOrderBy(sqlBuilder);

        return null;
    }

    private void createSelectFrom(final StringBuilder sqlBuilder){
        sqlBuilder.append("SELECT       c.codigo as codciudad,");
        sqlBuilder.append("             c.nombre as nomciudad,");
        sqlBuilder.append("             d.codigo as coddepartamento,");
        sqlBuilder.append("             d.nombre as nomdepartamento,");
        sqlBuilder.append("FROM         \"Ciudad\" c ");
        sqlBuilder.append("INNER JOIN   \"Departamento\" d ");
        sqlBuilder.append("ON           c.codigo = d.codigo");
    }

    private void createWhere(final StringBuilder sqlBuilder, final CiudadEntity ciudad, final List<Object> parameters){
        if(!ObjectHelper.isNull(ciudad)){
            var setWhere = true;

            if (!UUIDHelper.isDefaultUUID(ciudad.getCodigo())){
                sqlBuilder.append("WHERE c.codigo = ? ");
                setWhere = false;
                parameters.add(ciudad.getCodigo().toString());
            }

            if (!UUIDHelper.isDefaultUUID(ciudad.getDepartamento().getCodigo())){
                sqlBuilder.append(setWhere ? "WHERE ": "AND ").append("d.codigo = ? ");
                parameters.add(ciudad.getDepartamento().getCodigo().toString());
            }
        }
    }

    private void createOrderBy(final StringBuilder sqlBuilder){
        sqlBuilder.append("ORDER BY c.nombre ASC");
    }

    private void setParameterValues(PreparedStatement preparedStatement, final List<Object> parameters){
        CatalogoMensajes catalogoMensajes;
        try {
            for(int index = 0; index < parameters.size(); index++){
                preparedStatement.setObject(index + 1, parameters.get(index));
            }
        } catch (SQLException exception){
            System.out.println(exception.getMessage());//catalogoMensajes.obtenerMensaje("saludo")
        }
    }
}
