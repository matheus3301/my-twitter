package com.matheus.Model;

import java.util.Vector;

public abstract class Perfil {
    private String usuario;
    private Vector<Perfil> seguidos;
    private Vector<Perfil> seguidores;
    private Vector<Tweet> timeline;
    private boolean ativo;

    public Perfil(String usuario) {
        this.usuario = usuario;
        seguidos = new Vector<Perfil>();
        seguidores = new Vector<Perfil>();
        timeline = new Vector<Tweet>();
        ativo = true;
    }

    public void addSeguido(Perfil usuario) {
        seguidos.add(usuario);
    }

    public void addSeguidor(Perfil usuario) {
        seguidores.add(usuario);
    }

    public void addTweet(Tweet tweet){
        timeline.add(tweet);
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Vector<Perfil> getSeguidos() {
        return seguidos;
    }

    public Vector<Perfil> getSeguidores() {
        return seguidores;
    }

    public Vector<Tweet> getTimeline() {
        return timeline;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
