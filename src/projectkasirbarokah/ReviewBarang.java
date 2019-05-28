/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectkasirbarokah;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class ReviewBarang extends Barang{

    private ArrayList<Keranjang> krjg;
    Scanner in = new Scanner(System.in);
    public ReviewBarang(ArrayList<Keranjang> krjg) {
        
        if(krjg.isEmpty()){
            System.out.println("Tidak ada data");
            return;
        }
        this.krjg = krjg;
        boolean check = true;
        do{
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
            System.out.println("1. Edit Keranjang");
            System.out.println("2. Kosongkan Keranjang");
            System.out.println("3. Keluar Menu");
            System.out.print(">");
            int input = in.nextInt();
            if(input == 3){
                check = false;
            } else if(input == 1){
                EditKeranjang();
            } else if(input == 2){
                this.krjg.clear();
                check = false;
            }
        } while(check);
        
    }    
    
    public ArrayList<Keranjang> getReviewBarang(){
        return this.krjg;
    }
    
    private void EditKeranjang(){
        for(int i = 0; i < krjg.size(); i++){
            System.out.println(i+1 + ". " + getDaftarBarang()[krjg.get(i).getId()][0] + " - " + getDaftarBarang()[krjg.get(i).getId()][1]);
        }
        System.out.println("Masukan angka yang ingin di delete");
        int input;
        boolean check = true;
        while(check){
            try{
                input = in.nextInt();
                krjg.remove(input-1);
                check = false;
            } catch (InputMismatchException e){
                System.out.println("Silahkan Masukan Angka saja");
            } catch (NullPointerException e){
                System.out.println("Barang telah kosong");
                check = false;
            }
        }
        
    }
}
