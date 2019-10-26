/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectkasirbarokah;

//import javax.swing.JOptionPane;

public class ProjectKasirBarokah {
    public static void main(String[] args) throws ClassNotFoundException {
        /*MenuUtama init = new MenuUtama();
        init.MenuUtama();*/
        System.out.println("PROGRAM STARTED UP IN " + java.time.LocalDate.now());
        if(new Koneksi().CheckUserExist()){
            GuiLogin gui = new GuiLogin();
            gui.ini();
        } 
    }
}
