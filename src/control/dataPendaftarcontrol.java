/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.dataPendaftarinterface;
import dao.datapendaftarmanager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.dataPendaftargetset;
import model.dataPendaftarmodel;
import view.pengurusview;
import view.tablependaftar;

/**
 *
 * @author Muhammad Fahmy
 */
public class dataPendaftarcontrol {

    List<dataPendaftargetset> rec;
    dataPendaftarinterface ifc = new datapendaftarmanager();
    dataPendaftarmodel model;
    tablependaftar frame;

    public dataPendaftarcontrol(tablependaftar frame) {
        this.frame = frame;
    }

    public void select() {
        try {
            ifc.connect();
            rec = ifc.read();
            model = new dataPendaftarmodel(rec);
            frame.getDataPendaftar().setModel(model);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(frame, "Silahkan Periksa koneksi mysql anda");
            Logger.getLogger(dataPendaftarcontrol.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void back() {
        pengurusview a = new pengurusview();
        a.setVisible(true);
        frame.dispose();
    }
}
