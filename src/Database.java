import java.io.*;
import java.util.*;
import java.sql.*;

public class Login
{
 private static String name = null;
 private static Connection con = null;
 public static boolean getConnected(){
  try{
   String username = "zxu";
   String password = "16796125";
   String url = "jdbc:mysql://localhost:3306/mathquest?user=" + username + "&password="+ password;
   Class.forName("com.mysql.jdbc.Driver");
   con = DriverManager.getConnection(url);
   return true;
  }
  catch (ClassNotFoundException e){
   System.out.println("Cannot find the driver!");
   return false;
  }
  catch (SQLException e){
   System.out.println("Cannot get connected with Cerberus!");
   return false;
  }
 }

 public static boolean isValid(String inputName, String inputPass){
  name = inputName;
  try{
  Statement select = con.createStatement();
  ResultSet res = select.executeQuery("SELECT password from login where username = \"" + name + "\"") ;
  String storedPass =  null;
  if(res.next()){
   storedPass= res.getString(1);
     if(storedPass.equals(inputPass))
     return true;
  }
   con.close();
   return false;
  }
  catch (SQLException e){
   System.out.println("Error from isValid: " + e.getMessage());
   return false;
  }
 }
 
 public static String getType(){
  try{
  Statement select = con.createStatement();
  ResultSet res = select.executeQuery("SELECT type from login where username = \"" + name + "\"");
  String type = null;
  if(res.next())
   type = res.getString(1);
  con.close();
  return type;
  }
  catch (SQLException e){
   System.out.println("Error from getType: " + e.getMessage());
   return null;
  }
 }
}