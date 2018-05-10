/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import koneksi.koneksi;
import model.dataPendaftargetset;

/**
 *
 * @author Muhammad Fahmy
 */
public class datapendaftarmanager extends koneksi implements dataPendaftarinterface {

    @Override
    public void connect() throws SQLException {
        this.conn = (Connection) DriverManager.getConnection(host, user, pass);
    }

    @Override
    public void disconnect() throws SQLException {
        this.conn.close();
    }

    @Override
    public List read() throws SQLException {
        String sql = "SELECT p.id_pendaftar,p.nim, m.nama, m.tanggal_lahir, p.alamat_sekarang, p.divisi, p.alasan, m.nomorHP, m.angkatan FROM pendaftar p join mahasiswa m on p.nim=m.nim";
        Statement st = conn.createStatement();
        ResultSet res = st.executeQuery(sql);
        List ls = new ArrayList();
        while (res.next()) {
            dataPendaftargetset data = new dataPendaftargetset();
            data.setIdpendaftar(res.getInt("p.id_pendaftar"));
            data.setNim(res.getString("p.nim"));
            data.setNama(res.getString("m.nama"));
            data.setTanggal(res.getString("m.tanggal_lahir"));
            data.setAlamatsekarang(res.getString("p.alamat_sekarang"));
            data.setDivisi(res.getString("p.divisi"));
            data.setAlasan(res.getString("p.alasan"));
            data.setHP(res.getString("m.nomorHP"));
            data.setAngkatan(res.getString("m.angkatan"));
            ls.add(data);
        }
        return ls;
    }

}
