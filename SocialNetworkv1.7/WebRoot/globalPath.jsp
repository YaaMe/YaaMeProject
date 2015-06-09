<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="pojo.*" %>
<%@ page import="model.*" %>
<!doctype html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <title>全局图</title>
    <script src="js/two.js"></script>
    <script src="js/arrow.js"></script>
  </head>
  <body>
<canvas id="myCanvas"></canvas>
  </body>
<script type="text/javascript">
var h = screen.height - 40;
	var w = screen.width - 20;
	var c=document.getElementById("myCanvas");
	c.setAttribute('width', w);
	c.setAttribute('height', h);
	var params = {fullscreen: true};
	var	two = new Two(params).appendTo(document.body);;
	var ctx=c.getContext("2d");
	ctx.font="20px Georgia";		 
	ctx.fillText("A",10,50);
	ctx.fillText("B",60,50);
	ctx.fillText("G",10,100);
	ctx.fillText("F",60,100);
	ctx.fillText("E",110,100);
	ctx.fillText("I",110,150);
	ctx.fillText("C",160,100);
	ctx.fillText("D",210,100);
	ctx.fillText("H",210,150);
	ctx.fillText("J",110,200);
	ctx.fillText("X",10,150);
	var line1=two.makeLine(20,45,70,45);

	var line2=two.makeLine(20,95,70,95);
	var line3=two.makeLine(70,95,120,95);
	line3.stroke='rgb(255, 100, 100)';
	var line4=two.makeLine(120,95,170,95);
	line4.stroke='rgb(255, 100, 100)';
	var line5=two.makeLine(120,145,170,95);
	line5.stroke='rgb(255, 100, 100)';
	var line6=two.makeLine(170,95,220,95);
	var line7=two.makeLine(120,195,170,95);
	line7.stroke='rgb(255, 100, 100)';
	var line8=two.makeLine(170,95,220,145);
	var line9=two.makeLine(120,195,220,145);
	line9.stroke='rgb(100, 100, 255)';
	var line10=two.makeLine(220,145,220,95);
	line10.stroke='rgb(255, 100, 100)';
	var cirAngle=0,
		cirAngle2=180,
		cirAngle3=0;
	var pos = getPositions(0, 40),
		cir1 = two.makeCircle(line1.translation.x, line1.translation.y, 5),
		cir2 = two.makeCircle(line2.translation.x, line2.translation.y, 5),
		cir3 = two.makeCircle(line3.translation.x, line3.translation.y, 5),
		cir4 = two.makeCircle(line4.translation.x, line4.translation.y, 5),
		cir5 = two.makeCircle(line5.translation.x, line5.translation.y, 5),
		cir6 = two.makeCircle(line6.translation.x, line6.translation.y, 5),
		cir7 = two.makeCircle(line7.translation.x, line7.translation.y, 5),
		cir8 = two.makeCircle(line8.translation.x, line8.translation.y, 5),
		cir9 = two.makeCircle(line9.translation.x, line9.translation.y, 5),
		cir10 = two.makeCircle(line10.translation.x, line10.translation.y, 5);
	cir1.fill = 'rgb(0, 0, 0)';cir1.opacity=0.95;
	cir2.fill = 'rgb(0, 80, 0)';cir2.opacity=0.95;
	cir3.fill = 'rgb(0, 130, 0)';cir3.opacity=1-0.99/6;
	cir4.fill = 'rgb(0, 205, 0)';cir4.opacity=1-0.99/3;
	cir5.fill = 'rgb(0, 205, 0)';cir5.opacity=1-0.99/3;
	cir6.fill = 'rgb(0, 255, 255)';
	cir7.fill = 'rgb(0, 205, 0)';cir7.opacity=1-0.99/3;
	cir8.fill = 'rgb(0, 205, 0)';cir8.opacity=1-0.99/3;
	cir9.fill = 'rgb(0, 205, 0)';cir9.opacity=1-0.99/3;
	cir10.fill = 'rgb(255, 255, 255)';
	

	two.bind("update", function (frameCount) {
		var cirPos = getPositions(cirAngle, 20);
		cir1.translation.x = line1.translation.x + cirPos.x;
		cir2.translation.x = line2.translation.x + cirPos.x;
		cir6.translation.x = line6.translation.x + cirPos.x;
		cir8.translation.x = line8.translation.x + cirPos.x;
		cir8.translation.y = line8.translation.y + cirPos.x;
		if(cirAngle2==0)
			cirAngle2=180;
		cirPos=getPositions(cirAngle2,20);
		cir3.translation.x = line3.translation.x + cirPos.x;
		cir4.translation.x = line4.translation.x + cirPos.x;
		cir5.translation.x = line5.translation.x + cirPos.x;
		cir5.translation.y = line5.translation.y - cirPos.x;
		cir7.translation.x = line7.translation.x + cirPos.x;
		cir7.translation.y = line7.translation.y - 2*cirPos.x;
		
		cirPos=getPositions(180-cirAngle2,40);
		cir9.translation.x = line9.translation.x + cirPos.x;
		cir9.translation.y = line9.translation.y - 0.5*cirPos.x;
		cirPos=getPositions(180-cirAngle2,20);
		cir10.translation.y = line10.translation.y + cirPos.x;
		cirAngle +=5;
		cirAngle2-=3;
		
	});

	function getPositions(angle, orbit) {
		return {
				x: Math.cos(angle * Math.PI / 180) * orbit,
				y: Math.sin(angle * Math.PI / 180) * orbit
			};
	}
	two.update();
	two.play();
</script>
</html>

