package com.matheus.Repository;

import com.matheus.Exception.UJCException;
import com.matheus.Exception.UNCException;
import com.matheus.Model.Perfil;

public interface IRepositorioUsuario {
    void cadastrar(Perfil usuario) throws UJCException;
    Perfil buscar(String usuario);
    void atualizar(Perfil usuario) throws UNCException;
}
