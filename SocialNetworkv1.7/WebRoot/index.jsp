<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="pojo.*" %>
<%@ page import="model.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta charset="utf-8">
  <!-- Title and other stuffs -->
  <title>YaaMe</title> 
  <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
  <meta name="author" content="YaaMe">
  <!-- Stylesheets -->
  <link href="style/bootstrap.css" rel="stylesheet">
  <!-- Font awesome icon -->
  <link rel="stylesheet" href="style/font-awesome.css"> 
  <!-- jQuery UI -->
  <link rel="stylesheet" href="style/jquery-ui.css"> 
  <!-- Calendar -->
  <link rel="stylesheet" href="style/fullcalendar.css">
  <!-- prettyPhoto -->
  <link rel="stylesheet" href="style/prettyPhoto.css">  
  <!-- Star rating -->
  <link rel="stylesheet" href="style/rateit.css">
  <!-- Date picker -->
  <link rel="stylesheet" href="style/bootstrap-datetimepicker.min.css">
  <!-- CLEditor -->
  <link rel="stylesheet" href="style/jquery.cleditor.css">
  <!-- Bootstrap toggle -->
  <link rel="stylesheet" href="style/bootstrap-switch.css">
  <!-- Main stylesheet -->
  <link href="style/style.css" rel="stylesheet">
  <!-- Widgets stylesheet -->
  <link href="style/widgets.css" rel="stylesheet">   
  
  <!-- HTML5 Support for IE -->
  <!--[if lt IE 9]>
  <script src="js/html5shim.js"></script>
  <![endif]-->

  <!-- Favicon -->
  <link rel="shortcut icon" href="img/favicon/favicon.png">

  <!-- Form -->
  <link rel="stylesheet" type="text/css" href="Css/Login_style.css" />
  <script type="text/javascript" src="Javascript/Login_javascript.js"></script>
  <!--LeftBar-->
  <link rel="stylesheet" type="text/css" href="Css/component.css" />
  <script src="js/modernizr.custom.js"></script>
  <!-- RightSection -->
  <link rel="stylesheet" href="Css/sectiondiy.css"> 
  <link rel="stylesheet" href="Css/button.css"> 
    <!-- password -->
  <link rel="stylesheet" href="Css/password.css"> 
  <!-- alert -->
  
  <!-- upload -->

</head>

<body>

<!-- Header starts -->
  <header>
    <div class="container">
      <div class="row">

        

        <!-- Button section -->
        <div class="col-md-4">
        <object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=8,0,0,0" width="160" height="70" id="honehoneclock" align="middle">
            <param name="allowScriptAccess" value="always" />
            <param name="movie" value="http://chabudai.sakura.ne.jp/blogparts/honehoneclock/honehone_clock_tr.swf" />
            <param name="quality" value="high" />
            <param name="bgcolor" value="#ffffff" />
            <param name="wmode" value="transparent" />
            <embed wmode="transparent" src="http://chabudai.sakura.ne.jp/blogparts/honehoneclock/honehone_clock_tr.swf" quality="high" bgcolor="#ffffff" width="160" height="70" name="honehoneclock" align="middle" allowScriptAccess="always" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" />
            </object>

        </div>
		<!-- Logo section -->
        <div class="col-md-4">
          <!-- Logo. -->
           <div class="logo">
            <h1><a href="#">Coded by YaaMe<span class="bold"></span></a></h1>
            <p class="meta">基于图结构的社交网络分析系统的设计和实现</p>
          </div>
          <!-- Logo ends -->
        </div>
        <!-- Data section -->

        <div id="identity" class="col-md-4">
        <!-- Links -->
            <ul class="nav navbar-nav pull-right">
            
            <li class="dropdown pull-right">            
              <a data-toggle="modal" data-target="#myLogin" class="dropdown-toggle" href="#">
                Click to Login           
              </a>

             </li>
            
           </ul>  
        </div>

      </div>
    </div>
  </header>

