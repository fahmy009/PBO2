/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.m_login;
import view.login;

/**
 *
 * @author Muhtar
 */
public class c_login {

    m_login theModel = new m_login();
    login theView = new login();

    public c_login() {
        theView.setVisible(true);
        theView.AddBtnMasukListener(new loginListener());
        theView.AddBtnBatalListener(new batalListener());
    }

    public c_login(m_login theModel, login theView) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private class batalListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
          theView.dispose();
          c_menuAwal con = new c_menuAwal();
        }
    }

    private class loginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String Username = theView.getUsername().getText();
            String Password = "";
            char passArray[] = theView.getTxtpassword().getPassword();
            for (int i = 0; i < passArray.length; i++) {
                Password += passArray[i];
            }
            try {
                ResultSet rs = theModel.check(Username, Password);
                rs.last();
                if (rs.getRow() == 1) {
                    String Status = rs.getString(5);
                    theView.dispose();
                    if (Status.equalsIgnoreCase("Admin")) {
                        c_menuUtama control = new c_menuUtama();
//                        view.menuUtama a = new view.menuUtama();
//                        a.setVisible(true);
//                        theView.dispose();
                    } else {
                        c_menuUtamapega control = new c_menuUtamapega();
//                        view.menuUtamapega b = new view.menuUtamapega();
//                        b.setVisible(true);
//                        theView.dispose();
                    }

                } else {
                    theView.salah();
                }
            } catch (SQLException ex) {
                Logger.getLogger(c_login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
