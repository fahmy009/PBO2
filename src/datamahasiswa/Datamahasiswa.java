/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamahasiswa;

import javax.swing.UnsupportedLookAndFeelException;
import view.anggotahimasifview;
import view.datamahasiswaview;
import view.formpenilaianview;
import view.halamanutamaview;
import view.loginview;
import view.pendaftarview;

/**
 *
 * @author Muhammad Fahmy
 */
public class Datamahasiswa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        //====pakai nimbuz java SWING biar gak jadul AWT==//
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        //=============================//
        // TODO code application logic here

        //datamahasiswaview dmv = new datamahasiswaview();
        //anggotahimasifview dmv = new anggotahimasifview();
        //formpenilaianview dmv = new formpenilaianview();
        //pendaftarview dmv = new pendaftarview();
//        loginview dmv = new loginview();
        halamanutamaview dmv = new halamanutamaview();
        dmv.setVisible(true);
    }

}
