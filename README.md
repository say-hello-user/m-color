# m-color
图的m着色问题，通过canvas实现图的m着色问题的图形化表示，使用java实现图的m着色算法

![image]("github.com/say-hello-user/m-color/@6}{O`8F6CZ6NEGQHSRH15Q.png")

## 图的m着色问题是指下述两类问题

1.给定无环图G=（V,E），用m种颜色为图中的每条边着色，要求每条边着一种颜色，并使相邻的两条边有着不同的颜色，这个问题称为图的边着色问题。

2.给定无向图G=(V,E)，用m种颜色为图中的每个顶点着色，要求每个顶点着一种颜色，并使相邻的两顶点之间有着不同的颜色，这个问题称为图的顶点着色问题。

#### 回溯法
设数组color[n]表示顶点的着色情况，回溯法求解m着色问题的算法如下:

1.将数组color[n]初始化为0；

2.k=1

3.while(k>=1)

    3.1 依次考察每一种颜色，若顶点k的着色与其它顶点的着色不发生冲突，则转步骤3.2，否则，搜索下一个颜色；
  
    3.2 若顶点已全部着色，则输出数组color[n]，返回；
  
    3.3 否则
        3.3.1若顶点k是一个合法着色，则k=k+1，转步骤3处理下一个顶点;
        3.3.2否则，重置顶点K的着色情况，k=k+1，转步骤3.
      
```java
 public void GraphColor(int n,int c[][],int m)
     {
    	 this.c = c;
    	 int i,k=0;
       //所有数组数组下标从0开始
       for(i=0;i<=n;i++)
    	 {
    		color[i] = 0; //将数组color[n]初始化为0
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
        			 color[k] = color[k] + 1;//搜索下一个颜色
        		 }
        	 }
        	 if(color[k]<=m&&k==n-1)//求解完毕，输出解
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
        		 k = k+1;//处理下一个顶点
        	 else
        	 {
        		 color[k] = 0;
        		 k = k-1;//回溯
        	 }
         }
    	if(!isEnough) 
    	{
    		 System.out.println("最少需要的颜色不够");
    	}
     }
     
     
     public boolean OK(int k)
	{
  //判断顶点k的着色是否发生冲突
		for(int i=0;i<k;i++)
		{
			if(c[k][i]==1&&color[i]==color[k])
				return false;
		}
		return true;
	}
```
