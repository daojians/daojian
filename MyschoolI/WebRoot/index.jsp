<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
  <head>
    <title>学生</title>
     <script src="jquery-1.11.0.js"></script>
  <script type="text/javascript">
  function dj(idd){
  //存值，点击时对值进行修改，将修改的值传递到servlet
       //创建一个XMLHttpRequest对象
     var request = new XMLHttpRequest();
     //设置回调函数
     request.onreadystatechange=callBack;
     //初始化请求信息
     var url="http://192.168.43.245:8080/fenye/selectServlet?yema"+idd;
     request.open("get",url,true);
     request.send(null);
   
     function callBack() {
        if(request.readyState==4&&request.status==200){
            var s = request.responseText;
            var obj = JSON.parse(s);
            for (var int = 0; int < obj.length; int++) {
            	$("#"+(int+1)).html(obj[int].studentname);
			}
        }
     }
		
  }

 </script>
  </head>
  
  <body>
    		<p id="1"></p>
    		<p id="2"></p>
    		<p id="3"></p>
    		<p id="4"></p>
    		<p id="5"></p>
    	
   <button onclick="dj(1)">上一页</button>
   <button onclick="dj(2)">下一页</button>
  </body>

</html>
