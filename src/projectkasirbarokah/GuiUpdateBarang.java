/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectkasirbarokah;

import java.awt.event.ItemEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author user
 */
public class GuiUpdateBarang extends javax.swing.JFrame {

    /**
     * Creates new form GuiUpdateBarang
     */
    private GuiMenuUtama yolo;
    private ResultSet brngResultSet = new Koneksi().KoneksiMariaDB("SELECT * FROM BARANG ORDER BY ID_BARANG ASC");
    private ResultSet ktgrResultSet = new Koneksi().KoneksiMariaDB("SELECT * FROM KATEGORI ORDER BY ID_KATEGORI ASC");
    public GuiUpdateBarang(GuiMenuUtama yolo) {
        this.yolo = yolo;
        initComponents();
        setLocationRelativeTo(null);
        jTextField1.setEnabled(false);
        jTextField2.setEnabled(false);
        jComboBox2.setEnabled(false);
        jButton1.setEnabled(false);
        ArrayList<String> list = new ArrayList();
        ArrayList<String> list2 = new ArrayList();
        try{
            brngResultSet.beforeFirst();
            while(brngResultSet.next()){
                list.add(brngResultSet.getString(3));
            }
        } catch (SQLException e){
            System.err.println("ERROR: "+ e.getMessage());
        }
        try{
            while(ktgrResultSet.next()){
                list2.add(ktgrResultSet.getString(2));
            }
        } catch (SQLException e){
            System.err.println("ERROR: "+ e.getMessage());
        }
        jComboBox1.setModel(new DefaultComboBoxModel(list.toArray()));
        jComboBox2.setModel(new DefaultComboBoxModel(list2.toArray()));
        AutoCompletion.enable(jComboBox1);
        AutoCompletion.enable(jComboBox2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Kasir Toko Barokah - Ubah Data Barang");
        setLocationByPlatform(true);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Ubah Data Barang");

        jLabel2.setText("Cari Barang");

        jComboBox1.setEditable(true);
        jComboBox1.setFont(jComboBox1.getFont().deriveFont(jComboBox1.getFont().getStyle() & ~java.awt.Font.BOLD, jComboBox1.getFont().getSize()+6));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jLabel3.setText("Ubah Nama Barang disini:");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel4.setText("Ubah Harga Barang disini:");

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jButton1.setText("UBAH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox2.setEditable(true);
        jComboBox2.setFont(jComboBox2.getFont().deriveFont(jComboBox2.getFont().getStyle() & ~java.awt.Font.BOLD, jComboBox2.getFont().getSize()+6));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });

        jLabel5.setText("Ubah Kategori disini:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, 0, 380, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField1)
                    .addComponent(jTextField2)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.TRAILING, 0, 380, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange() == ItemEvent.SELECTED){
            int id_barang = jComboBox1.getSelectedIndex();
            System.out.println("id_barang : " + id_barang);
            String nmString = "";
            String hrgString = "";
            try{
                brngResultSet.beforeFirst();
                while(brngResultSet.next()){
                    if(id_barang+1 == brngResultSet.getInt(1)){
                        //System.out.println("found it!");
                        jComboBox2.setSelectedIndex(brngResultSet.getInt(2)-1);
                        nmString = brngResultSet.getString(3);
                        hrgString = brngResultSet.getString(4);
                    }
                }
            } catch (SQLException e){
                System.out.println("Error: "+e.getMessage());
            }
            jTextField1.setText(nmString);
            jTextField2.setText(hrgString);
            jTextField1.setEnabled(true);
            jTextField2.setEnabled(true);
            jComboBox2.setEnabled(true);
            jButton1.setEnabled(true);
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String[] isi = {
            String.valueOf(jComboBox2.getSelectedIndex()+1),
            jTextField1.getText(),
            jTextField2.getText()
        };
        this.setEnabled(false);
        System.out.println("id_barang = " + (jComboBox1.getSelectedIndex()+1));
        int pil = JOptionPane.showConfirmDialog(null, "Anda Yakin ingin mengubah? data ini?", "Ubah?", JOptionPane.YES_NO_OPTION);
        if(pil == JOptionPane.YES_OPTION){
            new Koneksi().KoneksiMariaDBDenganIsi("UPDATE barang SET id_kategori = ?, nama_barang = ?, harga_barang = ? WHERE id_barang = " + (jComboBox1.getSelectedIndex()+1), isi);
            try {
                /*try{
                brngResultSet.moveToInsertRow();
                brngResultSet.absolute(jComboBox1.getSelectedIndex()+1);
                brngResultSet.updateString(2, isi[0]);
                brngResultSet.updateInt(3, Integer.valueOf(isi[1]));
                brngResultSet.updateRow();
                } catch (SQLException e){
                System.err.println("Error: " + e.getMessage());
                }*/
                brngResultSet.close();
            } catch (SQLException ex) {
                Logger.getLogger(GuiUpdateBarang.class.getName()).log(Level.SEVERE, null, ex);
            }
            yolo.updateTableBarang();
            this.setVisible(false);
        } else if (pil == JOptionPane.NO_OPTION){
            this.setEnabled(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    /**
     * @param args the command line arguments
     */
    public void showUpdateBarang(GuiMenuUtama yolo) {
        /* Set the Nimbus look and feel */
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e){
            e.printStackTrace();
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new GuiUpdateBarang(yolo).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
