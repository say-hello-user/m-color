package com.app.main;

public class dataBean {
       private int index;//�ڵ���
       private int degree;//��
       private int color;//�ڵ����ɫ
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public int getDegree() {
        return degree;
    }
    public void setDegree(int degree) {
        this.degree = degree;
    }
    public int getColor() {
        return color;
    }
    public void setColor(int color) {
        this.color = color;
    }
    @Override
    public String toString() {
        return "dataBean [index=" + index + ", degree=" + degree + ", color="
                + color + "]";
    }
	public dataBean() {
		super();
	}
    
}
