package MathQuest.Database;

import java.io.*;
import java.util.*;
import java.sql.*;
import MathQuest.Logic.Equation.*;

public class Database
{
	private static int userID;
	private static Connection con = null;
	private static Integer[] cacheStats;
	private static String cacheType;
	private static String[][] cacheFormular; 

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
				return true;
			}
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
					cacheType();
					if (cacheType.equals("student")){
						cacheStats();
						cacheFormular();
					}
					return true;
				}
			}
			return false;
		}
		catch (SQLException e){
			System.out.println("Error from isValid: " + e.getMessage());
			return false;
		}
	}
	public static void cacheStats(){
		try{
			Statement select = con.createStatement();
			ResultSet res = select.executeQuery("SELECT * from Status where Login_userID =" + userID );
			Integer[] status = new Integer[4];
			if(res.next()){
				for(int index = 1;index < 5; index++)
					status[index-1] = res.getInt(index);
			}

			cacheStats = status;
		}
		catch (SQLException e){
			System.out.println("Error from getStatus: " + e.getMessage());
			cacheStats = null;
		}
	}

	public static void cacheType(){
		try{
			Statement select = con.createStatement();
			ResultSet res = select.executeQuery("SELECT type from Login where userID = " + userID);
			String type = null;
			if(res.next())
				type = res.getString("type");
			cacheType = type;
		}
		catch (SQLException e){
			System.out.println("Error from getType: " + e.getMessage());
			cacheType = null;
		} 
	}
	/**
	 * @return the type of account
	 */
	public static String getType(){
		return cacheType;
	}

	/**
	 * 
	 * @return in order of level, currentHealth, exp and gold
	 */
	public static Integer[] getStats(){
		return cacheStats;
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
				return true; 
			}
			else
				return false;
		}
		catch (SQLException e){
			System.out.println("Error from setStatus: " + e.getMessage());
			return false;
		}
	}
	/**
	 * @return user ID
	 */
	public static int getId(){
		return userID;
	}

	public static void close(){
		try{
			con.close();
		}
		catch(SQLException e){
			System.out.println("Error from close: " + e.getMessage());
		}
	}

	public static boolean setFormular(int monsterLevel, Sign sign, Digits digit, Terms term){
		try{
			PreparedStatement select = con.prepareStatement("UPDATE Formular SET sign = ?, digit = ?, term = ? where monsterLevel = ? and teacherId = ?");
			select.setString(1, sign.getSign());;
			select.setString(2, digit.getString());
			select.setString(3, term.getString());;
			select.setInt(4, monsterLevel);
			select.setInt(5, Database.getId());
			int res = select.executeUpdate();
			if (res>0)
				return true;
			else
				return false;
		}
		catch (SQLException e){
			System.out.println("Error from setFormular: " + e.getMessage());
			return false;
		}
	}

	public static void cacheFormular(){
		try{
			PreparedStatement select = con.prepareStatement("SELECT sign, digit, term From Formular Where studentId = ?");
			select.setInt(1, userID);
			ResultSet res = select.executeQuery();
			String[][] record = new String [19][3]; 
			int count = 0;
			if (res != null){
				while(res.next()){
					for(int index = 0;index < 3; index++)
						record[count][index] = res.getString(index+1);
					count ++;
				}
				cacheFormular = record;
			}
		}
		catch (SQLException e){
			System.out.println("Error from getFormular2: " + e.getMessage());
			cacheFormular = null;
		}
	}

	public static String[] getFormular(int monsterLevel){
		return cacheFormular[monsterLevel-1];
	}

	public static String[][] getFormular(int teacherId, int monsterLevel, int studentId){
		try{
			Statement select = con.createStatement();
			ResultSet res = select.executeQuery("SELECT sign, digit, term From Formular" + 
					"Where teacherId = " + teacherId + " and monsterLevel = " + monsterLevel +
					" Group by sign, digit, term" +
					"Order by count(studentId) DESC" +
					"LIMIT 1");
			Vector settings = new Vector();
			String[][] record = new String [1][3]; 
			if(res.next()){

				for(int index = 0;index < 3; index++)
					record[0][index] = res.getString(index+1);

			}

			return record;
		}
		catch (SQLException e){
			System.out.println("Error from getFormular1: " + e.getMessage());
			return null;
		}
	}

	public static String[][] getFormular(int teacherId, int monsterLevel){
		try{
			PreparedStatement select = con.prepareStatement("SELECT sign, digit, term From Formular Where teacherId = ? and monsterLevel = ? Group by sign, digit, term Order by count(studentId) DESC Limit 1");
			select.setInt(1, teacherId);
			select.setInt(2, monsterLevel);
			ResultSet res = select.executeQuery();
			String[][] record = new String [1][3]; 
			if(res.next()){

				for(int index = 0;index < 3; index++)
					record[0][index] = res.getString(index+1);

			}

			return record;
		}
		catch (SQLException e){
			System.out.println("Error from getFormular2: " + e.getMessage());
			return null;
		}
	}

	// public static void main(String[] args){
	//  Database.getConnected();
	//  Database.userID = 1;
	//  Database.getStatus();
	//  Integer [] status = {2,30,2,30};
	//  System.out.println(Database.setStatus(status));
	//  System.out.println(Database.createAccount("zxu123","1234","student"));
	//  Sign sign = Sign.ADDITION;
	//  Digits digit = Digits.FOUR;
	//  Terms term = Terms.FIVE;
	//  Database.setFormular(1, sign, digit, term);
	// }

}