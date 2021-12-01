package Form;

import DbIn_Out.AnswerDAO;
import DbIn_Out.QuestionDAO;
import Model.Question;
import java.awt.HeadlessException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class Frm_QuestionManagement extends javax.swing.JFrame {

    private List<Question> listQuestion;
    DefaultTableModel tableModel;
    int selectedRow = 0;

    public Frm_QuestionManagement() {
        this.setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        tableModel = (DefaultTableModel) tbQuestion.getModel();
        this.setTitle("Phần mềm trắc nghiệm");
        loadData();
    }

    //load danh sách câu hỏi
    public void loadData() {
        try {
            listQuestion = new QuestionDAO().getAllQuestion();
            if(listQuestion.isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Danh sách câu hỏi trống!");
            }
            tableModel.setRowCount(0);

            listQuestion.forEach((Question question) -> {
                tableModel.addRow(new Object[]{
                    question.getQuestion_Id(), question.getQuestion_Content(),
                    question.getChapter_Id(), question.getLevel_Id()
                });
            });
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Lỗi " + e.toString());
        }
    }

    //sắp xếp câu hỏi theo chương hoặc độ khó
    public void sortDataBy(String key) {
        if (key == "Chapter") {
            listQuestion = new QuestionDAO().sortListByChapter();
        } else {
            listQuestion = new QuestionDAO().sortListByLevel();
        }
        tableModel.setRowCount(0);

        listQuestion.forEach((Question question) -> {
            tableModel.addRow(new Object[]{
                question.getQuestion_Id(), question.getQuestion_Content(),
                question.getChapter_Id(), question.getLevel_Id()
            });
        });
    }

    //lọc câu hỏi theo chương và độ khó
    public void filterQuestion() {
        int chapterId = cbFilterChapter.getSelectedIndex();
        int levelId = cbFilterLevel.getSelectedIndex();
        if (chapterId == 0 && levelId == 0) {
            loadData();
        } else {
            listQuestion = new QuestionDAO().filterQuestion(chapterId, levelId);

            tableModel.setRowCount(0);

            listQuestion.forEach((Question question) -> {
                tableModel.addRow(new Object[]{
                    question.getQuestion_Id(), question.getQuestion_Content(),
                    question.getChapter_Id(), question.getLevel_Id()
                });
            });
        }
    }

    //quay lại giao diện trang chủ
    private void exit() {
        int input = JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn rời khỏi trang?", "Exit!!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (input == JOptionPane.YES_OPTION) {
            //quay lại
            this.dispose();
        } else {
            //hủy lệnh quay lại
            this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }

    //xóa câu hỏi
    public void delete() {
        selectedRow = tbQuestion.getSelectedRow();
        //kiểm tra danh sách rỗng và dòng chọn
        if (listQuestion.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane,
                    "Danh sách câu hỏi trống!", "Empty", JOptionPane.OK_OPTION);
        } else if (selectedRow == -1) {
            JOptionPane.showMessageDialog(rootPane,
                    "Chưa chọn dòng cần xóa!");
        } else {
            int dialogResult = JOptionPane.showConfirmDialog(rootPane,
                    "Bạn có muốn xóa câu hỏi này?", "Xóa", JOptionPane.YES_NO_OPTION);
            if (dialogResult == 0) {
                try {
                    int id = listQuestion.get(selectedRow).getQuestion_Id();
                    //xóa 4 đáp án theo Question_ID
                    if (new AnswerDAO().deleteAnswer(id)) {
                        if (new QuestionDAO().deleteQuestion(id)) {

                            loadData();

                            JOptionPane.showMessageDialog(rootPane, "Xoá thành công");
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Xóa thất bại!");
                        }
                    }

                } catch (HeadlessException e) {
                    JOptionPane.showMessageDialog(rootPane, "Lỗi " + e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Hủy xóa", "Thông báo", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnAddnewQuestionDialog = new javax.swing.JButton();
        btnUpdateQuestionDialog = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbFilterChapter = new javax.swing.JComboBox<>();
        cbFilterLevel = new javax.swing.JComboBox<>();
        btnFilter = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnSortByChapter = new javax.swing.JButton();
        btnSortByLevel = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnLoadData = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbQuestion = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(199, 228, 235));

        jPanel1.setBackground(new java.awt.Color(199, 228, 235));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setInheritsPopupMenu(true);

        jPanel2.setBackground(new java.awt.Color(251, 248, 202));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chỉnh sửa câu hỏi ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel2.setToolTipText("");

        btnAddnewQuestionDialog.setBackground(new java.awt.Color(51, 102, 255));
        btnAddnewQuestionDialog.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddnewQuestionDialog.setForeground(new java.awt.Color(255, 255, 255));
        btnAddnewQuestionDialog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/add_16.png"))); // NOI18N
        btnAddnewQuestionDialog.setText("Thêm câu hỏi mới");
        btnAddnewQuestionDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddnewQuestionDialogActionPerformed(evt);
            }
        });

        btnUpdateQuestionDialog.setBackground(new java.awt.Color(51, 102, 255));
        btnUpdateQuestionDialog.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpdateQuestionDialog.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateQuestionDialog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/32px-Crystal_Clear_app_kservices.png"))); // NOI18N
        btnUpdateQuestionDialog.setText("Sửa câu hỏi");
        btnUpdateQuestionDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateQuestionDialogActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(51, 102, 255));
        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Delete.png"))); // NOI18N
        btnDelete.setText("Xóa câu hỏi");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddnewQuestionDialog, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                    .addComponent(btnUpdateQuestionDialog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddnewQuestionDialog, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUpdateQuestionDialog)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAddnewQuestionDialog, btnDelete, btnUpdateQuestionDialog});

        jPanel3.setBackground(new java.awt.Color(251, 248, 202));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lọc dữ liệu ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Chương");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Độ khó");

        cbFilterChapter.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbFilterChapter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả chương", "1", "2", "3", "4" }));

        cbFilterLevel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbFilterLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Dễ", "TB", "Khó" }));

        btnFilter.setBackground(new java.awt.Color(51, 102, 255));
        btnFilter.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnFilter.setForeground(new java.awt.Color(255, 255, 255));
        btnFilter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Filter.png"))); // NOI18N
        btnFilter.setText("Lọc");
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbFilterChapter, 0, 160, Short.MAX_VALUE)
                    .addComponent(cbFilterLevel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbFilterChapter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbFilterLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbFilterChapter, cbFilterLevel, jLabel1, jLabel2});

        jPanel4.setBackground(new java.awt.Color(251, 248, 202));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sắp xếp dữ liệu ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        btnSortByChapter.setBackground(new java.awt.Color(51, 102, 255));
        btnSortByChapter.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSortByChapter.setForeground(new java.awt.Color(255, 255, 255));
        btnSortByChapter.setText("Theo chương");
        btnSortByChapter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortByChapterActionPerformed(evt);
            }
        });

        btnSortByLevel.setBackground(new java.awt.Color(51, 102, 255));
        btnSortByLevel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSortByLevel.setForeground(new java.awt.Color(255, 255, 255));
        btnSortByLevel.setText("Theo độ khó");
        btnSortByLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortByLevelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSortByLevel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSortByChapter, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSortByChapter, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSortByLevel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnSortByChapter, btnSortByLevel});

        jPanel5.setBackground(new java.awt.Color(251, 248, 202));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng hệ thống ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        btnLoadData.setBackground(new java.awt.Color(51, 102, 255));
        btnLoadData.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLoadData.setForeground(new java.awt.Color(255, 255, 255));
        btnLoadData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/reload.png"))); // NOI18N
        btnLoadData.setText("Tải dữ liệu");
        btnLoadData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadDataActionPerformed(evt);
            }
        });

        btnClose.setBackground(new java.awt.Color(255, 153, 153));
        btnClose.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Back.png"))); // NOI18N
        btnClose.setText("Quay lại");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLoadData, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLoadData, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnClose)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnClose, btnLoadData});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Danh sách câu hỏi");

        tbQuestion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbQuestion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nội dung", "Chương", "Độ khó"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbQuestion.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        tbQuestion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbQuestion.setRequestFocusEnabled(false);
        tbQuestion.setRowHeight(30);
        tbQuestion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbQuestionMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbQuestion);
        if (tbQuestion.getColumnModel().getColumnCount() > 0) {
            tbQuestion.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbQuestion.getColumnModel().getColumn(0).setMaxWidth(50);
            tbQuestion.getColumnModel().getColumn(1).setPreferredWidth(1400);
            tbQuestion.getColumnModel().getColumn(1).setMaxWidth(1400);
            tbQuestion.getColumnModel().getColumn(2).setPreferredWidth(100);
            tbQuestion.getColumnModel().getColumn(2).setMaxWidth(100);
            tbQuestion.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbQuestion.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 147, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        exit();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        exit();
    }//GEN-LAST:event_formWindowClosing

    private void btnLoadDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadDataActionPerformed
        // TODO add your handling code here:
        loadData();
    }//GEN-LAST:event_btnLoadDataActionPerformed

    private void btnAddnewQuestionDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddnewQuestionDialogActionPerformed
        // TODO add your handling code here:
        Dialog_AddQuestion addDialog = new Dialog_AddQuestion(this, rootPaneCheckingEnabled);
        addDialog.setVisible(true);
        loadData();
    }//GEN-LAST:event_btnAddnewQuestionDialogActionPerformed

    private void btnUpdateQuestionDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateQuestionDialogActionPerformed
        // TODO add your handling code here:
        selectedRow = tbQuestion.getSelectedRow();
        if (listQuestion.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane,
                    "Danh sách câu hỏi trống!", "Empty", JOptionPane.OK_OPTION);
        } else if (selectedRow == -1) {
            JOptionPane.showMessageDialog(rootPane,
                    "Chưa chọn dòng cần sửa!");
        } else {
            Dialog_EditQuestion editDialog = new Dialog_EditQuestion(this, rootPaneCheckingEnabled);
            //lấy thông tin câu hỏi cần sửa
            editDialog.getCurrentQuestion(listQuestion.get(selectedRow));
            editDialog.setVisible(true);
            loadData();
        }

    }//GEN-LAST:event_btnUpdateQuestionDialogActionPerformed

    private void tbQuestionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbQuestionMousePressed
        // TODO add your handling code here:
        selectedRow = tbQuestion.getSelectedRow();
    }//GEN-LAST:event_tbQuestionMousePressed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        delete();
        loadData();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSortByChapterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortByChapterActionPerformed
        // TODO add your handling code here:
        sortDataBy("Chapter");
    }//GEN-LAST:event_btnSortByChapterActionPerformed

    private void btnSortByLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortByLevelActionPerformed
        // TODO add your handling code here:
        sortDataBy("Level");
    }//GEN-LAST:event_btnSortByLevelActionPerformed

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        // TODO add your handling code here:
        filterQuestion();
    }//GEN-LAST:event_btnFilterActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(Frm_QuestionManagement.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_QuestionManagement.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_QuestionManagement.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_QuestionManagement.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_QuestionManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddnewQuestionDialog;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnLoadData;
    private javax.swing.JButton btnSortByChapter;
    private javax.swing.JButton btnSortByLevel;
    private javax.swing.JButton btnUpdateQuestionDialog;
    private javax.swing.JComboBox<String> cbFilterChapter;
    private javax.swing.JComboBox<String> cbFilterLevel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbQuestion;
    // End of variables declaration//GEN-END:variables
}
