package co.edu.uco.publiuco.crosscutting.messages.customization.implementation;

import co.edu.uco.publiuco.crosscutting.messages.customization.CatalogoMensajes;

import java.util.Locale;
import java.util.ResourceBundle;

public class CatalogoMensajesImpl implements CatalogoMensajes {
    private final ResourceBundle bundle = ResourceBundle.getBundle("./co/edu/uco/publiuco/crosscutting/messages/customization/catalog/messages");

    @Override
    public String getMessage(String clave) {
        return bundle.getString(clave);
    }
}
