package co.edu.uco.publiuco.crosscutting.exceptions.crosscutting;

import co.edu.uco.publiuco.crosscutting.exceptions.PubliUCOCustomException;
import co.edu.uco.publiuco.crosscutting.exceptions.enumeration.LayerException;
import static co.edu.uco.publiuco.crosscutting.helper.StringHelper.EMPTY;
public class CrosscuttingCustomException extends PubliUCOCustomException {
    private static final long serialVersionUID = 1L;

    protected CrosscuttingCustomException(Exception rootException, String technicalMessage, String userMessage){
        super(rootException,technicalMessage,userMessage,LayerException.CROSSCUTTING);
    }

    public static final PubliUCOCustomException createTechnicalException(final String technicalMessage, final Exception rootException){
        return new CrosscuttingCustomException(rootException,technicalMessage,EMPTY);
    }

    public static final PubliUCOCustomException createUserException(final String userMessage, final Exception rootException){
        return new CrosscuttingCustomException(rootException,userMessage,userMessage);
    }

    public static final PubliUCOCustomException create(final String userMessage, final String technicalMessage, final Exception rootException){
        return new CrosscuttingCustomException(rootException,technicalMessage,userMessage);
    }

    public static CrosscuttingCustomException create(String userMessage, String technicalMessage){
        return new CrosscuttingCustomException(new Exception(), userMessage, technicalMessage);
    }
}
