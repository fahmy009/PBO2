/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.anggotahimasifinterface;
import dao.anggotahimasifmanager;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.anggotahimasifgetset;
import model.anggotahimasifmodel;
import model.datamahasiswagetset;
import view.adminview;
import view.anggotahimasifview;
import view.pengurusview;

/**
 *
 * @author Muhammad Fahmy
 */
public class anggotahimasifcontrol {

    List<anggotahimasifmodel> rec;
    anggotahimasifinterface ifc = new anggotahimasifmanager();
    anggotahimasifmodel model;
    anggotahimasifmanager mgr;
    anggotahimasifview frame;

    public anggotahimasifcontrol(anggotahimasifview frame) {
        this.frame = frame;
    }
    
    public void back(){
        pengurusview a = new pengurusview();
        a.setVisible(true);
        frame.dispose();
    }

    public void select() {
        try {
            ifc.connect();
            rec = ifc.read();
            model = new anggotahimasifmodel(rec);
            frame.getTblMahasiswa().setModel(model);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(frame, "Silahkan Periksa koneksi mysql anda");
            Logger.getLogger(datamahasiswacontrol.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insert() {
        try {
            anggotahimasifgetset data = new anggotahimasifgetset();
            ifc.connect();
            data.setNim(frame.gettNIM().getText());
            data.setNama(frame.gettNama().getText());
            data.setTanggal(frame.gettTanggalLahir().getText());
            data.setAlamat(frame.gettAlamat().getText());
            data.setHP(frame.getTnomorHP().getText());
            data.setAgama(frame.getCbAgama().getSelectedItem().toString());
            data.setAngkatan(frame.getCbAngkatan().getSelectedItem().toString());
            data.setJabatan(frame.getCbJabatan().getSelectedItem().toString());
            ifc.insert(data);
            cleartext();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(frame, "Silahkan Isi Data Terlebih Dahulu");
        }
    }

    public void update() {
        int i = frame.getTblMahasiswa().getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(frame, "Tolong Pilih Data Terlebih Dahulu");
        } else {
            frame.getBtnUpdate().setEnabled(true);
            try {
                anggotahimasifgetset data = new anggotahimasifgetset();
                ifc.connect();
                data.setNim(frame.gettNIM().getText());
                data.setNama(frame.gettNama().getText());
                data.setTanggal(frame.gettTanggalLahir().getText());
                data.setAlamat(frame.gettAlamat().getText());
                data.setHP(frame.getTnomorHP().getText());
                data.setAgama(frame.getCbAgama().getSelectedItem().toString());
                data.setAngkatan(frame.getCbAngkatan().getSelectedItem().toString());
                data.setJabatan(frame.getCbJabatan().getSelectedItem().toString());
                ifc.update(data, (String) model.getValueAt(i, 0));

            } catch (SQLException ex) {
                Logger.getLogger(datamahasiswacontrol.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void delete() {
        int i = frame.getTblMahasiswa().getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(frame, "Tolong Pilih Data Terlebih Dahulu");
        } else {
            frame.getBtnDelete().setEnabled(true);
            try {
                ifc.connect();
                ifc.delete((String) model.getValueAt(i, 0));
            } catch (SQLException ex) {
                Logger.getLogger(datamahasiswacontrol.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void row() {
        int i = frame.getTblMahasiswa().getSelectedRow();
        frame.gettNIM().setText((String) model.getValueAt(i, 0));
        frame.gettNama().setText((String) model.getValueAt(i, 1));
        frame.gettTanggalLahir().setText((String) model.getValueAt(i, 2));
        frame.gettAlamat().setText((String) model.getValueAt(i, 3));
        frame.getCbAgama().setSelectedItem((String) model.getValueAt(i, 4));
        frame.getTnomorHP().setText((String) model.getValueAt(i, 5));
        frame.getCbAngkatan().setSelectedItem(String.valueOf(model.getValueAt(i, 6)));
        frame.getCbJabatan().setSelectedItem(String.valueOf(model.getValueAt(i, 7)));

    }

    public void cleartext() {
        frame.gettNIM().setText("");
        frame.gettNama().setText("");
        frame.gettTanggalLahir().setText("");
        frame.gettAlamat().setText("");
        frame.getCbAgama().setSelectedIndex(0);
        frame.getTnomorHP().setText("");
        frame.getCbAngkatan().setSelectedIndex(0);
        frame.getCbJabatan().setSelectedIndex(0);
    }

    public void cari() {
        if (frame.gettNIM().getText().length() == 12) {
            frame.setBtnSimpan(true);
            frame.getBtnBatal().setEnabled(true);
            try {
                anggotahimasifgetset data = new anggotahimasifgetset();
                ifc.connect();
                data.setNim(frame.gettNIM().getText());
                ifc.nim(frame.gettNIM().getText());
                frame.gettNama().setText(anggotahimasifmanager.nama);
                frame.gettTanggalLahir().setText(anggotahimasifmanager.tanggal);
                frame.gettAlamat().setText(anggotahimasifmanager.alamat);
                frame.getTnomorHP().setText(anggotahimasifmanager.nohp);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(frame, "Data Tidak Ada");
            }
        } 
    }

    public void batal() {
        frame.getBtnSimpan().setEnabled(false);
        frame.getBtnBatal().setEnabled(false);
        cleartext();
    }

}
