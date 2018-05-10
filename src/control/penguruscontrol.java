/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import view.adminview;
import view.anggotahimasifview;
import view.formpenilaianview;
import view.loginview;
import view.pengurusview;
import view.tablependaftar;

/**
 *
 * @author Muhammad Fahmy
 */
public class penguruscontrol {

    pengurusview frame;
    anggotahimasifview b = new anggotahimasifview();
    formpenilaianview c = new formpenilaianview();
    tablependaftar d = new tablependaftar();
    loginview x = new loginview();

    public penguruscontrol(pengurusview frame) {
        this.frame = frame;
    }

    public void himasif() {
        b.setVisible(true);
        frame.dispose();
    }

    public void penilaian() {
        c.setVisible(true);
        frame.dispose();
    }

    public void logout() {
        x.setVisible(true);
        frame.setVisible(false);
        b.setVisible(false);
    }

    public void daftar() {
        d.setVisible(true);
        frame.dispose();
    }
}
