package Form;

import DbIn_Out.AccountDAO;
import Model.Account;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class Frm_Register extends javax.swing.JFrame {

    public Frm_Register() {
        this.setUndecorated(true);
        initComponents();
        lblCheck.setVisible(false);
        txtUsername.setEnabled(false);
        lblcheckUser.setVisible(false);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblDangnhap = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnSignIn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtClass = new javax.swing.JTextField();
        txtStudentCode = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblCheck = new javax.swing.JLabel();
        txtpasscf = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        txtUsername = new javax.swing.JTextField();
        lblUserName = new javax.swing.JLabel();
        lblcheckUser = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(199, 228, 235));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Đăng ký tài khoản");

        lblDangnhap.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDangnhap.setForeground(new java.awt.Color(0, 0, 255));
        lblDangnhap.setText("Đăng nhập");
        lblDangnhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDangnhapMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Đã có tài khoản?");

        btnClear.setBackground(new java.awt.Color(51, 102, 255));
        btnClear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/clear.png"))); // NOI18N
        btnClear.setText("Xóa trắng");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(255, 153, 153));
        btnCancel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Back.png"))); // NOI18N
        btnCancel.setText("Quay lại");
        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelMouseClicked(evt);
            }
        });
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnSignIn.setBackground(new java.awt.Color(51, 102, 255));
        btnSignIn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSignIn.setForeground(new java.awt.Color(255, 255, 255));
        btnSignIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/register.png"))); // NOI18N
        btnSignIn.setText("Đăng kí");
        btnSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignInActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin cá nhân", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Họ tên");

        txtFullName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Số điện thoại");

        txtPhone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneActionPerformed(evt);
            }
        });
        txtPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPhoneKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Lớp");

        txtClass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtStudentCode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtStudentCode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtStudentCodeFocusLost(evt);
            }
        });
        txtStudentCode.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtStudentCodeInputMethodTextChanged(evt);
            }
        });
        txtStudentCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentCodeActionPerformed(evt);
            }
        });
        txtStudentCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtStudentCodeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtStudentCodeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStudentCodeKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Mã sinh viên");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtClass, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPhone, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtStudentCode, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFullName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtClass, txtFullName, txtPhone, txtStudentCode});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel5, jLabel6, jLabel7, jLabel8});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtStudentCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel5, jLabel6, jLabel7, jLabel8, txtClass, txtFullName, txtPhone, txtStudentCode});

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin tài khoản", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        lblCheck.setText("ok");

        txtpasscf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtpasscf.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtpasscfCaretUpdate(evt);
            }
        });
        txtpasscf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtpasscfMouseClicked(evt);
            }
        });
        txtpasscf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpasscfActionPerformed(evt);
            }
        });
        txtpasscf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpasscfKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Xác nhận mật khẩu");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Mật khẩu");

        txtPass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPass.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtPassCaretUpdate(evt);
            }
        });

        txtUsername.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        lblUserName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUserName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUserName.setText("Tên đăng nhập");

        lblcheckUser.setText("ok");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUserName, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblcheckUser)
                    .addComponent(lblCheck)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtPass, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                        .addComponent(txtpasscf)))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3, lblUserName});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUserName)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblcheckUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpasscf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, jLabel3, lblCheck, lblUserName, lblcheckUser, txtPass, txtUsername, txtpasscf});

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(lblDangnhap))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnClear)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(13, Short.MAX_VALUE))))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCancel, btnClear});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(45, 45, 45)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnSignIn)
                    .addComponent(btnClear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblDangnhap))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel1, jPanel2});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCancel, btnClear, btnSignIn});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();

    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignInActionPerformed
        int dk = JOptionPane.showConfirmDialog(this, "Bạn có muốn đăng ký?", "confirm", JOptionPane.YES_NO_OPTION);
        if (dk != JOptionPane.YES_OPTION) {
            return;
        }
        try {
            //khởi tạo 1 tài khoản mới từ dữ liệu đầu vào
            Account u = new Account();
            u.setUserName(txtUsername.getText());
            u.setPassword(txtPass.getText());
            u.setFull_Name(txtFullName.getText());
            u.setClass_Name(txtClass.getText());
            u.setPhone(txtPhone.getText());
            //kiểm tra các trường trống
            if (txtFullName.getText().equals("") || txtClass.getText().equals("") || txtPhone.getText().equals("")
                    || txtStudentCode.getText().equals("") || txtPass.getText().equals("") || txtpasscf.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Chưa nhập đủ thông tin");
                return;
            }
            //kiểm tra mật khẩu
            if (!txtPass.getText().equals(txtpasscf.getText())) {
                JOptionPane.showMessageDialog(this, "Sai password");
                return;
            }
            //kiểm tra mã sinh viên
            if (txtStudentCode.getText().length() != 10) {
                JOptionPane.showMessageDialog(this, "Mã sinh viên phải là 10 số");
                return;
            }
            //Kiểm tra tên đăng nhập đã tồn tại trong database chưa
            List<String> uN = new AccountDAO().getUserName();
            if (uN.contains(txtStudentCode.getText())) {
                JOptionPane.showMessageDialog(rootPane, "Tên đăng nhập đã tồn tại");
            }
            //kiểm tra số điện thoại
            String PhoneValue = txtPhone.getText();
            try {
                Integer.parseInt(PhoneValue);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Số điện thoại không bao gồm kí tự chữ");
                txtStudentCode.setText(PhoneValue.substring(0, PhoneValue.length()));
                return;
            }
            //thêm tài khoản vừa tạo vào database
            boolean addUser = new AccountDAO().insert(u);
            if (addUser) {
                int dn = JOptionPane.showConfirmDialog(this, "Đăng ký thành công! Đăng nhập ngay?", "confirm", JOptionPane.YES_NO_OPTION);
                if (dn == JOptionPane.YES_OPTION) {
                    this.dispose();
                    Frm_Login log = new Frm_Login();
                    log.show();
                } else {
                    xoaTrang();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Đăng ký lỗi");
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(rootPane, "Lỗi " + e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSignInActionPerformed
    //hàm xóa dữ liệu nhập vào
    private void xoaTrang() {
        txtFullName.setText("");
        txtClass.setText("");
        txtStudentCode.setText("");
        txtPhone.setText("");
        txtUsername.setText("");
        txtPass.setText("");
        txtpasscf.setText("");
        lblCheck.setVisible(false);
        txtFullName.requestFocus();
    }
    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        xoaTrang();
    }//GEN-LAST:event_btnClearActionPerformed

    private void txtpasscfCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtpasscfCaretUpdate
        // TODO add your handling code here:
        if (txtPass.getText().equals(txtpasscf.getText())) {
            lblCheck.setText("OK");
        } else {
            lblCheck.setText("Sai");
        }
    }//GEN-LAST:event_txtpasscfCaretUpdate

    private void txtpasscfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtpasscfMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_txtpasscfMouseClicked

    private void txtpasscfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpasscfActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtpasscfActionPerformed

    private void txtpasscfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasscfKeyTyped
        // TODO add your handling code here:
        lblCheck.setVisible(true);
    }//GEN-LAST:event_txtpasscfKeyTyped

    private void txtPassCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtPassCaretUpdate
        // TODO add your handling code here:
        if (txtPass.getText().equals(txtpasscf.getText())) {
            lblCheck.setText("OK");
        } else {
            lblCheck.setText("Sai");
        }
    }//GEN-LAST:event_txtPassCaretUpdate

    private void txtPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneActionPerformed

    private void txtStudentCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentCodeActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtStudentCodeActionPerformed

    private void btnCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_btnCancelMouseClicked

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void txtStudentCodeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtStudentCodeFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentCodeFocusLost

    private void txtStudentCodeInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtStudentCodeInputMethodTextChanged
        // TODO add your handling code here:       
    }//GEN-LAST:event_txtStudentCodeInputMethodTextChanged

    private void txtStudentCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStudentCodeKeyReleased
        // TODO add your handling code here:
        txtUsername.setText(txtStudentCode.getText());
        if (txtStudentCode.getText().length() == 10) {
            lblcheckUser.setVisible(true);
        } else {
            lblcheckUser.setVisible(false);
        }
        List<String> uN = new AccountDAO().getUserName();

        if (uN.contains(txtStudentCode.getText())) {
            lblcheckUser.setText("Tên đăng nhập đã tồn tại");
        } else
            lblcheckUser.setText("OK");
    }//GEN-LAST:event_txtStudentCodeKeyReleased

    private void txtStudentCodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStudentCodeKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtStudentCodeKeyPressed

    private void lblDangnhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDangnhapMouseClicked
        // TODO add your handling code here:
        this.dispose();
        new Frm_Login().show();
    }//GEN-LAST:event_lblDangnhapMouseClicked

    private void txtPhoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneKeyReleased
        // TODO add your handling code here:
        String value = txtPhone.getText();
        try {
            if (txtPhone.getText().equals("")) {
                return;
            }
            Integer.parseInt(value);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nhập sai định dạng");
            txtPhone.setText(value.substring(0, value.length() - 1));
            return;
        }
    }//GEN-LAST:event_txtPhoneKeyReleased

    private void txtStudentCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStudentCodeKeyTyped

    }//GEN-LAST:event_txtStudentCodeKeyTyped

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
            java.util.logging.Logger.getLogger(Frm_Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Register().setVisible(true);
                List<String> uN = new AccountDAO().getUserName();
                for (String i : uN) {
                    System.out.println(i);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSignIn;
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
    private javax.swing.JLabel lblCheck;
    private javax.swing.JLabel lblDangnhap;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JLabel lblcheckUser;
    private javax.swing.JTextField txtClass;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtStudentCode;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JPasswordField txtpasscf;
    // End of variables declaration//GEN-END:variables
}
