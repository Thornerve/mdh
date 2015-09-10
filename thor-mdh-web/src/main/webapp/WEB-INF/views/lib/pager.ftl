<#-- 分页（Pager对象、链接URL、参数Map、最大页码显示数、当前页的位置） -->
<#macro pager pager baseUrl parameterMap = {} maxShowPageCount = 8 currentPageLocation = 5 onclickFunName="">

	<#local pageNumber = pager.currentPage />
	<#local pageSize = pager.pageSize />
	<#local pageCount = pager.pageCount />
	<#local property = pager.property />
	<#local keyword = pager.keyword />
	<#local orderBy = pager.orderBy />
	<#local totalRows = pager.totalRows />
	<#local orderType = pager.orderType />

	<#local parameter = "" />
	<#if (pageSize != "")!>
		<#local parameter = parameter + "&pageSize=" + pageSize />
	</#if>
	<#if (property != "")!>
		<#local parameter = parameter + "&property=" + property />
	</#if>
	<#if (keyword != "")!>
		<#local parameter = parameter + "&keyword=" + keyword />
	</#if>
	<#if (orderBy != "")!>
		<#local parameter = parameter + "&orderBy=" + orderBy />
	</#if>
	<#if (orderType != "")!>
		<#local parameter = parameter + "&orderType=" + orderType />
	</#if>
	<#if (totalRows != "")!>
		<#local parameter = parameter + "&totalRows=" + totalRows />
	</#if>

	<#list parameterMap?keys as key>
		<#if parameterMap[key] != null && parameterMap[key] != "">
			<#local parameter = parameter + "&" + key + "=" + parameterMap[key] />
		</#if>
	</#list>
	
	<#if baseUrl?contains("?")>
		<#local baseUrl = baseUrl + "&" />
	<#else>
		<#local baseUrl = baseUrl + "?" />
	</#if>

	<#local firstPageUrl = baseUrl + "currentPage=1" + parameter />
	<#local lastPageUrl = baseUrl + "currentPage=" + pageCount + parameter />
	<#local prePageUrl = baseUrl + "currentPage=" + (pageNumber - 1) + parameter />
	<#local nextPageUrl = baseUrl + "currentPage=" + (pageNumber + 1) + parameter />

	<#if maxShowPageCount <= 0>
		<#local maxShowPageCount = 10>
	</#if>
	
	<#-- 当前页的位置之前页数5 -->
	<#local beforeLocationNumber = maxShowPageCount - currentPageLocation + 1 />
	<#-- 当前页的位置之后页数4 -->
	<#local afterLocationNumber = maxShowPageCount - currentPageLocation />
	
	<#-- 初始化页码的首页、尾页 -->
	<#if pageCount gt maxShowPageCount> <#-- 页数大于最大显示页数 -->
		<#-- 初始首页页码 -->
		<#if pageNumber lte currentPageLocation>  <#-- 页码小于当前页码显示位置时 -->
			<#local startPageNumber = 1 />
		<#elseif pageCount - pageNumber lte afterLocationNumber>
			<#local startPageNumber = pageCount - maxShowPageCount + 1 />
		<#else>
			<#local startPageNumber = pageNumber - beforeLocationNumber />
		</#if>
		
		<#-- 初始尾页页码 -->
		<#if pageNumber lte currentPageLocation>
			<#local endPageNumber = maxShowPageCount />
		<#else>
			<#local endPageNumber = pageNumber + afterLocationNumber />
		</#if>
	<#else> <#-- 页数小于最大显示页数 -->
		<#local startPageNumber = 1 />
		<#local endPageNumber = pageCount />
	</#if>
	
	<#if (startPageNumber < 1)>
		<#local startPageNumber = 1 />
	</#if>
	<#if (endPageNumber > pageCount)>
		<#local endPageNumber = pageCount />
	</#if>

	<#if (pageCount gte 1)>
	<div class="tar page paganation">
			<#-- 上一页 -->
			<#if (pageNumber > 1)>
				<#if onclickFunName != ""> 
					<a class="prev" href="javascript:void(0);" onclick="${onclickFunName}(&quot;${base}${prePageUrl}&quot;);">上一页</a>
				<#else> 
					<a class="prev" href="${base}${prePageUrl}">上一页</a>
				</#if>
			<#else>
				<a class="gary prev" href="javascript:void(0);">上一页</a>
			</#if>
			
			<#list startPageNumber .. endPageNumber as index>
				<#if pageNumber != index> 
					<#if onclickFunName != "">
						<a href="javascript:void(0);" onclick="${onclickFunName}(&quot;${base}${baseUrl + "currentPage=" + index + parameter}&quot;);return false;">${index}</a>
					<#else> 
						<a href="${base}${baseUrl + "currentPage=" + index + parameter}">${index}</a>
					</#if>
				<#else> 
					<a class="current" href="javascript:void(0);">${index}</a>
				</#if>
			</#list>
			<#-- 下一页 -->
			<#if (pageNumber < pageCount)>	
				<#if onclickFunName != "">
					<a class="next" href="javascript:void(0);" onclick="${onclickFunName}(&quot;${base}${nextPageUrl}&quot;);">下一页</a>
				<#else> 
					<a class="next" href="${base}${nextPageUrl}">下一页</a>
				</#if>
			<#else>
				<a class="gary next" href="javascript:void(0);">下一页</a>
			</#if>
		</div>
	</#if>

