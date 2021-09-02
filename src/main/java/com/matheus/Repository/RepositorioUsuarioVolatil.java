package com.matheus.Repository;

import com.matheus.Exception.UJCException;
import com.matheus.Exception.UNCException;
import com.matheus.Model.Perfil;

import java.util.Vector;

public class RepositorioUsuarioVolatil implements IRepositorioUsuario {
    Vector<Perfil> usuarios;

    public RepositorioUsuarioVolatil() {
        usuarios = new Vector<Perfil>();
    }

    @Override
    public void cadastrar(Perfil usuario) throws UJCException {
        if (buscar(usuario.getUsuario()) != null) throw new UJCException(usuario.getUsuario());
        usuarios.add(usuario);
    }

    @Override
    public Perfil buscar(String usuario) {
        for (Perfil cadastrado : usuarios)
            if (cadastrado.getUsuario().equals(usuario))
                return cadastrado;

        return null;
    }

    @Override
    public void atualizar(Perfil usuario) throws UNCException {
        if (buscar(usuario.getUsuario()) == null) throw new UNCException(usuario.getUsuario());

        for (Perfil cadastrado : usuarios) {
            if (cadastrado.getUsuario().equals(usuario.getUsuario())) {
                usuarios.remove(cadastrado);
                usuarios.add(usuario);
                return;
            }
        }
    }
}
