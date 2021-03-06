/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matheus.View;

import com.matheus.Exception.MFPException;
import com.matheus.Exception.PDException;
import com.matheus.Exception.PIException;
import com.matheus.Model.ITwitter;
import com.matheus.Model.Perfil;
import com.matheus.Model.Tweet;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

/**
 *
 * @author matheus
 */
public class jfHome extends javax.swing.JFrame {
    private ITwitter twitter;
    private String usuario;

    private void loadTable(){
        try {
            Vector<Tweet> timeline = twitter.timeline(usuario);
            ((DefaultTableModel)this.tbTweets.getModel()).setRowCount(0);
            for(int i = timeline.size() - 1; i >= 0; i--){
                Tweet tweet = timeline.elementAt(i);
                ((DefaultTableModel)this.tbTweets.getModel()).addRow(new Object[] { tweet.getUsuario(), tweet.getMensagem()});
            }

        } catch (Exception e) {
            this.dispose();
            JFrame jfLogin = new jfLogin(twitter);
        }
    }

    /**
     * Creates new form jfHome
     */
    public jfHome(ITwitter twitter, String usuario) {
        initComponents();
        this.txtTweet.setLineWrap(true);
        this.txtTweet.setWrapStyleWord(true);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setTitle("My Twitter - Home");

        this.twitter = twitter;
        this.usuario = usuario;

        try {
            this.lbSeguidores.setText(twitter.numeroSeguidores(this.usuario) + " Seguidores");
            this.lbSeguindo.setText(twitter.numeroSeguidos(this.usuario) + " Seguindo");
            this.loadTable();
        } catch (Exception e) {
            this.dispose();
            JFrame jfLogin = new jfLogin(twitter);
        }

        this.lbUsuario.setText("@"+usuario);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtTweet = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        btnTweetar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbTweets = new javax.swing.JTable();
        lbUsuario = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        lbSeguindo = new javax.swing.JLabel();
        lbSeguidores = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });


        jPanel1.setBackground(new java.awt.Color(20, 23, 26));

        jPanel2.setBackground(new java.awt.Color(101, 119, 134));

        txtTweet.setColumns(20);
        txtTweet.setRows(5);

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(245, 248, 250));
        jLabel4.setText("No que voc?? est?? pensando?");

        btnTweetar.setBackground(new java.awt.Color(29, 161, 242));
        btnTweetar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnTweetar.setForeground(new java.awt.Color(245, 248, 250));
        btnTweetar.setText("Tweetar");
        btnTweetar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTweetarActionPerformed(evt);
            }
        });

        tbTweets.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Usu??rio", "Tweet"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbTweets);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addComponent(btnTweetar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(txtTweet, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE))
                                                .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTweet, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTweetar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addContainerGap())
        );

        lbUsuario.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbUsuario.setForeground(new java.awt.Color(245, 248, 250));
        lbUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbUsuario.setText("@matheus3301");

        btnCancelar.setBackground(new java.awt.Color(255, 51, 51));
        btnCancelar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(245, 248, 250));
        btnCancelar.setText("Cancelar Conta");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(29, 161, 242));
        btnBuscar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(245, 248, 250));
        btnBuscar.setText("Buscar Usu??rios");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnLogout.setBackground(new java.awt.Color(29, 161, 242));
        btnLogout.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(245, 248, 250));
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        lbSeguindo.setForeground(new java.awt.Color(245, 248, 250));
        lbSeguindo.setText("0 Seguindo");
        lbSeguindo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSeguindoMouseClicked(evt);
            }
        });

        lbSeguidores.setForeground(new java.awt.Color(245, 248, 250));
        lbSeguidores.setText("0 Seguidores");
        lbSeguidores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSeguidoresMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addComponent(lbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addComponent(lbSeguidores, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addComponent(lbSeguindo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(8, 8, 8)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(lbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(lbSeguidores)
                                .addGap(6, 6, 6)
                                .addComponent(lbSeguindo)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar)
                                .addGap(386, 386, 386)
                                .addComponent(btnCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLogout)
                                .addGap(0, 19, Short.MAX_VALUE))
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>

    private void btnTweetarActionPerformed(java.awt.event.ActionEvent evt) {
        String tweet = this.txtTweet.getText();

        try {
            this.twitter.tweetar(this.usuario,tweet);
            this.txtTweet.setText("");
            this.loadTable();
        } catch (PIException e) {
            JOptionPane.showMessageDialog(null,"Erro Interno, tente logar novamente!","Erro!",JOptionPane.ERROR_MESSAGE);
        } catch (MFPException e) {
            JOptionPane.showMessageDialog(null,"Seu tweet deve conter entre 1 e 140 caracteres!","Erro!",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        int ans = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja desativar seu perfil? Ficar?? inacess??vel para outros usu??rios e voc?? n??o poder?? logar novamente!","Confirmar",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if(ans == 0){
            try {
                this.twitter.cancelarPerfil(this.usuario);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }finally {
                this.dispose();
                JFrame jfLogin = new jfLogin(twitter);
            }
        }
    }

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {
        String usuarioBuscado = JOptionPane.showInputDialog(null,"Digite o usu??rio que voc?? quer olhar o perfil:","Buscar",JOptionPane.QUESTION_MESSAGE);
        if(usuarioBuscado.equals(usuario)){
            JOptionPane.showMessageDialog(null,"Usu??rio ?? voc?? mesmo","Erro!",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(usuarioBuscado != null){
            try {
                twitter.tweets(usuarioBuscado);
                JFrame jfPerfil = new jfPerfil(usuarioBuscado,usuario,twitter);
            } catch (PIException e) {
                JOptionPane.showMessageDialog(null,"Usu??rio n??o encontrado!","Erro!",JOptionPane.ERROR_MESSAGE);
            } catch (PDException e) {
                JOptionPane.showMessageDialog(null,"Perfil desativado!","Erro!",JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        JFrame jfLogin = new jfLogin(twitter);
    }

    private void lbSeguidoresMouseClicked(java.awt.event.MouseEvent evt) {
        try {
            new jfLista(twitter.seguidores(usuario));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void lbSeguindoMouseClicked(java.awt.event.MouseEvent evt) {
        try {
            new jfLista(twitter.seguidos(usuario));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {
       this.loadTable();
        try {
            this.lbSeguidores.setText(twitter.numeroSeguidores(this.usuario) + " Seguidores");
            this.lbSeguindo.setText(twitter.numeroSeguidos(this.usuario) + " Seguindo");
        } catch (Exception e) {
            this.dispose();
            JFrame jfLogin = new jfLogin(twitter);
        }
    }


    // Variables declaration - do not modify
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnTweetar;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbSeguidores;
    private javax.swing.JLabel lbSeguindo;
    private javax.swing.JLabel lbUsuario;
    private javax.swing.JTable tbTweets;
    private javax.swing.JTextArea txtTweet;
    // End of variables declaration
}
