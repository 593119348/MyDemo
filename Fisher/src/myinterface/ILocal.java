package myinterface;

import model.other.MyPoint;

public interface ILocal {
	public void setMyX(float x);
	public void setMyY(float y);
	public float getMyX();
	public float getMyY();
	public void setMyPoint(MyPoint p);
	public MyPoint getMyPoint();
}
