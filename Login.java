
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Work
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form AdminLogin
     */
    public Login() {
        initComponents();
    }
    
    public static int ID = -1;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        lblUname = new java.awt.Label();
        lblPswd = new java.awt.Label();
        edtPswd = new javax.swing.JPasswordField();
        edtUname = new java.awt.TextField();
        btnLogin = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        cmbType = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Login");

        label1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label1.setText("Login");

        lblUname.setText("Username:");

        lblPswd.setText("Password:");

        edtPswd.setColumns(10);

        edtUname.setColumns(10);

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        cmbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<SELECT>", "Admin", "Parent", "Student", "Teacher" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPswd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(edtPswd)
                            .addComponent(edtUname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblUname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtUname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPswd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtPswd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin)
                    .addComponent(btnCancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String uname = edtUname.getName();
        String pswd = new String(edtPswd.getPassword());
        String type = cmbType.getSelectedItem().toString();
        
        if (uname.equals("") || pswd.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Username or password incorrect");
        }
        
        switch (type)
        {
            case "<SELECT>":
                JOptionPane.showMessageDialog(null, "Please select whether your are an administrator, parent, student, teacher");
                break;
            case "Admin":
                try {
                    Main pro = new Main();
                    pro.createConnection();
                    
                    boolean exist = false;
                    String sql = "SELECT AdminID, Username, Password FROM tbladmin";
                    Statement stmt = Main.con.createStatement();
                    ResultSet rs = stmt.executeQuery(sql);
                    rs.beforeFirst();
                    
                    while (rs.next()) {
                    String username = rs.getString("Username");
                    String password =  rs.getString("Password");
                    
                       if ((uname.equals(username)) || (pswd.equals(password))) {
                            exist = true;
                            ID = rs.getInt("AdminID");
                            new AdminDashboard().setVisible(true);
                            dispose();
                       }
                    } 
                    rs.close();
                    if(!exist){
                           JOptionPane.showMessageDialog(null, "Please Check Username and Password ");
                    } 
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "Parent":
                try {
                    Main pro = new Main();
                    pro.createConnection();
                    
                    boolean exist = false;
                    String sql = "SELECT ParentID, Name, Password FROM tblparent";
                    Statement stmt = Main.con.createStatement();
                    ResultSet rs = stmt.executeQuery(sql);
                    rs.beforeFirst();
                    
                    while (rs.next()) {
                    String username = rs.getString("Name");
                    String password =  rs.getString("Password");
                    
                       if ((uname.equals(username)) || (pswd.equals(password))) {
                            exist = true;
                            ID = rs.getInt("ParentID");
                            new ParentDashboard().setVisible(true);
                            dispose();
                       }
                    } 
                    rs.close();
                    if(!exist){
                           JOptionPane.showMessageDialog(null, "Please Check Username and Password ");
                    } 
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "Student":
                try {
                    Main pro = new Main();
                    pro.createConnection();
                    
                    boolean exist = false;
                    String sql = "SELECT StudentID, Name, Password FROM tblstudent";
                    Statement stmt = Main.con.createStatement();
                    ResultSet rs = stmt.executeQuery(sql);
                    rs.beforeFirst();
                    
                    while (rs.next()) {
                    String username = rs.getString("Name");
                    String password =  rs.getString("Password");
                    
                       if ((uname.equals(username)) || (pswd.equals(password))) {
                            exist = true;
                            ID = rs.getInt("StudentID");
                            new StudentDashboard().setVisible(true);
                            dispose();
                       }
                    } 
                    rs.close();
                    if(!exist){
                           JOptionPane.showMessageDialog(null, "Please Check Username and Password ");
                    }                    
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "Teacher":
                try {
                    Main pro = new Main();
                    pro.createConnection();
                    
                    boolean exist = false;
                    String sql = "SELECT TeacherID, Username, Password FROM tblteacher";
                    Statement stmt = Main.con.createStatement();
                    ResultSet rs = stmt.executeQuery(sql);
                    rs.beforeFirst();
                    
                    while (rs.next()) {
                    String username = rs.getString("Username");
                    String password =  rs.getString("Password");
                    
                       if ((uname.equals(username)) || (pswd.equals(password))) {
                            exist = true;
                            ID = rs.getInt("TeacherID");
                            new TeacherDashboard().setVisible(true);
                            dispose();
                       }
                    } 
                    rs.close();
                    if(!exist){
                           JOptionPane.showMessageDialog(null, "Please Check Username and Password ");
                    } 
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnLogin;
    private javax.swing.JComboBox<String> cmbType;
    private javax.swing.JPasswordField edtPswd;
    private java.awt.TextField edtUname;
    private java.awt.Label label1;
    private java.awt.Label lblPswd;
    private java.awt.Label lblUname;
    // End of variables declaration//GEN-END:variables
}
