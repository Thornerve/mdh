<#ftl strip_whitespace=true>
<#-- 
上汽freemarker框架 v0.2 陈琦

20140102: 修改为按多域名解析 v0.3 
-->

<#-- 开发期间无法获取时间戳 -->
<#if buildNo="${'$'}{maven.build.timestamp}">
    <#assign buildNo=.now?string('yyyyMMdd')>
</#if>

<#--
jsurl 格式化js的url加入版本号，用list形式可一次可以传入多个
-->
<#macro jsurl  url=[] resConcat='false'>
<#if resConcat == 'true'><script type="text/javascript" src="${jscssUrl("/??")}<#list url as js>${js}${minSuffix}.js<#if js_has_next>,</#if></#list>?t=${buildNo}.js"></script>
<#else><#list url as js><script type="text/javascript" src="${jscssUrl(js)}${minSuffix}.js?t=${buildNo}" ></script></#list>
</#if>
</#macro>

<#--
cssurl 格式化css的url加入版本号，用list形式可一次可以传入多个
-->
<#macro cssurl url=[] resConcat='false'>
<#if resConcat =='true'><link rel="stylesheet" type="text/css"  href="${jscssUrl("/??")}<#list url as css>${css}${minSuffix}.css<#if css_has_next>,</#if></#list>?t=${buildNo}.css" />
<#else><#list url as css><link rel="stylesheet" type="text/css" href="${jscssUrl(css)}${minSuffix}.css?t=${buildNo}" /></#list>
</#if>
</#macro>

<#--
jsurl 格式化js的url无版本号，用list形式可一次可以传入多个
-->
<#macro jsCommonUrl  url=[] resConcat='false'>
<#if resConcat == 'true'><script type="text/javascript" src="${jscssUrl("/??")}<#list url as js>${js}${minSuffix}.js<#if js_has_next>,</#if></#list>"></script>
<#else><#list url as js><script type="text/javascript" src="${jscssCommonUrl(js)}${minSuffix}.js" ></script></#list>
</#if>
</#macro>

<#--
cssurl 格式化css的url无版本号，用list形式可一次可以传入多个
-->
<#macro cssCommonUrl url=[] resConcat='false'>
<#if resConcat =='true'><link rel="stylesheet" type="text/css"  href="${jscssUrl("/??")}<#list url as css>${css}${minSuffix}.css<#if css_has_next>,</#if></#list>" />
<#else><#list url as css><link rel="stylesheet" type="text/css" href="${jscssCommonUrl(css)}${minSuffix}.css" /></#list>
</#if>
</#macro>

<#--
appImgUrl 格式化系统内图片的url
-->
<#macro appImgUrl url=''>${jscssUrl(url)}</#macro>

<#--
appHtmlUrl 格式化系统内静态页面的url
-->
<#macro appHtmlUrl url=''>${jscssUrl(url)}</#macro>