package com.app.main;

public class main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
         int[][] map  = {{1,1,1,0,0},{1,1,0,1,1},{1,0,1,0,1},{0,1,0,1,1},{0,1,1,1,1}};
         mColor mc = mColor.getInstance();
         mc.setMap(map);//设置图的矩阵数据
         mc.getData();//初始化节点数据
         mc.sortDegree();//根据度为节点数据排序
         mc.getResult();//执行函数，获取结果
         mc.syso();//输出结果
    }

}
