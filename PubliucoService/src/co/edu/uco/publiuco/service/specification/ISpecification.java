package co.edu.uco.publiuco.service.specification;

import java.util.List;

public interface ISpecification<T> {
    void isSatisfied(T data);
}
