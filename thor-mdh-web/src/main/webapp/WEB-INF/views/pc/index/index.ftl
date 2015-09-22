<!DOCTYPE HTML>
<html>
<head>
<#import "/lib/spring.ftl" as spring /> 
<#import "/lib/jscss.ftl" as jc />
<meta charset="utf-8">
<title>卖的欢管理系统</title>
<#include "/common/common_meta.ftl" />
<#-- 导入jquery核心类库 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/js/common/jquery-1.11.3.min.js?t=${buildNo}"></script>
<#-- 导入easyui类库 -->
<link id="easyuiTheme" rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/default.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
<#-- 导入ztree类库 -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/js/ztree/zTreeStyle.css" type="text/css" />
<script src="${pageContext.request.contextPath }/js/ztree/jquery.ztree.all-3.5.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/easyui/easyui-lang-zh_CN.js" type="text/javascript"></script>
<#-- js -->
<script src="${pageContext.request.contextPath }/js/index/login.js" type="text/javascript"></script>
</head>
<body class="easyui-layout">
	<#-- 页头 -->
	<#include "/public/header.ftl" />
	
	<#-- 右侧内容 -->
	<#include "/index/center.ftl" />
	
	<#-- 页尾 -->
	<#include  "/public/footer.ftl" />
	
	<#--修改密码窗口-->
    <#include "/index/updatePassword.ftl" />
</body>
</html>
