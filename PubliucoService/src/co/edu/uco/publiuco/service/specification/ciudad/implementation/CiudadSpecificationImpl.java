package co.edu.uco.publiuco.service.specification.ciudad.implementation;

import co.edu.uco.publiuco.crosscutting.exceptions.service.ServiceCustomException;
import co.edu.uco.publiuco.crosscutting.helper.ObjectHelper;
import co.edu.uco.publiuco.crosscutting.helper.StringHelper;
import co.edu.uco.publiuco.crosscutting.messages.customization.CatalogoMensajes;
import co.edu.uco.publiuco.crosscutting.messages.customization.implementation.CatalogoMensajesImpl;
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

    //TODO: CREAR UNA INTERFAZ QUE IMPLEMENTE EL METODO
    protected CatalogoMensajes catalogoMensajes;

    @Override
    public void isSatisfied(final CiudadDomain domain) {
        if (!listarCiudades.execute(Optional.of(domain)).isEmpty()) {
            throw ServiceCustomException.createUserException(catalogoMensajes.getMessage("specification.ciudad.database"));
        }
        if (!StringHelper.isOnlyWordsAndSpace(domain.getNombre())) {
            throw ServiceCustomException.createUserException(catalogoMensajes.getMessage("specification.ciudad.name"));
        }
        if (!ObjectHelper.isNull(domain.getDepartamento())) {
            throw ServiceCustomException.createUserException(catalogoMensajes.getMessage("specification.ciudad.departamentonull"));
        }
    }
}