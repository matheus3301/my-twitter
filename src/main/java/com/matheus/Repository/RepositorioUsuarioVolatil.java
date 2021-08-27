package com.matheus.Repository;

import com.matheus.Model.Perfil;

import java.util.Vector;

public class RepositorioUsuarioVolatil implements IRepositorioUsuario{
    Vector<Perfil> usuarios;
    @Override
    public void cadastrar(Perfil usuario) {
        usuarios.add(usuario);
    }

    @Override
    public Perfil buscar(String usuario) {
        for(Perfil cadastrado : usuarios)
            if(cadastrado.getUsuario().equals(usuario))
                return cadastrado;

        return null;
    }

    @Override
    public void atualizar(Perfil usuario) {
        for(Perfil cadastrado : usuarios){
            if(cadastrado.getUsuario().equals(usuario.getUsuario())){
                usuarios.remove(cadastrado);
                usuarios.add(usuario);
            }
        }
    }
}
