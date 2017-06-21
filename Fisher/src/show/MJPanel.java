package show;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import model.fisher.Fisher;
import model.fisher.Fisher01;

public class MJPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Image BG1 = new ImageIcon("imgs/bg_dewey.png").getImage();
	private static final Image BG2 = new ImageIcon("imgs/bg_03.png").getImage();
	private static final Image MENU = new ImageIcon("imgs/bg1.jpg").getImage();
//	private static final Image FIRE = new ImageIcon("imgs/level.png").getImage();
	private static final Image CLOST = new ImageIcon("imgs/close.png").getImage();
	private static final int FLUSH_TIME = 60;
	private static BufferedImage bimg;
	
	private Fisher f1;
	
	public MJPanel() {
		bimg = new BufferedImage(MJFrame.W-20, MJFrame.H-60,BufferedImage.TYPE_INT_RGB);
		f1 = new Fisher01(200, 200, Fisher.RIGHT, 1, 1);
		new DynamicThread().start();
		new Thread(f1).start();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(BG1, 0, 0, MJFrame.W, MJFrame.H, null);
		g.drawImage(CLOST, MJFrame.W-50, 15, 30, 30, null);
		
		Graphics2D gbimg = bimg.createGraphics();
		gbimg.drawImage(BG2, 0, 0, bimg.getWidth(), bimg.getHeight(), null);
		gbimg.drawImage(MENU, 0, bimg.getHeight()-50, bimg.getWidth(), 50, null);
		
		f1.draw(gbimg);
		
		g.drawImage(bimg, 10, 50, null);
	}
	
	class DynamicThread extends Thread {
		public void run() {
			super.run();
			while (true) {
				repaint();
				try {
					Thread.sleep(FLUSH_TIME);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
