package DbIn_Out;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Model.Result;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class ResultDAO {

    public ResultDAO() {
    }

    public boolean insertResult(Result result) {
        Connection connection = null;
        //get data from database
        PreparedStatement statement = null;
        try {
            //get Connect
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLTN", "root", "123456");

            String sql = "INSERT INTO RESULT (Username, Test_code, WorkTime, NumOfCorrect_Test, Date) VALUES (?,?,?,?,?);";
            statement = connection.prepareCall(sql);

            statement.setString(1, result.getUsername());
            statement.setString(2, result.getTest_Code());
            statement.setInt(3, result.getWorkTime());
            statement.setInt(4, result.getNumOfCorrect_Test());
            statement.setDate(5, result.getDate());

            statement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ResultDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ResultDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ResultDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public List<Result> getAllTest_CodeResult() {
        List<Result> listResult = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLTN", "root", "123456");

            String sql = "select * from result group by Test_code order by Result_Id ;";
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Result result = new Result(resultSet.getString("Test_code"));
                listResult.add(result);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResultDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ResultDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ResultDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return listResult;
    }

    public List<Result> getAllResultByTest_Code(String Test_Code) {
        List<Result> listResult = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLTN", "root", "123456");

            String sql = "select * from result where test_code = ?;";
            statement = connection.prepareCall(sql);
            statement.setString(1, Test_Code);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Result result = new Result(resultSet.getString("username"), resultSet.getString("Test_code"),
                        resultSet.getInt("WorkTime"), resultSet.getInt("NumOfCorrect_Test"));
                listResult.add(result);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResultDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ResultDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ResultDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return listResult;
    }

    public boolean deleteResult(String Test_Code) {
        Connection connection = null;
        //get data from database
        PreparedStatement statement = null;
        try {
            //get Connect
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLTN", "root", "123456");

            String sql = "DELETE FROM RESULT WHERE Test_Code = ?;";
            statement = connection.prepareCall(sql);

            statement.setString(1, Test_Code);

            statement.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ResultDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ResultDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public boolean deleteResultByUserName(String userName) {
        Connection connection = null;
        //get data from database
        PreparedStatement statement = null;
        try {
            //get Connect
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLTN", "root", "123456");

            String sql = "DELETE FROM RESULT WHERE Username = ?;";
            statement = connection.prepareCall(sql);

            statement.setString(1, userName);

            statement.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ResultDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ResultDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

}
