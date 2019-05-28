/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectkasirbarokah;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class KoneksiOracle {
    public ResultSet KoneksiOracleDB(String sql){
        try{
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "projectbufar", "06740");
            PreparedStatement a = conn.prepareStatement(sql);
            return a.executeQuery();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error while processing SQL: " + e.getMessage());
        }
        return null;
    }
    public ResultSet KoneksiOracleDBDenganIsi(String sql, String[] isinya){
        try{
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "projectbufar", "06740");
            PreparedStatement a = conn.prepareStatement(sql);
            for (int i = 0; i <= isinya.length-1; i++){
                a.setString(i+1, isinya[i]);
            }
            return a.executeQuery();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error while processing SQL: " + e.getMessage());
        }
        return null;
    }
}
