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
public class formpenilaianmodel extends AbstractTableModel {

    List<formpenilaingetset> ls = new ArrayList<formpenilaingetset>();

    public formpenilaianmodel(List ls) {
        this.ls = ls;
    }

    @Override
    public int getRowCount() {
        return this.ls.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return ls.get(rowIndex).getNama();
            case 1:
                return ls.get(rowIndex).getNilaiPengalaman();
            case 2:
                return ls.get(rowIndex).getNilaiEtika();
            case 3:
                return ls.get(rowIndex).getNilaiPenampilan();
            case 4:
                return ls.get(rowIndex).getStatus();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nama";
            case 1:
                return "Nilai Pengalaman";
            case 2:
                return "Nilai Etika";
            case 3:
                return "Nilai Penampilan";
            case 4:
                return "Status";
            default:
                return null;
        }
    }

}
