package Form;

import DbIn_Out.QuestionDAO;
import DbIn_Out.TestDAO;
import DbIn_Out.Test_QuestionDAO;
import Model.Question;
import Model.Test;
import Model.Test_Question;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class Dialog_AddTest extends javax.swing.JDialog {

    public Dialog_AddTest(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }
    
    //hàm tạo câu hỏi cho đề thi mới
    public List<Question> createTest_Question(int level) {
        // tạo ra các list chứa các câu hỏi cùng loại
        List<Question> EzQuestion = new QuestionDAO().getQuestionByLevel(1);
        List<Question> NmQuestion = new QuestionDAO().getQuestionByLevel(2);
        List<Question> HrQuestion = new QuestionDAO().getQuestionByLevel(3);
        // tạo ra list chứa 25 câu hỏi của 1 đề
        List<Question> ListQ_T = new ArrayList<>();
        Question Q = null;
        Random r = new Random();
        try {
            if (level == 1) { //tạo đề dễ 15easy-5normal-5hard
                for (int i = 0; i < 15; i++) {
                    int j = r.nextInt(EzQuestion.size());
                    ListQ_T.add(EzQuestion.get(j));
                    EzQuestion.remove(j);
                }
                for (int i = 0; i < 5; i++) {
                    int j = r.nextInt(NmQuestion.size());
                    ListQ_T.add(NmQuestion.get(j));
                    NmQuestion.remove(j);
                }
                for (int i = 0; i < 5; i++) {
                    int j = r.nextInt(HrQuestion.size());
                    ListQ_T.add(HrQuestion.get(j));
                    HrQuestion.remove(j);
                }
            }
            if (level == 2) { //tạo đề trung bình 5easy-15normal-5hard
                for (int i = 0; i < 5; i++) {
                    int j = r.nextInt(EzQuestion.size());
                    ListQ_T.add(EzQuestion.get(j));
                    EzQuestion.remove(j);
                }
                for (int i = 0; i < 15; i++) {
                    int j = r.nextInt(NmQuestion.size());
                    ListQ_T.add(NmQuestion.get(j));
                    NmQuestion.remove(j);
                }
                for (int i = 0; i < 5; i++) {
                    int j = r.nextInt(HrQuestion.size());
                    ListQ_T.add(HrQuestion.get(j));
                    HrQuestion.remove(j);
                }
            }
            if (level == 3) { //tạo đề khó 5easy-5normal-15hard
                for (int i = 0; i < 5; i++) {
                    int j = r.nextInt(EzQuestion.size());
                    ListQ_T.add(EzQuestion.get(j));
                    EzQuestion.remove(j);
                }
                for (int i = 0; i < 5; i++) {
                    int j = r.nextInt(NmQuestion.size());
                    ListQ_T.add(NmQuestion.get(j));
                    NmQuestion.remove(j);
                }
                for (int i = 0; i < 15; i++) {
                    int j = r.nextInt(HrQuestion.size());
                    ListQ_T.add(HrQuestion.get(j));
                    HrQuestion.remove(j);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Không thêm được câu hỏi");
            return null;
        }
        return ListQ_T;
    }
    
    //hàm thêm đề thi mới
    private void addTest() {
        try {
            //kiểm tra trường mã đề có trống không?
            Test test = new Test();
            if (jTextFieldTestCode == null || jTextFieldTestCode.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(rootPane, "Chưa nhập mã đề", "Empty", JOptionPane.WARNING_MESSAGE);
                return;
            }
            //kiểm tra mã đề có trùng với mã đề đã có trong database không?
            TestDAO testDAO = new TestDAO();
            List<Test> listTest = testDAO.getFullListTest();
            test.setTest_Code(jTextFieldTestCode.getText());
            if (listTest.contains(test)) {
                JOptionPane.showMessageDialog(rootPane, "Đề thi bị trùng!");
                return;
            }
            //kiểm tra đã chọn độ khó cho đề chưa?
            if (jRadioButtonEazy.isSelected() == true) {
                test.setLevel_Id(1);
            } else if (jRadioButtonNormal.isSelected() == true) {
                test.setLevel_Id(2);
            } else if (jRadioButtonHard.isSelected() == true) {
                test.setLevel_Id(3);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Chưa chọn độ khó đề");
                return;
            }
            Test_Question T_Q = new Test_Question();
            T_Q.setTest_Code(test.getTest_Code());
            List<Question> ListQ = createTest_Question(test.getLevel_Id());
            if (ListQ == null) {
                JOptionPane.showMessageDialog(rootPane, "Thêm thất bại!");
                return;
            }
            if (testDAO.insertTest(test)) { // nếu thêm thành công thì add test_question
                for (Question question : ListQ) { //test_question có testid lấy từ ở trên còn question_id lấy ở từng câu hỏi ở trong list câu hỏi
                    new Test_QuestionDAO().insertTestQuestion(T_Q.getTest_Code(), question.getQuestion_Id()); // 1 mã đề thì tạo ra 25 test_question rồi lưu nó vào bảng test question
                }
                JOptionPane.showMessageDialog(rootPane, "Thêm thành công");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Thêm thất bại!");
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(rootPane, "Lỗi " + e.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgLevelTest = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jRadioButtonEazy = new javax.swing.JRadioButton();
        jRadioButtonNormal = new javax.swing.JRadioButton();
        jRadioButtonHard = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldTestCode = new javax.swing.JTextField();
        jButtonBack = new javax.swing.JButton();
        jButtonAddTest = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(199, 228, 235));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bgLevelTest.add(jRadioButtonEazy);
        jRadioButtonEazy.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonEazy.setText("Easy");
        jPanel1.add(jRadioButtonEazy, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 114, 72, -1));

        bgLevelTest.add(jRadioButtonNormal);
        jRadioButtonNormal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonNormal.setText("Normal");
        jPanel1.add(jRadioButtonNormal, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 114, 77, -1));

        bgLevelTest.add(jRadioButtonHard);
        jRadioButtonHard.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonHard.setText("Hard");
        jPanel1.add(jRadioButtonHard, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 114, 80, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 255));
        jLabel1.setText("Tạo đề mới");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 120, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Mã đề");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 55, 55, -1));
        jPanel1.add(jTextFieldTestCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 49, 235, 33));

        jButtonBack.setBackground(new java.awt.Color(255, 153, 153));
        jButtonBack.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Back.png"))); // NOI18N
        jButtonBack.setText("Quay lại");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 120, 40));

        jButtonAddTest.setBackground(new java.awt.Color(51, 102, 255));
        jButtonAddTest.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonAddTest.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAddTest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/add_16.png"))); // NOI18N
        jButtonAddTest.setText("Thêm");
        jButtonAddTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddTestActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAddTest, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 110, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jButtonAddTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddTestActionPerformed
        // TODO add your handling code here:
        addTest();

    }//GEN-LAST:event_jButtonAddTestActionPerformed

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
            java.util.logging.Logger.getLogger(Dialog_AddTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dialog_AddTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dialog_AddTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dialog_AddTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                Dialog_AddTest dialog = new Dialog_AddTest(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgLevelTest;
    private javax.swing.JButton jButtonAddTest;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButtonEazy;
    private javax.swing.JRadioButton jRadioButtonHard;
    private javax.swing.JRadioButton jRadioButtonNormal;
    private javax.swing.JTextField jTextFieldTestCode;
    // End of variables declaration//GEN-END:variables
}
