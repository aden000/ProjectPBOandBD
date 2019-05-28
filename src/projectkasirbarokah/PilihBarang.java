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


public class PilihBarang extends Barang{

    Scanner cin = new Scanner(System.in);
    
    private ArrayList<Keranjang> keranjang = new ArrayList();
    public PilihBarang() {
        System.out.println(" -- Toko Barokah -- ");
        System.out.println("Daftar Barang        \t\tHarga: ");
        for (int i = 0; i < getBanyakBarang(); i++) {
            System.out.println( String.format("%s. %-20s \t%-6s",String.valueOf(i+1), getDaftarBarang()[i][0], getDaftarBarang()[i][1]));
        }
        int pil;
        
        boolean checked1 = false;
        do{
            boolean checked2 = false;
            while(!checked2){
                try{
                    System.out.print("Barang Pilihan?: ");
                    pil = cin.nextInt();
                    if(pil > getBanyakBarang() || pil < 1){
                        System.out.println("Barang itu tidak ada");
                    } else {
                        System.out.println("Masukan Banyak barang: ");
                        int banyak = cin.nextInt();
                        System.out.println(String.format("%s. %-20s \t%-6s - %s Pcs",String.valueOf(pil), getDaftarBarang()[pil-1][0], getDaftarBarang()[pil-1][1], String.valueOf(banyak)));
                        keranjang.add(new Keranjang(pil-1, banyak));
                        checked2 = true;
                    }
                } catch (InputMismatchException e){
                    System.out.println("Mohon maaf, masukan hanya angka pada pilihan");
                    cin.nextLine();
                } 
            }
            System.out.print("Ada lagi? (tekan 1 untuk ya) : ");
            int a = 0;
            checked2 = false;
            while(!checked2){
                try{
                    a = cin.nextInt();
                    checked2 = true;
                } catch (InputMismatchException e){
                    System.out.println("Mohon maaf, masukan hanya angka");
                    cin.nextLine();
                }
            }
            if(a != 1){
                checked1 = true;
            }
        } while (!checked1);
    }
    
    public ArrayList<Keranjang> getKeranjang(){
        return keranjang;
    }
    
    public void setKeranjang(ArrayList<Keranjang> a){
        this.keranjang = a;
    }
    
}