</#macro>

<#macro appendPreviewParameter url isPreview>
	<#if isPreview?? && isPreview>
		<#if url?index_of("?") &lt; 0>
			${url}?preview=true
		<#else>
			${url}&preview=true
		</#if>
	<#else>
		${url}
	</#if>
</#macro>

<#-- 文章内容分页 -->
<#macro articleContentPager article pageCount baseUrl pageNumber isPreview = false maxShowPageCount = 5>
	<#if baseUrl?index_of("?") &lt; 0>
		<#local param = "?page=" />
	<#else>
		<#local param = "&page=" />
	</#if>
	
	<#local firstPageUrl = baseUrl />
	<#local lastPageUrl = baseUrl + param + pageCount />
	<#if pageNumber == 1>
		<#local prePageUrl = firstPageUrl />
	<#else>
		<#local prePageUrl = baseUrl + param + (pageNumber - 1) />
	</#if>
	<#if pageNumber == pageCount>
		<#local nextPageUrl = lastPageUrl />
	<#else>
		<#local nextPageUrl = baseUrl + param + (pageNumber + 1) />
	</#if>

	<#if maxShowPageCount <= 0>
		<#local maxShowPageCount = 6>
	</#if>
	
	<#local segment = ((pageNumber - 1) / maxShowPageCount)?int + 1 />
	<#local startPageNumber = (segment - 1) * maxShowPageCount + 1 />
	<#local endPageNumber = segment * maxShowPageCount />
	<#if (startPageNumber < 1)>
		<#local startPageNumber = 1 />
	</#if>
	<#if (endPageNumber > pageCount)>
		<#local endPageNumber = pageCount />
	</#if>

	<#if (pageCount > 1)>
		<ul class="pager">
			<li class="pageInfo">
				共 ${pageCount} 页
			</li>
			<#-- 首页 -->
			<#if (pageNumber > 1)>
				<li class="firstPage">
					<a href="<#call appendPreviewParameter base + firstPageUrl isPreview>">首页</a>
				</li>
			<#else>
				<li class="firstPage">
					<span>首页</span>
				</li>
			</#if>
			
			<#-- 上一页 -->
			<#if (pageNumber > 1)>
				<li class="prePage">
					<a href="<#call appendPreviewParameter base + prePageUrl isPreview>">上一页</a>
				</li>
			<#else>
				<li class="prePage">
					<span>上一页</span>
				</li>
			</#if>
			
			<#if (startPageNumber > 1)>
				<li>
					<a href="<#call appendPreviewParameter base + baseUrl + param + (startPageNumber - 1) isPreview>">...</a>
				</li>
			</#if>
			
			<#list startPageNumber .. endPageNumber as index>
				<#if pageNumber != index>
					<li>
						<#if index == 1>
							<a href="<#call appendPreviewParameter base + baseUrl isPreview>">${index}</a>
						<#else>
							<a href="<#call appendPreviewParameter base + baseUrl + param + index isPreview>">${index}</a>
						</#if>
					</li>
				<#else>
					<li class="currentPage">
						<span>${index}</span>
					</li>
				</#if>
			</#list>
			
			<#if (endPageNumber < pageCount)>
				<li>
					<a href="<#call appendPreviewParameter base + baseUrl + param + (endPageNumber + 1) isPreview>">...</a>
				</li>
			</#if>
		    
			<#-- 下一页 -->
			<#if (pageNumber < pageCount)>
				<li class="nextPage">
					<a href="<#call appendPreviewParameter base + nextPageUrl isPreview>">下一页</a>
				</li>
			<#else>
				<li class="nextPage">
					<span>下一页</span>
				</li>
			</#if>
			
			<#-- 末页 -->
			<#if (pageNumber < pageCount)>
				<li class="lastPage">
					<a href="<#call appendPreviewParameter base + lastPageUrl isPreview>">末页</a>
				</li>
			<#else>
				<li class="lastPage">
					<span>末页</span>
				</li>
			</#if>
		</ul>
	</#if>
</#macro>