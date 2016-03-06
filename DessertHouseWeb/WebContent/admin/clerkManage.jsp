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
		<jsp:useBean id="clerkList"
			type="action.ClerkListBean"
			scope="request"></jsp:useBean>
			
		<jsp:useBean id="item" class="model.Clerk" 
			scope="page"></jsp:useBean>
			
		<jsp:useBean id="storeList"
			type="action.StoreListBean"
			scope="request"></jsp:useBean>
			
		<jsp:useBean id="item1" class="model.Store" 
			scope="page"></jsp:useBean>
	<% int store_id = 0;
	   if(request.getAttribute("store_id")!=null){
		   store_id = Integer.parseInt(String.valueOf(request.getAttribute("store_id")));
		}%>
<div class="frame">
	<span class="title">店员管理</span>
	<br></br>
	<a class="add" href="http://localhost:8080/DessertHouseWeb/FillClerkServlet">添加</a>
	<br></br>
<span class="word">店面</span><div class="tab">
  <ul class="tab_menu">
   <%
    	int num1 = storeList.getStoreList().size();
		for (int i = 0; i < num1; i++) {
			pageContext.setAttribute("item1", storeList.getStoreList(i));
	%>
	<li class="tab_menu-item" <%if(storeList.getStoreList(i).getId()==store_id){ %>style="background-color: #9b59b6"<%} %>><a href="http://localhost:8080/DessertHouseWeb/ShowClerksByStoreServlet?id=<jsp:getProperty name="item1" property="id"/>"><jsp:getProperty name="item1" property="name"/></a></li>
    <%} %> 
  </ul>
</div>
<div class="commodityList">
<table class="bordered">
    <thead>

    <tr>
        <th>员工号</th>        
        <th>姓名</th>
        <th>电话</th>
        <th>所在店面</th>
        <th>操作</th>
    </tr>
    </thead>
    <%
    	int num2 = clerkList.getClerkList().size();
		for (int i = 0; i < num2; i++) {
			pageContext.setAttribute("item", clerkList.getClerkList(i));
			String store = clerkList.getClerkList(i).getStore().getName();
	%>
    <tr>
        <td><jsp:getProperty name="item" property="id"/></td>    
        <td><jsp:getProperty name="item" property="name"/></td>    
        <td><jsp:getProperty name="item" property="telephone"/></td>
        <td><%=store %></td>
        <td><a class="order" href="http://localhost:8080/DessertHouseWeb/ShowOneClerkServlet?id=<jsp:getProperty name="item" property="id"/>">修改</a> <a class="order" href="http://localhost:8080/DessertHouseWeb/DeleteClerkServlet?id=<jsp:getProperty name="item" property="id"/>">删除</a></td>
    </tr>    
    <%} %> 
</table>
</div>
</div>
</body>
</html>