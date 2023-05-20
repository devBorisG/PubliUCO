package co.edu.uco.publiuco.service.domain;

import java.util.UUID;

public class DepartamentoDomain {

    private UUID codigo;
    private PaisDomain pais;
    private String nombre;

    public UUID getCodigo() {
        return codigo;
    }

    public PaisDomain getPais() {
        return pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }

    public void setPais(PaisDomain pais) {
        this.pais = pais;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