<!-- Header ends -->
<!-- 模态框（Modal） -->
<div class="modal fade" id="myLogin" tabindex="-1" role="dialog" 
     aria-labelledby="myModalLabel" aria-hidden="true">
     <div class="modal-dialog">

          <div class="modal-body">
             <div class="LoginWindow">
                 <div id="loginForm" class="login">
                    <p>
                      <label for="login">帐号:</label>
                      <input type="text" name="id" id="id" value="">
                    </p>

                    <p>
                      <label for="password">密码:</label>
                      <input type="password" name="password" id="password" value="">
                    </p>

                    <p class="login-submit">
                      <button onclick="loginSubmit()" class="login-button" data-dismiss="modal">Login</button>
                    </p>

                 </div>

             </div>
          </div>

  </div><!-- /.modal -->
 </div>
  <div class="modal fade" id="mypwdModal" tabindex="-1" role="dialog" 
     aria-labelledby="myModalLabel" aria-hidden="true">
     <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
              <button type="button" class="close" 
                data-dismiss="modal" aria-hidden="true">
                   &times;
             </button>
             <h4 class="modal-title" id="mypwdLabel" >
                	修改密码
             </h4>
          </div>
          <div class="modal-body ">
            <ul><li>
             <label for="newpassword">新密码  :</label>
              <input type="password" id="npwd" placeholder="new Password" />
            </li>
            <li>
            <label for="checkpassword">确认密码:</label>
            <input type="password" id="cpwd" placeholder="check it!" />
            <span class="form_hint">密码不同</span>
            </li>
            <li>
            <button id="pwdsub" type="button" class="btn btn-primary"  onclick="pwdchange()" data-dismiss="modal">
                                          确认更改
            </button>
            </li>
            </ul>
          </div>
          
        </div><!-- /.modal-content -->
  </div><!-- /.modal -->
 </div>

<!-- Main content starts -->

<div class="content">

    <!-- Sidebar -->
    <div class="sidebar">
        <div class="sidebar-dropdown"><a href="#">Navigation</a></div>
          <!-- Recent posts widget -->
            <div class="col-md-12 container demo-2">
            <div id="dl-menu" class="dl-menuwrapper">
	          <ul class="dl-menu dl-menuopen">
	           <div id="personal" class="demo-6">
	            
	            </div> 
	            <li>
	                <a href="#" id="myList" onclick="describeclick()">关于</a>
	            </li>
	          </ul>
        	</div>
            </div> 
      </div>
        
    </div>

    <!-- Sidebar ends -->

    <!-- Main bar -->
    <div class="mainbar">

      <!-- Page heading -->
      <div class="page-head">
         <ul id="tabs">
          <li><a href="#" name="#tab1" class="tabtitle">列表</a></li>
       </ul>

        <div class="clearfix"></div>

      </div>
      <!-- Page heading ends -->

      <!-- Matter -->

      <div class="matter">
        <div class="container">
      <div class="sectiondiy">
      <div id="tab1" class="tabcontext">
          <ul id="output">
			<li>
				基于图结构的社交网络分析系统的设计和实现。</br>
				最后更新于2015-5-24。
			</li>
          </ul>
   		  
      </div>
     <div id="describe" class="modal fade" style="display: none; ">
		<div class="modal-header">
		<a class="close" data-dismiss="modal">×</a>
		<h3>基于图结构的社交网络分析系统的设计和实现。</h3>
		<h3>最后更新于2015-5-24。</h3>
		</div>
	 </div>
  </div>



        </div>
      </div>
    <!-- Matter ends -->

    </div>

   <!-- Mainbar ends -->        
   <div class="clearfix"></div>

</div>
<!-- Content ends -->

<!-- Footer starts -->
<footer>
  <div class="container">
    <div class="row">
      <div class="col-md-12">
            <!-- Copyright info -->
            <p class="copy">Copyright &copy; 2012 | <a href="#">Your Site</a> </p>
      </div>
    </div>
  </div>
</footer>   

<!-- Footer ends -->

<!-- Scroll to top -->
<span class="totop"><a href="#"><i class="icon-chevron-up"></i></a></span> 

<!-- JS -->
<script src="js/jquery.js"></script> <!-- jQuery -->
<script type="text/javascript" src="js/jquery.min.js"></script>
<script src="js/bootstrap.js"></script> <!-- Bootstrap -->
<script src="js/jquery-ui-1.9.2.custom.min.js"></script> <!-- jQuery UI -->
<script src="js/fullcalendar.min.js"></script> <!-- Full Google Calendar - Calendar -->
<script src="js/jquery.rateit.min.js"></script> <!-- RateIt - Star rating -->
<script src="js/jquery.prettyPhoto.js"></script> <!-- prettyPhoto -->
<script type="text/javascript" src="js/featureList.js"></script><!-- ListSection -->

<!-- jQuery Flot -->
<script src="js/excanvas.min.js"></script>
<script src="js/jquery.flot.js"></script>
<script src="js/jquery.flot.resize.js"></script>
<script src="js/jquery.flot.pie.js"></script>
<script src="js/jquery.flot.stack.js"></script>

<!-- jQuery Notification - Noty -->
<script src="js/jquery.noty.js"></script> <!-- jQuery Notify -->
<script src="js/themes/default.js"></script> <!-- jQuery Notify -->
<script src="js/layouts/bottom.js"></script> <!-- jQuery Notify -->
<script src="js/layouts/topRight.js"></script> <!-- jQuery Notify -->
<script src="js/layouts/top.js"></script> <!-- jQuery Notify -->
<!-- jQuery Notification ends -->

