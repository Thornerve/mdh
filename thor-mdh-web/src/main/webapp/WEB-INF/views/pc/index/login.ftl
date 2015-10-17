<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>后台管理系统(毕业论文)</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- The styles -->
    <link id="bs-css" href="/css/bootstrap-cerulean.css" rel="stylesheet">

    <link href="/css/charisma-app.css" rel="stylesheet">
    <link href='/bower_components/fullcalendar/dist/fullcalendar.css' rel='stylesheet'>
    <link href='/bower_components/fullcalendar/dist/fullcalendar.print.css' rel='stylesheet' media='print'>
    <link href='/bower_components/chosen/chosen.css' rel='stylesheet'>
    <link href='/bower_components/colorbox/example3/colorbox.css' rel='stylesheet'>
    <link href='/bower_components/responsive-tables/responsive-tables.css' rel='stylesheet'>
    <link href='/bower_components/bootstrap-tour/build/css/bootstrap-tour.css' rel='stylesheet'>
    <link href='/css/jquery.noty.css' rel='stylesheet'>
    <link href='/css/noty_theme_default.css' rel='stylesheet'>
    <link href='/css/elfinder.css' rel='stylesheet'>
    <link href='/css/elfinder.theme.css' rel='stylesheet'>
    <link href='/css/jquery.iphone.toggle.css' rel='stylesheet'>
    <link href='/css/uploadify.css' rel='stylesheet'>
    <link href='/css/animate.css' rel='stylesheet'>

    <!-- jQuery -->
    <script src="/bower_components/jquery/jquery.js"></script>

    <!-- The fav icon -->
    <link rel="shortcut icon" href="img/favicon.ico">

</head>

<body>
<div class="ch-container">
    <div class="row">
	    <div class="row">
	        <div class="col-md-12 center login-header">
	            <h2>后台管理系统(毕业论文)</h2>
	        </div>
	    </div>
	    <div class="row">
	        <div class="well col-md-5 center login-box">
	            <div class="alert alert-info">
	               	请输入用户名和密码
	            </div>
	            <form class="form-horizontal" action="/account/pclogin.htm" method="post">
	                <fieldset>
	                    <div class="input-group input-group-lg">
	                        <span class="input-group-addon"><i class="glyphicon glyphicon-user red"></i></span>
	                        <input type="text" id="userName" name="userName" class="form-control" placeholder="用户名">
	                    </div>
	                    <div class="clearfix"></div><br>
	
	                    <div class="input-group input-group-lg">
	                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock red"></i></span>
	                        <input type="password" id="password" name="password" class="form-control" placeholder="密码">
	                    </div>
	                    <div class="clearfix"></div>
	
	                    <div class="input-prepend">
	                        <label class="remember" for="remember"><input name="autoLogin" type="checkbox" id="remember"> 记住我</label>
	                    </div>
	                    <div class="clearfix"></div>
	
	                    <p class="center col-md-5">
	                        <button type="submit" id="submitForm" class="btn btn-primary">登陆</button>
	                    </p>
	                </fieldset>
	            </form>
	        </div>
	    </div>
	</div>
</div>

<script src="/bower_components/bootstrap/dist/js/bootstrap.js"></script>
<script src="/js/index/login1.js"></script>
</body>
</html>
