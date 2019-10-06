package com.example.park21.models;

import java.util.List;

public class Familia {
    private List<Usuario> usuarios;
    private String rol;

    public Familia(List<Usuario> usuarios, String rol) {
        this.usuarios = usuarios;
        this.rol = rol;
    }

    public Familia(){
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
