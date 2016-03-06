<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" %>
<jsp:include page="../source/managerNav.jsp"/> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dessert House</title>
<link href="<%=request.getContextPath()%>/css/tab.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/table.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/order.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/laydate.js"></script>
</head>
<body>
<%List result=null ;
if(request.getAttribute("result")==null) 
    request.getRequestDispatcher("/MarketConsumeServlet").forward(request, response);
else 
	   result = (List)request.getAttribute("result"); %>
			
		<jsp:useBean id="storeList"
			type="action.StoreListBean"
			scope="request"></jsp:useBean>
			
		<jsp:useBean id="item1" class="model.Store" 
			scope="page"></jsp:useBean>
		<% int store_id = Integer.parseInt(String.valueOf(request.getAttribute("store_id")));
		int index = 0;%>
<div class="frame">
	<span class="title">当月预定销售情况</span>
	<br></br>
<div class="row">
<span class="word">店铺</span><div class="tab">
<ul class="tab_menu">
   <%
    	int num1 = storeList.getStoreList().size();
		for (int i = 0; i < num1; i++) {
			pageContext.setAttribute("item1", storeList.getStoreList(i));
	%>
	<li class="tab_menu-item" <%if(storeList.getStoreList(i).getId()==store_id){ %>style="background-color: #9b59b6"<%} %>><a href="http://localhost:8080/DessertHouseWeb/MarketServlet?store=<jsp:getProperty name="item1" property="id"/>"><jsp:getProperty name="item1" property="name"/></a></li>
    <%} %> 
  </ul>
</div>
</div>

<br></br>

<div class="commodityList">
<table class="bordered">
    <thead>

    <tr>
        <th>#</th>        
        <th>名称</th>
        <th>计划数量</th>
        <th>预定</th>
		<th>售出</th>
    </tr>
    </thead>
    
     <%String hot = String.valueOf(request.getAttribute("hot"));    
     for(Iterator iterator=result.iterator();iterator.hasNext();){
         Object[] obj=(Object[])iterator.next();
         index++;%>
			

    <tr>
        <td><%=index %></td>       
        <td><%=obj[0] %> <%if(String.valueOf(obj[0]).equals(hot)){ %><img src="<%=request.getContextPath()%>/pic/hot.png"/><%} %></td>
        <td><%=obj[1] %></td>
        <td><%=obj[2] %></td>
        <td><%=obj[3] %></td>

    </tr>    
    <%} %> 
</table>
</div>
</div>

</body>
</html>