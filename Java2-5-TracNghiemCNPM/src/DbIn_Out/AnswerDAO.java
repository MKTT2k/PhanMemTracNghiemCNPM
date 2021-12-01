package DbIn_Out;

import Model.Answer;
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
public class AnswerDAO {

    public AnswerDAO() {
    }

    public List<Answer> getAllAnswer() {
        Connection connection = null;
        //get data from database
        Statement statement = null;
        //create list to manage output data
        List<Answer> listAnswer = new ArrayList<>();
        try {
            //get Connect
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLTN", "root", "123456");

            String sql = "Select * from Answer ORDER BY Answer_Id;";
            statement = connection.createStatement();

            //return 
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Answer answer = new Answer(resultSet.getInt("Answer_Id"),
                        resultSet.getString("Answer_Content"), resultSet.getBoolean("Is_Correct"),
                        resultSet.getInt("Question_Id"));
                listAnswer.add(answer);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listAnswer;
    }

    public boolean insert(Answer answer) {
        Connection connection = null;
        //get data from database
        PreparedStatement statement = null;
        try {
            //get Connect
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLTN", "root", "123456");

            String sql = "INSERT INTO Answer (Answer_CONTENT, IS_CORRECT, Question_ID) VALUES (?,?,?);";
            statement = connection.prepareCall(sql);
            statement.setString(1, answer.getAnswer_Content());
            statement.setBoolean(2, answer.isIs_Correct());
            statement.setInt(3, answer.getQuestion_Id());

            statement.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(AnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public boolean deleteAnswer(int Question_Id) {
        Connection connection = null;
        //get data from database
        PreparedStatement statement = null;
        try {
            //get Connect
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLTN", "root", "123456");

            String sql = "DELETE FROM ANSWER WHERE Question_Id = ?";
            statement = connection.prepareCall(sql);

            statement.setInt(1, Question_Id);

            statement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public List<Answer> getAnswerByQuestionID(int Question_Id) {
        List<Answer> listAnswer = new ArrayList<>();
        Connection connection = null;
        //get data from database
        PreparedStatement statement = null;
        try {
            //get Connect
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLTN", "root", "123456");

            String sql = "SELECT * FROM ANSWER WHERE Question_Id = ?;";
            statement = connection.prepareCall(sql);
            statement.setInt(1, Question_Id);

            //return 
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Answer answer = new Answer(resultSet.getInt("Answer_Id"),
                        resultSet.getString("Answer_Content"), resultSet.getBoolean("Is_Correct"),
                        resultSet.getInt("Question_Id"));
                listAnswer.add(answer);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listAnswer;
    }

    public void update(Answer answer) {
        Connection connection = null;
        //get data from database
        PreparedStatement statement = null;
        try {
            //get Connect
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLTN", "root", "123456");

            String sql = "UPDATE ANSWER SET Answer_Content = ?, Is_Correct = ? WHERE Answer_Id = ?;";
            statement = connection.prepareCall(sql);

            statement.setString(1, answer.getAnswer_Content());
            statement.setBoolean(2, answer.isIs_Correct());
            statement.setInt(3, answer.getAnswer_Id());

            statement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(AnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public Answer getCorrectAnswer(int question_Id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        Answer answer = null;
        Connection connection = null;
        //get data from database
        PreparedStatement statement = null;
        try {
            //get Connect
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLTN", "root", "123456");

            String sql = "SELECT * FROM ANSWER WHERE Question_Id = ? AND Is_Correct = 1";
            statement = connection.prepareCall(sql);
            statement.setInt(1, question_Id);

            //return 
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                answer = new Answer(resultSet.getInt("Answer_Id"),
                        resultSet.getString("Answer_Content"), resultSet.getBoolean("Is_Correct"),
                        resultSet.getInt("Question_Id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return answer;
    }
}
