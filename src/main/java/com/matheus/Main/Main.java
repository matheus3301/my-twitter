package com.matheus.Main;

import com.matheus.Model.ITwitter;
import com.matheus.Model.MyTwitter;
import com.matheus.Repository.RepositorioUsuarioVolatil;
import com.matheus.View.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        ITwitter myTwitter = new MyTwitter(new RepositorioUsuarioVolatil());
        JFrame jfLogin = new jfLogin(myTwitter);
    }
}
