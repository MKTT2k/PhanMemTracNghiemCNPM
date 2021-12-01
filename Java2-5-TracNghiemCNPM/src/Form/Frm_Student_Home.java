package Form;

import Model.Account;

/**
 *
 * @author ADMIN
 */
public class Frm_Student_Home extends javax.swing.JFrame {

    public Frm_Student_Home() {
        initComponents();

    }
    Account userLogin;

    Frm_Student_Home(Account u) {
        this.setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        userLogin = u;
        txtname.setText(u.getFull_Name());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnDoTest = new javax.swing.JButton();
        btnResult = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtname = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnUpdateInfo = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 255));

        jPanel1.setBackground(new java.awt.Color(199, 228, 235));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PHẦN MỀM TRẮC NGHIỆM CÔNG NGHỆ PHẦN MỀM");

        btnDoTest.setBackground(new java.awt.Color(51, 102, 255));
        btnDoTest.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnDoTest.setForeground(new java.awt.Color(255, 255, 255));
        btnDoTest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/nhatky.png"))); // NOI18N
        btnDoTest.setText("Làm bài");
        btnDoTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoTestActionPerformed(evt);
            }
        });

        btnResult.setBackground(new java.awt.Color(51, 102, 255));
        btnResult.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnResult.setForeground(new java.awt.Color(255, 255, 255));
        btnResult.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/chucvu.png"))); // NOI18N
        btnResult.setText("Xem thống kê");
        btnResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResultActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 255));
        jLabel3.setText("Đăng xuất");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        txtname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtname.setText("name");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnUpdateInfo.setBackground(new java.awt.Color(51, 102, 255));
        btnUpdateInfo.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnUpdateInfo.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Customers.png"))); // NOI18N
        btnUpdateInfo.setText("Cập nhật thông tin cá nhân");
        btnUpdateInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateInfoActionPerformed(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/home1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 764, Short.MAX_VALUE)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtname)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpdateInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                    .addComponent(btnDoTest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(213, 213, 213))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(202, 202, 202)
                    .addComponent(jLabel1)
                    .addContainerGap(641, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(txtname)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(28, 28, 28)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(30, 30, 30)
                .addComponent(btnUpdateInfo)
                .addGap(33, 33, 33)
                .addComponent(btnDoTest)
                .addGap(33, 33, 33)
                .addComponent(btnResult, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(jLabel1)
                    .addContainerGap(454, Short.MAX_VALUE)))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnDoTest, btnResult, btnUpdateInfo});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        this.dispose();
        new Frm_Login().show();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void btnResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResultActionPerformed
        // TODO add your handling code here:
        Frm_Statistics statisticsForm = new Frm_Statistics();
        statisticsForm.setVisible(true);
    }//GEN-LAST:event_btnResultActionPerformed

    private void btnDoTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoTestActionPerformed
        // TODO add your handling code here:
        new Frm_Test(userLogin).show();
    }//GEN-LAST:event_btnDoTestActionPerformed

    private void btnUpdateInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateInfoActionPerformed
        // TODO add your handling code here:
        new Frm_UpdateInfo_Student(userLogin).show();
    }//GEN-LAST:event_btnUpdateInfoActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_Student_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Student_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Student_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Student_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Student_Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDoTest;
    private javax.swing.JButton btnResult;
    private javax.swing.JButton btnUpdateInfo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel txtname;
    // End of variables declaration//GEN-END:variables
}
