<!doctype html>
<html>
<head>
<#import "/ftlib/spring.ftl" as spring /> 
<#import "/ftlib/jscss.ftl" as jc />

<#-- 公用meta -->
<title>哎呀，你访问的页面走丢了...</title>

<#-- css -->
<@jc.cssurl url = ["css/lib/mobile-reset","css/pages/base","css/components/header","css/components/arrow","css/pages/error-404"]/>

<#-- 公用头部js -->
<#include "/mobile/mall/public/common_header_js.ftl" />
</head>
<body>
	<#if source?exists && source == "MongoToC">
	<#else>
		<header class="header">
			<div class="pri-title">
				<#-- 返回 -->
				<#include "/mobile/mall/public/header_return.ftl" />
			</div>
		</header>
	</#if>
<section class="wrapper">
	<figure>
		<img src="<@jc.appImgUrl url = "images/public/404.png" />"/>
		<p>哎呀，你访问的页面走丢了...</p>
		<a href="<#if channelCode?exists && (channelCode == '2' || channelCode == '3')>/mall/car.htm?channelCode=2<#else>/mall/index.htm</#if>">返回商城首页</a>
	</figure>
</section>

<#--引入js-->
<@jc.jsurl url = ["js/error/error-404"]/>
<#include "/ftlib/analyze_Montior.ftl" />
</body>
</html>