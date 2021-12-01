package Form;

import Model.Account;

/**
 *
 * @author ADMIN
 */
public class Frm_Teacher_Home extends javax.swing.JFrame {

    public Frm_Teacher_Home() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public Frm_Teacher_Home(Account u) {
        this.setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnEditAccount = new javax.swing.JButton();
        btnEditQuestion = new javax.swing.JButton();
        btnCreateTest = new javax.swing.JButton();
        btnThongKe = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(199, 228, 235));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 255));
        jLabel3.setText("Đăng xuất");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PHẦN MỀM TRẮC NGHIỆM CÔNG NGHỆ PHẦN MỀM");

        btnEditAccount.setBackground(new java.awt.Color(51, 102, 255));
        btnEditAccount.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnEditAccount.setForeground(new java.awt.Color(255, 255, 255));
        btnEditAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Customers.png"))); // NOI18N
        btnEditAccount.setText("Bảo trì tài khoản sinh viên");
        btnEditAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditAccountActionPerformed(evt);
            }
        });

        btnEditQuestion.setBackground(new java.awt.Color(51, 102, 255));
        btnEditQuestion.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnEditQuestion.setForeground(new java.awt.Color(255, 255, 255));
        btnEditQuestion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/32px-Crystal_Clear_app_package_settings.png"))); // NOI18N
        btnEditQuestion.setText("Quản lý câu hỏi");
        btnEditQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditQuestionActionPerformed(evt);
            }
        });

        btnCreateTest.setBackground(new java.awt.Color(51, 102, 255));
        btnCreateTest.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnCreateTest.setForeground(new java.awt.Color(255, 255, 255));
        btnCreateTest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/32px-Crystal_Clear_app_package_utilities.png"))); // NOI18N
        btnCreateTest.setText("Quản lý đề thi");
        btnCreateTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateTestActionPerformed(evt);
            }
        });

        btnThongKe.setBackground(new java.awt.Color(51, 102, 255));
        btnThongKe.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnThongKe.setForeground(new java.awt.Color(255, 255, 255));
        btnThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/chucvu.png"))); // NOI18N
        btnThongKe.setText("Thống kê");
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/home1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEditQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCreateTest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditAccount, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                .addGap(184, 184, 184))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditAccount)
                .addGap(18, 18, 18)
                .addComponent(btnEditQuestion)
                .addGap(18, 18, 18)
                .addComponent(btnCreateTest)
                .addGap(18, 18, 18)
                .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCreateTest, btnEditAccount, btnEditQuestion, btnThongKe});

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

    private void btnEditAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditAccountActionPerformed
        // TODO add your handling code here:
        new Frm_AccountManagement().show();
    }//GEN-LAST:event_btnEditAccountActionPerformed

    private void btnEditQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditQuestionActionPerformed
        // TODO add your handling code here:
        Frm_QuestionManagement questionManagement = new Frm_QuestionManagement();
        questionManagement.setVisible(true);
    }//GEN-LAST:event_btnEditQuestionActionPerformed

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        // TODO add your handling code here:
        Frm_Statistics statisticsForm = new Frm_Statistics();
        statisticsForm.setVisible(true);
    }//GEN-LAST:event_btnThongKeActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void btnCreateTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateTestActionPerformed
        // TODO add your handling code here:
        new Frm_TestManagement().show();
    }//GEN-LAST:event_btnCreateTestActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        this.dispose();
        new Frm_Login().show();
    }//GEN-LAST:event_jLabel3MouseClicked

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
            java.util.logging.Logger.getLogger(Frm_Teacher_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Teacher_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Teacher_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Teacher_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Teacher_Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateTest;
    private javax.swing.JButton btnEditAccount;
    private javax.swing.JButton btnEditQuestion;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
