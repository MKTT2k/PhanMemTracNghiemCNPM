/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbIn_Out;

import Model.Test_Question;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class Test_QuestionDAO {

    public Test_QuestionDAO() {
    }

    public List<Test_Question> getAllTest_Question(String TestCode) {
        Connection connection = null;
        PreparedStatement statement = null;

        List<Test_Question> list = new ArrayList<>();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLTN", "root", "123456");
            String sql = "SELECT * FROM Test_Question Where Test_Code = ? ORDER BY Question_ID";

            statement = connection.prepareCall(sql);
            statement.setString(1, TestCode);
            //return 
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Test_Question tq = new Test_Question();
                tq.setT_QT_ID(resultSet.getInt("T_QT_ID"));
                tq.setTest_Code(resultSet.getString("Test_Code"));
                tq.setQuestion_ID(resultSet.getInt("Question_ID"));
                list.add(tq);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Test_QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Test_QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Test_QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }
    
    public List<Test_Question> getTest_Question(String TestCode) {
        Connection connection = null;
        PreparedStatement statement = null;

        List<Test_Question> list = new ArrayList<>();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLTN", "root", "123456");
            String sql = "SELECT * FROM Test_Question Where Test_Code = ?;";

            statement = connection.prepareCall(sql);
            statement.setString(1, TestCode);
            //return 
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Test_Question tq = new Test_Question();
                tq.setT_QT_ID(resultSet.getInt("T_QT_ID"));
                tq.setTest_Code(resultSet.getString("Test_Code"));
                tq.setQuestion_ID(resultSet.getInt("Question_ID"));
                list.add(tq);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Test_QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Test_QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Test_QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }
    
    public int getLastT_QT_ID() {
        Connection connection = null;
        //get data from database
        Statement statement = null;
        int T_QT_Id = 0;
        try {
            //get Connect
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLTN", "root", "123456");

            String sql = "SELECT MAX(T_QT_Id) AS T_QT_Id FROM test_question;";
            statement = connection.createStatement();

            //return 
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                T_QT_Id = resultSet.getInt("T_QT_Id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Test_QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Test_QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Test_QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return T_QT_Id;
    }
    public void insertTestQuestion(String Test_Code, int Question_Id) {
        Connection connection = null;
        //get data from database
        PreparedStatement statement = null;
        try {
            //get Connect
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLTN", "root", "123456");

            String sql = "INSERT INTO Test_QUESTION (TEST_Code, QUESTION_ID) VALUES (?,?);";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, Test_Code);
            statement.setInt(2, Question_Id);
            statement.execute();
            
            return;

        } catch (SQLException ex) {
            Logger.getLogger(Test_QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Test_QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Test_QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return;
    }
    
    public boolean deleteTest_Question(String Test_Code) {
        Connection connection = null;
        //get data from database
        PreparedStatement statement = null;
        try {
            //get Connect
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLTN", "root", "123456");

            String sql = "DELETE FROM TEST_QUESTION WHERE Test_Code = ?;";
            statement = connection.prepareCall(sql);

            statement.setString(1, Test_Code);

            statement.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(Test_QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Test_QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Test_QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
    
    public boolean delete1Test_Question(String Test_Code, int Question_Id) {
        Connection connection = null;
        //get data from database
        PreparedStatement statement = null;
        try {
            //get Connect
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLTN", "root", "123456");

            String sql = "DELETE FROM TEST_QUESTION WHERE Test_Code = ? AND Question_Id = ?;";
            statement = connection.prepareCall(sql);

            statement.setString(1, Test_Code);
            statement.setInt(2, Question_Id);

            statement.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(Test_QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Test_QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Test_QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
}
