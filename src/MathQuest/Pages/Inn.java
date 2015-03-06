package MathQuest.Pages;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import java.io.File;
import java.io.IOException;

import MathQuest.GUI.OptionsPanel;
import MathQuest.Logic.Character;

public class Inn extends Area {

	private static final long serialVersionUID = 1L;
	private final static Character dude = new Character();
	
	public Inn(Character hero) {
		super(dude);
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
			this.background = new ImageIcon(ImageIO.read(new File("insideInn.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
