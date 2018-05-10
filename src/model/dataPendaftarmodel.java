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
public class dataPendaftarmodel extends AbstractTableModel {

    List<dataPendaftargetset> ls = new ArrayList<dataPendaftargetset>();

    public dataPendaftarmodel(List ls) {
        this.ls = ls;
    }

    @Override
    public int getRowCount() {
        return this.ls.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return ls.get(rowIndex).getIdpendaftar();
            case 1:
                return ls.get(rowIndex).getNim();
            case 2:
                return ls.get(rowIndex).getNama();
            case 3:
                return ls.get(rowIndex).getTanggal();
            case 4:
                return ls.get(rowIndex).getAlamatsekarang();
            case 5:
                return ls.get(rowIndex).getDivisi();
            case 6:
                return ls.get(rowIndex).getAlasan();
            case 7:
                return ls.get(rowIndex).getHP();
            case 8:
                return ls.get(rowIndex).getAngkatan();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Id Pendaftar";
            case 1:
                return "NIM";
            case 2:
                return "Nama";
            case 3:
                return "Tanggal Lahir";
            case 4:
                return "Alamat Kost";
            case 5:
                return "Divisi";
            case 6:
                return "Alasan";
            case 7:
                return "Nomor HP";
            case 8:
                return "Angkatan";
            default:
                return null;
        }
    }

}
