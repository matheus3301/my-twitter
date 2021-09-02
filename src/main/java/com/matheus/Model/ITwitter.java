package com.matheus.Model;

import com.matheus.Exception.*;

import java.util.Vector;

public interface ITwitter {
    public void criarPerfil(Perfil usuario) throws PEException;
    public void cancelarPerfil(String usuario) throws PIException, PDException;
    public void tweetar(String usuario, String mensagem) throws PIException, MFPException;
    public Vector<Tweet> timeline(String usuario) throws PIException, PDException;
    public Vector<Tweet> tweets(String usuario) throws PIException, PDException;
    public void seguir(String seguidor, String seguido) throws PIException, SIException, PDException;
    public int numeroSeguidores(String usuario) throws PDException, PIException;
    public int numeroSeguidos(String usuario) throws PDException, PIException;
    public Vector<Perfil> seguidores(String usuario) throws PIException, PDException;
    public Vector<Perfil> seguidos(String usuario) throws PIException, PDException;
}