/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author isaluja1811
 */
public class Cart extends javax.swing.JFrame {

    /**
     * Creates new form Cart
     */
    public Cart() {
        initComponents();
    }
    
    Customer c;
    
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
    
    public Cart(Customer cust) {
        this.c = cust;
        initComponents();
        ShowJTable();
    }
    float sum=0;
    DefaultTableModel model;
    
    public void ShowJTable() {
        ArrayList<Product> plist = c.getCartList();
        ArrayList<Integer> qlist = c.getQtyList();
        if (plist==null) {
            return;
        }
        model = (DefaultTableModel)JTable.getModel();
        
        model.setRowCount(0);
        Object[] row = new Object[5];
        for (int i=0;i<plist.size();i++) {
            row[0] = plist.get(i).getId();
            row[1] = plist.get(i).getName();
            row[2] = plist.get(i).getPrice();
            row[3] = qlist.get(i);
            float f = plist.get(i).getPrice();
            float r = qlist.get(i);
            row[4] = f*r;
            sum+=f*r;
            
            model.addRow(row);
        }
        Lbl_total.setText(Float.toString(sum));
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
        Btn_order = new javax.swing.JButton();
        Btn_back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Lbl_total = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Price", "Quantity", "Total"
            }
        ));
        JTable.setRowHeight(130);
        jScrollPane1.setViewportView(JTable);

        Btn_order.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        Btn_order.setText("Place Order");
        Btn_order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_orderActionPerformed(evt);
            }
        });

        Btn_back.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        Btn_back.setText("Go Back");
        Btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_backActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setText("Total:");

        Lbl_total.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        Lbl_total.setText("-");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 972, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(175, 175, 175)
                        .addComponent(Btn_order, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(249, 249, 249))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(Lbl_total, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lbl_total, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_order, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(106, Short.MAX_VALUE))
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

    private void Btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_backActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_Btn_backActionPerformed

    private void Btn_orderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_orderActionPerformed
        try {
            Connection con = getConnection();
            ArrayList <Product> plist = c.getCartList();
            ArrayList <Integer> qlist = c.getQtyList();
            int i;
            c.setSpent(c.getSpent() + sum);
            PreparedStatement pr = con.prepareStatement("UPDATE customer SET spent = ? WHERE id = ?");
            pr.setString(1, Float.toString(c.getSpent()));
            pr.setString(2, Integer.toString(c.getId()));
            pr.executeUpdate();
            PreparedStatement ps = con.prepareStatement("INSERT INTO orders(cid, oprice, odate)"
                    + "values(?, ?, ?) ");
            ps.setString(1, Integer.toString(c.getId()));
            ps.setString(2, Float.toString(sum));
            DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
            Calendar cal = Calendar.getInstance();
            String s = dateformat.format(cal.getTime());
            ps.setString(3, s);
            ps.executeUpdate();
            Statement st;
            ResultSet rs;
            
            int oid = 0;
            
            st = con.createStatement();
            rs = st.executeQuery("SELECT LAST_INSERT_ID()");
            
            if (rs.next()) {
                oid = rs.getInt(1);
            }
            
            
            for (i=0;i<plist.size();i++) {
                ps = con.prepareStatement("INSERT INTO transactions(orderid, customerid, productid, productname, productprice, productqty, amount, orderdate, producttype)"
                    + "values(?, ?, ?, ?, ?, ?, ?, ?, ?) ");
                ps.setString(1, Integer.toString(oid));
                ps.setString(2, Integer.toString(c.getId()));
                ps.setString(3, Integer.toString(plist.get(i).getId()));
                ps.setString(4, plist.get(i).getName());
                ps.setString(5, Float.toString(plist.get(i).getPrice()));
                ps.setString(6, Integer.toString(qlist.get(i)));
                float a = plist.get(i).getPrice()*qlist.get(i);
                ps.setString(7, Float.toString(a));
                ps.setString(8, s);
                ps.setString(9, plist.get(i).getType());
                plist.get(i).setQuantity(plist.get(i).getQuantity() - qlist.get(i));
                PreparedStatement pss = con.prepareStatement("UPDATE products SET Quantity = ? WHERE ID = ?");
                pss.setString(1, Integer.toString(plist.get(i).getQuantity()));
                pss.setString(2, Integer.toString(plist.get(i).getId()));
                ps.executeUpdate();
                pss.executeUpdate();
                
            }
            JOptionPane.showMessageDialog(null, "Order Placed Successfully");
            this.dispose();
            con.close();
            c.clearCart();
            ShowJTable();
        } catch (SQLException ex) {
            Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Btn_orderActionPerformed

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
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cart().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_back;
    private javax.swing.JButton Btn_order;
    private javax.swing.JTable JTable;
    private javax.swing.JLabel Lbl_total;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
