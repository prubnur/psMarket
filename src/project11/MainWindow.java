/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project11;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author isaluja1811
 */
public class MainWindow extends javax.swing.JFrame {

    /** Creates new form MainWindow */
    public MainWindow() {
        initComponents();
        ShowJTable();
        getConnection();
    }
    
    String ImgPath = null;
    int pos = 0;
    ArrayList<Product> productList;
    DefaultTableModel model;
    int c = 0;
    String str = null;
    String st = null;
    
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
    
    // Check Input Fields
    public boolean checkInputs() {
        if (Txt_name.getText() == null 
                || Txt_price.getText() == null
                || (Integer)Txt_quantity.getValue() == 0
                || Txt_date.getDate() == null) {
            return false;
        }
        else {
            try {
                Float.parseFloat(Txt_price.getText());
                return true;
            }catch(Exception ex) {
                return false;
            }
        }
    }
    
    // Resize Image
    public ImageIcon ResizeImage(String imagePath, byte[] pic) {
        ImageIcon myImage = null;
        
        if (imagePath!=null) {
            myImage = new ImageIcon(imagePath);
        }
        else {
            myImage = new ImageIcon(pic);
        }
        
        Image img = myImage.getImage();
        Image img2 = img.getScaledInstance(Lbl_img.getWidth(), Lbl_img.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);
        return image;
    }
    
