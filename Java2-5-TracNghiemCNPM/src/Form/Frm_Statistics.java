package Form;

import DbIn_Out.AccountDAO;
import DbIn_Out.ResultDAO;
import Model.Account;
import Model.Result;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public final class Frm_Statistics extends javax.swing.JFrame {

    private List<Result> listResult = null;
    private Account a;
    DefaultTableModel tableModelResult;

    public Frm_Statistics() {
        this.setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        tableModelResult = (DefaultTableModel) tbAllResult.getModel();
        getAllTest_Code();
        loadAllResult(cbFilterTest_Code.getSelectedItem().toString());

    }

    //lấy ra tất cả các Test_Code trong database
    public void getAllTest_Code() {
        listResult = new ResultDAO().getAllTest_CodeResult();
        if (listResult.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Chưa có kết quả bài test nào!");
            cbFilterTest_Code.addItem("Trống");
            return;
        }
        listResult.forEach(result -> {
            cbFilterTest_Code.addItem(result.getTest_Code());
        });
    }

    //Lấy ra tất cả các kết quả theo Test_Code
    public void loadAllResult(String Test_Code) {
        try {
            if (Test_Code.equals("Trống")) {
                tableModelResult.addRow(new Object[]{
                    "##", "###", "######", "##", "#.##"
                });
            } else {
                listResult = new ResultDAO().getAllResultByTest_Code(Test_Code);

                tableModelResult.setRowCount(0);
                DecimalFormat decimalFormat = new DecimalFormat("###,###.##");
                listResult.forEach(result -> {
                    a = new AccountDAO().getAUser(result.getUsername());
                    double mark = result.getNumOfCorrect_Test() * 0.4;
                    tableModelResult.addRow(new Object[]{
                        tableModelResult.getRowCount() + 1, result.getUsername(),
                        a.getFull_Name(), result.getWorkTime(), decimalFormat.format(mark)
                    });
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Lỗi " + e.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cbFilterTest_Code = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAllResult = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(199, 228, 235));

        cbFilterTest_Code.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbFilterTest_CodeItemStateChanged(evt);
            }
        });

        tbAllResult.setAutoCreateRowSorter(true);
        tbAllResult.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbAllResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã sinh viên", "Họ tên sinh viên", "Thời gian làm bài", "Điểm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbAllResult.setRowHeight(30);
        tbAllResult.setShowHorizontalLines(false);
        jScrollPane1.setViewportView(tbAllResult);
        if (tbAllResult.getColumnModel().getColumnCount() > 0) {
            tbAllResult.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbAllResult.getColumnModel().getColumn(0).setMaxWidth(50);
            tbAllResult.getColumnModel().getColumn(1).setPreferredWidth(150);
            tbAllResult.getColumnModel().getColumn(1).setMaxWidth(150);
            tbAllResult.getColumnModel().getColumn(2).setPreferredWidth(500);
            tbAllResult.getColumnModel().getColumn(2).setMaxWidth(500);
            tbAllResult.getColumnModel().getColumn(3).setPreferredWidth(150);
            tbAllResult.getColumnModel().getColumn(3).setMaxWidth(150);
            tbAllResult.getColumnModel().getColumn(4).setPreferredWidth(100);
            tbAllResult.getColumnModel().getColumn(4).setMaxWidth(100);
        }

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Mã đề kiểm tra");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THỐNG KÊ KẾT QUẢ ");

        jButton1.setBackground(new java.awt.Color(255, 153, 153));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Back.png"))); // NOI18N
        jButton1.setText("Quay lại");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(132, 132, 132))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbFilterTest_Code, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 798, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbFilterTest_Code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbFilterTest_Code, jLabel2});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbFilterTest_CodeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbFilterTest_CodeItemStateChanged
        // TODO add your handling code here:
        loadAllResult(cbFilterTest_Code.getSelectedItem().toString());
    }//GEN-LAST:event_cbFilterTest_CodeItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int rt = JOptionPane.showConfirmDialog(this, "Về trang chủ?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (rt == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_Statistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Statistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Statistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Statistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Frm_Statistics().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbFilterTest_Code;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbAllResult;
    // End of variables declaration//GEN-END:variables

}
