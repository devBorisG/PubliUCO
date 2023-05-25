package co.edu.uco.publiuco.crosscutting.exceptions;

import co.edu.uco.publiuco.crosscutting.exceptions.enumeration.LayerException;
import static co.edu.uco.publiuco.crosscutting.helper.ObjectHelper.getDefaultIfNull;
import static co.edu.uco.publiuco.crosscutting.helper.StringHelper.isEmpty;
public class PubliUCOCustomException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    private String userMessage;
    private LayerException layer;

    protected PubliUCOCustomException(final Throwable rootException, final String technicalMessage, final String userMessage, final LayerException layer){
        super(technicalMessage, getDefaultIfNull(rootException,new Exception()));
        setUserMessage(userMessage);
        setLayer(layer);
    }

    public String getUserMessage() {
        return userMessage;
    }

    private void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public LayerException getLayer() {
        return layer;
    }

    private void setLayer(LayerException layer) {
        this.layer = getDefaultIfNull(layer, LayerException.APPLICATION);
    }

    public final boolean isTechnicalException(){
        return isEmpty(getUserMessage());
    }
}