    // JTable
    public ArrayList<Product> getProductList() {
        
            productList = new ArrayList<Product>();
            Connection con = getConnection();
            String query = "SELECT * FROM products";
            
            Statement st;
            ResultSet rs;
            
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
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
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
            row[5] = list.get(i).getAddDate();
            
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
            row[5] = list.get(i).getAddDate();
            
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
            row[5] = list.get(i).getAddDate();
            
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
            row[5] = list.get(i).getAddDate();
            
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
            row[5] = list.get(i).getAddDate();
            
            model.addRow(row);
        }
    }
    
    
    public void ShowItem(int index) {
        
        Txt_id.setText(Integer.toString(productList.get(index).getId()));
        Txt_name.setText(productList.get(index).getName());
        Txt_price.setText(Float.toString(productList.get(index).getPrice()));
        Box_type.setSelectedItem(productList.get(index).getType());
            
        try {
            Date addDate = null;
            addDate = new SimpleDateFormat("dd/MM/yyyy").parse((String)productList.get(index).getAddDate());
            Txt_date.setDate(addDate);
        } catch (ParseException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Lbl_img.setIcon(ResizeImage(null, productList.get(index).getImage()));
        Txt_quantity.setValue((Integer)productList.get(index).getQuantity());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Txt_price = new javax.swing.JTextField();
        Txt_id = new javax.swing.JTextField();
        Txt_name = new javax.swing.JTextField();
        Lbl_img = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTable = new javax.swing.JTable();
        BtnImage = new javax.swing.JButton();
        Btn_insert = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        Btn_First = new javax.swing.JButton();
        Btn_Previous = new javax.swing.JButton();
        Btn_Next = new javax.swing.JButton();
        Btn_Last = new javax.swing.JButton();
        Txt_date = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        Txt_quantity = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        Box_type = new javax.swing.JComboBox<>();
        Btn_First1 = new javax.swing.JButton();
        Box_type1 = new javax.swing.JComboBox<>();
        Txt_search = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel1.setText("NAME:");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel2.setText("ID:");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel3.setText("PRICE:");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel4.setText("IMAGE:");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel5.setText("QTY IN STOCK:");

        Txt_price.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N

        Txt_id.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        Txt_id.setEnabled(false);

        Txt_name.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N

        Lbl_img.setBackground(new java.awt.Color(255, 255, 255));
        Lbl_img.setOpaque(true);

        JTable.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        JTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price", "Type", "Quantity", "Add Date"
            }
        ));
        JTable.setRowHeight(60);
        JTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTable);

        BtnImage.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        BtnImage.setText("Choose Image");
        BtnImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnImageActionPerformed(evt);
            }
        });

        Btn_insert.setText("Insert");
        Btn_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_insertActionPerformed(evt);
            }
        });

        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        Btn_First.setText("First");
        Btn_First.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_FirstActionPerformed(evt);
            }
        });

        Btn_Previous.setText("Previous");
        Btn_Previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_PreviousActionPerformed(evt);
            }
        });

        Btn_Next.setText("Next");
        Btn_Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_NextActionPerformed(evt);
            }
        });

        Btn_Last.setText("Last");
        Btn_Last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_LastActionPerformed(evt);
            }
        });

        Txt_date.setDateFormatString("dd/MM/yyyy");
        Txt_date.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel6.setText("ADD DATE:");

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel7.setText("TYPE:");

        Box_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Electronics", "Clothing", "Food and Beverages", "Books", "Vehicle", "Home/Kitchen", "Sports" }));
        Box_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box_typeActionPerformed(evt);
            }
        });

        Btn_First1.setText("Price Sort");
        Btn_First1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_First1ActionPerformed(evt);
            }
        });

        Box_type1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Filter by Type", "Electronics", "Clothing", "Food and Beverages", "Books", "Vehicle", "Home/Kitchen", "Sports" }));
        Box_type1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box_type1ActionPerformed(evt);
            }
        });

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

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel8.setText("Search:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Txt_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(Box_type, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BtnImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Txt_id)
                    .addComponent(Txt_name)
                    .addComponent(Txt_price)
                    .addComponent(Lbl_img, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Btn_insert, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Txt_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(125, 125, 125)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Btn_First, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(Btn_Previous, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Btn_Next, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(Btn_Last, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(100, 100, 100))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(Txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Box_type1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Btn_First1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Txt_id)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Btn_First1)
                        .addComponent(Box_type1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Txt_price, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Txt_quantity)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                .addComponent(Box_type, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Txt_date, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Lbl_img, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(BtnImage, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Btn_insert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Btn_Last, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Btn_Next, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Btn_Previous, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Btn_First, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(58, 58, 58))
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

    private void BtnImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnImageActionPerformed
        
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.image", "jpg","png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if(result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            Lbl_img.setIcon(ResizeImage(path, null));
            ImgPath = path;
        }
        else {
            System.out.println("No File Selected");
        }
    }//GEN-LAST:event_BtnImageActionPerformed

    private void Btn_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_insertActionPerformed
        if (checkInputs() && ImgPath != null) {
            try {
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("INSERT INTO products(Name,Price,Type,Quantity,AddDate,Image)"
                    + "values(?,?,?,?,?,?) ");
                ps.setString(1, Txt_name.getText());
                ps.setString(2, Txt_price.getText());
                ps.setString(3, Box_type.getSelectedItem().toString());
                ps.setString(4, Txt_quantity.getValue().toString());
                
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String addDate = dateFormat.format(Txt_date.getDate());
                ps.setString(5, addDate);
                
                InputStream img = new FileInputStream(new File(ImgPath));
                ps.setBlob(6, img);
                ps.executeUpdate();
                ShowJTable();
                JOptionPane.showMessageDialog(null, "Data Added");
                con.close();
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Fill All Fields");
        }
    }//GEN-LAST:event_Btn_insertActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        if(checkInputs() && Txt_id.getText() != null) {
            String UpdateQuery = null;
            PreparedStatement ps = null;
            Connection con = getConnection();
           
            //update without image
            if(ImgPath == null) {
                try {
                    UpdateQuery = "UPDATE products SET Name = ?, Price = ?"
                            + ", Type = ?, Quantity = ?, AddDate = ? WHERE ID = ?";
                    
                    ps = con.prepareStatement(UpdateQuery);
                    
                    ps.setString(1, Txt_name.getText());
                    ps.setString(2, Txt_price.getText());
                    ps.setString(3, Box_type.getSelectedItem().toString());
                    ps.setString(4, Txt_quantity.getValue().toString());
                    
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    String addDate = dateFormat.format(Txt_date.getDate());
                    
                    ps.setString(5, addDate);
                    
                    ps.setInt(6, Integer.parseInt(Txt_id.getText()));
                    
                    ps.executeUpdate();
                    ShowJTable();
                    JOptionPane.showMessageDialog(null, "Data Updated");
                    con.close();
                    
                } catch (SQLException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            //image
            else {
                try {
                    InputStream img = new FileInputStream(new File(ImgPath));
                
                    UpdateQuery = "UPDATE products SEF Name = ?, Price = ?"
                            + ", Type = ?, Quantity = ?, AddDate = ?, Image = ? WHERE ID = ?";
                    
                    ps = con.prepareStatement(UpdateQuery);
                    
                    ps.setString(1, Txt_name.getText());
                    ps.setString(2, Txt_price.getText());
                    ps.setString(3, Box_type.getSelectedItem().toString());
                    ps.setString(4, Txt_quantity.getValue().toString());
                    
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    String addDate = dateFormat.format(Txt_date.getDate());
                    
                    ps.setString(5, addDate);
                    
                    ps.setBlob(6, img);
                    
                    ps.setInt(7, Integer.parseInt(Txt_id.getText()));
                    
                    ps.executeUpdate();
                    ShowJTable();
                    JOptionPane.showMessageDialog(null, "Data Updated");
                    con.close();
                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Fields not correctly filled");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(!Txt_id.getText().equals("")) {
            try {
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("DELETE FROM products WHERE ID = ?");
                int id = Integer.parseInt(Txt_id.getText());
                ps.setInt(1, id);
                ps.executeUpdate();
                ShowJTable();
                JOptionPane.showMessageDialog(null, "Data Deleted");
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Data Not Deleted");
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Enter Product ID to delete");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void JTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableMouseClicked
        int index = JTable.getSelectedRow();
        pos = index;
        ShowItem(index);
    }//GEN-LAST:event_JTableMouseClicked

    private void Btn_FirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_FirstActionPerformed
        pos = 0;
        ShowItem(pos);
    }//GEN-LAST:event_Btn_FirstActionPerformed

    private void Btn_LastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_LastActionPerformed
        pos = getProductList().size()-1;
        ShowItem(pos);
    }//GEN-LAST:event_Btn_LastActionPerformed

    private void Btn_NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_NextActionPerformed
        pos++;
        if (pos>= getProductList().size()) {
            pos = getProductList().size()-1;
        }
        ShowItem(pos);
    }//GEN-LAST:event_Btn_NextActionPerformed

    private void Btn_PreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_PreviousActionPerformed
        pos--;
        if (pos<0) {
            pos = 0;
        }
        ShowItem(pos);
    }//GEN-LAST:event_Btn_PreviousActionPerformed

    private void Box_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Box_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Box_typeActionPerformed

    private void Btn_First1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_First1ActionPerformed
        c++;
        ShowJTable(c);
    }//GEN-LAST:event_Btn_First1ActionPerformed

    private void Box_type1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Box_type1ActionPerformed
        str = Txt_search.getText().trim();
        st = Box_type1.getSelectedItem().toString();
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
    }//GEN-LAST:event_Box_type1ActionPerformed

    private void Txt_searchInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_Txt_searchInputMethodTextChanged

    }//GEN-LAST:event_Txt_searchInputMethodTextChanged

    private void Txt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_searchActionPerformed

    }//GEN-LAST:event_Txt_searchActionPerformed

    private void Txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Txt_searchKeyReleased
        str = Txt_search.getText().trim();
        st = Box_type1.getSelectedItem().toString();
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

    private void Txt_searchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Txt_searchKeyTyped

    }//GEN-LAST:event_Txt_searchKeyTyped

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Box_type;
    private javax.swing.JComboBox<String> Box_type1;
    private javax.swing.JButton BtnImage;
    private javax.swing.JButton Btn_First;
    private javax.swing.JButton Btn_First1;
    private javax.swing.JButton Btn_Last;
    private javax.swing.JButton Btn_Next;
    private javax.swing.JButton Btn_Previous;
    private javax.swing.JButton Btn_insert;
    private javax.swing.JTable JTable;
    private javax.swing.JLabel Lbl_img;
    private com.toedter.calendar.JDateChooser Txt_date;
    private javax.swing.JTextField Txt_id;
    private javax.swing.JTextField Txt_name;
    private javax.swing.JTextField Txt_price;
    private javax.swing.JSpinner Txt_quantity;
    private javax.swing.JTextField Txt_search;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
