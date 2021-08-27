package com.matheus.Repository;

import com.matheus.Model.Perfil;

public interface IRepositorioUsuario {
    void cadastrar(Perfil usuario);
    Perfil buscar(String usuario);
    void atualizar(Perfil usuario);
}
