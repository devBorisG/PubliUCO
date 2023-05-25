package co.edu.uco.publiuco.crosscutting.exceptions.service;

import co.edu.uco.publiuco.crosscutting.exceptions.PubliUCOCustomException;
import co.edu.uco.publiuco.crosscutting.exceptions.enumeration.LayerException;
import static co.edu.uco.publiuco.crosscutting.helper.StringHelper.EMPTY;
public class ServiceCustomException extends PubliUCOCustomException {
    private static final long serialVersionUID = -7581138972968503560L;

    private ServiceCustomException(Exception rootException, String technicalMessage, String userMessage){
        super(rootException, technicalMessage, userMessage, LayerException.SERVICE);
    }

    public static final PubliUCOCustomException create(final String userMessage, final String technicalMessage) {
        return new ServiceCustomException(new Exception(), technicalMessage, userMessage);
    }

    public static final PubliUCOCustomException create(final Exception rootException, final String userMessage, final String technicalMessage){
        return new ServiceCustomException(rootException, technicalMessage, userMessage);
    }

    public static final PubliUCOCustomException createTechnicalException(final String technicalMessage){
        return new ServiceCustomException(new Exception(), technicalMessage, EMPTY);
    }

    public static final PubliUCOCustomException createTechnicalException(final Exception rootException, final String technicalMessage){
        return new ServiceCustomException(rootException, technicalMessage, EMPTY);
    }

    public static final PubliUCOCustomException createBusinessException(final String businessMessage, final Exception rootException){
        return new ServiceCustomException(rootException, businessMessage, EMPTY);
    }

    public static final PubliUCOCustomException createUserException(final String userMessage){
        return new ServiceCustomException(null,userMessage,userMessage);
    }

    public static final PubliUCOCustomException wrapException(final String message, final PubliUCOCustomException exception){
        if(exception.isTechnicalException()){
            //wrapper
            return ServiceCustomException.createBusinessException(message, exception);
        }
        return exception;
    }
}
