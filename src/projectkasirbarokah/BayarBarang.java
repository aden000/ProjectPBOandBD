/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectkasirbarokah;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class BayarBarang extends Barang{

    ArrayList<Keranjang> kjg;
    private boolean sukses = false;

    public boolean isSukses() {
        return sukses;
    }
    
    Scanner cin = new Scanner(System.in);
    public BayarBarang(ArrayList<Keranjang> krjg) {
        long total = 0;
        System.out.println("Keranjang: \t------------------------------");
        for(int i = 0; i < krjg.size(); i++){
            System.out.println( String.format("%s. %-20s \t%-6s - %s Pcs \t%s",
                    String.valueOf(i+1),
                    getDaftarBarang()[krjg.get(i).getId()][0],
                    getDaftarBarang()[krjg.get(i).getId()][1],
                    krjg.get(i).getBanyak(),
                    String.valueOf(Integer.parseInt(getDaftarBarang()[krjg.get(i).getId()][1]) * krjg.get(i).getBanyak())
            ));
            total += Integer.valueOf(getDaftarBarang()[krjg.get(i).getId()][1]) * krjg.get(i).getBanyak();
        }
        System.out.println("------------------------------\t TOTAL: " + total);
        System.out.println("1. Lanjutkan pembayaran");
        System.out.println("2. Batal dan Edit kembali");
        System.out.println("3. Batalkan pembayaran");
        boolean check = true;
        while(check){
            System.out.print(">");
            int pil = cin.nextInt();
            if(pil == 1){
                System.out.print("Masukan Uang: "); long bayar = cin.nextLong();
                if(total > bayar){
                    System.out.println("Uang yang dibayarkan kurang!");
                } else if (bayar >= total){
                    System.out.println("Transaksi Berhasil");
                    if(bayar > total){
                        long kembalian = bayar - total;
                        System.out.println("Kembalian : " + kembalian);
                    }
                    System.out.println("Terima kasih telah berbisnis!");
                    sukses = true;
                    check = false;
                }
            } else if (pil == 2){
                System.out.println("Membatalkan, Silahkan Edit kembali barang belanjaan anda");
                check = false;
            } else if (pil == 3){
                System.out.println("Anda Membatalkan pembayaran");
                sukses = true;
                check = false;
            } else {
                System.out.println("Masukan hanya pada inputan!");
            }
        }
    }
}
