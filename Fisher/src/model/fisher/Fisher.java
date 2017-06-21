package model.fisher;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.List;


import model.factory.ImageFactory;
import model.other.MyPoint;
import model.other.MySize;
import myinterface.IAction;
import myinterface.IDraw;
import myinterface.ILocal;
import myinterface.ISize;

public abstract class Fisher extends Rectangle implements Runnable,IAction,IDraw,ILocal,ISize {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int RIGHT=0,LEFT=1,BUTTOM=2;
	private static final int FLUSH_TIME = 60;
	private MySize size;
	private MyPoint point;
	private int value;
	private int ward;
	private float angle;
	private int speed;
	private int type;
	private List<Image[]> imgList;
	private int imgsIndex;
	private BufferedImage bufimg;
	private boolean live = true;
	
	public Fisher(int type, MyPoint point, int ward, int speed, int value) {
		this.type = type;
		this.point = point;
		this.size = new MySize(0, 0);
		this.ward = ward;
		this.speed = speed;
		this.value = value;
//		Image img = nextImage();
		bufimg = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
	}
	
	public Image nextImage() {
		if (imgList==null) {
			imgList = ImageFactory.getIstance().getObject(type);
		}
		Image[] imgs = imgList.get(ward==RIGHT?ImageFactory.FISHER_RIGHT:(ward==LEFT?ImageFactory.FISHER_LEFT:ImageFactory.FISHER_BUTTOM));
		imgsIndex = imgsIndex<imgs.length?imgsIndex:0;
		Image img = imgs[imgsIndex++];
		setSize(img.getWidth(null), img.getHeight(null));
		setMyWidth(img.getWidth(null));
		setMyHight(img.getHeight(null));
		return img;	
	}
	
	@Override
	public void run() {
		while(live==true) {
			action();
			try {
				Thread.sleep(FLUSH_TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public float getAngle() {
		return angle;
	}

	public void setAngle(float angle) {
		this.angle = angle;
	}

	public BufferedImage getBufimg() {
		return bufimg;
	}

	public void setBufimg(BufferedImage bufimg) {
		this.bufimg = bufimg;
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getWard() {
		return ward;
	}
	public void setWard(int ward) {
		this.ward = ward;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	@Override
	public MyPoint getMyPoint() {
		return point;
	}

	@Override
	public float getMyX() {
		return point.getX();
	}

	@Override
	public float getMyY() {
		return point.getY();
	}

	@Override
	public void setMyPoint(MyPoint p) {
		point = p;
		setLocation(Math.round(p.getX()), Math.round(p.getY()));
	}

	@Override
	public void setMyX(float x) {
		point.setX(x);
		setLocation(Math.round(point.getX()), Math.round(point.getY()));
	}

	@Override
	public void setMyY(float y) {
		System.out.println(y);
		point.setY(y);
		setLocation(Math.round(point.getX()), Math.round(point.getY()));
	}

	@Override
	public float getMyHight() {
		return size.getHight();
	}

	@Override
	public MySize getMySize() {
		return size;
	}

	@Override
	public float getMyWidth() {
		return size.getWidth();
	}

	@Override
	public void setMyHight(float hight) {
		size.setHight(hight);
		setSize(Math.round(size.getWidth()),Math.round(size.getHight()));
	}

	@Override
	public void setMySize(MySize s) {
		size = s;
		setSize(Math.round(size.getWidth()),Math.round(size.getHight()));
	}

	@Override
	public void setMyWidth(float width) {
		size.setWidth(width);
		setSize(Math.round(size.getWidth()),Math.round(size.getHight()));
	}
	
}
