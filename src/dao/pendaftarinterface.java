/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.List;
import model.pendaftargetset;

/**
 *
 * @author Muhammad Fahmy
 */
public interface pendaftarinterface {

    public void connect() throws SQLException;

    public void disconnect() throws SQLException;

    public void insert(pendaftargetset data) throws SQLException;

    public void nim(String nim) throws SQLException;
}
