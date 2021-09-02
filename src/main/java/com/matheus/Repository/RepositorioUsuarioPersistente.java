package com.matheus.Repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.matheus.Exception.UJCException;
import com.matheus.Exception.UNCException;
import com.matheus.Model.Perfil;
import com.matheus.Model.PessoaFisica;
import com.matheus.Model.PessoaJuridica;
import com.matheus.Model.Tweet;

import java.io.*;
import java.lang.reflect.Type;
import java.util.Scanner;
import java.util.Vector;

public class RepositorioUsuarioPersistente implements IRepositorioUsuario {
    Vector<Perfil> usuarios;
    Gson gson;

    public RepositorioUsuarioPersistente() {
        gson = new Gson();

        try (Scanner scanner = new Scanner( new File("./perfis.json"), "UTF-8" )) {
            String text = scanner.useDelimiter("\\A").next();

            Type vectorType = new TypeToken<Vector<PessoaJuridica>>(){}.getType();
            usuarios = gson.fromJson(text, vectorType);
            System.out.println(usuarios.size() + " usuários carregados!");
        } catch (FileNotFoundException e) {
            usuarios = new Vector<Perfil>();
            System.out.println("Arquivo não existe ainda, 0 perfis carregados");
        }
    }

    @Override
    public void cadastrar(Perfil usuario) throws UJCException {
        if (buscar(usuario.getUsuario()) != null) throw new UJCException(usuario.getUsuario());
        usuarios.add(usuario);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("./perfis.json",false));
            writer.append(gson.toJson(usuarios));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


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

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("./perfis.json",false));
            writer.append(gson.toJson(usuarios));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
