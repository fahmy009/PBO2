/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.datamahasiswamanager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.datamahasiswagetset;
import model.datamahasiswamodel;
import view.datamahasiswaview;
import dao.datamahasiswainterface;
import java.text.SimpleDateFormat;
import view.adminview;

/**
 *
 * @author Muhammad Fahmy
 */
public class datamahasiswacontrol {

    List<datamahasiswagetset> rec;
    datamahasiswainterface ifc = new datamahasiswamanager();
    datamahasiswamodel model;
    datamahasiswaview frame;

    public datamahasiswacontrol(datamahasiswaview frame) {
        this.frame = frame;
    }

    public void select() {
        try {
            ifc.connect();
            rec = ifc.read();
            model = new datamahasiswamodel(rec);
            frame.getTblMahasiswa().setModel(model);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(frame, "Silahkan Periksa koneksi mysql anda");
            Logger.getLogger(datamahasiswacontrol.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insert() {
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal = String.valueOf(fm.format(frame.getTanggal().getDate()));
        try {
            datamahasiswagetset data = new datamahasiswagetset();
            ifc.connect();
            data.setNim(frame.gettNIM().getText());
            data.setNama(frame.gettNama().getText());
            data.setTanggal(tanggal);
            data.setAlamat(frame.gettAlamat().getText());
            data.setHP(frame.getTnomorHP().getText());
            data.setAgama(frame.getCbAgama().getSelectedItem().toString());
            data.setAngkatan(frame.getCbAngkatan().getSelectedItem().toString());
            ifc.insert(data);
            cleartext();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(frame, "Silahkan Isi Data Terlebih Dahulu");
        }

    }

    public void update() {
        int i = frame.getTblMahasiswa().getSelectedRow();
         SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal = String.valueOf(fm.format(frame.getTanggal().getDate()));
        if (i == -1) {
            JOptionPane.showMessageDialog(frame, "Tolong Pilih Data Terlebih Dahulu");
        } else {
            try {
                datamahasiswagetset data = new datamahasiswagetset();
                ifc.connect();
                data.setNim(frame.gettNIM().getText());
                data.setNama(frame.gettNama().getText());
                data.setTanggal(tanggal);
                data.setAlamat(frame.gettAlamat().getText());
                data.setHP(frame.getTnomorHP().getText());
                data.setAgama(frame.getCbAgama().getSelectedItem().toString());
                data.setAngkatan(frame.getCbAngkatan().getSelectedItem().toString());
                ifc.update(data, (String) model.getValueAt(i, 0));
                cleartext();
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
            frame.getBtnBatal().setEnabled(true);
            try {
                cleartext();
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

    }

    public void cleartext() {
        frame.gettNIM().setText("");
        frame.gettNama().setText("");
        frame.gettAlamat().setText("");
        frame.getCbAgama().setSelectedIndex(0);
        frame.getTnomorHP().setText("");
        frame.getCbAngkatan().setSelectedIndex(0);
    }

    public void back() {
        adminview a = new adminview();
        a.setVisible(true);
        frame.dispose();
    }

    public void batal() {
        frame.getBtnSimpan().setEnabled(false);
        frame.getBtnBatal().setEnabled(false);
        frame.getBtnUpdate().setEnabled(false);
        frame.getBtnDelete().setEnabled(false);
        cleartext();
    }

    public void check() {
        if (frame.gettNIM().getText().length() == 12) {
            frame.getBtnSimpan().setEnabled(true);
            frame.getBtnBatal().setEnabled(true);
        }
    }

}
