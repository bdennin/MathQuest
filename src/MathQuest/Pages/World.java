package MathQuest.Pages;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import MathQuest.MathQuest;
import MathQuest.GUI.OptionsPanel;
import MathQuest.Logic.Character;

public class World extends Area {

	private static final long serialVersionUID = 1L;
	private BasicPlayer mediaPlayer;
	
	public World(Character hero) {
		
		super(hero);
		this.loadImages();
		
		this.initializeMusic();
		
		final JLabel innLabel = new JLabel();
		innLabel.setBounds(0, 0, 180, 650);
		innLabel.setToolTipText("Travel to the inn!");
		innLabel.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				stopMusic();
				MathQuest.switchToInn();
			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				innLabel.setBorder(new LineBorder(Color.yellow));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				innLabel.setBorder(null);
			}
		});
		add(innLabel);

		final JLabel blacksmithLabel = new JLabel();
		blacksmithLabel.setBounds(660, 0, 363, 600);
		blacksmithLabel.setToolTipText("Travel to the blacksmith!");
		blacksmithLabel.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				stopMusic();
				MathQuest.switchToBlacksmith();
			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				blacksmithLabel.setBorder(new LineBorder(Color.yellow));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				blacksmithLabel.setBorder(null);
			}
		});
		add(blacksmithLabel);

		final JLabel killingFieldsLabel = new JLabel();
		killingFieldsLabel.setBounds(250, 550, 300, 318);
		killingFieldsLabel.setToolTipText("Travel to the killing fields!");
		killingFieldsLabel.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				stopMusic();
				MathQuest.switchToKillingFields();
			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			public void mouseEntered(MouseEvent e) {
				killingFieldsLabel.setBorder(new LineBorder(Color.yellow));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				killingFieldsLabel.setBorder(null);
			}
		});
		add(killingFieldsLabel);
		
		this.renderBackground();
	}
	
	private void initializeMusic() {
	
		String worldMusic = System.getProperty("user.dir").replace("\\", "/") + "/townMusic.mp3";
		this.mediaPlayer = new BasicPlayer();
		
		try {
			mediaPlayer.open(new URL("file:///" + worldMusic));
			mediaPlayer.play();
		}
		catch(BasicPlayerException | MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	private void stopMusic() {
		try {
			this.mediaPlayer.stop();
		} catch (BasicPlayerException e) {
			e.printStackTrace();
		}
	}
	
	public void loadImages() {
		try {           
			this.background = new ImageIcon(ImageIO.read(new File("gameworld.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public OptionsPanel loadOptionsPanel() {
		return new OptionsPanel(this.hero, false);
	}
}
