
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;

public class MathQuest
{
	private static JFrame outerFrame;
	private static final Dimension FRAME_DIMENSIONS = new Dimension(1024, 768);
	
	public MathQuest() {
		initializeMathQuest();
	}
	
	private void initializeMathQuest() {
		outerFrame = new JFrame("MathQuest");
		outerFrame.setSize(FRAME_DIMENSIONS);
		outerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		outerFrame.setLocationRelativeTo(null);
		outerFrame.setResizable(false);
		outerFrame.add(new LoginPage());
		outerFrame.setVisible(true);
	}
	
	public static Dimension getDimensions() {
		return FRAME_DIMENSIONS;
	}
	
	public static void switchToGameWorld() {
		outerFrame.removeAll();
		outerFrame.pack();
		outerFrame.add(new GameWorld());
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
