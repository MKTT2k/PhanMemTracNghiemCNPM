/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbIn_Out;

import Model.Test;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author Administrator
 */
public class TestDAO {

    Connection connection = null;
    Statement statement = null;

    public TestDAO() {
    }

    public List<Test> getFullListTest() {

        List<Test> list_Test = new ArrayList<>();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLTN", "root", "123456");
            String sql = "Select * From TEST WHERE status=1;";

            statement = connection.createStatement();

            //return 
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Test test = new Test();
                test.setTest_Code(resultSet.getString("Test_Code"));
                test.setTime(resultSet.getInt("Time"));
                test.setLevel_Id(resultSet.getInt("Level_Id"));
                test.setStatus(resultSet.getBoolean("Status"));
                list_Test.add(test);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list_Test;
    }

    public List<Test> getListTested(String username) {
        //get data from database
        PreparedStatement st = null;
        List<Test> list_Test = new ArrayList<>();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLTN", "root", "123456");
            String sql = "select * from test where test_code not in (select test_code from result where username = ?);";

            st = connection.prepareCall(sql);
            st.setString(1, username);

            //return 
            ResultSet resultSet = st.executeQuery();

            while (resultSet.next()) {
                Test test = new Test();
                test.setTest_Code(resultSet.getString("Test_Code"));
                test.setTime(resultSet.getInt("Time"));
                test.setLevel_Id(resultSet.getInt("Level_Id"));
                test.setStatus(resultSet.getBoolean("Status"));
                list_Test.add(test);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list_Test;
    }

    public boolean insertTest(Test test) {
        //get data from database
        PreparedStatement statement = null;
        try {
            //get Connect
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLTN", "root", "123456");

            String sql = "INSERT INTO TEST (TEST_CODE, LEVEL_ID) VALUES (?,?);";
            statement = connection.prepareCall(sql);

            statement.setString(1, test.getTest_Code());
            statement.setInt(2, test.getLevel_Id());
            statement.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public boolean deleteTest(String Test_Code) {
        //get data from database
        PreparedStatement statement = null;
        try {
            //get Connect
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLTN", "root", "123456");

            String sql = "DELETE FROM TEST WHERE Test_Code = ?;";
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
                    Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public Test getATest(String Test_Code) {
        PreparedStatement st = null;
        Test test = new Test();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLTN", "root", "123456");
            String sql = "Select * From TEST WHERE Test_Code = ?;";

            st = connection.prepareCall(sql);
            st.setString(1, Test_Code);

            //return 
            ResultSet resultSet = st.executeQuery();

            while (resultSet.next()) {
                test.setTest_Code(resultSet.getString("Test_Code"));
                test.setTime(resultSet.getInt("Time"));
                test.setLevel_Id(resultSet.getInt("Level_Id"));
                test.setStatus(resultSet.getBoolean("Status"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return test;
    }
}
