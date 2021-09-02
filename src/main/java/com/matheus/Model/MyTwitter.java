package com.matheus.Model;

import com.matheus.Exception.*;
import com.matheus.Repository.IRepositorioUsuario;

import java.util.Vector;
import java.util.stream.Collectors;

public class MyTwitter implements ITwitter {
    IRepositorioUsuario repositorio;

    public MyTwitter(IRepositorioUsuario repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public void criarPerfil(Perfil usuario) throws PEException {
        try {
            repositorio.cadastrar(usuario);
        } catch (UJCException e) {
            throw new PEException(usuario.getUsuario());
        }
    }

    @Override
    public void cancelarPerfil(String usuario) throws PIException, PDException {
        Perfil perfil = repositorio.buscar(usuario);
        if (perfil == null) {
            throw new PIException(usuario);
        } else if (!perfil.isAtivo()) {
            throw new PDException(usuario);
        } else {
            perfil.setAtivo(false);
            try {
                repositorio.atualizar(perfil);
            } catch (UNCException e) {
                throw new PIException(usuario);
            }
        }
    }

    @Override
    public void tweetar(String usuario, String mensagem) throws PIException, MFPException {
        Perfil perfil = repositorio.buscar(usuario);
        if (perfil == null) {
            throw new PIException(usuario);
        } else if (mensagem.length() > 140 || mensagem.length() < 1) {
            throw new MFPException(mensagem);
        } else {
            //Criar o tweet, pegar a lista de seguidores do usuario, adicionar o tweet, atualizar o perfil de cada um
            Tweet tweet = new Tweet();
            tweet.setMensagem(mensagem);
            tweet.setUsuario(usuario);

            perfil.addTweet(tweet);
            try {
                repositorio.atualizar(perfil);
            } catch (UNCException e) {
                throw new PIException(usuario);
            }

            // TODO: Analizar a semântica do nome seguido e seguidor
            for (Perfil seguidor : perfil.getSeguidores()) {
                seguidor.addTweet(tweet);
                try {
                    repositorio.atualizar(seguidor);
                } catch (UNCException e) {
                    throw new PIException(usuario);
                }
            }

        }
    }

    @Override
    public Vector<Tweet> timeline(String usuario) throws PIException, PDException {
        Perfil perfil = repositorio.buscar(usuario);
        if (perfil == null) {
            throw new PIException(usuario);
        } else if (!perfil.isAtivo()) {
            throw new PDException(usuario);
        } else {
            return perfil.getTimeline();
        }
    }

    @Override
    public Vector<Tweet> tweets(String usuario) throws PIException, PDException {
        Perfil perfil = repositorio.buscar(usuario);
        if (perfil == null) {
            throw new PIException(usuario);
        } else if (!perfil.isAtivo()) {
            throw new PDException(usuario);
        } else {
            return perfil.getTimeline().stream().filter(tweet -> tweet.getUsuario().equals(usuario)).collect(Collectors.toCollection(Vector::new));
        }
    }

    @Override
    public void seguir(String seguidor, String seguido) throws PIException, SIException, PDException {
        Perfil perfilSeguidor = repositorio.buscar(seguidor);
        Perfil perfilSeguido = repositorio.buscar(seguido);

        if (perfilSeguido == null) {
            throw new PIException(seguido);
        } else if (perfilSeguidor == null) {
            throw new PIException(seguidor);
        } else if (seguidor.equals(seguido)) {
            throw new SIException(seguido);
        } else if (!perfilSeguido.isAtivo()) {
            throw new PDException(seguido);
        } else if (!perfilSeguidor.isAtivo()) {
            throw new PDException(seguidor);
        }else{
            perfilSeguido.addSeguidor(perfilSeguidor);
            perfilSeguidor.addSeguido(perfilSeguido);

            try {
                this.repositorio.atualizar(perfilSeguido);
            } catch (UNCException e) {
                throw new PIException(perfilSeguido.getUsuario());
            }
            try {
                this.repositorio.atualizar(perfilSeguidor);
            } catch (UNCException e) {
                throw new PIException(perfilSeguidor.getUsuario());
            }
        }

    }

    @Override
    public int numeroSeguidores(String usuario) throws PDException, PIException {
        return seguidores(usuario).size();
    }

    @Override
    public int numeroSeguidos(String usuario) throws PDException, PIException {
        return seguidos(usuario).size();
    }

    @Override
    public Vector<Perfil> seguidores(String usuario) throws PIException, PDException {
        Perfil perfil = repositorio.buscar(usuario);

        if(perfil == null){
            throw new PIException(usuario);
        }else if(!perfil.isAtivo()){
            throw new PDException(usuario);
        }

        return perfil.getSeguidores().stream().filter(seguidor -> seguidor.isAtivo()).collect(Collectors.toCollection(Vector::new));
    }

    @Override
    public Vector<Perfil> seguidos(String usuario) throws PIException, PDException {
        Perfil perfil = repositorio.buscar(usuario);

        if(perfil == null){
            throw new PIException(usuario);
        }else if(!perfil.isAtivo()){
            throw new PDException(usuario);
        }

        return perfil.getSeguidos().stream().filter(seguido -> seguido.isAtivo()).collect(Collectors.toCollection(Vector::new));
    }
}
