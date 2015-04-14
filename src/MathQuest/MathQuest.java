package MathQuest;
//This is a comment
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import MathQuest.Database.Database;
import MathQuest.Logic.Character;
import MathQuest.Pages.*;


public class MathQuest
{
	private static final Dimension FRAME_DIMENSIONS = new Dimension(1024, 768);

	private static JFrame outerFrame;
	private static JPanel contentPane;
	private static String username;
	private static String password;
	private static Character hero;
	private static double volume;

	public static boolean connectToDatabase = true;
	public static boolean isMuted;

	public MathQuest() {
		initializeMathQuest();
	}

	private static void initializeMathQuest() {
		isMuted = false;
		volume = 1;
		outerFrame = new JFrame("MathQuest");
		outerFrame.setSize(FRAME_DIMENSIONS);
		outerFrame.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {

			}

			@Override
			public void windowClosing(WindowEvent e) {
				quitAndSave();
			}

			@Override
			public void windowClosed(WindowEvent e) {

			}

			@Override
			public void windowIconified(WindowEvent e) {

			}

			@Override
			public void windowDeiconified(WindowEvent e) {

			}

			@Override
			public void windowActivated(WindowEvent e) {

			}

			@Override
			public void windowDeactivated(WindowEvent e) {

			}
		});
		outerFrame.setLocationRelativeTo(null);
		outerFrame.setResizable(false);
		contentPane = new Login();
		outerFrame.setContentPane(contentPane);
		outerFrame.setVisible(true);
	}

	public static void quitAndSave() {
		if(MathQuest.connectToDatabase){
			if (Database.getType().equals("Student")){
				Database.getConnected();
				Database.setStatus(hero.getStatus());
				Database.saveInventory(hero.getInventory());
				Database.saveAccuracy(hero.getAnsweredCorrectly(), hero.getAnsweredIncorrectly());
				Database.close();
			}
		}
		System.exit(0);
	}

	public static Dimension getDimensions() {
		return FRAME_DIMENSIONS;
	}

	public static void switchToAdminMain(){
		contentPane = new AdminMain();
		outerFrame.setContentPane(contentPane);
	}

	public static void switchToAdminFomularSetting(int Id){
		contentPane = new AdminFormulaSetting(Id);
		outerFrame.setContentPane(contentPane);
	}

	public static void switchToGameWorld() {
		contentPane = new World(hero);
		outerFrame.setContentPane(contentPane);
	}

	public static void switchToInn() {
		contentPane = new Inn(hero);
		outerFrame.setContentPane(contentPane);
	}

	public static void switchToBlacksmith() {
		contentPane = new Blacksmith(hero);
		outerFrame.setContentPane(contentPane);
	}

	public static void switchToKillingFields() {
		contentPane = new KillingFields(hero);
		outerFrame.setContentPane(contentPane);
	}

	public static void switchToCombat(Character creature) {
		contentPane = new Combat(hero, creature);
		outerFrame.setContentPane(contentPane);
	}

	public static void switchToLogin(){
		Database.cleanUp();
		contentPane = new Login();
		outerFrame.setContentPane(contentPane);
		contentPane.revalidate();
	}

	public static void switchToAdminIndividualFormulaSetting(){
		contentPane = new AdminIndividualFormulaSetting();
		outerFrame.setContentPane(contentPane);
	}

	public static void switchToRankList(){
		contentPane = new RankList();
		outerFrame.setContentPane(contentPane);
	}

	public static String getUsername() {
		return username;
	}

	public static void setUsername(String name) {
		username = name;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String pass) {
		password = pass;
	}

	public static Character getCharacter() {
		return hero;
	}

	public static void setCharacter(Character character) {
		hero = character;
	}

	public static void setVolume(double gain) {
		volume = gain;
	}

	public static double getVolume() {
		return volume;
	}

	public static JFrame getOuterFrame(){
		return outerFrame;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater (
				new Runnable() {
					@Override
					public void run() {
						new MathQuest();
					}
				}
				);	
	}
}
