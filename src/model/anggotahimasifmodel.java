/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Muhammad Fahmy
 */
public class anggotahimasifmodel extends AbstractTableModel {

    List<anggotahimasifgetset> ls = new ArrayList<anggotahimasifgetset>();

    public anggotahimasifmodel(List ls) {
        this.ls = ls;
    }

    @Override
    public int getRowCount() {
        return this.ls.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return ls.get(rowIndex).getNim();
            case 1:
                return ls.get(rowIndex).getNama();
            case 2:
                return ls.get(rowIndex).getTanggal();
            case 3:
                return ls.get(rowIndex).getAlamat();
            case 4:
                return ls.get(rowIndex).getAgama();
            case 5:
                return ls.get(rowIndex).getHP();
            case 6:
                return ls.get(rowIndex).getAngkatan();
            case 7:
                return ls.get(rowIndex).getJabatan();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "NIM";
            case 1:
                return "Nama";
            case 2:
                return "Tanggal Lahir";
            case 3:
                return "Alamat";
            case 4:
                return "Agama";
            case 5:
                return "Nomor HP";
            case 6:
                return "Angkatan";
            case 7:
                return "Jabatan";
            default:
                return null;
        }
    }

}
