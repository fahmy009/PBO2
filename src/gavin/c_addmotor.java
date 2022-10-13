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
import model.m_addmotor;
import view.addMotor;

//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import model.m_addmotor;
//import view.addMotor;
/**
 *
 * @author Muhtar
 */
public class c_addmotor {

    m_addmotor themodel = new m_addmotor();
    addMotor theview = new addMotor();

    public c_addmotor() {
//        this.themodel = themodel;
//        this.theview = theview;
        theview.setVisible(true);
//        theview.setTable(themodel.getTableModel());
        theview.addsavemotorListener(new saveListener());
        theview.addeditmotorListener(new editListener());
        theview.addupdatemotorListener(new updateListener());
        theview.addhapusmotorListener(new hapusListener());
        theview.addBtnAddUserListener(new AddUserListener());
//        theview.addBtnPinjamListener(new PinjamListener());
        theview.addBtnKeluarListener(new KeluarListener());
        try {
            theview.setTable(themodel.getTableModel());
        } catch (SQLException ex) {
            Logger.getLogger(c_addmotor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    private class PinjamListener implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            theview.dispose();
//            try {
//                c_peminjam con = new c_peminjam();
//            } catch (SQLException ex) {
//                Logger.getLogger(c_addmotor.class.getName()).log(Level.SEVERE, null, ex);
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

    private class AddUserListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theview.dispose();
            c_adduser con = new c_adduser();
        }
    }

    private class updateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int baris = theview.getSelectedRow();
                String motorid = theview.getIdtor();
                String merek = theview.getMerekmotor();
                String type = theview.getTypemotor();
                String tahun = theview.getTahun();
                String nopol = theview.getNopol();
                String harga = theview.getHargasewa();
//                String status = theview.getStatusmotor();
                themodel.update(motorid, merek, type, tahun, nopol, harga);
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

//    private class saveListener implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            try {
//                themodel.save(theview.getMerekmotor(), theview.getTypemotor(), theview.getTahun(), theview.getNopol(), theview.getHargasewa(), theview.getStatusmotor());
//                theview.setTable(themodel.getTableModel());
//                theview.setMerekmotor("");
//                theview.setTypemotor("");
//                theview.setTahun("");
//                theview.setNopol("");
//                theview.setHargasewa("");
//                theview.text(false);
//                theview.buttonsave(true);
////                theview.button(true);
//            } catch (SQLException ex) {
//                Logger.getLogger(c_addmotor.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
    private class saveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                themodel.save(theview.getMerekmotor(), theview.getTypemotor(), theview.getTahun(), theview.getNopol(), theview.getHargasewa());
                theview.setTable(themodel.getTableModel());
                theview.setMerekmotor("");
                theview.setTypemotor("");
                theview.setTahun("");
                theview.setNopol("");
                theview.setHargasewa("");
                theview.text(false);
                theview.buttonsave(true);
                theview.button(true);
                clear();
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

                String motorid = theview.getValueAt(baris, 0);
                String merek = theview.getValueAt(baris, 1);
                String type = theview.getValueAt(baris, 2);
                String tahun = theview.getValueAt(baris, 3);
                String nopol = theview.getValueAt(baris, 4);
                String harga = theview.getValueAt(baris, 5);

                theview.setIdtor(motorid);
                theview.setMerekmotor(merek);
                theview.setTypemotor(type);
                theview.setTahun(tahun);
                theview.setNopol(nopol);
                theview.setHargasewa(harga);

                theview.text(true);
            }
//        theview.button(true);
        }
    }

    private class hapusListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int baris = theview.getSelectedRow();
                String motorid = theview.getValueAt(baris, 0);
                System.out.println(motorid);
                themodel.delete(motorid);
                theview.text(true);
                theview.button(true);
                clear();
//             theview.buttonadd(false);
                theview.setTable(themodel.getTableModel());
            } catch (SQLException ex) {
                Logger.getLogger(c_addmotor.class.getName()).log(Level.SEVERE, null, ex);
            }
//        theview.text(false);
//        theview.button(true);
        }
    }

    public void clear() {
        theview.setIdtor("");
        theview.setMerekmotor("");
        theview.setTypemotor("");
        theview.setTahun("");
        theview.setHargasewa("");
        theview.setNopol("");
    }

}
