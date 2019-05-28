/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectkasirbarokah;


/**
 *
 * @author user
 */
public class Barang {
    private final String[][] daftarbarang = {
        /* Sembako */
        {"Mi Sedap", "2500"},
        {"Indomie", "2500"},
        {"Mi Burung Dara", "2000"},
        {"Gula 1 KG", "17000"},
        {"Kopi ABC Sachet", "2000"},
        {"Garam 1 Sachet", "2000"},
        {"Royco", "1500"},
        {"Sajiku Krispi", "7000"},
        {"Sajiku Biasa", "5000"},
        {"Mi Gelas", "1000"},
        
        /* Obat & Kebutuhan Kesehatan*/
        {"Oskadon", "3500"},
        {"Paramex", "3500"},
        {"Minyak GPU", "7000"},
        {"Minyak Tawon", "9000"},
        {"Minyak Kayu Putih", "2000"},
        
        /* Rokok dan Sebangsanya */
        {"Surya 12 1 Pack", "13000"},
        {"LA 1 Pack", "25000"},
        {"Black 1 Pack", "27000"},
        {"Sampoerna 1 Pack", "15000"},
        
        /* Jajan kecil kecilan */
        {"Permen 3 Biji", "500"},
        {"Richeese Mini", "500"},
        {"Regal", "1000"},
        
        /* Buku dan sebagainya */
        {"Kertas Kado", "3000"},
        {"Plastik Parcel", "2500"},
        {"Sampul Coklat", "500"},
        
    };
   
    
    public String[][] getDaftarBarang(){
        return daftarbarang;
    }
    
    public int getBanyakBarang(){
        return daftarbarang.length;
    }
}

