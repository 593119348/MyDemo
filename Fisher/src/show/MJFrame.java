package show;


import java.awt.Cursor;

import javax.swing.JFrame;

public class MJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int W = 800,H = 600;
	public static final int CENW = MJFrame.W/2;
	public static final int CENH = MJFrame.H/2;
	public MJFrame() {
		MJPanel panel = new MJPanel();
		panel.setBounds(0, 0, W, H);
		this.setSize(W, H);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setUndecorated(true);
		this.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		this.add(panel);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new MJFrame();
	}
	
}
