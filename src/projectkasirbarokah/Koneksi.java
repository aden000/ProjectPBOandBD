/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectkasirbarokah;

import java.awt.BorderLayout;
import java.sql.*;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author user
 */
public class Koneksi {
    private final String userdb = "projectbufar";
    private final String passdb = "06740";
    public ResultSet KoneksiOracleDB(String sql){
        try{
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", userdb, passdb);
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
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", userdb, passdb);
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
    
    public ResultSet KoneksiMariaDB(String sql){
        try{
            Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/pkb?user=root");
            PreparedStatement a = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            return a.executeQuery();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public ResultSet KoneksiMariaDBDenganIsi(String sql, String[] isinya){
       try{
            Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/pkb?user=root");
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
    
    public boolean CheckUserExist(){
        try{
            Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/pkb?user=root");
            if(conn.isValid(10)){
                System.out.println("Koneksi Valid, Program dijalankan");
                return true;
            } else {
                int check = JOptionPane.showConfirmDialog(null, "Koneksi gagal, apakah anda ingin reconnect?", "Konfirmasi", JOptionPane.OK_CANCEL_OPTION);
                if(check == JOptionPane.OK_OPTION){
                    new Koneksi().CheckUserExist();
                    return false;
                } else if(check == JOptionPane.CANCEL_OPTION){
                    return false;
                }
            }
        } catch (SQLException e){
            if(e.getMessage().contains("refused")){
                System.err.println("Koneksi ditolak, anda mungkin belum menjalankan service MariaDB anda...");
                JOptionPane.showMessageDialog(null, "Koneksi ditolak, tolong jalankan service MariaDB anda terlebih dahulu!");
            } else if (e.getMessage().contains("Unknown database")){
                System.err.println("Koneksi ditolak, sepertinya anda menjalankan program pertama kali");
                JOptionPane.showMessageDialog(null, "Koneksi belum ada, Program ini akan menuntun anda untuk menyiapkan database untuk\nKasir Toko Barokah");
                try{
                    Connection konek = DriverManager.getConnection("jdbc:mariadb://localhost:3306/mysql?user=root");
                    if(konek.isValid(10)){
                        JOptionPane.showMessageDialog(null, "Setelah ini, anda akan dibuatkan database bernama \"PKB\" (Project Kasir Barokah)");
                        CreateUserDB(konek);
                        //konek.close();
                    }

                    final JDialog loading = new JDialog();
                    JPanel p1 = new JPanel(new BorderLayout());
                    p1.add(new JLabel("Mohon Tunggu Sebentar\nSelagi program memproses database"), BorderLayout.CENTER);
                    loading.setUndecorated(true);
                    loading.getContentPane().add(p1);
                    loading.pack();
                    loading.setLocationRelativeTo(null);
                    loading.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                    loading.setModal(true);

                    SwingWorker<Void, Void> sw = new SwingWorker<Void, Void>() {
                        @Override
                        protected Void doInBackground() throws Exception {
                            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            Connection knk = DriverManager.getConnection("jdbc:mariadb://localhost:3306/mysql?user=root");
                            if(knk.isValid(10)){
                                try{
                                    CreateTableDB(knk);
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }

                            }
                            return null;
                        }
                        @Override
                        protected void done(){
                            loading.dispose();
                            CreateAdmin();
                        }
                    };
                    sw.execute();
                    loading.setVisible(true);
                    return false;
                } catch (SQLException err){
                    if(err.getMessage().contains("invalid username")){
                        JOptionPane.showMessageDialog(null, "Program dibatalkan, password salah");
                        return false;
                    } else {
                        System.err.println("ERROR: " + err.getMessage());
                        return false;
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Error while connecting DB: " + e.getMessage());
            return false;
        }
        return false;
    }
    
    private void CreateUserDB(Connection konek){
        try{
            konek.setAutoCommit(false);
            Statement call = konek.createStatement();
            call.execute("CREATE DATABASE PKB");
            konek.commit();
            konek.setAutoCommit(true);
        } catch (SQLException e){
            e.printStackTrace();
            System.exit(0);
        }
    }
    private void CreateTableDB(Connection konek) throws SQLException{
        konek.setAutoCommit(false);
        Statement call = konek.createStatement();
        call.addBatch("USE PKB");
        call.addBatch("CREATE TABLE BARANG("
                + "id_barang integer not null,"
                + "nama_barang varchar(50),"
                + "harga_barang integer,"
                + "constraint PK_BARANG primary key (id_barang))");
        System.out.println("Executed Table Barang");
        call.addBatch("CREATE TABLE PENJAGA("
                + "id_penjaga integer not null,"
                + "nama_penjaga varchar(30),"
                + "tanggal_masuk date,"
                + "tanggal_keluar date,"
                + "username varchar(16),"
                + "password varchar(16),"
                + "constraint PK_PENJAGA primary key (id_penjaga))");
        System.out.println("Executed Table Penjaga");
        call.addBatch("CREATE TABLE TRANSAKSI("
                + "id_transaksi integer,"
                + "id_penjaga integer,"
                + "id_barang integer,"
                + "tanggal_transaksi date,"
                + "total_transaksi integer,"
                + "bayar integer,"
                + "kembalian integer,"
                + "constraint FK_PENJAGA foreign key (id_penjaga)"
                + " references penjaga (id_penjaga),"
                + "constraint FK_BARANG foreign key (id_barang)"
                + " references barang (id_barang))");
        System.out.println("Executed Table Transaksi");
        int[] checkedbatch = call.executeBatch();
        System.out.println("Status : " + checkedbatch.toString());
        konek.commit();
        konek.setAutoCommit(true);
    }
    private void CreateAdmin(){
        JOptionPane.showMessageDialog(null, "Pembuatan tabel selesai, Anda akan memasukan nama admin dan password admin\nanda bisa mengubah username atau password admin pada program utama");
        SwingWorker<Void, Void> sw = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                GuiTambahPegawai gtp = new GuiTambahPegawai(null);
                gtp.setVisible(true);
                return null;
            }
        };
        sw.execute();
        
    }
}
