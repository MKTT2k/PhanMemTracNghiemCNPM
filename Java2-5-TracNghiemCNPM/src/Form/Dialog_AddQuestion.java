package Form;

import DbIn_Out.AnswerDAO;
import DbIn_Out.QuestionDAO;
import Model.Answer;
import Model.Question;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class Dialog_AddQuestion extends javax.swing.JDialog {

    List<Question> listQuestion = new ArrayList<>();
    private Frm_QuestionManagement adminForm;

    public Dialog_AddQuestion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Thêm câu hỏi");
        adminForm = (Frm_QuestionManagement) parent;
    }
    
    //xóa nội dung nhập
    public void clearInput() {
        txtQuestionContent.setText("");
        txtQuestionContent.requestFocus();
        txtAnswerA.setText("");
        txtAnswerB.setText("");
        txtAnswerC.setText("");
        txtAnswerD.setText("");
        bgCorrect.clearSelection();
        bgLevel.clearSelection();
        cbChapter.setSelectedIndex(0);
    }

    //kiểm tra các trường trống?
    public boolean isEmpty() {
        return txtQuestionContent.getText().trim().length() == 0
                && txtAnswerA.getText().trim().length() == 0
                && txtAnswerB.getText().trim().length() == 0
                && txtAnswerC.getText().trim().length() == 0
                && txtAnswerD.getText().trim().length() == 0;
    }
    
    //hàm thêm câu hỏi
    public void insert() {
        try {
            //khởi tạo câu hỏi mới
            Question question = new Question();

            //tạo Question_Id mới
            int newQuestionID = new QuestionDAO().getLastQuestionID() + 1;

            if (txtQuestionContent.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(rootPane, "Chưa nhập nội dung câu hỏi", "Empty", JOptionPane.WARNING_MESSAGE);
                return;
            }
            //Đặt các thuộc tính cho câu hỏi
            question.setQuestion_Content(txtQuestionContent.getText() + "");
            question.setChapter_Id(cbChapter.getSelectedIndex() + 1);
            if (rbEasy.isSelected()) {
                question.setLevel_Id(1);
            } else if (rbNomal.isSelected()) {
                question.setLevel_Id(2);
            } else if (rbHard.isSelected()) {
                question.setLevel_Id(3);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Chưa chọn độ khó", "NULL", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (!rbAisCorrect.isSelected() && !rbBisCorrect.isSelected()
                    && !rbCisCorrect.isSelected() && !rbDisCorrect.isSelected()) {
                JOptionPane.showMessageDialog(rootPane, "Chưa chọn câu trả lời đúng", "NULL", JOptionPane.WARNING_MESSAGE);
                return;
            }

            boolean addQuestion = new QuestionDAO().insert(question);
            //khởi tạo 4 câu trả lời tương ứng

            Answer asA = new Answer();
            asA.setAnswer_Content(txtAnswerA.getText() + "");
            asA.setIs_Correct(rbAisCorrect.isSelected());
            asA.setQuestion_Id(newQuestionID);

            Answer asB = new Answer();
            asB.setAnswer_Content(txtAnswerB.getText() + "");
            asB.setIs_Correct(rbBisCorrect.isSelected());
            asB.setQuestion_Id(newQuestionID);

            Answer asC = new Answer();
            asC.setAnswer_Content(txtAnswerC.getText() + "");
            asC.setIs_Correct(rbCisCorrect.isSelected());
            asC.setQuestion_Id(newQuestionID);

            Answer asD = new Answer();
            asD.setAnswer_Content(txtAnswerD.getText() + "");
            asD.setIs_Correct(rbDisCorrect.isSelected());
            asD.setQuestion_Id(newQuestionID);

            boolean addAnswerA = new AnswerDAO().insert(asA);
            boolean addAnswerB = new AnswerDAO().insert(asB);
            boolean addAnswerC = new AnswerDAO().insert(asC);
            boolean addAnswerD = new AnswerDAO().insert(asD);

            if (addQuestion == addAnswerA == addAnswerB == addAnswerC == addAnswerD == true) {
                adminForm.loadData();
                int dialogResult = JOptionPane.showConfirmDialog(rootPane,
                        "Thêm thành công! Tiếp tục?", "Thành công",
                        JOptionPane.YES_NO_OPTION);
                if (dialogResult == 1) {
                    this.dispose();
                } else {
                    clearInput();
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Không thêm được");
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, "Lỗi " + e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgCorrect = new javax.swing.ButtonGroup();
        bgLevel = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbChapter = new javax.swing.JComboBox<>();
        txtQuestionContent = new javax.swing.JTextField();
        txtAnswerA = new javax.swing.JTextField();
        txtAnswerB = new javax.swing.JTextField();
        txtAnswerC = new javax.swing.JTextField();
        txtAnswerD = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        rbEasy = new javax.swing.JRadioButton();
        rbNomal = new javax.swing.JRadioButton();
        rbHard = new javax.swing.JRadioButton();
        btnSave = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnGetBack = new javax.swing.JButton();
        rbAisCorrect = new javax.swing.JRadioButton();
        rbBisCorrect = new javax.swing.JRadioButton();
        rbCisCorrect = new javax.swing.JRadioButton();
        rbDisCorrect = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(199, 228, 235));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Đáp án A");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nội dung câu hỏi");

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÊM CÂU HỎI MỚI ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Đáp án D");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Đáp án B");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Đáp án C");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Chương");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Độ khó");

        cbChapter.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbChapter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));

        txtQuestionContent.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtAnswerA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtAnswerB.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtAnswerC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtAnswerD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(199, 228, 235));

        rbEasy.setBackground(new java.awt.Color(199, 228, 235));
        bgLevel.add(rbEasy);
        rbEasy.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbEasy.setText("Dễ");
        jPanel1.add(rbEasy);

        rbNomal.setBackground(new java.awt.Color(199, 228, 235));
        bgLevel.add(rbNomal);
        rbNomal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbNomal.setText("Trung bình");
        jPanel1.add(rbNomal);

        rbHard.setBackground(new java.awt.Color(199, 228, 235));
        bgLevel.add(rbHard);
        rbHard.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbHard.setText("Khó");
        jPanel1.add(rbHard);

        btnSave.setBackground(new java.awt.Color(51, 102, 255));
        btnSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Add1.png"))); // NOI18N
        btnSave.setText("Thêm");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(51, 102, 255));
        btnClear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/clear.png"))); // NOI18N
        btnClear.setText("Xóa nội dung nhập");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
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

        bgCorrect.add(rbAisCorrect);
        rbAisCorrect.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbAisCorrect.setText("Đáp án đúng");

        bgCorrect.add(rbBisCorrect);
        rbBisCorrect.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbBisCorrect.setText("Đáp án đúng");
        rbBisCorrect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbBisCorrectActionPerformed(evt);
            }
        });

        bgCorrect.add(rbCisCorrect);
        rbCisCorrect.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbCisCorrect.setText("Đáp án đúng");

        bgCorrect.add(rbDisCorrect);
        rbDisCorrect.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbDisCorrect.setText("Đáp án đúng");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 62, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtQuestionContent, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtAnswerA)
                                    .addComponent(cbChapter, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAnswerD, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                    .addComponent(txtAnswerC)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAnswerB))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbDisCorrect)
                                    .addComponent(rbCisCorrect)
                                    .addComponent(rbBisCorrect)
                                    .addComponent(rbAisCorrect)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addGap(73, 73, 73)
                        .addComponent(btnClear)
                        .addGap(63, 63, 63)
                        .addComponent(btnGetBack)))
                .addGap(0, 70, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQuestionContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAnswerA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbAisCorrect)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAnswerB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(rbBisCorrect))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAnswerC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(rbCisCorrect))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAnswerD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(rbDisCorrect))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbChapter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGetBack)
                    .addComponent(btnClear)
                    .addComponent(btnSave))
                .addGap(18, 18, 18))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnClear, btnGetBack, btnSave, cbChapter, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9, rbAisCorrect, rbBisCorrect, rbCisCorrect, rbDisCorrect, txtAnswerA, txtAnswerB, txtAnswerC, txtAnswerD, txtQuestionContent});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbBisCorrectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbBisCorrectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbBisCorrectActionPerformed

    private void btnGetBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetBackActionPerformed
        // TODO add your handling code here:
        if (isEmpty())
            this.dispose();
        else {
            int input = JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn thêm câu hỏi mới?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (input == JOptionPane.YES_OPTION) {
                insert();
            }else{
                this.dispose();
            }
        }
    }//GEN-LAST:event_btnGetBackActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        clearInput();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        insert();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if (isEmpty())
            this.dispose();
        else {
            int input = JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn thêm câu hỏi mới?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (input == JOptionPane.YES_OPTION) {
                insert();
            }else{
                this.dispose();
            }
        }
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(Dialog_AddQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dialog_AddQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dialog_AddQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dialog_AddQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Dialog_AddQuestion dialog = new Dialog_AddQuestion(new javax.swing.JFrame(), true);
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
    private javax.swing.ButtonGroup bgCorrect;
    private javax.swing.ButtonGroup bgLevel;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnGetBack;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbChapter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton rbAisCorrect;
    private javax.swing.JRadioButton rbBisCorrect;
    private javax.swing.JRadioButton rbCisCorrect;
    private javax.swing.JRadioButton rbDisCorrect;
    private javax.swing.JRadioButton rbEasy;
    private javax.swing.JRadioButton rbHard;
    private javax.swing.JRadioButton rbNomal;
    private javax.swing.JTextField txtAnswerA;
    private javax.swing.JTextField txtAnswerB;
    private javax.swing.JTextField txtAnswerC;
    private javax.swing.JTextField txtAnswerD;
    private javax.swing.JTextField txtQuestionContent;
    // End of variables declaration//GEN-END:variables
}
