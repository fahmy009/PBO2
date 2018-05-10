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
import model.pendaftargetset;

/**
 *
 * @author Muhammad Fahmy
 */
public class pendaftaranmanager extends koneksi implements pendaftarinterface {

    public static String nama;
    public static String tanggal;

    @Override
    public void connect() throws SQLException {
        this.conn = (Connection) DriverManager.getConnection(host, user, pass);
    }

    @Override
    public void disconnect() throws SQLException {
        this.conn.close();
    }

    @Override
    public void insert(pendaftargetset data) throws SQLException {
        String sql = "INSERT INTO pendaftar(id_pendaftar, nim, alamat_sekarang,divisi, alasan) VALUES (?,?,?,?,?)";
        PreparedStatement pre = conn.prepareStatement(sql);
        pre.setInt(1, data.getIdpendaftar());
        pre.setString(2, data.getNim());
        pre.setString(3, data.getAlamatsekarang());
        pre.setString(4, data.getDivisi());
        pre.setString(5, data.getAlasan());
        pre.executeUpdate();
    }

    @Override
    public void nim(String nim) throws SQLException {
        String sql = "SELECT nama, tanggal_lahir FROM mahasiswa WHERE nim='" + nim + "'";
        Statement st = conn.createStatement();
        ResultSet res = st.executeQuery(sql);
        res.next();
        nama = res.getString("nama");
        tanggal = res.getString("tanggal_lahir");
    }

  

}
