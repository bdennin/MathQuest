package MathQuest.Database;

import java.io.*;
import java.util.*;
import java.sql.*;

import com.sun.xml.internal.ws.api.config.management.policy.ManagementAssertion.Setting;

import MathQuest.Logic.*;
import MathQuest.Logic.Equation.*;

public class Database
{
	private static int userID;
	private static Connection con = null;
	private static Integer[] cacheStats;
	private static String cacheType;
	private static Vector cacheStudentsName; 
	private static ArrayList<String[]> cacheFormulaSettings = new ArrayList<String[]>();
	private static ArrayList<Item> cacheinventory = new ArrayList<Item>();

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
						cacheStudents();
						cacheFormulaSettings();
						cacheInventory();			
					}
					else{
						cacheStudents();
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
			ResultSet res = select.executeQuery("SELECT Status.level, Status.currentHealth, Status.exp, Status.gold, Status.potion, StudentAccuracy.answeredCorrectly, StudentAccuracy.answeredIncorrectly from Status LEFT JOIN StudentAccuracy ON Status.Login_userID = StudentAccuracy.studentID WHERE Login_userID =" + userID );
			Integer[] status = new Integer[7];
			if(res.next()){
				for(int index = 1;index < 8; index++)
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
			PreparedStatement select = con.prepareStatement("UPDATE Status SET level = ?, currentHealth = ?, exp = ?, gold = ?, potion = ? where Login_userID = " + userID);
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

	public static boolean setFormula(int monsterLevel, Sign sign, Digits digit, Terms term){
		try{
			PreparedStatement select = con.prepareStatement("UPDATE Formula SET sign = ?, digit = ?, term = ? where monsterLevel = ? and teacherId = ?");
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
			System.out.println("Error from setFormula: " + e.getMessage());
			return false;
		}
	}

	public static boolean setFormula(int studentId, int monsterLevel, Sign sign, Digits digit, Terms term){
		try{
			PreparedStatement select = con.prepareStatement("UPDATE Formula SET sign = ?, digit = ?, term = ? where monsterLevel = ? and teacherId = ? and studentId = ?");
			select.setString(1, sign.getSign());;
			select.setString(2, digit.getString());
			select.setString(3, term.getString());;
			select.setInt(4, monsterLevel);
			select.setInt(5, Database.getId());
			select.setInt(6, studentId);
			int res = select.executeUpdate();
			if (res>0)
				return true;
			else
				return false;
		}
		catch (SQLException e){
			System.out.println("Error from setFormula: " + e.getMessage());
			return false;
		}
	}

	public static String[] getFormulaFromCache(int monsterLevel){
		//System.out.println(cacheFormulaSettings.isEmpty());
		if (monsterLevel > cacheFormulaSettings.size() )
			return null;
		else
			return cacheFormulaSettings.get(monsterLevel-1);
	}

	public static String[][] getFormula(int monsterLevel){
		try{
			PreparedStatement select = con.prepareStatement("SELECT sign, digit, term From Formula Where teacherId = ? and monsterLevel = ? Group by sign, digit, term Order by count(studentId) DESC Limit 1");
			select.setInt(1, getId());
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
			System.out.println("Error from getFormula1: " + e.getMessage());
			return null;
		}
	}

	public static String[][] getFormula(int studentId, int monsterLevel){
		try{
			PreparedStatement select = con.prepareStatement("SELECT sign, digit, term FROM Formula WHERE monsterLevel = ? and studentId = ?");
			select.setInt(1, monsterLevel);
			select.setInt(2,studentId);
			ResultSet res = select.executeQuery();
			String[][] settings = new String[1][3];
			if(res.next()){
				for(int index = 0;index < 3; index++)
					settings[0][index] = res.getString(index+1);
			}
			return settings;
		}
		catch (SQLException e){
			System.out.println("Error from getFormula2: " + e.getMessage());
			return null;
		}
	}

	public static void cacheStudents(){
		try{
			PreparedStatement select = con.prepareStatement("SELECT Login.userID, Login.firstname, Login.lastname FROM Login LEFT JOIN Formula ON Login.userID = Formula.studentId WHERE Formula.teacherId = ? GROUP BY Formula.studentId ORDER BY Login.lastname");
			select.setInt(1, getId());
			ResultSet res = select.executeQuery();
			cacheStudentsName = new Vector();
			while(res.next()){
				String name = res.getString(3) + ", " + res.getString(2);
				int id = res.getInt(1);
				DropdownElement element = new DropdownElement(id,name);
				cacheStudentsName.add(element);
			}
		}
		catch (SQLException e){
			System.out.println("Error from cacheStudents: " + e.getMessage());
			cacheStudentsName = null;
		}
	}

	public static void cacheFormulaSettings(){
		try{
			PreparedStatement select = con.prepareStatement("SELECT sign, digit, term FROM Formula WHERE studentId = ? ORDER BY monsterLevel");
			select.setInt(1, getId());
			ResultSet res = select.executeQuery();
			String[] setting = new String[3];
			while(res.next()){
				//System.out.println("MonsterLevel");
				for(int index = 0;index < 3; index++)
					setting[index] = res.getString(index+1);
				cacheFormulaSettings.add(setting);
			}
		}
		catch (SQLException e){
			System.out.println("Error from cacheFormulaSettings: " + e.getMessage());
		}
	}

	public static Vector getNames(){
		return cacheStudentsName;
	}

	public static void cacheInventory(){
		try{
			PreparedStatement select = con.prepareStatement("SELECT name, color, slot, level, str, gold, vit, isEquipped FROM Inventory WHERE Login_userID = ? ORDER BY inventoryID");
			select.setInt(1, getId());
			ResultSet res = select.executeQuery();
			String[] strings = new String[3];
			Integer[] numbers = new Integer[4];
			if(!res.wasNull())
				while(res.next()){
					for (int i = 0; i<3; i++)
						strings[i] = res.getString(i+1);
					for (int i = 0; i<4; i++)
						numbers[i] = res.getInt(i+4);
					boolean isEquipped = res.getBoolean(8);
					cacheinventory.add(new Item(strings, numbers,isEquipped));
					//System.out.println("count");
				}
			else
				cacheinventory = null;
		}
		catch (SQLException e){
			System.out.println("Error from cacheInventory: " + e.getMessage());
		}
	}

	public static ArrayList<Item> getInventory(){
		return cacheinventory;
	}

	public static void saveInventory(ArrayList<Item> items){
		try{if(items != null){
			PreparedStatement delete = con.prepareStatement("DELETE FROM Inventory WHERE Login_userID = ?");
			delete.setInt(1, getId());
			delete.executeUpdate();
			for(Item item : items){
				PreparedStatement inventory = con.prepareStatement("INSERT INTO Inventory (name, color, level, str, gold, vit, Login_userID, slot, isEquipped) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
				inventory.setString(1, item.getName());
				inventory.setString(2, item.getColor());
				inventory.setString(8, item.getSlot());
				inventory.setInt(3, item.getItemLvl());
				inventory.setInt(4, item.getItemStr());
				inventory.setInt(5, item.getItemGold());
				inventory.setInt(6, item.getItemVit());
				inventory.setInt(7, getId());
				inventory.setBoolean(9, item.isEquipped());
				inventory.executeUpdate();
			}
		}
		}
		catch (SQLException e){
			System.out.println("Error from saveInventory: " + e.getMessage());
		}
	}

	public static void saveAccuracy(int answeredCorrectly,int answeredIncorrectly){
		try{
			PreparedStatement teacher = con.prepareStatement("SELECT teacherID FROM TeacherStudent WHERE studentID = ?");
			teacher.setInt(1, getId());
			ResultSet rs = teacher.executeQuery();
			int teacherID = 1;
			if(rs.next())
				teacherID = rs.getInt(1);
			PreparedStatement delete = con.prepareStatement("DELETE FROM StudentAccuracy WHERE studentID = ?");
			delete.setInt(1, getId());
			delete.executeUpdate();
			PreparedStatement newRecord = con.prepareStatement("INSERT INTO StudentAccuracy (studentID, answeredCorrectly, answeredIncorrectly, teacherID) VALUES (?, ?, ?, ?)");
			newRecord.setInt(1, getId());
			newRecord.setInt(2, answeredCorrectly);
			newRecord.setInt(3, answeredIncorrectly);
			newRecord.setInt(4,teacherID);
			newRecord.executeUpdate();
		}
		catch (SQLException e){
			System.out.println("Error from saveAccuracy: " + e.getMessage());
		}
	}

	public static String[][] getRank(){
		try{
			PreparedStatement select = con.prepareStatement("Select Login.lastname , Login.firstname,  StudentAccuracy.answeredCorrectly, StudentAccuracy.answeredIncorrectly from StudentAccuracy left join Login on StudentAccuracy.studentID = Login.userID where StudentAccuracy.teacherID = ? order by Login.lastname DESC");
			select.setInt(1, getId());
			ResultSet res = select.executeQuery();
			int numberRows=0;
			if (res.last()) {
				numberRows = res.getRow();
				// Move to beginning
				res.beforeFirst();
			}
			String[][] record = new String [numberRows][4]; 
			while(res.next()){
				int answeredCorrectly = res.getInt(3);
				int answeredIncorrectly = res.getInt(4);
				record[numberRows-1][0] = res.getString(1) + ", " + res.getString(2);
				record[numberRows-1][1] = ((Integer)answeredCorrectly).toString();
				record[numberRows-1][2] = ((Integer)answeredIncorrectly).toString();		
				record[numberRows-1][3] = ((Long)Math.round(answeredCorrectly*100.0/(answeredCorrectly+answeredIncorrectly))).toString() + "%";
				numberRows--;
			}
			return record;
		}
		catch(SQLException e){
			System.out.println("Error from getRank: " + e.getMessage());
			return null;
		}
	}

	public static boolean changePassword(String oldPass, String newPass){
		try{
			PreparedStatement select = con.prepareStatement("Select password from Login where userID = ?");
			select.setInt(1,  getId());
			ResultSet execute = select.executeQuery();
			String pass = null;
			if(execute.next())
				pass=execute.getString(1);
			if(pass.equals(oldPass)){
				PreparedStatement update = con.prepareStatement("UPDATE Login SET password = ? where userID = ?");
				update.setString(1, newPass);;
				update.setInt(2,  getId());
				int res = update.executeUpdate();
				if (res > 0)
					return true;
			}
			return false;
		}
		catch (SQLException e){
			System.out.println("Error from changePassword: " + e.getMessage());
			return false;
		}
	}
	public static void cleanUp(){
		con = null;
		cacheStats = null;
		cacheType = null;
		cacheStudentsName = null; 
		cacheFormulaSettings = new ArrayList<String[]>();
	}

	/*
	public static void main(String[] args){
		Database.getConnected();
		Database.userID = 23;
		//	  Database.getStatus();
		//	  Integer [] status = {2,30,2,30};
		//	  System.out.println(Database.setStatus(status));
		//	  System.out.println(Database.createAccount("zxu123","1234","student"));
		//	  Sign sign = Sign.ADDITION;
		//	  Digits digit = Digits.FOUR;
		//	  Terms term = Terms.FIVE;
		//	  Database.setFormula(1, sign, digit, term);
		//	  String[][] a = Database.getFormula(17,1);
		//	  for(int index = 0;index < 3; index++)
		//	  System.out.println(a[0][index]);
		//	  Database.cacheStudents();
		//Database.cacheFormulaSettings();
		//System.out.println(Database.getFormulaFromCache(1));
		//		ArrayList<Item> items =  new ArrayList<Item>();
		//		Item one = new Item();
		//		items.add(one);
		//		Database.saveInventory(items);
		String [][] a = Database.getRank();
		System.out.println(a.length);
	}*/
}