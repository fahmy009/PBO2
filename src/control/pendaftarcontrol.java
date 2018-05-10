/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.pendaftaranmanager;
import dao.pendaftarinterface;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import model.pendaftargetset;
import view.halamanutamaview;
import view.pendaftarview;

/**
 *
 * @author Muhammad Fahmy
 */
public class pendaftarcontrol {

    pendaftarinterface ifc = new pendaftaranmanager();
    pendaftarview frame;

    public pendaftarcontrol(pendaftarview frame) {
        this.frame = frame;
    }

    public void insert() {
        pendaftargetset data = new pendaftargetset();
        try {
            ifc.connect();
            data.setNim(frame.gettNIM().getText());
            data.setNama(frame.gettNama().getText());
            data.setAlamatsekarang(frame.gettAlamat().getText());
            data.setDivisi(frame.getCbDivisi().getSelectedItem().toString());
            data.setAlasan(frame.gettAlasan().getText());
            ifc.insert(data);
            JOptionPane.showMessageDialog(frame, "Terima Kasih Telah Mendaftar\nTunggu Konfirmasi Selanjutnya");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(frame, "Silahkan Isi Data Terlebih Dahulu");
        }
    }

    public void cari() {
        if (frame.gettNIM().getText().length() == 12) {
            frame.setBtnSimpan(true);
            boolean a = true;
            int pilihan = JOptionPane.showConfirmDialog(frame, "Apakah NIM yang Anda Masukkan Benar..?\nNIMnya adalah " + frame.gettNIM().getText(), "Konfirmasi NIM", YES_NO_OPTION);
            while (a == true) {
                if (pilihan == JOptionPane.YES_OPTION) {
                    try {
                        pendaftargetset data = new pendaftargetset();
                        ifc.connect();
                        data.setNim(frame.gettNIM().getText());
                        ifc.nim(frame.gettNIM().getText());
                        frame.gettNama().setText(pendaftaranmanager.nama);
                        frame.gettTanggalLahir().setText(pendaftaranmanager.tanggal);
                        frame.setNIM(false);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(frame, "Data Tidak Ada");
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Silahkan Masukkan Kembali NIM Anda");
                }
                a = false;
            }
        }
    }

    public void back() {
        halamanutamaview a = new halamanutamaview();
        a.setVisible(true);
        frame.dispose();
    }
}
