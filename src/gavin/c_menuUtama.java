/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.m_adduser;
import view.addUser;
import view.menuUtama;

/**
 *
 * @author Muhtar
 */
public class c_menuUtama {

    menuUtama theView = new menuUtama();

    public c_menuUtama() {
        theView.setVisible(true);
        theView.addBtnAddMotorListener(new AddMotorListener());
        theView.addBtnAddUserListener(new AddUserListener());
        theView.addBtnKeluarListener(new KeluarListener());
    }

    private class KeluarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.dispose();
            c_menuAwal con = new c_menuAwal();
        }
    }

    private class AddUserListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.dispose();
            c_adduser con = new c_adduser();

        }
    }

    private class PengembalianListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    private class PeminjamListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.dispose();
            try {
                c_peminjam con = new c_peminjam();
            } catch (SQLException ex) {
                Logger.getLogger(c_menuUtama.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class AddMotorListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.dispose();
            c_addmotor con = new c_addmotor();

        }
    }
}
