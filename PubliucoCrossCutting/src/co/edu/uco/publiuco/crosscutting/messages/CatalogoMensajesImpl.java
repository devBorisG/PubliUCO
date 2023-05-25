package co.edu.uco.publiuco.crosscutting.messages;

import java.util.Locale;
import java.util.ResourceBundle;

public class CatalogoMensajesImpl {
    private final ResourceBundle bundle;

    public CatalogoMensajesImpl(Locale locale){
        bundle = ResourceBundle.getBundle("./co/edu/uco/publiuco/crosscutting/messages/messages", locale);
    }

    public CatalogoMensajesImpl(){
        bundle = ResourceBundle.getBundle("./co/edu/uco/publiuco/crosscutting/messages/messages");
    }

    public String obtenerMensaje(String clave) {
        return bundle.getString(clave);
    }
}
