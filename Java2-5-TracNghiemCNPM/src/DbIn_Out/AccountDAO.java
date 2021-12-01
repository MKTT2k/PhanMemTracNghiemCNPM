/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbIn_Out;

import Model.Account;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

/**
 *
 * @author ADMIN
 */
public class AccountDAO {

    public AccountDAO() {
    }

    public List<Account> getAllUser() {
        Connection connection = null;
        //get data from database
        Statement statement = null;
        List<Account> listUser = new ArrayList<>();
        try {
//        Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLTN", "root", "123456");
            String sql = "select * from account where Role = 0;";
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Account u = new Account(rs.getString("UserName"), rs.getString("Password"),
                        rs.getString("Full_Name"), rs.getString("Class_Name"), rs.getString("Phone"), rs.getBoolean("Role"));
                listUser.add(u);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listUser;
    }

    public Account getAUser(String username) {
        Account user = null;
        Connection connection = null;
        //get data from database
        PreparedStatement statement = null;
        try {
            //get Connect
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLTN", "root", "123456");

            String sql = "SELECT * FROM ACCOUNT WHERE Username = ?;";
            statement = connection.prepareCall(sql);
            statement.setString(1, username);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                user = new Account(rs.getString("Username"), rs.getString("Password"),
                        rs.getString("Full_Name"), rs.getString("Class_Name"), rs.getString("Phone"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public boolean insert(Account user) {
        Connection conn = null;
        //get data from database
        PreparedStatement statement = null;
        try {
            //get Connect
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLTN", "root", "123456");

            String sql = "insert into account(UserName, Password, Full_Name, Class_Name,Phone) values (?,?,?,?,?)";
            statement = conn.prepareCall(sql);

            statement.setString(1, user.getUserName());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFull_Name());
            statement.setString(4, user.getClass_Name());
            statement.setString(5, user.getPhone());

            statement.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public boolean delete(String Username) {
        Connection connection = null;
        //get data from database
        PreparedStatement statement = null;
        try {
            //get Connect
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLTN", "root", "123456");

            String sql = "DELETE FROM ACCOUNT WHERE Username = ?;";
            statement = connection.prepareCall(sql);

            statement.setString(1, Username);

            statement.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public boolean reset(String Username) {
        Connection connection = null;
        //get data from database
        PreparedStatement statement = null;
        try {
            //get Connect
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLTN", "root", "123456");

            String sql = "UPDATE ACCOUNT SET Password = 123456 WHERE Username = ?;";
            statement = connection.prepareCall(sql);

            statement.setString(1, Username);

            statement.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public boolean update(Account user) {
        Connection connection = null;
        //get data from database
        PreparedStatement statement = null;
        try {
            //get Connect
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLTN", "root", "123456");

            String sql = "UPDATE ACCOUNT SET Password = ?, Full_Name = ?, Class_Name = ?, Phone = ? WHERE Username = ?;";
            statement = connection.prepareCall(sql);

            statement.setString(1, user.getPassword());
            statement.setString(2, user.getFull_Name());
            statement.setString(3, user.getClass_Name());
            statement.setString(4, user.getPhone());
            statement.setString(5, user.getUserName());
            statement.execute();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public Account login(String username, String password) {
        Connection conn = null;
        //get data from database
        Account user = null;
        PreparedStatement statement = null;
        try {
            //get Connect
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLTN", "root", "123456");

            String sql = "select * from account where Username = ? and Password = ?;";
            statement = conn.prepareCall(sql);

            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                user = new Account(rs.getString("Username"), rs.getString("Password"),
                        rs.getString("Full_Name"), rs.getString("Class_Name"), rs.getString("Phone"), rs.getBoolean("Role"));

            }
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public List<String> getUserName() {
        Connection connection = null;
        //get data from database
        Statement statement = null;
        List<String> listUserName = new ArrayList<String>();
        try {
//        Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLTN", "root", "123456");
            String sql = "SELECT UserName FROM ACCOUNT WHERE Role=0";
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String u = new String(rs.getString("Username"));
                listUserName.add(u);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listUserName;
    }

}
