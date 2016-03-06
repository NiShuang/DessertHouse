<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dessert House</title>
<link href="<%=request.getContextPath()%>/css/lrtk.css" rel="stylesheet" type="text/css" />
</head>
<body>
<nav class="nav">
  <ul class="nav_menu">
    <li class="nav_menu-item"><a href="http://localhost:8080/DessertHouseWeb/ShowPlanServlet">计划管理</a></li>
    <li class="nav_menu-item"><a href="http://localhost:8080/DessertHouseWeb/ShowCommodityServlet">商品管理</a></li>
    <li class="nav_menu-item_exit"><a href="http://localhost:8080/DessertHouseWeb/common/specialLogin.jsp">退出</a></li>
  </ul>
</nav>
</body>
</html>