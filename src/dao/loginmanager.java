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
import model.logingetset;

/**
 *
 * @author Muhammad Fahmy
 */
public class loginmanager extends koneksi implements logininterface {

    public static String username;
    public static String password;
    public static int level;

    @Override
    public void connect() throws SQLException {
        this.conn = (Connection) DriverManager.getConnection(host, user, pass);
    }

    @Override
    public void disconnect() throws SQLException {
        this.conn.close();
    }

    @Override
    public logingetset check(String nama) throws SQLException {
        String sql = "select * from user where username=?";
        PreparedStatement pre = conn.prepareStatement(sql);
        pre.setString(1,nama);
        ResultSet rs = pre.executeQuery();
        logingetset u = new logingetset();
        if (rs.next()) {
            u.setIduser(rs.getInt("id_user"));
            u.setUsername(rs.getString("username"));
            u.setPassword(rs.getString("password"));
            u.setLevel(rs.getInt("id_level"));
        }
        return u;
    }

}
