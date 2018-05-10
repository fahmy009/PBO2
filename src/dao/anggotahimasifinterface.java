/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.List;
import model.anggotahimasifgetset;
import model.datamahasiswagetset;

/**
 *
 * @author Muhammad Fahmy
 */
public interface anggotahimasifinterface {

    public void connect() throws SQLException;

    public void disconnect() throws SQLException;

    public List read() throws SQLException;

    public void insert(anggotahimasifgetset data) throws SQLException;

    public void update(anggotahimasifgetset data, String nim) throws SQLException;

    public void delete(String nim) throws SQLException;
    
    public void nim(String nim) throws SQLException;

}
