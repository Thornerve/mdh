<div data-options="region:'north',border:false"
	style="height:80px;padding:10px;background:url('${pageContext.request.contextPath }/images/public/header_bg.png') no-repeat right;">
	<div>
		<img src="${pageContext.request.contextPath }/images/logo.png" border="0">
	</div>
	<div id="sessionInfoDiv"
		style="position: absolute;right: 5px;top:10px;">
		[<strong>超级管理员</strong>]，欢迎你！您使用[<strong>192.168.1.100</strong>]IP登录！
	</div>
	<div style="position: absolute; right: 5px; bottom: 10px; ">
		<a href="javascript:void(0);" class="easyui-menubutton"
			data-options="menu:'#layout_north_pfMenu',iconCls:'icon-ok'">更换皮肤</a>
		<a href="javascript:void(0);" class="easyui-menubutton"
			data-options="menu:'#layout_north_kzmbMenu',iconCls:'icon-help'">控制面板</a>
	</div>
	<div id="layout_north_pfMenu" style="width: 120px; display: none;">
		<div onclick="changeTheme('default');">default</div>
		<div onclick="changeTheme('gray');">gray</div>
		<div onclick="changeTheme('black');">black</div>
		<div onclick="changeTheme('bootstrap');">bootstrap</div>
		<div onclick="changeTheme('metro');">metro</div>
	</div>
	<div id="layout_north_kzmbMenu" style="width: 100px; display: none;">
		<div onclick="editPassword();">修改密码</div>
		<div onclick="showAbout();">联系管理员</div>
		<div class="menu-sep"></div>
		<div onclick="logoutFun();">退出系统</div>
	</div>
</div>
<div data-options="region:'west',split:true,title:'菜单导航'"
	style="width:200px">
	<div class="easyui-accordion" fit="true" border="false">
		<div title="基本功能" data-options="iconCls:'icon-mini-add'" style="overflow:auto">
			<ul id="treeMenu" class="ztree"></ul>
		</div>
		<div title="系统管理" data-options="iconCls:'icon-mini-add'" style="overflow:auto">  
			<ul id="adminMenu" class="ztree"></ul>
		</div>
	</div>
</div>