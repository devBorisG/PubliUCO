package co.edu.uco.publiuco.service.specification.ciudad.implementation;

import co.edu.uco.publiuco.crosscutting.exceptions.service.ServiceCustomException;
import co.edu.uco.publiuco.crosscutting.helper.ObjectHelper;
import co.edu.uco.publiuco.crosscutting.helper.StringHelper;
import co.edu.uco.publiuco.crosscutting.messages.CatalogoMensajesImpl;
import co.edu.uco.publiuco.service.domain.CiudadDomain;
import co.edu.uco.publiuco.service.specification.ciudad.CiudadSpecification;
import co.edu.uco.publiuco.service.usecase.ciudad.ListarCiudades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CiudadSpecificationImpl implements CiudadSpecification {

    @Autowired
    private ListarCiudades listarCiudades;

    @Override
    public boolean isSatisfied(final CiudadDomain domain) {
        CatalogoMensajesImpl mensaje = new CatalogoMensajesImpl();
        boolean satisfied = true;
        validateDB(domain, mensaje);
        validateLettersAndSpaces(domain,mensaje);
        validateDepartamentoNull(domain, mensaje);
        return satisfied;
    }

    private void validateDB(final CiudadDomain domain, CatalogoMensajesImpl mensaje) {
        if (!listarCiudades.execute(Optional.of(domain)).isEmpty()) {
            throw ServiceCustomException.createUserException(mensaje.obtenerMensaje("specification.ciudad.database"));
        }
    }

    private void validateLettersAndSpaces(final CiudadDomain domain,  CatalogoMensajesImpl mensaje){
        if(!StringHelper.isOnlyWordsAndSpace(domain.getNombre())){
            throw ServiceCustomException.createUserException(mensaje.obtenerMensaje("specification.ciudad.name"));
        }
    }

    private void validateDepartamentoNull(final CiudadDomain domain,  CatalogoMensajesImpl mensaje){
        if(!ObjectHelper.isNull(domain.getDepartamento())){
            throw ServiceCustomException.createUserException(mensaje.obtenerMensaje("specification.ciudad.departamentonull"));
        }

    }
}