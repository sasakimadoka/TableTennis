package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverAccessor {

 private final static String DRIVER_URL = "jdbc:mysql://localhost:3306/GameStorage?useUnicode=true&characterEncoding=Windows-31J";
 private final static String DRIVER_NAME = "com.mysql.jdbc.Driver";
 private final static String USER_NAME = "root";
 private final static String PASSWORD = "";

 public Connection createConnection() {
  try {
   Class.forName(DRIVER_NAME);
   Connection con = DriverManager.getConnection(DRIVER_URL, USER_NAME, PASSWORD);
   return con;
  } catch (ClassNotFoundException e) {
   System.out.println("Can't Find JDBC Driver.\n");
  } catch (SQLException e) {
   System.out.println("Connection Error.\n");
  }
  return null;
 }

 public void closeConnection(Connection con) {
  try {
   con.close();
  } catch (Exception ex) {
  }
 }
}