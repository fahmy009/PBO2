/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.List;
import model.formpenilaingetset;

/**
 *
 * @author Muhammad Fahmy
 */
public interface formpenilaianinterface {

    public void connect() throws SQLException;

    public void disconnect() throws SQLException;

    public List read() throws SQLException;

    public void insert(formpenilaingetset data) throws SQLException;

    public void update(formpenilaingetset data, String id) throws SQLException;

    public void delete(String nim) throws SQLException;

    public void nim(String id) throws SQLException;

}
