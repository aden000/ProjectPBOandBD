/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectkasirbarokah;

import java.util.Scanner;
import java.sql.*;
import oracle.jdbc.driver.OracleDriver;

/**Oracle Thin
 *
 * @author user
 */
public class MenuUtama {

    Scanner cin = new Scanner(System.in);
    PilihBarang pb;
    ReviewBarang rb;
    BayarBarang byr;
    public void MenuUtama() throws ClassNotFoundException {
        try{
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ade_06740", "06740");
            System.out.println("Koneksi Berhasil!");    
        } catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println(" -- Toko Barokah -- ");
        System.out.println(" 1. Pilih Barang");
        System.out.println(" 2. Review Barang");
        System.out.println(" 3. Bayar");
        System.out.println(" 4. Keluar Program");
        System.out.print(" >");
        int a = cin.nextInt();
        if(a == 1){
            pb = new PilihBarang();
        } else if (a == 2){
            try{
                rb = new ReviewBarang(pb.getKeranjang());
                
                pb.setKeranjang(rb.getReviewBarang());
            } catch (NullPointerException e){
                System.out.println("Tidak ada data...");
            }
        } else if (a == 3){
            try{
                byr = new BayarBarang(pb.getKeranjang());
                if(byr.isSukses()){
                    pb.setKeranjang(null);
                }
            } catch (NullPointerException e){
                System.out.println("Tidak ada data...");
            }
        } else if (a == 4){
            System.exit(0);
        } else {
            System.out.println("Masukan hanya yang ada pada pilihan");
        }
        MenuUtama();
    }

}
