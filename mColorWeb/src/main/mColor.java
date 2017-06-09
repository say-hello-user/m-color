package main;

import java.util.ArrayList;
import java.util.List;


public class mColor {
	private int[] color = new int[10];
	private int c[][];
	private boolean isEnough=false;
	private List<String> data = new ArrayList<String>();
	public boolean OK(int k)
	{
		for(int i=0;i<k;i++)
		{
			if(c[k][i]==1&&color[i]==color[k])
				return false;
		}
		return true;
	}
     public void GraphColor(int n,int c[][],int m)
     {
    	 this.c = c;
    	 int i,k=0;    	 
    	 for(i=0;i<=n;i++)
    	 {
    		color[i] = 0; 
    	 }
         while(k>=0)
         {
        	 color[k] = color[k] + 1;
        	 while(color[k]<=m)
        	 {
        		 if(OK(k))
        		 {
        			 break;
        		 }
        		 else
        		 {
        			 color[k] = color[k] + 1;
        		 }
        	 }
        	 if(color[k]<=m&&k==n-1)
        	 {
        		 StringBuilder sb = new StringBuilder();
        		 for(i=0;i<n;i++)
        		 {
        			 sb.append(color[i]);
        			 sb.append("|");
        		 }
        		 data.add(sb.toString());
        		 isEnough = true;
        	 }
        	 else if(color[k]<=m&&k<n)
        		 k = k+1;
        	 else
        	 {
        		 color[k] = 0;
        		 k = k-1;
        	 }
         }
    	if(!isEnough) 
    	{
    		 System.out.println("最少需要的颜色不够");
    	}
     }
     public List<String> getList()
     {
    	 return this.data;
     }
}
