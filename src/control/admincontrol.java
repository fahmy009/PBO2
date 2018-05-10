/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import view.adminview;
import view.anggotahimasifview;
import view.datamahasiswaview;
import view.formpenilaianview;
import view.loginview;

/**
 *
 * @author Muhammad Fahmy
 */
public class admincontrol {

    adminview frame;
    datamahasiswaview a = new datamahasiswaview();
    loginview x = new loginview();

    public admincontrol(adminview frame) {
        this.frame = frame;
    }

    public void mahasiswa() {
        a.setVisible(true);
        frame.dispose();
    }

    public void logout() {
        x.setVisible(true);
        frame.setVisible(false);
        a.setVisible(false);
    }

}
