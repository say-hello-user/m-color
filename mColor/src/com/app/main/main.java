package com.app.main;

public class main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
         int[][] map  = {{1,1,1,0,0},{1,1,0,1,1},{1,0,1,0,1},{0,1,0,1,1},{0,1,1,1,1}};
         mColor mc = mColor.getInstance();
         mc.setMap(map);//����ͼ�ľ�������
         mc.getData();//��ʼ���ڵ�����
         mc.sortDegree();//���ݶ�Ϊ�ڵ���������
         mc.getResult();//ִ�к�������ȡ���
         mc.syso();//������
    }

}
