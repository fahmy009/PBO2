/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.logininterface;
import dao.loginmanager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.logingetset;
import model.loginmodel;
import view.adminview;
import view.formpenilaianview;
import view.halamanutamaview;
import view.loginview;
import view.pengurusview;

/**
 *
 * @author Muhammad Fahmy
 */
public class logincontrol {

    List<loginmodel> rec;
    logininterface ifc = new loginmanager();
    loginview frame;
    logingetset mgr;

    public logincontrol(loginview frame) {
        this.frame = frame;
    }

    public boolean checkQuery(String username, String password) {
        boolean hasil = false;
        try {
            ifc.connect();
            mgr = ifc.check(username);
            if (username.equals(mgr.getUsername()) && password.equals(mgr.getPassword())) {
                hasil = true;
            } else {
                hasil = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(logincontrol.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hasil;
    }

    public void check() {
        if (checkQuery(frame.getUsername().getText(), frame.getPassword().getText())) {
            frame.getUsername().setText("");
            frame.getPassword().setText("");
            if (mgr.getLevel() == 1) {
                adminview a = new adminview();
                a.setVisible(true);
                frame.dispose();
            } else {
                pengurusview a = new pengurusview();
                a.setVisible(true);
                frame.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Maaf, Username dan password anda tidak sesuai..!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            frame.getUsername().setText("");
            frame.getPassword().setText("");
        }
    }

    public void back() {
        halamanutamaview a = new halamanutamaview();
        a.setVisible(true);
        frame.dispose();
    }

}