<script src="js/sparklines.js"></script> <!-- Sparklines -->
<script src="js/jquery.cleditor.min.js"></script> <!-- CLEditor -->
<script src="js/bootstrap-datetimepicker.min.js"></script> <!-- Date picker -->
<script src="js/bootstrap-switch.min.js"></script> <!-- Bootstrap Toggle -->
<script src="js/filter.js"></script> <!-- Filter for support page -->
<script src="js/custom.js"></script> <!-- Custom codes -->
<script src="js/charts.js"></script> <!-- Charts & Graphs -->
<!-- Draw -->
<script src="js/two.js"></script> 
<script type="text/javascript">
function openWin(){
window.open("globalPath.jsp");
}
</script>

<!-- RightSection -->
<script type="text/javascript" src="js/sectiondiy.js"></script>
<!-- LeftBar -->
<script type="text/javascript" src="js/jquery.dlmenu.js"></script>
<script type="text/javascript">
$(function() {
    $( '#dl-menu' ).dlmenu({
        animationClasses : { classin : 'dl-animate-in-1', classout : 'dl-animate-out-1' }
    });
});
</script>
<!-- login -->
<script type="text/javascript">
  function loginSubmit () {
    localStorage.setItem("userid",$("#id").val());
    $("#identity").html("<ul class=\"nav navbar-nav pull-right\">" +
        "<li class=\"dropdown pull-right\">" +
        "<span>" +
        "Logining..." +
        "</span>" +
        "</li>" +
        "</ul>");
    $.ajax({
      type:"post",
      url:"login.do",
      async:"false",
      data:{
      name:$("#id").val(),
      password:$("#password").val()
      },
      success:function(data){
      if(data==0){
      $("#identity").html("<div class=\"alert alert-warning\">" +
        "<a class=\"close\" data-dismiss=\"alert\" href=\"#\" aria-hidden=\"true\">" +
        "<strong>login failed!</strong>&times;" +
        "</a>" +
        "</div>" +
        "<ul class=\"nav navbar-nav pull-right\">" +
        "<li class=\"dropdown pull-right\">" +
        "<a data-toggle=\"modal\" data-target=\"#myLogin\" class=\"dropdown-toggle\" href=\"#\">" +
        "Click to Login" +
        "</a>" +
        "</li>" +
        "</ul>");
      }
      else{
        $("#identity").html(data);
        $.ajax({
          type:"post",
          url:"loadleftbar.do",
          success:function(data){
            $("#personal").html(data);
            $(".dl-back").remove();
            $( '#dl-menu' ).dlmenu({
            animationClasses : { classin : 'dl-animate-in-1', classout : 'dl-animate-out-1' }
        });
          },
          error:function(){
            alert("error in load LeftBar");
          }
        });
        $.ajax({
          type:"post",
          url:"output.do",
          success:function(data){
            $("#output").html(data);
            $(".dl-back").remove();
            $( '#dl-menu' ).dlmenu({
            animationClasses : { classin : 'dl-animate-in-1', classout : 'dl-animate-out-1' }
        });
	        $('.dl-menuopen li a').featureList({
			output			:	'#output li',
			start_item		:	0
		});
          },
          error:function(){
            alert("error in load output");
          }
        });
        }
      },
      error:function(){
        alert("error");
      }
      });
    
  }
  function pwdchange(){
  	if($("#cpwd").val()==$("#npwd").val()){
  		$.ajax({
          type:"post",
          url:"PasswordChange.do",
          data:{
          npwd:$("#npwd").val()
          },
          success:function(data){
            alert("pwd change success!");
            $.ajax({
          type:"post",
          url:"loadleftbar.do",
          success:function(data){
            $("#personal").html(data);
            $(".dl-back").remove();
            $( '#dl-menu' ).dlmenu({
            animationClasses : { classin : 'dl-animate-in-1', classout : 'dl-animate-out-1' }
        });
          },
          error:function(){
            alert("error in load LeftBar");
          }
        });
             $.ajax({
          type:"post",
          url:"output.do",
          success:function(data){
            $("#output").html(data);
            $(".dl-back").remove();
            $( '#dl-menu' ).dlmenu({
            animationClasses : { classin : 'dl-animate-in-1', classout : 'dl-animate-out-1' }
        });
	        $('.dl-menuopen li a').featureList({
			output			:	'#output li',
			start_item		:	0
		});
          },
          error:function(){
            alert("error in load output");
          }
        });
       	 	},
          error:function(){
            alert("error in pwd change");
          }
        });
  	}
  	else{
  		alert("pwd wrong!");
  	}
  }
  
</script>

<!-- Section  -->
<script type="text/javascript" src="js/featureList.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('.dl-menuopen li a').featureList({
		output			:	'#output li',
		start_item		:	0
	});
});

function describeclick(){
	$("#describe").modal();
}
</script>
</body>
</html>