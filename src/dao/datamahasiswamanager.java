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
import koneksi.koneksi;
import model.datamahasiswagetset;

/**
 *
 * @author Muhammad Fahmy
 */
public class datamahasiswamanager extends koneksi implements datamahasiswainterface {

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
        String sql = "SELECT * FROM mahasiswa";
        Statement st = conn.createStatement();
        ResultSet res = st.executeQuery(sql);
        List ls = new ArrayList();
        while (res.next()) {
            datamahasiswagetset data = new datamahasiswagetset();
            data.setNim(res.getString("nim"));
            data.setNama(res.getString("nama"));
            data.setTanggal(res.getString("tanggal_lahir"));
            data.setAlamat(res.getString("alamat"));
            data.setAgama(res.getString("agama"));
            data.setHP(res.getString("nomorHP"));
            data.setAngkatan(res.getString("angkatan"));
            ls.add(data);
        }
        return ls;
    }

    @Override
    public void insert(datamahasiswagetset data) throws SQLException {
        String sql = "INSERT INTO mahasiswa(nim,nama,tanggal_lahir,alamat,agama, nomorHP, angkatan) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement pre = conn.prepareStatement(sql);
        pre.setString(1, data.getNim());
        pre.setString(2, data.getNama());
        pre.setString(3, data.getTanggal());
        pre.setString(4, data.getAlamat());
        pre.setString(5, data.getAgama());
        pre.setString(6, data.getHP());
        pre.setString(7, data.getAngkatan());
        pre.executeUpdate();
    }

    @Override
    public void update(datamahasiswagetset data, String nim) throws SQLException {
        String sql = "UPDATE mahasiswa SET nim=?, nama=?, tanggal_lahir=?,alamat=?,agama=?,nomorHP=?,angkatan=? WHERE nim=?";
        PreparedStatement pre = conn.prepareStatement(sql);
        pre.setString(1, data.getNim());
        pre.setString(2, data.getNama());
        pre.setString(3, data.getTanggal());
        pre.setString(4, data.getAlamat());
        pre.setString(5, data.getAgama());
        pre.setString(6, data.getHP());
        pre.setString(7, data.getAngkatan());
        pre.setString(8, nim);
        pre.executeUpdate();

    }

    @Override
    public void delete(String nim) throws SQLException {
        String sql = "DELETE FROM mahasiswa WHERE nim=?";
        PreparedStatement pre = conn.prepareStatement(sql);
        pre.setString(1, nim);
        pre.executeUpdate();
    }

}
