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
import view.menuUtama;
import view.menuUtamapega;

/**
 *
 * @author Muhtar
 */
public class c_menuUtamapega {

    menuUtamapega theView = new menuUtamapega();

    public c_menuUtamapega() {
        theView.setVisible(true);
        theView.addBtnPeminjamListener(new c_menuUtamapega.PeminjamListener());
//        theView.addBtnPengembalianListener(new c_menuUtamapega.PengembalianListener());
        theView.addBtnKeluarListener(new c_menuUtamapega.KeluarListener());
    }

    private class KeluarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.dispose();
            c_menuAwal con = new c_menuAwal();
        }
    }

    private class PeminjamListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
          theView.dispose();
            try {
                c_peminjamanpega con = new c_peminjamanpega();
            } catch (SQLException ex) {
                Logger.getLogger(c_menuUtamapega.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class AddMotorListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.dispose();
            c_addmotorpega con = new c_addmotorpega();
//theView.addBtnAddUserListener(false);
//            theView.button(false);
        }
    }
}
