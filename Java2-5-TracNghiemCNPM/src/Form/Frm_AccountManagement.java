package Form;

import DbIn_Out.AccountDAO;
import DbIn_Out.ResultDAO;
import Model.Account;
import java.awt.HeadlessException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class Frm_AccountManagement extends javax.swing.JFrame {
    private List<Account> listUsers;
    DefaultTableModel tableModel;
    int selectedRow = 0;

    public Frm_AccountManagement() {
        this.setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        tableModel = (DefaultTableModel) tbUsers.getModel();
        load();
    }
    
    //hàm load danh sách tài khoản sinh viên từ database lên bảng
    public void load(){
        listUsers = new AccountDAO().getAllUser();
        if (listUsers.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Danh sách sinh viên trống!");
        }
        tableModel.setRowCount(0);
        for (Account user : listUsers) {
            tableModel.addRow(new Object[]{
                user.getUserName(),user.getFull_Name(),user.getClass_Name(),user.getPhone()
            });
        }
    }
    //xóa tài khoản sinh viên khỏi database
    public void delete() {
        selectedRow = tbUsers.getSelectedRow();
        //kiểm tra danh sách tài khoản rỗng và dòng chọn
        if (listUsers.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane,
                    "Danh sách tài khoản trống!");
        } else if (selectedRow == -1) {
            JOptionPane.showMessageDialog(rootPane,
                    "Chưa chọn dòng cần xóa!");
        } else {
            int dialogResult = JOptionPane.showConfirmDialog(rootPane,
                    "Bạn có chắc muốn xoá?", "Xóa", JOptionPane.YES_NO_OPTION);
            if (dialogResult == 0) {
                try {
                    //xóa 
                    String id = listUsers.get(selectedRow).getUserName();
                        if (new ResultDAO().deleteResultByUserName(id) && new AccountDAO().delete(id)) {
                            load();
                            JOptionPane.showMessageDialog(rootPane, "Xoá thành công");
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Xóa thất bại!");
                        }
                } catch (HeadlessException e) {
                    JOptionPane.showMessageDialog(rootPane, "Lỗi " + e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }

    //hàm reset mật khẩu về mặc định
    public void reset() {
        selectedRow = tbUsers.getSelectedRow();
        if (listUsers.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane,
                    "Danh sách tài khoản trống!");
        } else if (selectedRow == -1) {
            JOptionPane.showMessageDialog(rootPane,
                    "Chưa chọn tài khoản cần reset mật khẩu!");
        } else {
            
            int dialogResult = JOptionPane.showConfirmDialog(rootPane,
                    "Bạn có chắc muốn reset mật khẩu của tài khoản này?", "Reset", JOptionPane.YES_NO_OPTION);
            if (dialogResult == 0) {
                try {
                    String id = listUsers.get(selectedRow).getUserName();
                    
                        if (new AccountDAO().reset(id)) {

                            load();

                            JOptionPane.showMessageDialog(rootPane, "Reset thành công");
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Reset thất bại!");
                        }
                } catch (HeadlessException e) {
                    JOptionPane.showMessageDialog(rootPane, "Lỗi " + e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUsers = new javax.swing.JTable();
        btnResetPass = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnGetBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(199, 228, 235));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản lý tài khoản sinh viên");

        jPanel1.setBackground(new java.awt.Color(199, 228, 235));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bảo trì TK", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        tbUsers.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        tbUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "User name", "Họ tên", "Lớp", "Số điện thoại"
            }
        ));
        tbUsers.setRowHeight(30);
        jScrollPane1.setViewportView(tbUsers);

        btnResetPass.setBackground(new java.awt.Color(51, 102, 255));
        btnResetPass.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnResetPass.setForeground(new java.awt.Color(255, 255, 255));
        btnResetPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Edit.png"))); // NOI18N
        btnResetPass.setText("Reset mật khẩu");
        btnResetPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetPassActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(51, 102, 255));
        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Delete.png"))); // NOI18N
        btnDelete.setText("Xóa tài khoản");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnGetBack.setBackground(new java.awt.Color(255, 153, 153));
        btnGetBack.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGetBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Back.png"))); // NOI18N
        btnGetBack.setText("Quay lại");
        btnGetBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(btnResetPass)
                .addGap(41, 41, 41)
                .addComponent(btnDelete)
                .addGap(44, 44, 44)
                .addComponent(btnGetBack, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnResetPass, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGetBack))
                .addGap(19, 19, 19))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnDelete, btnGetBack});

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(442, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(45, 45, 45)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        delete();
        load();
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnResetPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetPassActionPerformed
        // TODO add your handling code here:
        reset();
        load();
    }//GEN-LAST:event_btnResetPassActionPerformed

    private void btnGetBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetBackActionPerformed
        // TODO add your handling code here:
        int rt = JOptionPane.showConfirmDialog(this,"Về trang chủ?","confirm",JOptionPane.YES_NO_OPTION);
        if(rt == JOptionPane.YES_OPTION){
            this.dispose();
        }
    }//GEN-LAST:event_btnGetBackActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_AccountManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_AccountManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_AccountManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_AccountManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_AccountManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnGetBack;
    private javax.swing.JButton btnResetPass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbUsers;
    // End of variables declaration//GEN-END:variables
}
