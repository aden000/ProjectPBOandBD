/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectkasirbarokah;

import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author user
 */
public class GuiMenuUtama extends javax.swing.JFrame {

    /**
     * Creates new form GuiMenuUtama
     * @param id_penjaga
     */
    private int id_penjaga;
    private ResultSet brngResultSet = new KoneksiOracle().KoneksiOracleDB("SELECT * FROM BARANG ORDER BY id_barang ASC");
    private ResultSet pnjgResultSet = new KoneksiOracle().KoneksiOracleDB("SELECT * FROM PENJAGA ORDER BY id_penjaga ASC");
    private TableColumn tc;
    
    private DefaultTableModel krjgTableModel;
    //private int id_penjaga;
    //private static Object obj = new Object();
    public GuiMenuUtama(int id_penjaga) {
        initComponents();
        this.id_penjaga = id_penjaga;
        ResultSet executedQuery = new KoneksiOracle().KoneksiOracleDB("select nama_penjaga from penjaga where id_penjaga=" + id_penjaga);
        ResultSet namaBarangResultSet = new KoneksiOracle().KoneksiOracleDB("SELECT nama_barang FROM barang ORDER BY id_barang ASC");
        krjgTableModel = new DefaultTableModel();
        krjgTableModel.setColumnIdentifiers(new Object[]{
            "ID Barang",
            "Nama Barang",
            "Jumlah",
            "Harga Total"
        });
        jTable1.setEnabled(false);
        jTable2.setEnabled(false);
        try{
            while(executedQuery.next()){
                //System.out.println("String: " + executedQuery.getString(1));
                jLabel2.setText(jLabel2.getText() +  " " + executedQuery.getString(1));
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "You got Error: " + e.getMessage());
        }
        if(id_penjaga == 1){
            //jTabbedPane1.setSelectedIndex(1);
            jTabbedPane1.setEnabledAt(0, false);
            jTabbedPane1.setSelectedIndex(1);
            jTable1.setModel(DbUtils.resultSetToTableModel(brngResultSet));
            jTable2.setModel(DbUtils.resultSetToTableModel(pnjgResultSet));
            jTable1.setEnabled(false);
            jTable2.setEnabled(false);
            jTable1.setDragEnabled(false);
            jTable2.setDragEnabled(false);
            try {
                pnjgResultSet.beforeFirst();
            } catch (SQLException ex) {
                Logger.getLogger(GuiMenuUtama.class.getName()).log(Level.SEVERE, null, ex);
            }
            tc = jTable2.getColumnModel().getColumn(jTable2.getColumnCount()-1);
            jTable2.removeColumn(jTable2.getColumnModel().getColumn(jTable2.getColumnCount()-1));
            setTitle("Kasir Toko Barokah - [Administrator Access]");
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        } else {
            jFormattedTextField1.setColumns(3);
            jLabel1.setText(jLabel1.getText() + " " + java.time.LocalDateTime.now());
            jFormattedTextField1.setEditable(false);
            ArrayList<String> ars = new ArrayList();
            try{
                while(namaBarangResultSet.next()){
                    ars.add(namaBarangResultSet.getString(1));
                }
            } catch (SQLException e){
                JOptionPane.showMessageDialog(null, "You got Error: " + e.getMessage());
            }
            jComboBox1.setModel(new DefaultComboBoxModel(ars.toArray()));
            jComboBox1.setLightWeightPopupEnabled(true);
            /**
             * Source Code berasal dari
             * http://www.orbital-computer.de/JComboBox/
             */
            AutoCompletion.enable(jComboBox1);
            jTable3.setModel(krjgTableModel);
            jTable3.setColumnSelectionAllowed(false);
            jTable3.setCellSelectionEnabled(false);
            jTable3.setRowSelectionAllowed(true);
            jTabbedPane1.setEnabledAt(1, false);
            jTabbedPane1.setEnabledAt(2, false);
            jButton8.setEnabled(false);
            jButton9.setEnabled(false);
            setTitle("Kasir Toko Barokah - " + jLabel2.getText());
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
        try{
            brngResultSet.close();
            pnjgResultSet.close();
            executedQuery.close();
            namaBarangResultSet.close();
        }catch (SQLException e){
            System.err.println("Error: "+e.getMessage());
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("jdbc:oracle:thin:@localhost:1521:XEPU").createEntityManager();
        barang_1Query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT b FROM Barang_1 b");
        barang_1List = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : barang_1Query.getResultList();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        NumberFormat format = NumberFormat.getIntegerInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(1);
        formatter.setMaximum(99);
        formatter.setAllowsInvalid(false);
        // If you want the value to be committed on each keystroke instead of focus lost
        formatter.setCommitsOnValidEdit(true);
        jFormattedTextField1 = new javax.swing.JFormattedTextField(formatter);
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setText("Tanggal Operasi:");

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Barang", "Nama Barang", "Jumlah", "Harga"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable3.setColumnSelectionAllowed(true);
        jTable3.getTableHeader().setReorderingAllowed(false);
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);
        jTable3.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jLabel3.setText("Nama Barang");

        jComboBox1.setEditable(true);
        jComboBox1.setFont(jComboBox1.getFont().deriveFont(jComboBox1.getFont().getStyle() & ~java.awt.Font.BOLD, jComboBox1.getFont().getSize()+6));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jLabel4.setText("Harga Satuan");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Rp.");

        jLabel6.setText("Jumlah");

        jLabel7.setText("Harga Total");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Rp.");

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Action"));

        jButton7.setText("Tambahkan ke Keranjang");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Hapus baris terpilih");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(255, 102, 51));
        jButton9.setText("Bayar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jFormattedTextField1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jFormattedTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFormattedTextField1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(163, 163, 163))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jFormattedTextField1)
                                        .addGap(13, 13, 13)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel5)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(132, 132, 132)
                                .addComponent(jLabel4))
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel8))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextField1))))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Kasir Utama", jPanel1);

        jTable1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Tambah Barang");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setText("Ubah Barang");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Olah Data Barang", jPanel2);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable2);

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton5.setText("Tambah Pegawai");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton6.setText("Ubah Info Pegawai");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Tampilkan Password");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Olah Data Penjaga", jPanel3);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Penjaga:");

        jButton1.setText("Log out");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void updateTableBarang(){
        //brngResultSet.refreshRow();
        brngResultSet = new KoneksiOracle().KoneksiOracleDB("SELECT * FROM BARANG ORDER BY ID_BARANG ASC");
        jTable1.setModel(DbUtils.resultSetToTableModel(brngResultSet));
        try {
            brngResultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(GuiMenuUtama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateTablePenjaga(){
        //pnjgResultSet.updateRow();
        pnjgResultSet = new KoneksiOracle().KoneksiOracleDB("SELECT * FROM PENJAGA ORDER BY ID_PENJAGA ASC");
        jTable2.setModel(DbUtils.resultSetToTableModel(pnjgResultSet));
        if(jCheckBox1.isSelected() == false){
            jTable2.removeColumn(jTable2.getColumnModel().getColumn(jTable2.getColumnCount()-1));
        }
        try {
            pnjgResultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(GuiMenuUtama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        GuiLogin guiLogin = new GuiLogin();
        guiLogin.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        GuiTambahBarang tb = new GuiTambahBarang(this);
        tb.showTambahBarang(this);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        GuiTambahPegawai tp = new GuiTambahPegawai(this);
        tp.showTambahPegawai(this);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        GuiUpdatePegawai up = new GuiUpdatePegawai(this);
        up.showUpdatePegawai(this);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange() == ItemEvent.SELECTED){
            if(jFormattedTextField1.isEditable()== false){
                jFormattedTextField1.setEditable(true);
            }
            int id_barang = jComboBox1.getSelectedIndex();
            //System.out.println("id_barang : " + id_barang);
            String lblhrString = "";
            brngResultSet = new KoneksiOracle().KoneksiOracleDB("SELECT * FROM BARANG ORDER BY ID_BARANG ASC");
            try{
                while(brngResultSet.next()){
                    if(id_barang+1 == brngResultSet.getInt(1)){
                        //System.out.println("found it!");
                        lblhrString = brngResultSet.getString(3);
                    }
                }
                brngResultSet.close();
            } catch (SQLException e){
                System.out.println("Error: "+e.getMessage());
            }
            jLabel5.setText("Rp."+lblhrString);
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        GuiUpdateBarang gub = new GuiUpdateBarang(this);
        gub.showUpdateBarang(this);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange() == ItemEvent.SELECTED){
            jTable2.addColumn(tc);
        } else {
            jTable2.removeColumn(jTable2.getColumnModel().getColumn(jTable2.getColumnCount()-1));
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try{
            Object row[] = new Object[]{
                jComboBox1.getSelectedIndex()+1,
                jComboBox1.getSelectedItem(),
                Integer.valueOf(jFormattedTextField1.getText()),
                jLabel8.getText().substring(3)
            };
            krjgTableModel.addRow(row);
            jComboBox1.setSelectedIndex(0);
            jFormattedTextField1.setValue(null);
            jFormattedTextField1.setEditable(false);
            jLabel5.setText("Rp.");
            jLabel8.setText("Rp.");
            if(krjgTableModel.getRowCount() > 0){
                jButton9.setEnabled(true);
                int harga = 0;
                for(int i = 0; i < krjgTableModel.getRowCount(); i++){
                    harga = harga + Integer.parseInt(String.valueOf(krjgTableModel.getValueAt(i, 3)));
                }
                jButton9.setText("Bayar: Rp." + harga);
            }
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Pastikan data di dalam Kolom nama barang dan jumlah barang benar");
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
        if(jTable3.isRowSelected(jTable3.getSelectedRow()) == true){
            jButton8.setEnabled(true);
        } else {
            jButton8.setEnabled(false);
        }
    }//GEN-LAST:event_jTable3MouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        int check = JOptionPane.showConfirmDialog(null, "Anda yakin untuk menghapus yang dipilih?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if(check == JOptionPane.YES_OPTION){
            krjgTableModel.removeRow(jTable3.getSelectedRow());
            jButton8.setEnabled(false);
            if(krjgTableModel.getRowCount() < 1){
                jButton9.setText("Bayar");
                jButton9.setEnabled(false);
            } else if(krjgTableModel.getRowCount() > 0){
                //jButton9.setEnabled(true);
                int harga = 0;
                for(int i = 0; i < krjgTableModel.getRowCount(); i++){
                    harga = harga + Integer.parseInt(String.valueOf(krjgTableModel.getValueAt(i, 3)));
                }
                jButton9.setText("Bayar: Rp." + harga);
            }
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        int bayar = Integer.parseInt(jButton9.getText().substring(10));
        int uang = 0, kembalian = 0;
        boolean check = true;
        boolean terbayar = false;
        while(check){
            try{
                uang = Integer.parseInt(JOptionPane.showInputDialog(null, "Masukan uang:"));                
            } catch (NumberFormatException e){
                check = false;
            }
            /**
             * Proses Uang
             */
            if(uang > bayar){
                kembalian = uang - bayar;
                JOptionPane.showMessageDialog(null, "Kembalian:\nRp." + kembalian + "\nSilahkan mengambil kembalian", "Kembalian", JOptionPane.INFORMATION_MESSAGE);
                check = false;
                terbayar = true;
            } else if(uang == bayar){
                JOptionPane.showMessageDialog(null, "Uangnya Pas\n", "Info", JOptionPane.INFORMATION_MESSAGE);
                check = false;
                terbayar = true;
            } else if(uang == 0){
                check = false;
            } else {
                JOptionPane.showMessageDialog(null, "Uang yang dimasukan Kurang!", "Kurang!", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(check == false && terbayar){
            if(krjgTableModel.getRowCount() > 0){
                int id_transaksi = 0;
                ResultSet idtr = new KoneksiOracle().KoneksiOracleDB("Select id_transaksi from transaksi order by id_transaksi asc");
                try{
                    while(idtr.next()){
                        id_transaksi = idtr.getInt(1);
                    }
                    idtr.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
                for(int i = krjgTableModel.getRowCount(); i > 0; i--){
                    String[] isi = {
                        String.valueOf(id_penjaga),
                        String.valueOf(krjgTableModel.getValueAt(krjgTableModel.getRowCount()-1, 0)),
                        String.valueOf(krjgTableModel.getValueAt(krjgTableModel.getRowCount()-1, 3)),
                        String.valueOf(uang),
                        String.valueOf(kembalian)
                    };

                    new KoneksiOracle().KoneksiOracleDBDenganIsi("INSERT INTO TRANSAKSI VALUES (" + (id_transaksi+1) + ", ?, ?, (select sysdate from dual), ?, ?, ?)", isi);
                    krjgTableModel.removeRow(krjgTableModel.getRowCount()-1);
                }
            }
            jButton9.setText("Bayar");
            jButton9.setEnabled(false);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jFormattedTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextField1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getKeyCode() == KeyEvent.VK_DELETE){
            getToolkit().beep();
            jFormattedTextField1.setValue(null);
            jLabel8.setText("Rp.");
        } else {
            //JOptionPane.showMessageDialog(null,"\""+ jFormattedTextField1.getValue() + "\"");
            try{
                if(jFormattedTextField1.getValue()==null){
                    if(evt.getKeyChar() != '0'){
                        jLabel8.setText("Rp."+ (Integer.valueOf(String.valueOf(evt.getKeyChar())) * Integer.valueOf(jLabel5.getText().substring(3))));
                    } else {
                        JOptionPane.showMessageDialog(null, "Barang Tidak boleh 0!");
                        jFormattedTextField1.setValue(null);
                    }
                } else {
                    if(String.valueOf(jFormattedTextField1.getValue()).concat(String.valueOf(evt.getKeyChar())).length() < 3){
                        jLabel8.setText("Rp."+ (Integer.valueOf(String.valueOf(jFormattedTextField1.getValue())+String.valueOf(evt.getKeyChar())) * Integer.valueOf(jLabel5.getText().substring(3))));
                    } else {
                        getToolkit().beep();
                    }
                }
            } catch (NumberFormatException e){
                getToolkit().beep();
            }
        }
    }//GEN-LAST:event_jFormattedTextField1KeyPressed
    
    
    /**
     * @param id_penjaga
     */
    public void MenuUtama(int id_penjaga) {
        /* Set the Nimbus look and feel */
        System.out.println("Accessed : " + id_penjaga);
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e){
            e.printStackTrace();
        }
        
        /* Create and display the form */

        java.awt.EventQueue.invokeLater(() -> {
            new GuiMenuUtama(id_penjaga).setVisible(true);  
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.util.List<projectkasirbarokah.Barang_1> barang_1List;
    private javax.persistence.Query barang_1Query;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}
