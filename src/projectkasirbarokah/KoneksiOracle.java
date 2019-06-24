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
            PreparedStatement a = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            return a.executeQuery();
        } catch (SQLException e){
            if(e.getLocalizedMessage().contains("unique")){
                JOptionPane.showMessageDialog(null, "Data yang ada di field tidak boleh sama dengan yang ada di database");
            } else {
                JOptionPane.showMessageDialog(null, "Error while processing SQL: " + e.getLocalizedMessage());
            }
        }
        return null;
    }

    /**
     *
     * @param sql - ISI QUERY SQL + dengan PREPARED STATEMENT DENGAN FIELD YANG BISA DI PASANG ? ? ? ? ?
     * @param isinya - ISI ARRAYED STRING, BIASANYA DIBERIKAN PADA PREPARED STATEMENT sebanyak Simbol tanda tanya yg diperlukan
     * @return - BENTUK RETURN VALUE BERUPA RESULTSET, ANDA MUNGKIN DIMINTA UNTUK TRY CATCH UNTUK STATEMENT INI
     */
    public ResultSet KoneksiOracleDBDenganIsi(String sql, String[] isinya){
        try{
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "projectbufar", "06740");
            PreparedStatement a = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            for (int i = 0; i <= isinya.length-1; i++){
                a.setString(i+1, isinya[i]);
            }
            return a.executeQuery();
        } catch (SQLException e){
            if(e.getLocalizedMessage().contains("unique")){
                JOptionPane.showMessageDialog(null, "Data yang ada di field tidak boleh sama dengan yang ada di database");
            } else {
                JOptionPane.showMessageDialog(null, "Error while processing SQL: " + e.getLocalizedMessage());
            }
        }
        return null;
    }
}
