/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author isaluja1811
 */
public class Customersdet extends javax.swing.JFrame {

    /**
     * Creates new form Usersdet
     */
    public Customersdet() {
        initComponents();
        ShowJTable();
    }
    
    String str = null;
    String st = null;
    ArrayList<Customer> customerList;
    DefaultTableModel model;
    int c = 0;
    
    public Connection getConnection() {
        Connection con = null;
        
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/productsdb","root","");
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } 
    }
    
    public ArrayList<Customer> getCustomerList() {
        
            customerList = new ArrayList<Customer>();
            Connection con = getConnection();
            String query = "SELECT * FROM customer";
            
            Statement st;
            ResultSet rs;
            
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            Customer customer;
            
            while (rs.next()) {
                customer = new Customer(rs.getInt("ID"), rs.getString("Name"), rs.getString("Email"), rs.getString("Username"), rs.getString("Password"), rs.getFloat("Spent"));
                customerList.add(customer);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customerList;
    }
    
    public ArrayList<Customer> getCustomerList(String str) {
        
            customerList = new ArrayList<Customer>();
            Connection con = getConnection();
            String query = "SELECT * FROM customer WHERE id LIKE '%"+str+"%'";
            
            Statement st;
            ResultSet rs;
            
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            Customer customer;
            
            while (rs.next()) {
                customer = new Customer(rs.getInt("ID"), rs.getString("Name"), rs.getString("Email"), rs.getString("Username"), rs.getString("Password"), rs.getFloat("Spent"));
                customerList.add(customer);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customerList;
    }
    
    public ArrayList<Customer> getCustomerList(String s, int a) {
        
            customerList = new ArrayList<Customer>();
            Connection con = getConnection();
            String query = "SELECT * FROM customer WHERE name LIKE '%"+s+"%'";
            
            Statement st;
            ResultSet rs;
            
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            Customer customer;
            
            while (rs.next()) {
                customer = new Customer(rs.getInt("ID"), rs.getString("Name"), rs.getString("Email"), rs.getString("Username"), rs.getString("Password"), rs.getFloat("Spent"));
                customerList.add(customer);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customerList;
    }
    
    public ArrayList<Customer> getCustomerList(String str, String s, int a) {
        
            customerList = new ArrayList<Customer>();
            Connection con = getConnection();
            String query = "SELECT * FROM customer WHERE id LIKE '%"+str+"%' and name LIKE '%"+s+"%'";
            
            Statement st;
            ResultSet rs;
            
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            Customer customer;
            
            while (rs.next()) {
                customer = new Customer(rs.getInt("ID"), rs.getString("Name"), rs.getString("Email"), rs.getString("Username"), rs.getString("Password"), rs.getFloat("Spent"));
                customerList.add(customer);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customerList;
    }
    
    
    
    public void ShowJTable() {
        ArrayList<Customer> list = getCustomerList();
        model = (DefaultTableModel)JTable.getModel();
        
        model.setRowCount(0); //clear table
        Object[] row = new Object[5];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getUsername();
            row[3] = list.get(i).getEmail();
            row[4] = list.get(i).getSpent();
            
            model.addRow(row);
        }
    } 
    
    public void ShowJTable(int a) {
        ArrayList<Customer> list = getCustomerList();
        if (a%2==0)
        Collections.sort(customerList);
        else {
            Collections.sort(customerList, Collections.reverseOrder());
        }
        model = (DefaultTableModel)JTable.getModel();
        
        model.setRowCount(0); //clear table
        Object[] row = new Object[5];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getUsername();
            row[3] = list.get(i).getEmail();
            row[4] = list.get(i).getSpent();
            
            model.addRow(row);
        }
    } 
    
    public void ShowJTable(String str) {
        ArrayList<Customer> list = getCustomerList(str);
        model = (DefaultTableModel)JTable.getModel();
        
        model.setRowCount(0); //clear table
        Object[] row = new Object[5];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getUsername();
            row[3] = list.get(i).getEmail();
            row[4] = list.get(i).getSpent();
            
            model.addRow(row);
        }
    }
    
    public void ShowJTable(String s, int a) {
        ArrayList<Customer> list = getCustomerList(s, 0);
        model = (DefaultTableModel)JTable.getModel();
        
        model.setRowCount(0); //clear table
        Object[] row = new Object[5];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getUsername();
            row[3] = list.get(i).getEmail();
            row[4] = list.get(i).getSpent();
            
            model.addRow(row);
        }
    }
    
    public void ShowJTable(String str, String s, int a) {
        ArrayList<Customer> list = getCustomerList(str, s, 0);
        model = (DefaultTableModel)JTable.getModel();
        
        model.setRowCount(0); //clear table
        Object[] row = new Object[5];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getUsername();
            row[3] = list.get(i).getEmail();
            row[4] = list.get(i).getSpent();
            
            model.addRow(row);
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        Txt_search = new javax.swing.JTextField();
        Txt_search1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JTable.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        JTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Username", "Email", "Total Spent"
            }
        ));
        JTable.setRowHeight(60);
        JTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTable);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel1.setText("Search by ID:");

        Txt_search.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        Txt_search.setToolTipText("Search");
        Txt_search.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                Txt_searchInputMethodTextChanged(evt);
            }
        });
        Txt_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_searchActionPerformed(evt);
            }
        });
        Txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Txt_searchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Txt_searchKeyTyped(evt);
            }
        });

        Txt_search1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        Txt_search1.setToolTipText("Search");
        Txt_search1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                Txt_search1InputMethodTextChanged(evt);
            }
        });
        Txt_search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_search1ActionPerformed(evt);
            }
        });
        Txt_search1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Txt_search1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Txt_search1KeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel2.setText("Search by Name:");

        jButton1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jButton1.setText("Sort by Spent");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 926, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(Txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(Txt_search1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Txt_search1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_JTableMouseClicked

    private void Txt_searchInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_Txt_searchInputMethodTextChanged

    }//GEN-LAST:event_Txt_searchInputMethodTextChanged

    private void Txt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_searchActionPerformed

    }//GEN-LAST:event_Txt_searchActionPerformed

    private void Txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Txt_searchKeyReleased
        str = Txt_search.getText().trim();
        st = Txt_search1.getText().trim();
        if (str==null || str.length()==0) {
            if (st==null || st.length()==0)
            ShowJTable();
            else {
                ShowJTable(st,0);
            }
        }
        else {
            if (st==null || st.length()==0)
            ShowJTable(str);
            else {
                ShowJTable(str,st,0);
            }
        }
    }//GEN-LAST:event_Txt_searchKeyReleased

    private void Txt_searchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Txt_searchKeyTyped

    }//GEN-LAST:event_Txt_searchKeyTyped

    private void Txt_search1InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_Txt_search1InputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_search1InputMethodTextChanged

    private void Txt_search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_search1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_search1ActionPerformed

    private void Txt_search1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Txt_search1KeyReleased
        str = Txt_search.getText().trim();
        st = Txt_search1.getText().trim();
        if (st==null || st.length()==0) {
            if (str==null || str.length()==0)
            ShowJTable();
            else {
                ShowJTable(str);
            }
        }
        else {
            if (str==null || st.length()==0)
            ShowJTable(st,0);
            else {
                ShowJTable(str,st,0);
            }
        }
    }//GEN-LAST:event_Txt_search1KeyReleased

    private void Txt_search1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Txt_search1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_search1KeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        c++;
        ShowJTable(c);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Customersdet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customersdet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customersdet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customersdet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customersdet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTable;
    private javax.swing.JTextField Txt_search;
    private javax.swing.JTextField Txt_search1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
