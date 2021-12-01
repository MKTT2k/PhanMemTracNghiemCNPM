/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbIn_Out;

import Model.Question;
import java.sql.Statement;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author ADMIN
 */
public class QuestionDAO {

    public QuestionDAO() {
    }

    public List<Question> getAllQuestion() {
        Connection connection = null;
        //get data from database
        Statement statement = null;
        //create list to manage output data
        List<Question> listQuestion = new ArrayList<>();
        try {
            //get Connect
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLTN", "root", "123456");

            String sql = "Select * from QUESTION ORDER BY Question_Id;";
            statement = connection.createStatement();

            //return 
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Question question = new Question(resultSet.getInt("Question_Id"),
                        resultSet.getString("Question_Content"), resultSet.getInt("Chapter_Id"),
                        resultSet.getInt("Level_Id"));
                listQuestion.add(question);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listQuestion;
    }

    public boolean insert(Question question) {
        Connection connection = null;
        //get data from database
        PreparedStatement statement = null;
        try {
            //get Connect
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLTN", "root", "123456");

            String sql = "INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) VALUES (?,?,?);";
            statement = connection.prepareCall(sql);
            statement.setString(1, question.getQuestion_Content());
            statement.setInt(2, question.getLevel_Id());
            statement.setInt(3, question.getChapter_Id());
            statement.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public boolean update(Question question) {
        Connection connection = null;
        //get data from database
        PreparedStatement statement = null;
        try {
            //get Connect
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLTN", "root", "123456");

            String sql = "UPDATE QUESTION SET Question_Content = ?, Chapter_Id = ?, Level_Id = ? WHERE Question_Id = ?;";
            statement = connection.prepareCall(sql);

            statement.setString(1, question.getQuestion_Content());
            statement.setInt(2, question.getChapter_Id());
            statement.setInt(3, question.getLevel_Id());
            statement.setInt(4, question.getQuestion_Id());

            statement.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public boolean deleteQuestion(int Question_Id) {
        Connection connection = null;
        //get data from database
        PreparedStatement statement = null;
        try {
            //get Connect
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLTN", "root", "123456");

            String sql = "DELETE FROM QUESTION WHERE Question_Id = ?;";
            statement = connection.prepareCall(sql);

            statement.setInt(1, Question_Id);

            statement.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public int getLastQuestionID() {
        Connection connection = null;
        //get data from database
        Statement statement = null;
        int question_Id = 0;
        try {
            //get Connect
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLTN", "root", "123456");

            String sql = "SELECT MAX(Question_Id) AS Question_Id FROM QUESTION;";
            statement = connection.createStatement();

            //return 
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                question_Id = resultSet.getInt("Question_Id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return question_Id;
    }

    public Question getQuestionById(int ID) {
        Question question = null;
        Connection connection = null;
        //get data from database
        PreparedStatement statement = null;
        try {
            //get Connect
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLTN", "root", "123456");

            String sql = "SELECT * FROM QUESTION WHERE Question_Id = ?;";
            statement = connection.prepareCall(sql);
            statement.setInt(1, ID);

            //return 
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                question = new Question(resultSet.getInt("Question_Id"),
                        resultSet.getString("Question_Content"), resultSet.getInt("Chapter_Id"),
                        resultSet.getInt("Level_Id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return question;
    }

    public List<Question> sortListByChapter() {
        Connection connection = null;
        //get data from database
        Statement statement = null;
        //create list to manage output data
        List<Question> listQuestion = new ArrayList<>();
        try {
            //get Connect
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLTN", "root", "123456");

            String sql = "Select * from QUESTION ORDER BY Chapter_Id, Level_Id;";
            statement = connection.createStatement();

            //return 
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Question question = new Question(resultSet.getInt("Question_Id"),
                        resultSet.getString("Question_Content"), resultSet.getInt("Chapter_Id"),
                        resultSet.getInt("Level_Id"));
                listQuestion.add(question);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listQuestion;
    }

    public List<Question> sortListByLevel() {
        Connection connection = null;
        //get data from database
        Statement statement = null;
        //create list to manage output data
        List<Question> listQuestion = new ArrayList<>();
        try {
            //get Connect
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLTN", "root", "123456");

            String sql = "Select * from QUESTION ORDER BY Level_Id, Chapter_Id;";
            statement = connection.createStatement();

            //return 
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Question question = new Question(resultSet.getInt("Question_Id"),
                        resultSet.getString("Question_Content"), resultSet.getInt("Chapter_Id"),
                        resultSet.getInt("Level_Id"));
                listQuestion.add(question);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listQuestion;
    }

    public List<Question> filterQuestion(int chapterId, int levelId) {
        Connection connection = null;
        //get data from database
        PreparedStatement statement = null;
        //create list to manage output data
        List<Question> listQuestion = new ArrayList<>();
        String sql = null;
        try {
            //get Connect
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLTN", "root", "123456");
            
            if (chapterId == 0) {
                sql = "SELECT * FROM QUESTION WHERE LEVEL_ID = ?;";
                statement = connection.prepareCall(sql);
                statement.setInt(1, levelId);
            } else if (levelId == 0) {
                sql = "SELECT * FROM QUESTION WHERE Chapter_ID = ?;";
                statement = connection.prepareCall(sql);
                statement.setInt(1, chapterId);
            } else {
                sql = "SELECT * FROM QUESTION  WHERE CHAPTER_ID = ? AND LEVEL_ID = ?;";
                statement = connection.prepareCall(sql);
                statement.setInt(1, chapterId);
                statement.setInt(2, levelId);
            }

            //return 
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Question question = new Question(resultSet.getInt("Question_Id"),
                        resultSet.getString("Question_Content"), resultSet.getInt("Chapter_Id"),
                        resultSet.getInt("Level_Id"));
                listQuestion.add(question);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listQuestion;
    }
    
    public List<Question> getQuestionByLevel(int level) { //tạo list chứa câu hỏi cùng level
        Connection connection = null;
        //get data from database
        PreparedStatement statement = null;
        //create list to manage output data

        List<Question> listQuestion = new ArrayList<>();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLTN", "root", "123456");
            String sql = "select * from QUESTION where level_ID= ?";
            statement = connection.prepareCall(sql);

            statement.setInt(1, level);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Question question = new Question(resultSet.getInt("Question_Id"),
                        resultSet.getString("Question_Content"), resultSet.getInt("Chapter_Id"),
                        resultSet.getInt("Level_Id"));
                listQuestion.add(question);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listQuestion;
    }

    public List<Question> getQuestionByTestCode(String TestCode) {
        Connection connection = null;
        //get data from database
        PreparedStatement statement = null;
        //create list to manage output data

        List<Question> listQuestion = new ArrayList<Question>();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLTN", "root", "123456");

            String sql = "SELECT Q.question_ID, Q.Question_Content, Q.Chapter_ID, Q.Level_ID from Test_Question TQ "
                    + "inner join question Q on TQ.question_ID=Q.question_ID inner join Test T on T.test_Code=TQ.test_Code where T.test_code= ?;";
            statement = connection.prepareCall(sql);

            statement.setString(1, TestCode);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Question question = new Question(resultSet.getInt("Question_Id"),
                        resultSet.getString("Question_Content"), resultSet.getInt("Chapter_Id"),
                        resultSet.getInt("Level_Id"));
                listQuestion.add(question);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listQuestion;
    }
}
