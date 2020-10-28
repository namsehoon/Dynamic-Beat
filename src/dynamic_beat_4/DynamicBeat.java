package dynamic_beat_4;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DynamicBeat extends JFrame {

	
	private Image screenImage;
	private Graphics screenGraphic;
	
	private Image introBack = new ImageIcon(Main.class.getResource("../images/introBack.jpg")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/memuBar.png")));
	
	private ImageIcon exitBtnEnteredImage = new ImageIcon(Main.class.getResource("../images/back.png"));
	private ImageIcon exitBtnBasicImage =  new ImageIcon(Main.class.getResource("../images/go.png"));
	private JButton exitBtn = new JButton(exitBtnBasicImage);
	
	private int mouseX, mouseY;
	

		public DynamicBeat() {
			//ȭ��
			setUndecorated(true);
			setTitle("Dynamic Butt");
			setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
			setResizable(false);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			setBackground(new Color(0,0,0,0));
			setLayout(null);
			
			//��ư����
			exitBtn.setBounds(0, 0 ,30, 30);
			exitBtn.setBorderPainted(false);
			exitBtn.setContentAreaFilled(false);
			exitBtn.setFocusPainted(false);
			//�̺�Ʈ
			exitBtn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					exitBtn.setIcon(exitBtnEnteredImage);
					exitBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					exitBtn.setIcon(exitBtnBasicImage);
					exitBtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
				@Override
				public void mousePressed(MouseEvent e) {
					System.exit(0);
				}
			});
			
			add(exitBtn);
			
			
			//�޴� �� ����
			menuBar.setBounds(0, 0, 1280, 30);
			menuBar.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					mouseX = e.getX();
					mouseY = e.getY();
				}
			});
			//�̺�Ʈ
			menuBar.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					int x = e.getXOnScreen();
					int y = e.getYOnScreen();
					//�޴��� ��� ������ ����
					setLocation(x - mouseX, y - mouseY);
				}
			});
			add(menuBar);
			
		
			Music intromusic = new Music("music.mp3", true);
			intromusic.start();
		}
		
		//���α׷��� ����� ������ �׷���
		public void paint(Graphics g) {
			screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
			screenGraphic = screenImage.getGraphics();
			screenDraw(screenGraphic);
			g.drawImage(screenImage,0,0,null);
		}
		
		public void screenDraw(Graphics g) {
			g.drawImage(introBack,0,0,null);
			//������ ��
			paintComponents(g);
			this.repaint();
		}
		
		
		
		
		
		
}
