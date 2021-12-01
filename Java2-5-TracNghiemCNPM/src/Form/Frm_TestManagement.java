package Form;

import DbIn_Out.QuestionDAO;
import DbIn_Out.ResultDAO;
import DbIn_Out.TestDAO;
import DbIn_Out.Test_QuestionDAO;
import Model.Question;
import Model.Test;
import Model.Test_Question;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class Frm_TestManagement extends javax.swing.JFrame {

    private List<Test> listTests; // Tạo danh sách để lưu các đề
    private List<Test_Question> listTestQuestion; //tạo danh sách để lưu các câu hỏi của đề đó
    DefaultTableModel tableModelQuestion;
    DefaultTableModel tableModelTest;
    int selectedRowTest = 0, selectedRowQuestion = 0; // tạo các biến chỉ số để xác định dòng được chọn trong bảng

    public Frm_TestManagement() {
//        this.setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Quản lý đề kiểm tra");
    }

    //Hàm load các đề thi
    public void LoadTableTest() {
        tableModelTest = (DefaultTableModel) tbTest.getModel();
        listTests = new TestDAO().getFullListTest();
        tableModelTest.setRowCount(0);
        listTests.forEach(t -> {
            tableModelTest.addRow(new Object[]{
                t.getTest_Code(), t.getTime(), t.getLevel_Id(), t.isStatus()
            });
        });
    }

    //hàm load câu các câu hỏi cho đề thi
    private void LoadQuestion(String TestCode) {
        tableModelQuestion = (DefaultTableModel) tbQuestion_Test.getModel();
        listTestQuestion = new Test_QuestionDAO().getTest_Question(TestCode);
        tableModelQuestion.setRowCount(0);
        for (Test_Question test_Question : listTestQuestion) {
            Question question = new QuestionDAO().getQuestionById(test_Question.getQuestion_ID());
            tableModelQuestion.addRow(new Object[]{
                test_Question.getQuestion_ID(), question.getQuestion_Content(), question.getChapter_Id(), question.getLevel_Id()
            });
        }
    }

    //hàm so sánh Question_id của câu hỏi với danh sách câu hỏi
    public boolean compare(int question_Id, List<Test_Question> listTest_Question) {
        for (Test_Question test_Question : listTest_Question) {
            if (question_Id == test_Question.getQuestion_ID()) {
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonLoad = new javax.swing.JButton();
        jButtonExit = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbQuestion_Test = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbTest = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btXoaDe = new javax.swing.JButton();
        btSuaDe = new javax.swing.JButton();
        btThemDe = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(199, 228, 235));

        jButtonLoad.setBackground(new java.awt.Color(51, 102, 255));
        jButtonLoad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonLoad.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLoad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/reload.png"))); // NOI18N
        jButtonLoad.setText("Load");
        jButtonLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoadActionPerformed(evt);
            }
        });

        jButtonExit.setBackground(new java.awt.Color(255, 153, 153));
        jButtonExit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Back.png"))); // NOI18N
        jButtonExit.setText("Quay lại");
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });

        tbQuestion_Test.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã câu", "Câu hỏi", "Chương", "Độ khó"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(tbQuestion_Test);
        if (tbQuestion_Test.getColumnModel().getColumnCount() > 0) {
            tbQuestion_Test.getColumnModel().getColumn(0).setMinWidth(75);
            tbQuestion_Test.getColumnModel().getColumn(0).setMaxWidth(75);
            tbQuestion_Test.getColumnModel().getColumn(2).setMinWidth(125);
            tbQuestion_Test.getColumnModel().getColumn(2).setMaxWidth(125);
        }

        tbTest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã đề", "Thời gian(Phút)", "Độ khó", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbTest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbTestMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbTestMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(tbTest);
        if (tbTest.getColumnModel().getColumnCount() > 0) {
            tbTest.getColumnModel().getColumn(0).setMinWidth(75);
            tbTest.getColumnModel().getColumn(0).setMaxWidth(75);
            tbTest.getColumnModel().getColumn(1).setMinWidth(150);
            tbTest.getColumnModel().getColumn(1).setMaxWidth(150);
            tbTest.getColumnModel().getColumn(2).setMinWidth(150);
        }

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Danh sách câu hỏi");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản Lý Đề Thi");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Danh sách đề thi");

        btXoaDe.setBackground(new java.awt.Color(51, 102, 255));
        btXoaDe.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btXoaDe.setForeground(new java.awt.Color(255, 255, 255));
        btXoaDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Delete.png"))); // NOI18N
        btXoaDe.setText("Xóa đề");
        btXoaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaDeActionPerformed(evt);
            }
        });

        btSuaDe.setBackground(new java.awt.Color(51, 102, 255));
        btSuaDe.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btSuaDe.setForeground(new java.awt.Color(255, 255, 255));
        btSuaDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/32px-Quick_restart.png"))); // NOI18N
        btSuaDe.setText("Đổi câu hỏi");
        btSuaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaDeActionPerformed(evt);
            }
        });

        btThemDe.setBackground(new java.awt.Color(51, 102, 255));
        btThemDe.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btThemDe.setForeground(new java.awt.Color(255, 255, 255));
        btThemDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Add1.png"))); // NOI18N
        btThemDe.setText("Thêm đề");
        btThemDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemDejButtonAddTestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jButtonLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btThemDe)
                .addGap(18, 18, 18)
                .addComponent(btXoaDe, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131)
                .addComponent(btSuaDe, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(158, 158, 158))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btThemDe, btXoaDe, jButtonLoad});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btSuaDe, jButtonExit});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(406, 406, 406)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btThemDe)
                    .addComponent(btXoaDe)
                    .addComponent(btSuaDe)
                    .addComponent(jButtonExit))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(111, 111, 111)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(61, Short.MAX_VALUE)))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btSuaDe, btThemDe, btXoaDe, jButtonExit, jButtonLoad});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btThemDejButtonAddTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemDejButtonAddTestActionPerformed
        // TODO add your handling code here:
        Dialog_AddTest addTest = new Dialog_AddTest(this, rootPaneCheckingEnabled);
        addTest.setVisible(true);
        LoadTableTest();
    }//GEN-LAST:event_btThemDejButtonAddTestActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
