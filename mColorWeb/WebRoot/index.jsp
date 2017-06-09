<%@ page language="java" import="java.util.*,main.mColor" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	//输入顶点数据,图的矩阵表示
       int c[][] = {
       					{1,1,1,1,0},
       					{1,1,1,1,1},
       					{1,1,1,1,0},
       					{1,1,1,1,1},
       					{0,1,0,1,1}
       			   };
			  /*  int c[][] = {
					{1,1,0,0,0},
					{1,1,1,0,0},
					{0,1,1,1,0},
					{0,0,1,1,1},
					{0,0,0,1,1}
			   };*/
      
	   StringBuilder sb = new StringBuilder();
	   List <String> list = new ArrayList<String>();
	   for(int i=0;i<c.length;i++)
	   {
		   for(int j =0;j<c.length;j++)
		   {
	   sb.append(c[i][j]);
	   sb.append("|");
		   }
		   if(i!=c.length-1)
		   sb.append(",");
	   }
	   mColor t2 = new mColor();
	   Integer lineNum;
	   lineNum = 5;//边数目
	   Integer colorNum;
	   colorNum = 4;
	   t2.GraphColor(lineNum, c, colorNum);
	   //第一个参数:边数
	   //第二个参数:顶点数据
	   //第三个参数:m颜色大小
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta name="renderer" content="webkit"> 
    <title>图的m着色问题</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <body>

	<button id="drawPolygon">绘画所有可能的图形</button>
    <div id="allCanvas" style="height: auto; width: auto;"></div>
    <script type="text/javascript">
      var colorData = new Array();
      var radius;

    var javaColor = "<%=t2.getList()%>";
    var newjavaColor = javaColor.replace("[","");
    var newdata = newjavaColor.split(",");
	console.log(javaColor)

  var matrixData = "<%=sb.toString()%>";
   var newMatrixData = matrixData.split(",");
   var dataArray = new Array();
   for(var i=0;i<newMatrixData.length;i++)
   {
       dataArray[i] = new Array();
       var newData = newMatrixData[i].split("|"); 
       for(var j=0;j<newData.length;j++)
       dataArray[i][j] = newData[j];
   }

	//初始化 需要load进行加载
	function init(){
		var btnDraPolygon = document.getElementById('drawPolygon');
		btnDraPolygon.addEventListener('click',addData,false);
		var allCanvas = document.getElementById("allCanvas");
	    colorData.push("#1abc9c");
	    colorData.push("#d35400");
	    colorData.push("#3498db");
	    colorData.push("#9b59b6");
	    colorData.push("#34495e");
	    colorData.push("#f1c40f");
	    colorData.push("#c0392b");
		radius = 40;
	}
	function addData()
	{     
		for(var i=0;i<newdata.length;i++)
		drawpolygon(newdata[i]);
	}
	function drawpolygon(data){
		var colorArray = data.split("|");
		colorArray.splice(colorArray.length-1,1)
		var canvas;
		var context;
	    var pointX = new Array();
	    var pointY = new Array();
		canvas = document.createElement("canvas");
		canvas.height = 100;
		canvas.width = 100;
		console.log(allCanvas.nodeName)
		allCanvas.append(canvas);
		context = canvas.getContext('2d');
		pointX.splice(0,pointX.length);
		pointY.splice(0,pointY.length);
		var numSides = "<%=lineNum%>";
		numSides = parseInt(numSides);
		//设置绘画中心位置
		var xCenter = parseInt(canvas.width/2);
		var yCenter = parseInt(canvas.height/2);

		//清空画布
		context.clearRect(0,0,canvas.width,canvas.height);

		//开始绘画
		//context.beginPath();

		//绘画的初始值 开始的位置
		var xPos = xCenter + radius * Math.cos(2*Math.PI*0/numSides);
		pointX.push(xPos);
		var yPos = yCenter + radius * Math.sin(2*Math.PI*0/numSides);
		pointY.push(yPos);

		//循环路径
		for(i = 1;i<=numSides; i++){
			xPos = xCenter+radius*Math.cos(2*Math.PI*i/numSides);
			yPos = xCenter+radius*Math.sin(2*Math.PI*i/numSides);
			pointX.push(xPos);
			pointY.push(yPos);
		}
		context.closePath();
   		for(var i = 0;i<numSides; i++){
			for(var j=i+1;j<numSides;j++)
				{
					context.beginPath();
					context.moveTo(pointX[i],pointY[i]);
					if(parseInt(dataArray[i][j]))
						context.lineTo(pointX[j],pointY[j]);
					 context.lineWidth = 5;   //线宽
					context.lineJoin = 'round'  //柔和边线处理 
					context.stroke();	
					context.closePath();
				}
		}
		for(i = 0;i<pointX.length-1; i++){
		        context.beginPath();
				context.arc(pointX[i],pointY[i],10,0,2*Math.PI);
				
				context.fillStyle = colorData[parseInt(colorArray[i])-1];
                 context.fill();
				context.closePath();

				 context.beginPath();
				 context.fillStyle = "white";
				context.font = "normal 5px 微软雅黑";//字体
		    context.textBaseline = "middle";//竖直对齐
			context.textAlign = "center";//水平对齐
			context.fillText(i+1, pointX[i], pointY[i]);//绘制文字
				context.closePath();	

		         			
		}

	}
	window.addEventListener('load',init,false);   //在页面加载完成就执行load方法
    </script>
  </body>
</html>
