/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.menuAwal;

/**
 *
 * @author Muhtar
 */
public class c_menuAwal {

    menuAwal theView = new menuAwal();

    public c_menuAwal() {
        theView.setVisible(true);
        theView.addBtnMasukListener(new MasukListener());
//        theView.addBtnMasukListener(new );
//        theView.addBtnMasukListener(new MasukListener);
System.out.println("controller berfungsi");
    }

    private class MasukListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.dispose();
            c_login con = new c_login();
        }
    }
}
