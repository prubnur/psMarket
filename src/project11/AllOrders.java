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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author isaluja1811
 */
public class AllOrders extends javax.swing.JFrame {

    /**
     * Creates new form MyOrders
     */
    public AllOrders() {
        initComponents();
        ShowJTable();
        spentlabel();
    }
    
    public void spentlabel() {
        try {
            Connection con = getConnection();
            String query = "SELECT * FROM customer";
            
            Statement st=null;
            ResultSet rs=null;
            
            float sum = 0;
            
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
            //    Lbl_tspent.setText(rs.getString("spent"));
                sum+=rs.getFloat("spent");
            }
            Lbl_tspent.setText(Float.toString(sum));
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AllOrders.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    Customer cust;
    String sm = "Filter by Month";
    String sy = "Filter by Year";
    
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
    
    public ArrayList<Order> getOrderList() {
        
        ArrayList<Order> orderList = new ArrayList<Order>();
        Connection con = getConnection();
        String query = "SELECT * FROM orders";
          
        Statement st = null;
        ResultSet rs = null;
            
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            Order order;
            
            while (rs.next()) {
                order = new Order(rs.getInt("oid"), rs.getInt("cid"), Float.parseFloat(rs.getString("oprice")), rs.getString("odate"));
                orderList.add(order);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        try {
            st.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        try {
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return orderList;
    }
    
    public ArrayList<Order> getOrderList(String sm) {
        
        ArrayList<Order> orderList = new ArrayList<Order>();
        Connection con = getConnection();
        String query = "SELECT * FROM orders WHERE odate like '%/"+sm+"/%' ";
          
        Statement st = null;
        ResultSet rs = null;
            
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            Order order;
            
            while (rs.next()) {
                order = new Order(rs.getInt("oid"), rs.getInt("cid"), Float.parseFloat(rs.getString("oprice")), rs.getString("odate"));
                orderList.add(order);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        try {
            st.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        try {
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return orderList;
    }
    
    public ArrayList<Order> getOrderList(String sy, int a) {
        
        ArrayList<Order> orderList = new ArrayList<Order>();
        Connection con = getConnection();
        String query = "SELECT * FROM orders WHERE odate like '%/"+sy+"' ";
          
        Statement st = null;
        ResultSet rs = null;
            
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            Order order;
            
            while (rs.next()) {
                order = new Order(rs.getInt("oid"), rs.getInt("cid"), Float.parseFloat(rs.getString("oprice")), rs.getString("odate"));
                orderList.add(order);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        try {
            st.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        try {
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return orderList;
    }
    
    public ArrayList<Order> getOrderList(String sm, String sy) {
        
        ArrayList<Order> orderList = new ArrayList<Order>();
        Connection con = getConnection();
        String query = "SELECT * FROM orders WHERE odate like '%/"+sm+"/%' and odate like '%/"+sy+"' ";
          
        Statement st = null;
        ResultSet rs = null;
            
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            Order order;
            
            while (rs.next()) {
                order = new Order(rs.getInt("oid"), rs.getInt("cid"), Float.parseFloat(rs.getString("oprice")), rs.getString("odate"));
                orderList.add(order);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        try {
            st.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        try {
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return orderList;
    }
    
    public void ShowJTable() {
        ArrayList<Order> list = getOrderList();
        DefaultTableModel model = (DefaultTableModel)JTable.getModel();
        
        model.setRowCount(0); //clear table
        Object[] row = new Object[4];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[2] = list.get(i).getTotal();
            row[3] = list.get(i).getDate();
            row[1] = list.get(i).getCustomerId();
            model.addRow(row);
        }
    }
    
    public void ShowJTable(String sm) {
        ArrayList<Order> list = getOrderList(sm);
        DefaultTableModel model = (DefaultTableModel)JTable.getModel();
        
        model.setRowCount(0); //clear table
        Object[] row = new Object[4];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[2] = list.get(i).getTotal();
            row[3] = list.get(i).getDate();
            row[1] = list.get(i).getCustomerId();
            model.addRow(row);
        }
    }
    
    public void ShowJTable(String sm, String sy) {
        ArrayList<Order> list = getOrderList(sm, sy);
        DefaultTableModel model = (DefaultTableModel)JTable.getModel();
        
        model.setRowCount(0); //clear table
        Object[] row = new Object[4];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[2] = list.get(i).getTotal();
            row[3] = list.get(i).getDate();
            row[1] = list.get(i).getCustomerId();
            model.addRow(row);
        }
    }
    
    public void ShowJTable(String sy, int a) {
        ArrayList<Order> list = getOrderList(sy, a);
        DefaultTableModel model = (DefaultTableModel)JTable.getModel();
        
        model.setRowCount(0); //clear table
        Object[] row = new Object[43];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[2] = list.get(i).getTotal();
            row[3] = list.get(i).getDate();
            row[1] = list.get(i).getCustomerId();
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTable = new javax.swing.JTable();
        Btn_back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Lbl_tspent = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Box_month = new javax.swing.JComboBox<>();
        Box_year = new javax.swing.JComboBox<>();

        jPopupMenu1.setBackground(new java.awt.Color(255, 255, 255));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Order ID", "Customer ID", "Order Total", "Order Date"
            }
        ));
        JTable.setRowHeight(100);
        JTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTable);

        Btn_back.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        Btn_back.setText("Back");
        Btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_backActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel1.setText("Cumulative Order Total:");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel2.setText("ORDERS");

        Lbl_tspent.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel3.setText("Filter:");

        Box_month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Filter by Month", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        Box_month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box_monthActionPerformed(evt);
            }
        });

        Box_year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Filter by Year", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022" }));
        Box_year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box_yearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(127, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Box_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Box_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(425, 425, 425))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(237, 237, 237)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(Lbl_tspent, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(198, 198, 198))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(508, 508, 508))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Box_month, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Box_year, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lbl_tspent, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(106, 106, 106))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableMouseClicked
        int index = JTable.getSelectedRow();
        try {
            Connection con = getConnection();
            String query = "SELECT * FROM orders WHERE oid='"+JTable.getValueAt(index,0)+"'";
            
            Statement st;
            ResultSet rs;
            
            try {
                st = con.createStatement();
                rs = st.executeQuery(query);
                Order order;
                
                if (rs.next()) {
                    order = new Order(rs.getInt("oid"), rs.getInt("cid"), Float.parseFloat(rs.getString("oprice")), rs.getString("odate"));
                    ShowOrderAdmin s = new ShowOrderAdmin(order);
                    s.setVisible(true);
                    this.dispose();
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_JTableMouseClicked

    private void Btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_backActionPerformed
        this.dispose();
    }//GEN-LAST:event_Btn_backActionPerformed

    private void Box_monthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Box_monthActionPerformed
        sm = Box_month.getSelectedItem().toString();
        if (sm.charAt(0)!='F') {
            if (sy.charAt(0)!='F') {
                ShowJTable(sm, sy);
            }
            else
            ShowJTable(sm);
        }
        else {
            if (sy.charAt(0)!='F') {
                ShowJTable(sy, 0);
            }
            else
                ShowJTable();
        }
    }//GEN-LAST:event_Box_monthActionPerformed

    private void Box_yearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Box_yearActionPerformed
        sy = Box_year.getSelectedItem().toString();
        if (sy.charAt(0)!='F') {
            if (sm.charAt(0)!='F') {
                ShowJTable(sm, sy);
            }
            else
            ShowJTable(sy, 0);
        }
        else {
            if (sm.charAt(0)!='F') {
                ShowJTable(sm);
            }
            else {
                ShowJTable();
            }
        }
    }//GEN-LAST:event_Box_yearActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Box_month;
    private javax.swing.JComboBox<String> Box_year;
    private javax.swing.JButton Btn_back;
    private javax.swing.JTable JTable;
    private javax.swing.JLabel Lbl_tspent;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
