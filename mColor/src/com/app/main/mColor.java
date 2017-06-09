package com.app.main;

import java.util.TreeMap;

public class mColor {
    private static int[][] map ;
    private  dataBean node[];
    private static mColor mc = null;
    private static int k =0;
    private mColor(){ 
    	node=new dataBean[10];
        for(int i =0;i<10;i++)
            node[i] = new dataBean();
     }
    public static mColor getInstance()
    {
        if(mc==null)
            mc = new mColor();
        return mc;
    }
    public void sortDegree()
    {
        int i;
        int size = node.length;
        dataBean temp = new dataBean();
        for(i=0;i<size;i++)
        {
            int k = i;
            for(int j = size-1;j>i;j--)
            {
                if(node[j].getDegree()>node[k].getDegree())
                {
                    k = j;
                }
            }
            temp = node[i];
            node[i] = node[k];
            node[k] = temp;
        }
      
    }
    public  void getData()
    {
        int i,j,degree;
        for(i=0;i<map.length;i++)
        {
            degree = 0;
            for(j=0;j<map.length;j++)
            {
                if(map[i][j]==1&&i!=j)
                {
                    degree++;
                }
            }
            node[i].setIndex(i);
            node[i].setDegree(degree);
            node[i].setColor(0);
        }
    }
    public void getResult()
    {
    	int length = map.length;
        while(true)
        {
            k++;//k代表第几种颜色
            int i;
            for(i=0;i<length;i++)//先找到第一个未着色的节点
            {
                if(node[i].getColor()==0)
                {
                    node[i].setColor(k);
                    break;
                }
            }
            if(i==map.length)//循环退出条件，所有节点都已着色
                break;
            for(int j=0;j<length;j++)//再把所有不和该节点相邻的节点着相同的颜色
            {
                if(node[j].getColor()==0 && map[node[i].getIndex()][node[j].getIndex()]==0 && i!=j)
                {
                    node[j].setColor(k);
                }
            }
        }
    }
    public int[][] getMap() {
        return map;
    }
    public void setMap(int[][] map) {
        this.map = map;
    }
    public void syso()
    {
        System.out.println("共需要"+(this.k-1)+"种颜色");
        for(int i =0;i<map.length;i++)
        {
            System.out.println(node[i]);
        }
    }
}
