/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.formpenilaianinterface;
import dao.formpenilaianmanager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.formpenilaianmodel;
import model.formpenilaingetset;
import view.adminview;
import view.formpenilaianview;
import view.pengurusview;

/**
 *
 * @author Muhammad Fahmy
 */
public class formpenilaiancontrol {

    List<formpenilaianmodel> rec;
    formpenilaianinterface ifc = new formpenilaianmanager();
    formpenilaianmodel model;
    formpenilaianmanager mgr;
    formpenilaianview frame;

    public formpenilaiancontrol(formpenilaianview frame) {
        this.frame = frame;
    }

    public void select() {
        try {
            ifc.connect();
            rec = ifc.read();
            model = new formpenilaianmodel(rec);
            frame.getTableNilai().setModel(model);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(frame, "Silahkan Periksa koneksi mysql anda");
            Logger.getLogger(formpenilaiancontrol.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insert() {
        try {
            formpenilaingetset data = new formpenilaingetset();
            ifc.connect();
            data.setIdPendaftar(Integer.parseInt(frame.gettIdPendaftar().getText()));
            data.setNilaiPengalaman(Double.valueOf(frame.gettPengalaman().getText()));
            data.setNilaiEtika(Double.valueOf(frame.gettEtika().getText()));
            data.setNilaiPenampilan(Double.valueOf(frame.gettPenampilan().getText()));
            ifc.insert(data);
            clearText();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(frame, "Silahkan Isi Data Terlebih Dahulu", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void update() {
        int i = frame.getTableNilai().getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(frame, "Tolong Pilih Data Terlebih Dahulu");
        } else {
            try {
                formpenilaingetset data = new formpenilaingetset();
                ifc.connect();
                data.setIdPendaftar(Integer.parseInt(frame.gettIdPendaftar().getText()));
                data.setNilaiPengalaman(Double.valueOf(frame.gettPengalaman().getText()));
                data.setNilaiEtika(Double.valueOf(frame.gettEtika().getText()));
                data.setNilaiPenampilan(Double.valueOf(frame.gettPenampilan().getText()));
                ifc.update(data, (String) model.getValueAt(i, 0));

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(frame, "Silahkan Isi Data Terlebih Dahulu", "Kesalahan", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(datamahasiswacontrol.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void delete() {
        int i = frame.getTableNilai().getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(frame, "Tolong Pilih Data Terlebih Dahulu");
        } else {
            try {
                ifc.connect();
                ifc.delete((String) model.getValueAt(i, 0));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(frame, "Silahkan Isi Data Terlebih Dahulu", "Kesalahan", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(datamahasiswacontrol.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void row() {
        int i = frame.getTableNilai().getSelectedRow();
        frame.gettIdPendaftar().setText((String) model.getValueAt(i, 0));
        frame.gettPengalaman().setText((String) model.getValueAt(i, 1));
        frame.gettEtika().setText((String) model.getValueAt(i, 2));
        frame.gettPenampilan().setText((String) model.getValueAt(i, 3));
    }

    public void clearText() {
        frame.gettIdPendaftar().setText("");
        frame.gettNIM().setText("");
        frame.getTnama().setText("");
        frame.gettPengalaman().setText("");
        frame.gettPenampilan().setText("");
        frame.gettEtika().setText("");
    }

    public void cari() {
        try {
            formpenilaingetset data = new formpenilaingetset();
            ifc.connect();
            data.setIdPendaftar(Integer.parseInt(frame.gettIdPendaftar().getText()));
            ifc.nim(frame.gettIdPendaftar().getText());
            frame.gettNIM().setText(formpenilaianmanager.nim);
            frame.getTnama().setText(formpenilaianmanager.nama);
            if (frame.gettNIM().getText().length() == 12) {
                frame.gettIdPendaftar().setEnabled(false);
                frame.getBtnSelesai().setEnabled(true);
                frame.getBtnBatal().setEnabled(true);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(frame, "Data Tidak Ada");
        }
    }

    public void back() {
        pengurusview a = new pengurusview();
        a.setVisible(true);
        frame.dispose();
    }

    public void batal() {
        frame.gettIdPendaftar().setEnabled(true);
        frame.getBtnBatal().setEnabled(false);
        frame.getBtnSelesai().setEnabled(false);
        clearText();
    }
}
