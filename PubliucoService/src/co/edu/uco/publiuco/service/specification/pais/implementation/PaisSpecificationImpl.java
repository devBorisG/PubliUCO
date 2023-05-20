package co.edu.uco.publiuco.service.specification.pais.implementation;

import co.edu.uco.publiuco.service.domain.PaisDomain;
import co.edu.uco.publiuco.service.specification.pais.PaisSpecification;

public class PaisSpecificationImpl implements PaisSpecification {
    @Override
    public boolean isSatisfied(PaisDomain domain) {
        return false;
    }
}
