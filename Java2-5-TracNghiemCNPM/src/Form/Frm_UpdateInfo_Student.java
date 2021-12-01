package Form;

import DbIn_Out.AccountDAO;
import Model.Account;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class Frm_UpdateInfo_Student extends javax.swing.JFrame {

    public Frm_UpdateInfo_Student() {
        initComponents();
    }

    Account userLogin = null;

    Frm_UpdateInfo_Student(Account u) {
        //khởi tạo giao diện với tài khoản đã đăng nhập
        this.setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        lblCheck.setVisible(false);
        userLogin = u;
        txtUsername.setEnabled(false);
        txtUsername.setText(u.getUserName());
        txtFullName.setText(u.getFull_Name());
        txtClass.setText(u.getClass_Name());
        txtPhone.setText(u.getPhone());
        oldPass.setText(u.getPassword());
        newPass0.setText(u.getPassword());
        newPass1.setText(u.getPassword());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtClass = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        pnlPassword = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblCheck = new javax.swing.JLabel();
        newPass0 = new javax.swing.JPasswordField();
        newPass1 = new javax.swing.JPasswordField();
        oldPass = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        btThoat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(550, 150));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(199, 228, 235));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thay đổi thông tin cá nhân"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Họ tên");

        txtFullName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Lớp");

        txtClass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Điện thoại");

        txtPhone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnSave.setBackground(new java.awt.Color(51, 102, 255));
        btnSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Save1.png"))); // NOI18N
        btnSave.setText("Lưu thay đổi");
        btnSave.setToolTipText("Cập nhật thông tin người dùng");
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        pnlPassword.setBackground(new java.awt.Color(199, 228, 235));
        pnlPassword.setBorder(javax.swing.BorderFactory.createTitledBorder("Mật khẩu"));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Xác nhận mật khẩu mới*");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Mật khẩu cũ*");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Mật khẩu mới*");

        lblCheck.setText("ok");

        newPass0.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        newPass0.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                newPass0CaretUpdate(evt);
            }
        });
        newPass0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                newPass0MousePressed(evt);
            }
        });
        newPass0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPass0ActionPerformed(evt);
            }
        });

        newPass1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        newPass1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                newPass1CaretUpdate(evt);
            }
        });
        newPass1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                newPass1KeyReleased(evt);
            }
        });

        oldPass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout pnlPasswordLayout = new javax.swing.GroupLayout(pnlPassword);
        pnlPassword.setLayout(pnlPasswordLayout);
        pnlPasswordLayout.setHorizontalGroup(
            pnlPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPasswordLayout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(pnlPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(pnlPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(newPass0)
                        .addComponent(oldPass, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPasswordLayout.createSequentialGroup()
                        .addComponent(newPass1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblCheck)))
                .addGap(21, 21, 21))
        );

        pnlPasswordLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel6, jLabel7, jLabel8});

        pnlPasswordLayout.setVerticalGroup(
            pnlPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPasswordLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oldPass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(pnlPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(newPass0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newPass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pnlPasswordLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel6, jLabel7, jLabel8, newPass0, newPass1, oldPass});

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Tên đăng nhập");

        txtUsername.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btThoat.setBackground(new java.awt.Color(255, 153, 153));
        btThoat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btThoat.setForeground(new java.awt.Color(255, 255, 255));
        btThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Back.png"))); // NOI18N
        btThoat.setText("Quay lại");
        btThoat.setToolTipText("Thoát");
        btThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btThoatMouseClicked(evt);
            }
        });
        btThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pnlPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 33, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUsername)
                            .addComponent(txtFullName, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                            .addComponent(txtClass, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtClass, txtFullName});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btThoat, btnSave, jLabel1, jLabel2, jLabel3, jLabel4, txtClass, txtFullName, txtUsername});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newPass1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newPass1KeyReleased
        // TODO add your handling code here:
        lblCheck.setVisible(true);
    }//GEN-LAST:event_newPass1KeyReleased

    private void newPass1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_newPass1CaretUpdate
        // TODO add your handling code here:
        if (newPass0.getText().equals(newPass1.getText())) {
            lblCheck.setText("OK");
        } else {
            lblCheck.setText("Sai");
        }
    }//GEN-LAST:event_newPass1CaretUpdate

    private void newPass0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPass0ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newPass0ActionPerformed

    private void newPass0MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newPass0MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_newPass0MousePressed

    private void newPass0CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_newPass0CaretUpdate
        // TODO add your handling code here:
        if (newPass0.getText().equals(newPass1.getText())) {
            lblCheck.setText("OK");
        } else {
            lblCheck.setText("Sai");
        }
    }//GEN-LAST:event_newPass0CaretUpdate

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        try {
            //tạo 1 tài khoản mới với dữ liệu đầu vào
            Account u = userLogin;
            u.setUserName(txtUsername.getText());
            u.setFull_Name(txtFullName.getText());
            if (!oldPass.getText().equals(u.getPassword())) {
                JOptionPane.showMessageDialog(this, "Sai mật khẩu!");
                return;
            }
            if (!newPass0.getText().equals(newPass1.getText())) {
                JOptionPane.showMessageDialog(this, "Mật khẩu không trùng khớp");
                return;
            }
            u.setPassword(newPass0.getText());
            u.setFull_Name(txtFullName.getText());
            u.setClass_Name(txtClass.getText());
            u.setPhone(txtPhone.getText());

            //cập nhật tài khoản vào database
            if (txtFullName.getText().equals("") || txtClass.getText().equals("") || txtPhone.getText().equals("")
                    || oldPass.getText().equals("") || newPass0.getText().equals("") || newPass1.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Chưa nhập đủ thông tin");
                return;
            }
            //Kiểm tra số điện thoại
            if (txtPhone.getText().length() != 10) {
                JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ");
                return;
            }
            String PhoneValue = txtPhone.getText();
            try {
                Integer.parseInt(PhoneValue);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ");
                return;
            }

            //kiểm tra lưu thành công hay không
            if (new AccountDAO().update(u)) {
                JOptionPane.showMessageDialog(this, "Lưu thành công");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Có lỗi xảy ra");
            }
        } catch (HeadlessException e) {
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btThoatMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btThoatMouseClicked

    private void btThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThoatActionPerformed
        // TODO add your handling code here:

        int rt = JOptionPane.showConfirmDialog(this, "Về trang chủ?", "confirm", JOptionPane.YES_NO_OPTION);
        if (rt == JOptionPane.YES_OPTION) {
            this.dispose();
            new Frm_Student_Home(userLogin).setVisible(true);
        } else
            return;
    }//GEN-LAST:event_btThoatActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(Frm_UpdateInfo_Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_UpdateInfo_Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_UpdateInfo_Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_UpdateInfo_Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_UpdateInfo_Student().setVisible(false);
                System.out.println("vui lòng đăng nhập trước");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btThoat;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCheck;
    private javax.swing.JPasswordField newPass0;
    private javax.swing.JPasswordField newPass1;
    private javax.swing.JPasswordField oldPass;
    private javax.swing.JPanel pnlPassword;
    private javax.swing.JTextField txtClass;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
