/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.List;
import model.logingetset;

/**
 *
 * @author Muhammad Fahmy
 */
public interface logininterface {

    public void connect() throws SQLException;

    public void disconnect() throws SQLException;

    public logingetset check(String nama) throws SQLException;
}
