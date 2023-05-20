package co.edu.uco.publiuco.service.specification;

public interface ISpecification<T> {
    boolean isSatisfied(T domain);
}
