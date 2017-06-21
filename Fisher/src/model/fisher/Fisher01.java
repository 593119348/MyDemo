package model.fisher;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Transparency;

import show.MJFrame;

import model.factory.ImageFactory;
import model.other.MyPoint;


public class Fisher01 extends Fisher {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int TYPE = ImageFactory.FISHER_10;
	
	public Fisher01(int x,int y,int ward,int speed,int value) {
		super(TYPE,new MyPoint(x, y),ward,speed,value);
	}

	@Override
	public void action() {
		if (isLive()==true) {
			if (getWard()==RIGHT) {
//				setMyX( getMyX()+getSpeed() );
			} else if (getWard()==LEFT) {
				setMyX( getMyX()-getSpeed() );
			} else if (getWard()==BUTTOM) {
				setMyY( getMyY()+getSpeed() );
			}
			setAngle(getAngle()+0.01f);
		}
//		System.out.println("IsLive:"+isLive()+";X:"+getMyX()+";Y:"+getMyY());
	}

	@Override
	public void draw(Graphics2D g) {
		Graphics2D g2 = getBufimg().createGraphics();
		Image img = nextImage();
		setBufimg( g2.getDeviceConfiguration().createCompatibleImage(img.getWidth(null), img.getHeight(null), 1) );
		g2.dispose();
		g2 = getBufimg().createGraphics();
		g2.drawImage(img, 0,0, null);
		g.rotate(getAngle(), 1000, 1000);
		g.drawImage(getBufimg(), Math.round(getMyX()), Math.round(getMyY()), null);
	}


}
