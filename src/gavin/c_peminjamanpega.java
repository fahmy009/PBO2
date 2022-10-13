/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.m_peminjam;
import model.m_peminjampega;
import view.peminjam;
import view.peminjampega;

/**
 *
 * @author Muhtar
 */
public class c_peminjamanpega {

    m_peminjampega themodel = new m_peminjampega();
    peminjampega theview = new peminjampega();

    public c_peminjamanpega() throws SQLException {
//        this.themodel = themodel;
//        this.theview = theview;
        theview.setVisible(true);
//        theview.setTable(themodel.getTableModel());
//        theview.addsaveListener(new saveListener());
        theview.addsaveListener(new saveListener());
        theview.setIdmotor(themodel.IdMotor());
//        theview.setIdmotor(themodel.IdMotor());
//        theview.setIdmotor(themodel.IdMotor());
//        theview.addeditListener(new editListener());
//        theview.addupdateListener(new updateListener());
        theview.addhapusListener(new hapusListener());
//        theview.addBtnUserListener(new UserListener());
        theview.addhitungListener(new hitungListener());
        theview.addBtnKeluarListener(new KeluarListener());
        theview.check(new c_peminjamanpega.check());
        Date now = new Date();

//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String tgl = simpleDateFormat.format(now);
//        theview.getTglpinjam().setText(tgl);
        try {
            theview.setTable(themodel.getTableModel());
        } catch (SQLException ex) {
            Logger.getLogger(c_peminjamanpega.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private class check implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            try {
                themodel.status(Integer.parseInt((String) theview.getIdmotor().getSelectedItem()));
                theview.setNopol(m_peminjam.nopol);
                theview.setMerek(m_peminjam.merek);
                theview.setType(m_peminjam.type);
            } catch (SQLException ex) {
                Logger.getLogger(c_peminjamanpega.class.getName()).log(Level.SEVERE, null, ex);
//                }
            }
        }
    }

    private class KeluarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theview.dispose();
            c_menuUtamapega con = new c_menuUtamapega();
        }
    }

    private class hitungListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                Date pinjam = df.parse(theview.getPinja());
                Date kembali = df.parse(theview.getKemba());
                int pinjam1 = (int) pinjam.getTime();
                int kembali1 = (int) kembali.getTime();
                int diff = kembali1 - pinjam1;
                int lama = diff / (24 * 60 * 60 * 1000);
                themodel.status(Integer.parseInt((String) theview.getIdmotor().getSelectedItem()));
                int hasil = lama * m_peminjam.harga;
                theview.getHari().setText(Integer.toString(lama));
                theview.getHarga().setText(String.valueOf(hasil));

            } catch (ParseException a) {
                System.out.println("" + a.getMessage());
            } catch (SQLException ex) {
                Logger.getLogger(c_peminjam.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class MotorListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theview.dispose();
            c_addmotorpega con = new c_addmotorpega();
        }
    }

    private class hapusListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int baris = theview.getSelectedRow();
                String id = theview.getValueAt(baris, 0);
                System.out.println(id);
                themodel.delete(id);
                theview.text(true);
                theview.button(true);
//                clear();
//             theview.buttonadd(false);
                theview.setTable(themodel.getTableModel());
            } catch (SQLException ex) {
                Logger.getLogger(c_peminjamanpega.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class saveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                //                int baris = theview.getSelectedRow();
//            if (baris != -1) {
//                
//            }
//                String idmotor = Integer.valueOf();
//                idmotor = Integer.valueOf()(theview.getIdmotor());
                themodel.save(theview.getIdmotor().getSelectedItem().toString(), theview.getNama(), theview.getAlamat(), theview.getNotelp(), theview.getNoktp(), theview.getMerek(), theview.getTipe(), theview.getStatus(), theview.getPinja(), theview.getKemba(), theview.getHari().getText(), theview.getHarga().getText());
                theview.setTable(themodel.getTableModel());

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(theview, "Motor Tidak Tersedia");
//                Logger.getLogger(c_peminjam.class.getName()).log(Level.SEVERE, null, ex);
            }

//                theview.setIdmotor(0);
            theview.setNama("");
            theview.setAlamat("");
            theview.setNotelp("");
            theview.setNoktp("");
            theview.setNopol("");
            theview.setMerek("");
            theview.setType("");
//                theview.setTglpinjam("");
//                theview.setTglkembali("");
            theview.getHari().setText("");
            theview.getHarga().setText("");
//                theview.setIdmotor(0);
//            theview.text(false);
//            theview.buttonsave(true);
//            theview.button(true);
            //                clear();

        }
    }
}
