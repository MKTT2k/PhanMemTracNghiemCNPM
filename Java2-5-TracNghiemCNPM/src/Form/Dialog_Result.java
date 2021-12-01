package Form;

import DbIn_Out.AccountDAO;
import DbIn_Out.QuestionDAO;
import Model.Account;
import Model.Answer;
import Model.Question;
import Model.Result;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public final class Dialog_Result extends javax.swing.JDialog {

    public Dialog_Result(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        
    }
    
    public Dialog_Result(List<Answer> list, Result res) {
        initComponents();
        loadData(list, res);
        this.setLocationRelativeTo(null);
    }

    //Load dữ liệu lên bảng và các trường
    public void loadData(List<Answer> list, Result res) {
        Account user = new AccountDAO().getAUser(res.getUsername() + "");
        jTextFieldName.setText(user.getFull_Name());
        jTextFieldTestCode.setText(res.getTest_Code());
        jTextFieldCorrectQT.setText(res.getNumOfCorrect_Test() + " / " + list.size());
        jTextFieldTime.setText(res.getWorkTime() + " phút");
        DecimalFormat df = new DecimalFormat("###,###.##");
        Double mark = res.getNumOfCorrect_Test() * 10.0 / list.size();
        lblMark.setText(df.format(mark));
        
        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
        list.forEach((Answer answer) -> {
            Question question = new QuestionDAO().getQuestionById(answer.getQuestion_Id());
            tableModel.addRow(new Object[]{
                question.getQuestion_Content(),
                answer.getAnswer_Content(),
                answer.isIs_Correct()
            });
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPaneInfor = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jTextFieldTestCode = new javax.swing.JTextField();
        jTextFieldCorrectQT = new javax.swing.JTextField();
        jTextFieldTime = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lblMark = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPaneInfor.setBackground(new java.awt.Color(199, 228, 235));
        jPaneInfor.setPreferredSize(new java.awt.Dimension(876, 200));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Họ và Tên :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Mã đề :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Số câu đúng :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Thời gian làm :");

        jTextFieldName.setEditable(false);

        jTextFieldTestCode.setEditable(false);

        jTextFieldCorrectQT.setEditable(false);

        jTextFieldTime.setEditable(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Điểm");

        lblMark.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        lblMark.setForeground(new java.awt.Color(255, 51, 51));
        lblMark.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMark.setText("0");
        lblMark.setToolTipText("");
        lblMark.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblMark.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPaneInforLayout = new javax.swing.GroupLayout(jPaneInfor);
        jPaneInfor.setLayout(jPaneInforLayout);
        jPaneInforLayout.setHorizontalGroup(
            jPaneInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaneInforLayout.createSequentialGroup()
                .addGroup(jPaneInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPaneInforLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jTextFieldName, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPaneInforLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPaneInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPaneInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPaneInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldTestCode, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldCorrectQT)
                            .addComponent(jTextFieldTime))))
                .addGap(125, 125, 125)
                .addGroup(jPaneInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMark, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPaneInforLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel6)))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        jPaneInforLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTextFieldCorrectQT, jTextFieldName, jTextFieldTestCode, jTextFieldTime});

        jPaneInforLayout.setVerticalGroup(
            jPaneInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaneInforLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPaneInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPaneInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPaneInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPaneInforLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMark, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPaneInforLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPaneInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldTestCode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPaneInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldCorrectQT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(15, 15, 15)
                        .addGroup(jPaneInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPaneInforLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4, jTextFieldCorrectQT, jTextFieldName, jTextFieldTestCode, jTextFieldTime});

        jPanel1.add(jPaneInfor, java.awt.BorderLayout.PAGE_START);

        jButton1.setBackground(new java.awt.Color(255, 153, 153));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Back.png"))); // NOI18N
        jButton1.setText("Thoát");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, java.awt.BorderLayout.PAGE_END);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Câu hỏi", "Câu trả lời", "True/ False"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(2).setMinWidth(80);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(89);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(80);
        }

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
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
            java.util.logging.Logger.getLogger(Dialog_Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dialog_Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dialog_Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dialog_Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Dialog_Result dialog = new Dialog_Result(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPaneInfor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldCorrectQT;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldTestCode;
    private javax.swing.JTextField jTextFieldTime;
    private javax.swing.JLabel lblMark;
    // End of variables declaration//GEN-END:variables
}
