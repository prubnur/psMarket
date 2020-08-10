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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author isaluja1811
 */
public class UserMainWindow extends javax.swing.JFrame {

    /**
     * Creates new form UserMainWindow
     */
    public UserMainWindow(Customer c) {
        this.cust = c;
        initComponents();
        getConnection();
        ShowJTable();
    }
    
    String str = null;
    String st = null;
    Customer cust;
    
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
    
    ArrayList<Product> productList;
    
    public ArrayList<Product> getProductList() {
        
        productList = new ArrayList<Product>();
        Connection con = getConnection();
        String query = "SELECT * FROM products";
          
        Statement st = null;
        ResultSet rs = null;
            
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            Product product;
            
            while (rs.next()) {
                product = new Product(rs.getInt("ID"), rs.getString("Name"), Float.parseFloat(rs.getString("Price")), rs.getString("Type"), rs.getInt("Quantity"), rs.getString("AddDate"), rs.getBytes("Image"));
                productList.add(product);
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
        return productList;
    }
    
    public ArrayList<Product> getProductList(String s) {
        
            productList = new ArrayList<Product>();
            Connection con = getConnection();
            String query = "SELECT * FROM products WHERE Name LIKE '%"+s+"%' ";
            
            Statement st = null;
            ResultSet rs = null;
            
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            Product product;
            
            while (rs.next()) {
                product = new Product(rs.getInt("ID"), rs.getString("Name"), Float.parseFloat(rs.getString("Price")), rs.getString("Type"), rs.getInt("Quantity"), rs.getString("AddDate"), rs.getBytes("Image"));
                productList.add(product);
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
        return productList;
    }
    
    public ArrayList<Product> getProductList(String s, int a) {
        
            productList = new ArrayList<Product>();
            Connection con = getConnection();
            String query = "SELECT * FROM products WHERE Type='"+s+"' ";
            
            Statement st=null;
            ResultSet rs=null;
            
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            Product product;
            
            while (rs.next()) {
                product = new Product(rs.getInt("ID"), rs.getString("Name"), Float.parseFloat(rs.getString("Price")), rs.getString("Type"), rs.getInt("Quantity"), rs.getString("AddDate"), rs.getBytes("Image"));
                productList.add(product);
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
        return productList;
    }
    
    public ArrayList<Product> getProductList(String str, String s, int a) {
        
            productList = new ArrayList<Product>();
            Connection con = getConnection();
            String query = "SELECT * FROM products WHERE Type='"+s+"' AND Name like '%"+str+"%' ";
            
            Statement st=null;
            ResultSet rs=null;
            
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            Product product;
            
            while (rs.next()) {
                product = new Product(rs.getInt("ID"), rs.getString("Name"), Float.parseFloat(rs.getString("Price")), rs.getString("Type"), rs.getInt("Quantity"), rs.getString("AddDate"), rs.getBytes("Image"));
                productList.add(product);
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
        return productList;
    }
    
    DefaultTableModel model;

    
    public void ShowJTable() {
        ArrayList<Product> list = getProductList();
        model = (DefaultTableModel)JTable.getModel();
        
        model.setRowCount(0); //clear table
        Object[] row = new Object[6];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getPrice();
            row[3] = list.get(i).getType();
            row[4] = list.get(i).getQuantity();
            Icon icon = new ImageIcon(list.get(i).getImage());
            row[5] = icon;
            
            model.addRow(row);
        }
    }
    
    public void ShowJTable(int a) {
        ArrayList<Product> list = productList;
        if (a%2==0)
        Collections.sort(productList);
        else {
            Collections.sort(productList, Collections.reverseOrder());
        }
        model = (DefaultTableModel)JTable.getModel();
        
        model.setRowCount(0); //clear table
        Object[] row = new Object[6];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getPrice();
            row[3] = list.get(i).getType();
            row[4] = list.get(i).getQuantity();
            Icon icon = new ImageIcon(list.get(i).getImage());
            row[5] = icon;
            
            model.addRow(row);
        }
    }
    
    public void ShowJTable(String s) {
        ArrayList<Product> list = getProductList(s);
        model = (DefaultTableModel)JTable.getModel();
        
        model.setRowCount(0); //clear table
        Object[] row = new Object[6];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getPrice();
            row[3] = list.get(i).getType();
            row[4] = list.get(i).getQuantity();
            Icon icon = new ImageIcon(list.get(i).getImage());
            row[5] = icon;
            
            model.addRow(row);
        }
    }
    
    public void ShowJTable(String s, int a) {
        ArrayList<Product> list = getProductList(s,0);
        model = (DefaultTableModel)JTable.getModel();
        
        model.setRowCount(0); //clear table
        Object[] row = new Object[6];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getPrice();
            row[3] = list.get(i).getType();
            row[4] = list.get(i).getQuantity();
            Icon icon = new ImageIcon(list.get(i).getImage());
            row[5] = icon;
            
            model.addRow(row);
        }
    }
    
