package myinterface;

import model.other.MySize;

public interface ISize {
	public void setMyWidth(float width);
	public void setMyHight(float hight);
	public float getMyWidth();
	public float getMyHight();
	public void setMySize(MySize s);
	public MySize getMySize();
}
