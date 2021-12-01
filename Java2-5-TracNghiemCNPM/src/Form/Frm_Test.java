package Form;

import DbIn_Out.AnswerDAO;
import DbIn_Out.QuestionDAO;
import DbIn_Out.ResultDAO;
import DbIn_Out.TestDAO;
import DbIn_Out.Test_QuestionDAO;
import Model.Account;
import Model.Answer;
import Model.Question;
import Model.Result;
import Model.Test;
import Model.Test_Question;
import java.util.ArrayList;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public final class Frm_Test extends javax.swing.JFrame {

    Account userLogin; //tạo ra đối tượng đăng nhập để làm bài
    List<Test> listTest = null; //để lưu danh sách đề thi
    List<Answer> listAnswerCorrect = new ArrayList<>(); //để lưu danh sách câu trả lời đúng
    List<Answer> listChoose = new ArrayList<>();// để lưu danh sách các câu trả lời đã chọn
    List<String> choose = new ArrayList<String>();// để lưu danh sách các đáp án A,B,C, D đã chọn
    List<Test_Question> listTQ = null; //để lưu dánh sách các câu hỏi của đề
    Thread thread;
    boolean timeout=true;
    Result result = new Result();
    DefaultTableModel tableModelTest;
    int selectedRow = 0, tg = 0;
    int numOfCorrect_Test = 0;
    
    public Frm_Test() {
        initComponents();
        setLocationRelativeTo(null);

    }

    //khởi tạo giao diện test với tài khoản vừa đăng nhập
    public Frm_Test(Account a) {
        this.setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        btnSubmit.setVisible(false);
        lblName.setText(a.getFull_Name());
        lblClass.setText(a.getClass_Name());
        lblUserName.setText(a.getUserName());
        lblDate.setText(Date.valueOf(LocalDate.now()) + "");
        txtQuestion.setEditable(false);
        txtA.setEditable(false);
        txtB.setEditable(false);
        txtC.setEditable(false);
        txtD.setEditable(false);
        btnTest.setEnabled(false);
        jPanelSubmit.setVisible(false);
        jPanelAnswer.setVisible(false);
        jPanelQuestion.setVisible(false);
        userLogin = a;
        LoadTableTest();
    }

    //hàm đếm ngược thời gian làm bài
    private void loadTime(JLabel time) {
        thread = new Thread() {
            @Override
            public void run() {
                int minus = 20, second = -1;
                while (timeout == true) {
                    try {
                        if (second == -1) {
                            second = 59;
                            minus--;
                            tg++;
                        }
                        if (second <= 9) {
                            time.setText(minus + ":0" + second);
                        } else {
                            time.setText(minus + ":" + second);
                        }
                        if (minus == 0 && second == 0) {
                            //hết giờ, kiểm tra có muốn xem kết quả không?
                            int i = JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn xem kết quả không", "Hết giờ", JOptionPane.YES_NO_OPTION);
                            if (i == 0) {
                                int now = Integer.parseInt(lblNumber.getText()) - 1;
                                if (listChoose.get(now).isIs_Correct()) {
                                    numOfCorrect_Test--;
                                }
                                Answer answerChoose = new Answer();
                                choose(answerChoose, now);
                                listChoose.set(now, answerChoose);
                                submitResult();
                                seeResult();
                                loadAfterTest();
                            } else {
                                int now = Integer.parseInt(lblNumber.getText()) - 1;
                                if (listChoose.get(now).isIs_Correct()) {
                                    numOfCorrect_Test--;
                                }
                                Answer answerChoose = new Answer();
                                choose(answerChoose, now);
                                listChoose.set(now, answerChoose);
                                submitResult();
                                loadAfterTest();
                            }
                            break;
                        }
                        --second;
                        thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Frm_Test.class.getName()).log(Level.SEVERE, null, ex);
                    }
                };
            }
        };
        thread.start();
    }

    //Hàm load bảng danh sách đề
    public void LoadTableTest() {
        lblTime.setText("00:00");
        listTest = new TestDAO().getListTested(userLogin.getUserName());
        tableModelTest = (DefaultTableModel) jTableTest.getModel();
        tableModelTest.setRowCount(0);
        listTest.forEach(t -> {
            tableModelTest.addRow(new Object[]{
                t.getTest_Code(), t.getTime(), t.getLevel_Id()
            });
        });
    }

    //hàm lấy danh sách câu hỏi
    private List<Test_Question> loadListQuestion() {
        selectedRow = jTableTest.getSelectedRow();
        String testCode = null;
        if (selectedRow >= 0) {
            testCode = (String) jTableTest.getValueAt(selectedRow, 0);
            lblTestCode.setText(testCode);
            listTQ = new Test_QuestionDAO().getAllTest_Question(testCode);
            for (int i = 0; i < listTQ.size(); i++) {
                choose.add("");
                listChoose.add(new Answer(i, "", false, listTQ.get(i).getQuestion_ID()));
                listAnswerCorrect.add(new AnswerDAO().getCorrectAnswer(listTQ.get(i).getQuestion_ID()));
            }
            lblSum.setText("/" + listTQ.size());
        }
        return listTQ;
    }

    // hàm xem đáp án dược lựa chọn
    public void selectCurrentOption(int num) {
        if (choose.get(num) == "A") {
            rbA.setSelected(true);
        } else if (choose.get(num) == "B") {
            rbB.setSelected(true);
        } else if (choose.get(num) == "C") {
            rbC.setSelected(true);
        } else if (choose.get(num) == "D") {
            rbD.setSelected(true);
        }
    }

    //hàm lấy 1 câu hỏi của đề để đưa ra màn hình
    private void get1Question(int index) {
        lblNumber.setText((index + 1) + "");
        Question Q = new QuestionDAO().getQuestionById(listTQ.get(index).getQuestion_ID());// lấy các câu hỏi từ database
        txtQuestion.setText(Q.getQuestion_Content());
        List<Answer> listA = new AnswerDAO().getAnswerByQuestionID(Q.getQuestion_Id());// Lấy nội dung các câu trả lời và đưa vào các trường đáp án
        txtA.setText(listA.get(0).getAnswer_Content());
        txtB.setText(listA.get(1).getAnswer_Content());
        txtC.setText(listA.get(2).getAnswer_Content());
        txtD.setText(listA.get(3).getAnswer_Content());
    }

    //hàm lưu kết quả vào database
    public void submitResult() {
        result.setUsername(userLogin.getUserName());
        result.setTest_Code(lblTestCode.getText());
        Date now = Date.valueOf(LocalDate.now());
        result.setDate(now);
        result.setWorkTime(tg);
        result.setNumOfCorrect_Test(numOfCorrect_Test);
        if (new ResultDAO().insertResult(result) == false) {
            JOptionPane.showMessageDialog(rootPane, "Không lưu được đáp án!");
        }
    }

    //Hàm xem kết quả
    public void seeResult() {
        Dialog_Result resultTestForm = new Dialog_Result(listChoose, result);
        resultTestForm.pack();
        resultTestForm.setVisible(true);
        if (thread.getState() == Thread.State.WAITING) {
            thread.stop();
        }
    }

    //hàm lưu các đáp án đã lựa chọn, kiểm tra đúng sai cho các đáp án đó và đếm số câu đúng
    private void choose(Answer answerChoose, int now) {
        try {
            answerChoose.setQuestion_Id(listTQ.get(now).getQuestion_ID());
            answerChoose.setIs_Correct(false);
            if (rbA.isSelected()) {
                choose.set(now, "A");
                answerChoose.setAnswer_Content(txtA.getText());
                if ((txtA.getText().equals(listAnswerCorrect.get(now).getAnswer_Content()))) {
                    answerChoose.setIs_Correct(true);
                    numOfCorrect_Test++;
                }
            } else if (rbB.isSelected()) {
                choose.set(now, "B");
                answerChoose.setAnswer_Content(txtB.getText());
                if (txtB.getText().equals(listAnswerCorrect.get(now).getAnswer_Content())) {
                    answerChoose.setIs_Correct(true);
                    numOfCorrect_Test++;
                }
            } else if (rbC.isSelected()) {
                choose.set(now, "C");
                answerChoose.setAnswer_Content(txtC.getText());
                if (txtC.getText().equals(listAnswerCorrect.get(now).getAnswer_Content())) {
                    answerChoose.setIs_Correct(true);
                    numOfCorrect_Test++;
                }
            } else if (rbD.isSelected()) {
                choose.set(now, "D");
                answerChoose.setAnswer_Content(txtD.getText());
                if (txtC.getText().equals(listAnswerCorrect.get(now).getAnswer_Content())) {
                    answerChoose.setIs_Correct(true);
                    numOfCorrect_Test++;
                }
            } else {
                choose.set(now, "");
                answerChoose.setAnswer_Content("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }

    //hàm load lại giao diện sau khi hoàn thành bài thi
    private void loadAfterTest() {
        jPanelQuestion.setVisible(false);
        jPanelAnswer.setVisible(false);
        jPanelListTest.setVisible(true);
        jPanelSubmit.setVisible(false);
        btnTest.setEnabled(false);
        btnLoadTest.setEnabled(true);
        jPanelDashboard.setVisible(true);
        LoadTableTest();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgAnwser = new javax.swing.ButtonGroup();
        jPanelInformation = new javax.swing.JPanel();
        lblTime = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblClass = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        lblTestCode = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jPanelDashboard = new javax.swing.JPanel();
        btnLoadTest = new javax.swing.JButton();
        btnTest = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jPanelMain = new javax.swing.JPanel();
        jPanelExam = new javax.swing.JPanel();
        jPanelQuestion = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtQuestion = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        lblNumber = new javax.swing.JLabel();
        lblSum = new javax.swing.JLabel();
        jPanelAnswer = new javax.swing.JPanel();
        rbA = new javax.swing.JRadioButton();
        rbC = new javax.swing.JRadioButton();
        rbD = new javax.swing.JRadioButton();
        rbB = new javax.swing.JRadioButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtC = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtA = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtD = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtB = new javax.swing.JTextArea();
        jPanelSubmit = new javax.swing.JPanel();
        btnNext = new javax.swing.JButton();
        btnPress = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        jPanelListTest = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTest = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trắc nghiệm công nghệ phần mềm");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanelInformation.setBackground(new java.awt.Color(199, 228, 235));

        lblTime.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTime.setForeground(new java.awt.Color(255, 0, 51));
        lblTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTime.setText("00:00");

        lblName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Lớp:");
        jLabel2.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Họ tên:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Tên tài khoản:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Mã đề:");

        lblClass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblUserName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblTestCode.setBackground(new java.awt.Color(199, 228, 235));
        lblTestCode.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Ngày thi");

        lblDate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDate.setText("jLabel6");

        javax.swing.GroupLayout jPanelInformationLayout = new javax.swing.GroupLayout(jPanelInformation);
        jPanelInformation.setLayout(jPanelInformationLayout);
        jPanelInformationLayout.setHorizontalGroup(
            jPanelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInformationLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                    .addComponent(lblClass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInformationLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTestCode, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelInformationLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(jPanelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDate)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanelInformationLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel5, lblDate});

        jPanelInformationLayout.setVerticalGroup(
            jPanelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInformationLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanelInformationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5)
                    .addGroup(jPanelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblUserName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInformationLayout.createSequentialGroup()
                        .addComponent(lblDate)
                        .addGap(0, 5, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInformationLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblClass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                            .addComponent(lblTestCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        jPanelInformationLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel4, jLabel5, lblDate});

        jPanelDashboard.setBackground(new java.awt.Color(199, 228, 235));
        jPanelDashboard.setForeground(new java.awt.Color(255, 255, 255));

        btnLoadTest.setBackground(new java.awt.Color(51, 102, 255));
        btnLoadTest.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        btnLoadTest.setForeground(new java.awt.Color(255, 255, 255));
        btnLoadTest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/register.png"))); // NOI18N
        btnLoadTest.setText("Danh sách đề");
        btnLoadTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadTestActionPerformed(evt);
            }
        });

        btnTest.setBackground(new java.awt.Color(51, 102, 255));
        btnTest.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnTest.setForeground(new java.awt.Color(255, 255, 255));
        btnTest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/nhatky.png"))); // NOI18N
        btnTest.setText("Làm bài");
        btnTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTestActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(255, 153, 153));
        btnBack.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Back.png"))); // NOI18N
        btnBack.setText("Quay lại");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDashboardLayout = new javax.swing.GroupLayout(jPanelDashboard);
        jPanelDashboard.setLayout(jPanelDashboardLayout);
        jPanelDashboardLayout.setHorizontalGroup(
            jPanelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnLoadTest, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnTest, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelDashboardLayout.setVerticalGroup(
            jPanelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDashboardLayout.createSequentialGroup()
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnLoadTest, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109)
                .addComponent(btnTest, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelMain.setBackground(new java.awt.Color(199, 228, 235));

        txtQuestion.setColumns(20);
        txtQuestion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtQuestion.setRows(5);
        jScrollPane2.setViewportView(txtQuestion);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Câu số:");

        lblNumber.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblNumber.setText("0");

        lblSum.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSum.setText("/25");

        javax.swing.GroupLayout jPanelQuestionLayout = new javax.swing.GroupLayout(jPanelQuestion);
        jPanelQuestion.setLayout(jPanelQuestionLayout);
        jPanelQuestionLayout.setHorizontalGroup(
            jPanelQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelQuestionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(jPanelQuestionLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lblNumber)
                .addGap(18, 18, 18)
                .addComponent(lblSum)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelQuestionLayout.setVerticalGroup(
            jPanelQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelQuestionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblNumber)
                    .addComponent(lblSum))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bgAnwser.add(rbA);
        rbA.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        rbA.setText("A:");
        rbA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAActionPerformed(evt);
            }
        });

        bgAnwser.add(rbC);
        rbC.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        rbC.setText("C:");

        bgAnwser.add(rbD);
        rbD.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        rbD.setText("D:");

        bgAnwser.add(rbB);
        rbB.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        rbB.setText("B:");

        txtC.setColumns(20);
        txtC.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtC.setRows(5);
        jScrollPane3.setViewportView(txtC);

        txtA.setColumns(20);
        txtA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtA.setRows(5);
        jScrollPane4.setViewportView(txtA);

        txtD.setColumns(20);
        txtD.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtD.setRows(5);
        jScrollPane5.setViewportView(txtD);

        txtB.setColumns(20);
        txtB.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtB.setRows(5);
        jScrollPane6.setViewportView(txtB);

        jPanelSubmit.setBackground(new java.awt.Color(153, 153, 255));

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/NextArrow.png"))); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnPress.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/PresArrow.png"))); // NOI18N
        btnPress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPressActionPerformed(evt);
            }
        });

        btnSubmit.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnSubmit.setText("Hoàn thành");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelSubmitLayout = new javax.swing.GroupLayout(jPanelSubmit);
        jPanelSubmit.setLayout(jPanelSubmitLayout);
        jPanelSubmitLayout.setHorizontalGroup(
            jPanelSubmitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSubmitLayout.createSequentialGroup()
                .addContainerGap(409, Short.MAX_VALUE)
                .addComponent(btnPress)
                .addGap(73, 73, 73)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(187, 187, 187)
                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        jPanelSubmitLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnNext, btnPress});

        jPanelSubmitLayout.setVerticalGroup(
            jPanelSubmitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSubmitLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSubmitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanelSubmitLayout.createSequentialGroup()
                        .addComponent(btnPress, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelAnswerLayout = new javax.swing.GroupLayout(jPanelAnswer);
        jPanelAnswer.setLayout(jPanelAnswerLayout);
        jPanelAnswerLayout.setHorizontalGroup(
            jPanelAnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAnswerLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanelAnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rbA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelAnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addComponent(jScrollPane6))
                .addGap(76, 76, 76)
                .addGroup(jPanelAnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rbC, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelAnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addComponent(jScrollPane5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelAnswerLayout.createSequentialGroup()
                .addComponent(jPanelSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanelAnswerLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {rbA, rbB, rbC, rbD});

        jPanelAnswerLayout.setVerticalGroup(
            jPanelAnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAnswerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbC)
                    .addComponent(rbA)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelAnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbB)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbD))
                .addGap(18, 18, 18)
                .addComponent(jPanelSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanelAnswerLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jScrollPane3, jScrollPane5, jScrollPane6});

        jPanelAnswerLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {rbC, rbD});

        javax.swing.GroupLayout jPanelExamLayout = new javax.swing.GroupLayout(jPanelExam);
        jPanelExam.setLayout(jPanelExamLayout);
        jPanelExamLayout.setHorizontalGroup(
            jPanelExamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelExamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelExamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelAnswer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanelExamLayout.setVerticalGroup(
            jPanelExamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelExamLayout.createSequentialGroup()
                .addComponent(jPanelQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelExam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelExam, javax.swing.GroupLayout.PREFERRED_SIZE, 501, Short.MAX_VALUE)
        );

        jPanelListTest.setBackground(new java.awt.Color(199, 228, 235));

        jTableTest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã đề", "Thời gian (Phút)", "Độ khó"
            }
        ));
        jTableTest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTestMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableTest);

        javax.swing.GroupLayout jPanelListTestLayout = new javax.swing.GroupLayout(jPanelListTest);
        jPanelListTest.setLayout(jPanelListTestLayout);
        jPanelListTestLayout.setHorizontalGroup(
            jPanelListTestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListTestLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 974, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelListTestLayout.setVerticalGroup(
            jPanelListTestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListTestLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelListTest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanelInformation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelInformation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelListTest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jPanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanelDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoadTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadTestActionPerformed
        // TODO add your handling code here:
        listTest = new TestDAO().getListTested(userLogin.getUserName());
        if (listTest.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Danh sách đề thi trống");
        }
        btnTest.setEnabled(false);
        LoadTableTest();
    }//GEN-LAST:event_btnLoadTestActionPerformed

    private void rbAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbAActionPerformed

    private void btnTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTestActionPerformed
        // TODO add your handling code here:
        jPanelListTest.setVisible(false);
        jPanelSubmit.setVisible(true);
        lblTime.setVisible(true);
        btnSubmit.setVisible(true);
        jPanelDashboard.setVisible(false);
        tg = 0;
        numOfCorrect_Test = 0;
        bgAnwser.clearSelection();

        btnNext.setEnabled(true);
        loadListQuestion();
        get1Question(Integer.parseInt(lblNumber.getText()));
        loadTime(lblTime);
        jPanelSubmit.setVisible(true);
        jPanelAnswer.setVisible(true);
        jPanelQuestion.setVisible(true);
        btnPress.setEnabled(false);
        txtA.setWrapStyleWord(false);
        txtA.setLineWrap(true);
        txtB.setWrapStyleWord(false);
        txtB.setLineWrap(true);
        txtC.setWrapStyleWord(false);
        txtC.setLineWrap(true);
        txtD.setWrapStyleWord(false);
        txtD.setLineWrap(true);
    }//GEN-LAST:event_btnTestActionPerformed

    private void jTableTestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTestMouseClicked
        // TODO add your handling code here:
        btnTest.setEnabled(true);
        lblTestCode.setText("");
        lblNumber.setText("0");
        listChoose.removeAll(listChoose);
        choose.removeAll(choose);
        listAnswerCorrect.removeAll(listAnswerCorrect);
    }//GEN-LAST:event_jTableTestMouseClicked

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        //lưu câu trả lời cho câu hỏi trước và tải câu hỏi tiếp theo
        int now = Integer.parseInt(lblNumber.getText()) - 1;
        btnPress.setEnabled(true);
        if (now + 2 == listTQ.size()) {
            btnNext.setEnabled(false);
        }
        if (listChoose.get(now).isIs_Correct()) {
            numOfCorrect_Test--;
        }
        Answer answerChoose = new Answer();
        choose(answerChoose, now);
        listChoose.set(now, answerChoose);
        bgAnwser.clearSelection();
        get1Question(now + 1);
        selectCurrentOption(now + 1);
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPressActionPerformed
        // TODO add your khandling code here:
        //lưu câu trả lời cho câu hỏi trước và tải câu hỏi tiếp theo
        int now = Integer.parseInt(lblNumber.getText()) - 1;
        btnNext.setEnabled(true);
        if (now == 1) {
            btnPress.setEnabled(false);
        }
        if (listChoose.get(now).isIs_Correct()) {
            numOfCorrect_Test--;
        }
        Answer answerChoose = new Answer();
        choose(answerChoose, now);
        listChoose.set(now, answerChoose);
        bgAnwser.clearSelection();
        get1Question(now - 1);
        selectCurrentOption(now - 1);
    }//GEN-LAST:event_btnPressActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        try {
            int now = Integer.parseInt(lblNumber.getText()) - 1;
            if (listChoose.get(now).isIs_Correct()) {
                numOfCorrect_Test--;
            }
            Answer answerChoose = new Answer();
            choose(answerChoose, now);
            listChoose.set(now, answerChoose);
            //khi ấn hoàn thành thì lưu câu trả lời hiện tại, dừng thời gian và hiện giao diện xem kết quả
            thread.stop();
            submitResult();
            seeResult();
            loadAfterTest();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        int rt = JOptionPane.showConfirmDialog(this, "Về trang chủ?", "confirm", JOptionPane.YES_NO_OPTION);
        if (rt == JOptionPane.YES_OPTION) {
            this.dispose();
        } else
            this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_Test.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Test.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Test.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Test.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Frm_Test().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgAnwser;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnLoadTest;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPress;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnTest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanelAnswer;
    private javax.swing.JPanel jPanelDashboard;
    private javax.swing.JPanel jPanelExam;
    private javax.swing.JPanel jPanelInformation;
    private javax.swing.JPanel jPanelListTest;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelQuestion;
    private javax.swing.JPanel jPanelSubmit;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTableTest;
    private javax.swing.JLabel lblClass;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNumber;
    private javax.swing.JLabel lblSum;
    private javax.swing.JLabel lblTestCode;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JRadioButton rbA;
    private javax.swing.JRadioButton rbB;
    private javax.swing.JRadioButton rbC;
    private javax.swing.JRadioButton rbD;
    private javax.swing.JTextArea txtA;
    private javax.swing.JTextArea txtB;
    private javax.swing.JTextArea txtC;
    private javax.swing.JTextArea txtD;
    private javax.swing.JTextArea txtQuestion;
    // End of variables declaration//GEN-END:variables
}