    public void ShowJTable(String str, String s, int a) {
        ArrayList<Product> list = getProductList(str,s,0);
        model = (DefaultTableModel)JTable.getModel();
        
        model.setRowCount(0); //clear table
        Object[] row = new Object[6];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getPrice();
            row[3] = list.get(i).getType();
            row[4] = list.get(i).getQuantity();
            Icon icon = new ImageIcon(list.get(i).getImage());
            row[5] = icon;
            
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
        Txt_search = new javax.swing.JTextField();
        Box_type = new javax.swing.JComboBox<>();
        Btn_sort = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Btn_cart = new javax.swing.JButton();
        Btn_logout = new javax.swing.JButton();
        Btn_myorders = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JTable.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        JTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Price", "Type", "Qty in Stock", "Image"
            }
        ));
        JTable.setRowHeight(150);
        JTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTable);
        if (JTable.getColumnModel().getColumnCount() > 0) {
            JTable.getColumnModel().getColumn(0).setHeaderValue("ID");
        }

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

        Box_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Filter by Type", "Electronics", "Clothing", "Food and Beverages", "Books", "Vehicle", "Home/Kitchen", "Sports" }));
        Box_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box_typeActionPerformed(evt);
            }
        });

        Btn_sort.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        Btn_sort.setText("Price Sort");
        Btn_sort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_sortActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel1.setText("Search:");

        Btn_cart.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        Btn_cart.setText("Cart");
        Btn_cart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_cartActionPerformed(evt);
            }
        });

        Btn_logout.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        Btn_logout.setText("Logout");
        Btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_logoutActionPerformed(evt);
            }
        });

        Btn_myorders.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        Btn_myorders.setText("My Orders");
        Btn_myorders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_myordersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1385, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(Txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(Box_type, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(Btn_sort, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(Btn_cart, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Btn_logout, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                            .addComponent(Btn_myorders, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addComponent(Btn_myorders, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Box_type, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Btn_sort, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Btn_cart, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        int index = JTable.getSelectedRow();
        try {
            Connection con = getConnection();
            String query = "SELECT * FROM products WHERE id='"+JTable.getValueAt(index,0)+"'";
            
            Statement st;
            ResultSet rs;
            
            try {
                st = con.createStatement();
                rs = st.executeQuery(query);
                Product product;
                
                if (rs.next()) {
                    product = new Product(rs.getInt("ID"), rs.getString("Name"), Float.parseFloat(rs.getString("Price")), rs.getString("Type"), rs.getInt("Quantity"), rs.getString("AddDate"), rs.getBytes("Image"));
                    ShowProduct s = new ShowProduct(cust, product);
                    s.setVisible(true);
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_JTableMouseClicked

    private void Box_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Box_typeActionPerformed
        str = Txt_search.getText().trim();
        st = Box_type.getSelectedItem().toString();
        if (st==null || st.equals("Filter by Type")) {
            if (str==null || str.length()==0)
            ShowJTable();
            else {
                ShowJTable(str);
            }
        }
        else {
            if (str==null || str.length()==0)
            ShowJTable(st,0);
            else {
                ShowJTable(str,st,0);
            }
        }    
    }//GEN-LAST:event_Box_typeActionPerformed

    private void Txt_searchInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_Txt_searchInputMethodTextChanged

    }//GEN-LAST:event_Txt_searchInputMethodTextChanged

    private void Txt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_searchActionPerformed
        
    }//GEN-LAST:event_Txt_searchActionPerformed

    private void Txt_searchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Txt_searchKeyTyped

    }//GEN-LAST:event_Txt_searchKeyTyped

    private void Txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Txt_searchKeyReleased
        str = Txt_search.getText().trim();
        st = Box_type.getSelectedItem().toString();
        if (str==null || str.length()==0) {
            if (st==null || st.equals("Filter by Type"))
            ShowJTable();
            else {
                ShowJTable(st,0);
            }
        }
        else {
            if (st==null || st.equals("Filter by Type"))
            ShowJTable(str);
            else {
                ShowJTable(str,st,0);
            }
        }
    }//GEN-LAST:event_Txt_searchKeyReleased
    int c=0;
    private void Btn_sortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_sortActionPerformed
        c++;
        ShowJTable(c);
    }//GEN-LAST:event_Btn_sortActionPerformed

    private void Btn_cartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_cartActionPerformed
        Cart c = new Cart(cust);
        c.setVisible(true);
    }//GEN-LAST:event_Btn_cartActionPerformed

    private void Btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_logoutActionPerformed
        this.dispose();
        CLogin l = new CLogin();
        l.setVisible(true);
    }//GEN-LAST:event_Btn_logoutActionPerformed

    private void Btn_myordersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_myordersActionPerformed
        MyOrders mo = new MyOrders(cust);
        mo.setVisible(true);
    }//GEN-LAST:event_Btn_myordersActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Box_type;
    private javax.swing.JButton Btn_cart;
    private javax.swing.JButton Btn_logout;
    private javax.swing.JButton Btn_myorders;
    private javax.swing.JButton Btn_sort;
    private javax.swing.JTable JTable;
    private javax.swing.JTextField Txt_search;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
