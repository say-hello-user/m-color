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
            k++;//k����ڼ�����ɫ
            int i;
            for(i=0;i<length;i++)//���ҵ���һ��δ��ɫ�Ľڵ�
            {
                if(node[i].getColor()==0)
                {
                    node[i].setColor(k);
                    break;
                }
            }
            if(i==map.length)//ѭ���˳����������нڵ㶼����ɫ
                break;
            for(int j=0;j<length;j++)//�ٰ����в��͸ýڵ����ڵĽڵ�����ͬ����ɫ
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
        System.out.println("����Ҫ"+(this.k-1)+"����ɫ");
        for(int i =0;i<map.length;i++)
        {
            System.out.println(node[i]);
        }
    }
}
