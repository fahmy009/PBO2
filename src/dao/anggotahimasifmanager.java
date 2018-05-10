/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.anggotahimasifgetset;
import model.datamahasiswagetset;
import koneksi.koneksi;

/**
 *
 * @author Muhammad Fahmy
 */
public class anggotahimasifmanager extends koneksi implements anggotahimasifinterface {

    public static String nama;
    public static String tanggal;
    public static String alamat;
    public static String nohp;

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
        String sql = "SELECT ah.nim , ah.jabatan , m.nama, m.tanggal_lahir ,m.alamat ,m.agama ,m.nomorHP ,m.angkatan  FROM anggotahimasif ah JOIN mahasiswa m ON ah.nim = m.nim";
        Statement st = conn.createStatement();
        ResultSet res = st.executeQuery(sql);
        List ls = new ArrayList();
        while (res.next()) {
            anggotahimasifgetset data = new anggotahimasifgetset();
            data.setNim(res.getString("nim"));
            data.setNama(res.getString("nama"));
            data.setTanggal(res.getString("tanggal_lahir"));
            data.setAlamat(res.getString("alamat"));
            data.setAgama(res.getString("agama"));
            data.setHP(res.getString("nomorHP"));
            data.setAngkatan(res.getString("angkatan"));
            data.setJabatan(res.getString("jabatan"));
            ls.add(data);
        }
        return ls;
    }

    @Override
    public void insert(anggotahimasifgetset data) throws SQLException {
        String sql = "INSERT INTO anggotahimasif(id_anggota, nim, jabatan,id_user) VALUES (?,?,?,2)";
        PreparedStatement pre = conn.prepareStatement(sql);
        pre.setInt(1, data.getId());
        pre.setString(2, data.getNim());
        pre.setString(3, data.getJabatan());
//        pre.setInt(4, data.getIduser());
        pre.executeUpdate();
    }

    @Override
    public void update(anggotahimasifgetset data, String id) throws SQLException {
        String sql = "UPDATE anggotahimasif SET id_anggota=?, nim=?, jabatan=?,id_user=? WHERE id_anggota=?";
        PreparedStatement pre = conn.prepareStatement(sql);
        pre.setInt(1, data.getId());
        pre.setString(2, data.getNim());
        pre.setString(3, data.getJabatan());
        pre.setInt(4, data.getIduser());
        pre.setString(5, id);
        pre.executeUpdate();
    }

    @Override
    public void delete(String id) throws SQLException {
        String sql = "DELETE FROM anggotahimasif WHERE id_anggota=?";
        PreparedStatement pre = conn.prepareStatement(sql);
        pre.setString(1, id);
        pre.executeUpdate();
    }

    @Override
    public void nim(String NIM) throws SQLException {
        String sql = "SELECT nama, tanggal_lahir, alamat, nomorHP FROM mahasiswa WHERE nim='" + NIM + "'";
        Statement st = conn.createStatement();
        ResultSet res = st.executeQuery(sql);
        res.next();
        nama = res.getString("nama");
        tanggal = res.getString("tanggal_lahir");
        alamat = res.getString("alamat");
        nohp = res.getString("nomorHP");
    }

}
