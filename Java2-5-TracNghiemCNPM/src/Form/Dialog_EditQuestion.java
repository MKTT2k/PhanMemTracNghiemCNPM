package Form;

import DbIn_Out.AnswerDAO;
import DbIn_Out.QuestionDAO;
import Model.Answer;
import Model.Question;
import java.awt.HeadlessException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class Dialog_EditQuestion extends javax.swing.JDialog {

    private final Frm_QuestionManagement adminForm;

    public Dialog_EditQuestion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        adminForm = (Frm_QuestionManagement) parent;
        this.setTitle("Sửa thông tin câu hỏi");
    }
    
    //Lấy thông tin câu hỏi cần sửa
    public void getCurrentQuestion(Question question) {
        txtQuestionID.setText(question.getQuestion_Id() + "");
        txtQuestionContent.setText(question.getQuestion_Content() + "");
        txtQuestionContent.requestFocus();
        cbChapter.setSelectedIndex(question.getChapter_Id() - 1);
        switch (question.getLevel_Id()) {
            case 1 ->
                rbEasy.setSelected(true);
            case 2 ->
                rbNomal.setSelected(true);
            default ->
                rbHard.setSelected(true);
        }
        
        //Lấy ra 4 câu trả lời tương ứng
        List<Answer> listAnswer = new AnswerDAO().getAnswerByQuestionID(question.getQuestion_Id());
        txtAnswerA.setText(listAnswer.get(0).getAnswer_Content());
        if (listAnswer.get(0).isIs_Correct()) {
            rbAisCorrect.setSelected(true);
        }

        txtAnswerB.setText(listAnswer.get(1).getAnswer_Content());
        if (listAnswer.get(1).isIs_Correct()) {
            rbBisCorrect.setSelected(true);
        }

        txtAnswerC.setText(listAnswer.get(2).getAnswer_Content());
        if (listAnswer.get(2).isIs_Correct()) {
            rbCisCorrect.setSelected(true);
        }

        txtAnswerD.setText(listAnswer.get(3).getAnswer_Content());
        if (listAnswer.get(3).isIs_Correct()) {
            rbDisCorrect.setSelected(true);
        }

    }

    //hàm cập nhật câu hỏi và câu trả lời
    public void updateQuestion() {
        try {
            Question question = new Question(Integer.parseInt(txtQuestionID.getText() + ""));
            if (txtQuestionContent == null || txtQuestionContent.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(rootPane, "Chưa nhập nội dung câu hỏi", "Empty", JOptionPane.WARNING_MESSAGE);
                return;
            }
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

            List<Answer> listAnswer = new AnswerDAO().getAnswerByQuestionID(question.getQuestion_Id());
            listAnswer.get(0).setAnswer_Content(txtAnswerA.getText() + "");
            listAnswer.get(0).setIs_Correct(rbAisCorrect.isSelected());

            listAnswer.get(1).setAnswer_Content(txtAnswerB.getText() + "");
            listAnswer.get(1).setIs_Correct(rbBisCorrect.isSelected());

            listAnswer.get(2).setAnswer_Content(txtAnswerC.getText() + "");
            listAnswer.get(2).setIs_Correct(rbCisCorrect.isSelected());

            listAnswer.get(3).setAnswer_Content(txtAnswerD.getText() + "");
            listAnswer.get(3).setIs_Correct(rbDisCorrect.isSelected());

            adminForm.loadData();
            int save = JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn lưu kết quả", "Lưu", JOptionPane.YES_NO_OPTION);
            if (save == JOptionPane.YES_OPTION) {
                if (new QuestionDAO().update(question)) {
                    JOptionPane.showMessageDialog(rootPane, "Lưu thành công !");
                    new AnswerDAO().update(listAnswer.get(0));
                    new AnswerDAO().update(listAnswer.get(1));
                    new AnswerDAO().update(listAnswer.get(2));
                    new AnswerDAO().update(listAnswer.get(3));
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Lưu thất bại", "Thông báo", JOptionPane.WARNING_MESSAGE);
                }
            } else JOptionPane.showMessageDialog(rootPane, "Hủy lưu", "Thông báo", JOptionPane.WARNING_MESSAGE);
            this.dispose();
        } catch (HeadlessException e) {
            JOptionPane.showConfirmDialog(rootPane, "Lỗi " + e.toString());
        }
        return;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgLevel = new javax.swing.ButtonGroup();
        bgCorrectAnswer = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        txtQuestionContent = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        rbCisCorrect = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        txtAnswerB = new javax.swing.JTextField();
        txtAnswerA = new javax.swing.JTextField();
        rbDisCorrect = new javax.swing.JRadioButton();
        txtQuestionID = new javax.swing.JTextField();
        txtAnswerD = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtAnswerC = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        rbEasy = new javax.swing.JRadioButton();
        rbNomal = new javax.swing.JRadioButton();
        rbHard = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        btnGetBack = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cbChapter = new javax.swing.JComboBox<>();
        rbBisCorrect = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rbAisCorrect = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 204));

        jPanel2.setBackground(new java.awt.Color(199, 228, 235));

        btnSave.setBackground(new java.awt.Color(51, 102, 255));
        btnSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Save1.png"))); // NOI18N
        btnSave.setText("Lưu");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        txtQuestionContent.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Đáp án B");

        bgCorrectAnswer.add(rbCisCorrect);
        rbCisCorrect.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbCisCorrect.setText("Đáp án đúng");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Chương");

        txtAnswerB.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtAnswerA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        bgCorrectAnswer.add(rbDisCorrect);
        rbDisCorrect.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbDisCorrect.setText("Đáp án đúng");

        txtQuestionID.setEditable(false);
        txtQuestionID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtAnswerD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Mã câu hỏi");

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SỬA CÂU HỎI ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Đáp án D");

        txtAnswerC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

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

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Đáp án A");

        btnGetBack.setBackground(new java.awt.Color(255, 153, 153));
        btnGetBack.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGetBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Back.png"))); // NOI18N
        btnGetBack.setText("Quay lại");
        btnGetBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetBackActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Độ khó");

        cbChapter.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbChapter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));

        bgCorrectAnswer.add(rbBisCorrect);
        rbBisCorrect.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbBisCorrect.setText("Đáp án đúng");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nội dung câu hỏi");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Đáp án C");

        bgCorrectAnswer.add(rbAisCorrect);
        rbAisCorrect.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbAisCorrect.setText("Đáp án đúng");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAnswerC)
                                    .addComponent(txtAnswerB)
                                    .addComponent(txtAnswerA)
                                    .addComponent(txtAnswerD))
                                .addGap(40, 40, 40)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(rbCisCorrect, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rbBisCorrect, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rbAisCorrect, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rbDisCorrect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtQuestionContent)
                                .addGap(32, 32, 32))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtQuestionID, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbChapter, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(109, 109, 109)
                                        .addComponent(btnGetBack)))
                                .addGap(132, 132, 132)))
                        .addGap(51, 51, 51))))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(2, 2, 2)))
                    .addContainerGap(640, Short.MAX_VALUE)))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQuestionID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQuestionContent, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtAnswerA, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(txtAnswerB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtAnswerC, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtAnswerD, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rbAisCorrect)
                        .addGap(18, 18, 18)
                        .addComponent(rbBisCorrect)
                        .addGap(18, 18, 18)
                        .addComponent(rbCisCorrect)
                        .addGap(18, 18, 18)
                        .addComponent(rbDisCorrect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(cbChapter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGetBack)
                    .addComponent(btnSave))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(167, 167, 167)
                    .addComponent(jLabel3)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel4)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel5)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel7)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(66, Short.MAX_VALUE)))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnGetBack, btnSave, cbChapter, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9, jPanel1, rbAisCorrect, rbBisCorrect, rbCisCorrect, rbDisCorrect});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtAnswerA, txtAnswerB, txtAnswerC, txtAnswerD, txtQuestionContent, txtQuestionID});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGetBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetBackActionPerformed
        // TODO add your handling code here:
        updateQuestion();
        this.dispose();
    }//GEN-LAST:event_btnGetBackActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        updateQuestion();
    }//GEN-LAST:event_btnSaveActionPerformed

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
            java.util.logging.Logger.getLogger(Dialog_EditQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dialog_EditQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dialog_EditQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dialog_EditQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Dialog_EditQuestion dialog = new Dialog_EditQuestion(new javax.swing.JFrame(), true);
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
    private javax.swing.ButtonGroup bgCorrectAnswer;
    private javax.swing.ButtonGroup bgLevel;
    private javax.swing.JButton btnGetBack;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbChapter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JTextField txtQuestionID;
    // End of variables declaration//GEN-END:variables
}
