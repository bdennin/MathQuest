package MathQuest.Database;

import java.io.*;
import java.util.*;
import java.sql.*;

public class Database
{
	private static int userID;
	private static Connection con = null;

	/**
	 * @return true if program connects Cerberus successfully
	 */
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

	/**
	 * 
	 * @param inputName
	 * @param inputPass
	 * @param inputType
	 * @return true if save the information successfully. Otherwise, the input username already exists in the database.
	 */
	public static boolean createAccount(String inputName, String inputPass, String inputType){
		try{
			Statement select = con.createStatement();
			int res = select.executeUpdate("INSERT IGNORE INTO Login (username, password, type) VALUES (\"" + inputName + "\" ,\"" + inputPass + "\" ,\"" + inputType + "\")" );
			if (res == 1){
				con.close();
				return true;
			}
			con.close();
			return false;
		}
		catch (SQLException e){
			System.out.println("Error from createAccount: " + e.getMessage());
			return false;
		}
	}
	/**
	 * return true if given username and password match with database
	 * return false if either username is invalid or password is invalid
	 */
	public static boolean isValid(String inputName, String inputPass){
		try{
			Statement select = con.createStatement();
			ResultSet res = select.executeQuery("SELECT password, userID from Login where username = \"" + inputName + "\"") ;
			String storedPass =  null;
			if(res.next()){
				storedPass= res.getString("password");
				if(storedPass.equals(inputPass)){
					userID = res.getInt("userID");
					System.out.println(userID);
					return true;
				}
			}
			con.close();
			return false;
		}
		catch (SQLException e){
			System.out.println("Error from isValid: " + e.getMessage());
			return false;
		}
	}

	/**
	 * @return the type of account
	 */
	public static String getType(){
		try{
			Statement select = con.createStatement();
			ResultSet res = select.executeQuery("SELECT type from Login where userID = " + userID);
			String type = null;
			if(res.next())
				type = res.getString("type");
			con.close();
			return type;
		}
		catch (SQLException e){
			System.out.println("Error from getType: " + e.getMessage());
			return null;
		}
	}

	/**
	 * 
	 * @return in order of level, currentHealth, exp and gold
	 */
	public static int[] getStats(){
		try{
			Statement select = con.createStatement();
			ResultSet res = select.executeQuery("SELECT * from Status where Login_userID =" + userID );
			int[] status = new int[4];
			if(res.next()){
				for(int index = 1;index < 5; index++)
					status[index-1] = res.getInt(index);
			}
			con.close();
			return status;
		}
		catch (SQLException e){
			System.out.println("Error from getStatus: " + e.getMessage());
			return null;
		}
	}

	/**
	 * 
	 * @param input string array should in order of level, currentHealth, exp and gold
	 * @return true if save the status successfully.
	 */
	public static boolean setStatus(Integer[] status){
		try{
			PreparedStatement select = con.prepareStatement("UPDATE Status SET level = ?, currentHealth = ?, exp = ?, gold = ? where Login_userID = " + userID);
			int index = 1;
			for(Integer item : status){
				select.setInt(index, item);
				index++;
			}
			int res = select.executeUpdate();
			if (res == 1){
				con.close();
				return true; 
			}
			else
				con.close();
			return false;
		}
		catch (SQLException e){
			System.out.println("Error from setStatus: " + e.getMessage());
			return false;
		}
	}
	/*
 public static void main(String[] args){
  Database.getConnected();
  //Database.userID = 1;
  //Database.getStatus();
  //Integer [] status = {2,30,2,30};
  //System.out.println(Database.setStatus(status));
  System.out.println(Database.createAccount("zxu123","1234","student"));
 }
	 */
}