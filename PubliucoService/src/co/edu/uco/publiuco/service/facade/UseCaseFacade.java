package co.edu.uco.publiuco.service.facade;

public interface UseCaseFacade<T> {
    void execute(T dto);
}
