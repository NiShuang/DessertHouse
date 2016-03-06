<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../source/adminNav.jsp"/> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dessert House</title>
<link href="<%=request.getContextPath()%>/css/tab.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/table.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/manage.css" rel="stylesheet" type="text/css" />

</head>
<body>
		<jsp:useBean id="storeList"
			type="action.StoreListBean"
			scope="request"></jsp:useBean>
			
		<jsp:useBean id="item" class="model.Store" 
			scope="page"></jsp:useBean>
<div class="frame">
	<span class="title">店面管理</span>
	<br></br>
	<a class="add" href="http://localhost:8080/DessertHouseWeb/admin/addStore.jsp">添加</a>
	<br></br>
	<div class="commodityList">
	<table class="bordered">
    <thead>

    <tr>
        <th>店面号</th>        
        <th>店名</th>
        <th>地址</th>
        <th>电话</th>
        <th>操作</th>
    </tr>
    </thead>
    <%
    	int num = storeList.getStoreList().size();
		for (int i = 0; i < num; i++) {
			pageContext.setAttribute("item", storeList.getStoreList(i));
	%>
    <tr>
        <td><jsp:getProperty name="item" property="id"/></td>    
        <td><jsp:getProperty name="item" property="name"/></td>    
        <td><jsp:getProperty name="item" property="location"/></td>
        <td><jsp:getProperty name="item" property="telephone"/></td>
        <td><a class="order" href="http://localhost:8080/DessertHouseWeb/ShowOneStoreServlet?id=<jsp:getProperty name="item" property="id"/>">修改</a> <a class="order" href="http://localhost:8080/DessertHouseWeb/DeleteStoreServlet?id=<jsp:getProperty name="item" property="id"/>">删除</a></td>
    </tr>    
    <%} %>  
</table>
</div>
</div>
</body>
</html>