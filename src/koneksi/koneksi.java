/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package koneksi;

import com.mysql.jdbc.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Muhammad Fahmy
 */
public class koneksi {
    
    public String host="jdbc:mysql://localhost:3306/p2maba";
    public String user="root";
    public String pass="";
    public Connection conn;
    
    public koneksi(){
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public koneksi(Connection conn){
        this.conn=conn;
    }
    
}
