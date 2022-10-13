/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.mysql.jdbc.UpdatableResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import model.m_adduser;
import view.addUser;

/**
 *
 * @author Muhtar
 */
public class c_adduser {

//    m_adduser themodel = new m_adduser();
    m_adduser themodel = new m_adduser();
    addUser theview = new addUser();
//    c_adduser con = new c_adduser(themodel, theview);

    public c_adduser() {
//        this.themodel = themodel;
//        this.theview = theview;
        theview.setVisible(true);
//        theview.setTable(themodel.getTableModel());
        theview.addsaveListener(new saveListener());
        theview.addeditListener(new editListener());
        theview.addupdateListener(new updateListener());
        theview.addhapusListener(new hapusListener());
        theview.addBtnAddMotorListener(new AddMotorListener());
//        theview.addBtnPinjamListener(new PinjamListener());
        theview.addBtnKeluarListener(new KeluarListener());

        try {
            theview.setTable(themodel.getTableModel());
        } catch (SQLException ex) {
            Logger.getLogger(c_adduser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//
//    private class PinjamListener implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//          theview.dispose();
//            try {
//                c_peminjam con = new c_peminjam();
//            } catch (SQLException ex) {
//                Logger.getLogger(c_adduser.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }

    private class KeluarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theview.dispose();
            c_menuAwal con = new c_menuAwal();
        }
    }

    private class AddMotorListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theview.dispose();
            c_addmotor con = new c_addmotor();
        }
    }

    private class hapusListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int baris = theview.getSelectedRow();
                String iduser = theview.getValueAt(baris, 0);
                System.out.println(iduser);
                themodel.delete(iduser);
                theview.text(true);
                theview.button(true);

//             theview.buttonadd(false);
                theview.setTable(themodel.getTableModel());
            } catch (SQLException ex) {
                Logger.getLogger(c_addmotor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class updateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int baris = theview.getSelectedRow();
                String id = theview.getId();
//                int id = Integer.parseInt(iduser);
                String nama = theview.getNamauser();
                String user = theview.getUsername();
                String pass = theview.getPass();
                String status = theview.getStatus();
                themodel.update(id, nama, user, pass, status);
                clear();
                theview.text(true);
                theview.buttonupdate(true);
                theview.button(true);
                theview.setTable(themodel.getTableModel());
            } catch (SQLException ex) {
                Logger.getLogger(c_addmotor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class editListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            int baris = theview.getSelectedRow();
            if (baris != -1) {

                String iduser = theview.getValueAt(baris, 0);
                String Nama = theview.getValueAt(baris, 1);
                String Username = theview.getValueAt(baris, 2);
                String Password = theview.getValueAt(baris, 3);

                theview.setId(iduser);
                theview.setNamauser(Nama);
                theview.setUsername(Username);
                theview.setPass(Password);

                theview.text(true);
            }
//        theview.button(true);
        }
    }

    private class saveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                themodel.save(theview.getNamauser(), theview.getUsername(), theview.getPass(), theview.getStatus());
                theview.setTable(themodel.getTableModel());
                theview.setNamauser("");
                theview.setUsername("");
                theview.setPass("");
                theview.text(false);
                theview.buttonsave(true);
                theview.button(true);
            } catch (SQLException ex) {
                Logger.getLogger(c_addmotor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void clear() {
        theview.setId("");
        theview.setNamauser("");
        theview.setUsername("");
        theview.setPass("");
        theview.setStatus(0);
    }
}
