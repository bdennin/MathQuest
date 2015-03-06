package MathQuest.Pages;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import MathQuest.GUI.OptionsPanel;
import MathQuest.Logic.Character;

import java.io.File;
import java.io.IOException;

public class Blacksmith extends Area {
	
	private static final long serialVersionUID = 1L;

	public Blacksmith(Character hero) {
		super(hero);
		this.loadImages();
		this.renderBackground();
		
		
	}

	@Override
	public OptionsPanel loadOptionsPanel() {
		return new OptionsPanel(this.hero, true);
	}

	@Override
	public void loadImages() {
		try {           
			this.background = new ImageIcon(ImageIO.read(new File("insideBlacksmith.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
