package co.edu.uco.publiuco.crosscutting.messages.impl;

import co.edu.uco.publiuco.crosscutting.messages.CatalogoMensajes;

import java.util.Locale;
import java.util.ResourceBundle;

public class CatalogoMensajesImpl implements CatalogoMensajes {
    private final ResourceBundle bundle;

    public CatalogoMensajesImpl(Locale locale){
        bundle = ResourceBundle.getBundle("messages", locale);
    }

    @Override
    public String obtenerMensaje(String clave) {
        return bundle.getString(clave);
    }
}
