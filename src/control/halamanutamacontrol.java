/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import view.loginview;
import view.halamanutamaview;
import view.pendaftarview;

/**
 *
 * @author Muhammad Fahmy
 */
public class halamanutamacontrol {
    halamanutamaview frame;
    loginview a = new loginview();
    pendaftarview b = new pendaftarview();

    public halamanutamacontrol(halamanutamaview frame) {
        this.frame = frame;
    }
    
    public void login(){
        a.setVisible(true);
        frame.dispose();
    }
    
    public void daftar(){
        b.setVisible(true);
        frame.dispose();
    }
}
