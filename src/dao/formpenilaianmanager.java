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
import model.formpenilaingetset;

/**
 *
 * @author Muhammad Fahmy
 */
public class formpenilaianmanager extends koneksi implements formpenilaianinterface {

    public static String nim;
    public static String nama;

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
        String sql = "SELECT m.nama, p.nilai_pengalaman, p.nilai_etika, p.nilai_penampilan, p.status FROM pendaftar pd JOIN penilaian p ON pd.id_pendaftar=p.id_pendaftar JOIN mahasiswa m ON m.nim=pd.nim";
        Statement st = conn.createStatement();
        ResultSet res = st.executeQuery(sql);
        List ls = new ArrayList();
        while (res.next()) {
            formpenilaingetset data = new formpenilaingetset();
            data.setNama(res.getString("nama"));
            data.setNilaiPengalaman(res.getDouble("nilai_pengalaman"));
            data.setNilaiEtika(res.getDouble("nilai_etika"));
            data.setNilaiPenampilan(res.getDouble("nilai_penampilan"));
            data.setStatus(res.getString("status"));
            ls.add(data);
        }
        return ls;
    }

    @Override
    public void insert(formpenilaingetset data) throws SQLException {
        String sql = "INSERT INTO penilaian(id_pendaftar, nilai_pengalaman, nilai_etika, nilai_penampilan, status) VALUES (?,?,?,?,?)";
        double hasil = (data.getNilaiPengalaman() + data.getNilaiEtika() + data.getNilaiPenampilan()) / 3;
        String status;
        if (hasil >= 70) {
            status = "Diterima";
        } else {
            status = "Tidak Diterima";
        }
        PreparedStatement pre = conn.prepareStatement(sql);
        pre.setInt(1, data.getIdPendaftar());
        pre.setDouble(2, data.getNilaiPengalaman());
        pre.setDouble(3, data.getNilaiEtika());
        pre.setDouble(4, data.getNilaiPenampilan());
        pre.setString(5, status);
        pre.executeUpdate();
    }

    @Override
    public void update(formpenilaingetset data, String id) throws SQLException {
        String sql = "UPDATE penilaian SET id_pendaftar=?, nilai_pengalaman=?, nilai_etika=?,nilai_penampilan=? WHERE id_pendaftar=?";
        PreparedStatement pre = conn.prepareStatement(sql);
        pre.setInt(1, data.getIdPendaftar());
        pre.setDouble(2, data.getNilaiPengalaman());
        pre.setDouble(3, data.getNilaiEtika());
        pre.setDouble(4, data.getNilaiPenampilan());
        pre.setString(5, id);
        pre.executeUpdate();
    }

    @Override
    public void delete(String id) throws SQLException {
        String sql = "DELETE FROM penilaian WHERE id_pendaftar=?";
        PreparedStatement pre = conn.prepareStatement(sql);
        pre.setString(1, id);
        pre.executeUpdate();
    }

    @Override
    public void nim(String id) throws SQLException {
        String sql = "SELECT * FROM pendaftar p join mahasiswa m on p.nim=m.nim where id_pendaftar='" + id + "'";
        Statement st = conn.createStatement();
        ResultSet res = st.executeQuery(sql);
        res.next();
        nim = res.getString("m.nim");
        nama = res.getString("m.nama");
    }

}