//        testsLoad();
    }//GEN-LAST:event_formWindowOpened

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        // TODO add your handling code here:
        int rt = JOptionPane.showConfirmDialog(this, "Về trang chủ?", "confirm", JOptionPane.YES_NO_OPTION);
        if (rt == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void tbTestMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTestMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbTestMousePressed

    private void tbTestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTestMouseClicked
        // TODO add your handling code here:
        selectedRowTest = tbTest.getSelectedRow();
        if (selectedRowTest >= 0) {
            String TestCode = (String) tbTest.getValueAt(selectedRowTest, 0);
            LoadQuestion(TestCode);
        }
    }//GEN-LAST:event_tbTestMouseClicked

    private void jButtonLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoadActionPerformed
        // TODO add your handling code here:
        LoadTableTest();
        if (listTests.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Danh sách đề thi rỗng");
        } else {
            tableModelQuestion = (DefaultTableModel) tbQuestion_Test.getModel();
            tableModelQuestion.setRowCount(0);
        }
    }//GEN-LAST:event_jButtonLoadActionPerformed

    private void btXoaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaDeActionPerformed
        // TODO add your handling code here:
        try {
            selectedRowTest = tbTest.getSelectedRow();
            //kiểm tra danh sach đề thi rỗng và dòng chọn
            if (listTests.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane,
                        "Danh sách đề thi trống!", "Empty", JOptionPane.OK_OPTION);
                return;
            } else if (selectedRowTest == -1) {
                JOptionPane.showMessageDialog(rootPane,
                        "Chưa chọn đề cần xóa!");
                return;
            } else {// thông báo xóa và kiểm tra xóa thành công?
                int dialogResult = JOptionPane.showConfirmDialog(rootPane,
                        "Bạn có muốn xóa đề này?", "Xóa", JOptionPane.YES_NO_OPTION);
                if (dialogResult == 0) {
                    String testCode = listTests.get(selectedRowTest).getTest_Code();
                    if (new Test_QuestionDAO().deleteTest_Question(testCode) && new ResultDAO().deleteResult(testCode)) {
                        if (new TestDAO().deleteTest(testCode)) {
                            LoadTableTest();
                            JOptionPane.showMessageDialog(rootPane, "Xoá thành công");
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Xóa thất bại!");
                        }
                    }
                }
            }
            tableModelQuestion.setRowCount(0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Lỗi " + e.toString());
        }
    }//GEN-LAST:event_btXoaDeActionPerformed

    private void btSuaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaDeActionPerformed
        // TODO add your handling code here:
        try {
            selectedRowTest = tbTest.getSelectedRow();
            selectedRowQuestion = tbQuestion_Test.getSelectedRow();
            //kiểm tra dòng chọn
            if (listTests.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Danh sách đề thi trống!", "Empty", JOptionPane.OK_OPTION);
            } else if (selectedRowTest == -1) {
                JOptionPane.showMessageDialog(rootPane, "Chưa chọn đề cần đổi câu hỏi!");
            } else if (selectedRowQuestion == -1) {
                JOptionPane.showMessageDialog(rootPane, "Chưa chọn câu hỏi cần đổi!");
            } else {
                //lấy ra mã câu hỏi, độ khó của câu hỏi cần đổi
                int level = (int) tbQuestion_Test.getValueAt(selectedRowQuestion, 3);
                int Question_Id = (int) tbQuestion_Test.getValueAt(selectedRowQuestion, 0);
                //tạo list câu hỏi cùng độ khó với câu hỏi cần đổi
                String test_Code = (String) tbTest.getValueAt(selectedRowTest, 0);

                List<Question> change = new QuestionDAO().getQuestionByLevel(level);
                listTestQuestion = new Test_QuestionDAO().getAllTest_Question(test_Code);
                Random r = new Random();
                int i = 0;
                while (true) {
                    i = r.nextInt(change.size());
                    Question question = change.get(i);
                    if (compare(question.getQuestion_Id(), listTestQuestion)) {
                        if (new Test_QuestionDAO().delete1Test_Question(test_Code, Question_Id)) {
                            new Test_QuestionDAO().insertTestQuestion(test_Code, question.getQuestion_Id());
                            LoadQuestion(test_Code);
                            return;
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Không thể đổi câu hỏi");
                        }
                    } else {
                        change.remove(question);
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Lỗi " + e.toString());
        }
    }//GEN-LAST:event_btSuaDeActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_TestManagement.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_TestManagement.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_TestManagement.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_TestManagement.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_TestManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSuaDe;
    private javax.swing.JButton btThemDe;
    private javax.swing.JButton btXoaDe;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonLoad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable tbQuestion_Test;
    private javax.swing.JTable tbTest;
    // End of variables declaration//GEN-END:variables
}
