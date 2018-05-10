/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.List;
import model.datamahasiswagetset;

/**
 *
 * @author Muhammad Fahmy
 */
public interface datamahasiswainterface {

    public void connect() throws SQLException;

    public void disconnect() throws SQLException;

    public List read() throws SQLException;

    public void insert(datamahasiswagetset data) throws SQLException;

    public void update(datamahasiswagetset data, String nim) throws SQLException;

    public void delete(String nim) throws SQLException;

}
