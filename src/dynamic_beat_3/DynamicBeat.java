package dynamic_beat_3;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class DynamicBeat extends JFrame {

	
	private Image screenImage;
	private Graphics screenGraphic;
	
	private Image introBack;
	
		public DynamicBeat() {
			setTitle("Dynamic Butt");
			setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
			setResizable(false);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			
			introBack = new ImageIcon(Main.class.getResource("../images/introBack.jpg")).getImage();
			
			Music intromusic = new Music("music.mp3", true);
			intromusic.start();
		}
		
		//프로그램이 종료될 떄까지 그려줌
		public void paint(Graphics g) {
			screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
			screenGraphic = screenImage.getGraphics();
			screenDraw(screenGraphic);
			g.drawImage(screenImage,0,0,null);
		}
		
		public void screenDraw(Graphics g) {
			g.drawImage(introBack,0,0,null);
			this.repaint();
		}
		
		
		
		
		
		
}
