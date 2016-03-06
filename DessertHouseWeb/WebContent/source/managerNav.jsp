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
    <li class="nav_menu-item"><a href="http://localhost:8080/DessertHouseWeb/ShowPlanSubmitedServlet">产品计划</a></li>
    <li class="nav_menu-item"><a href="http://localhost:8080/DessertHouseWeb/AgeServlet">统计</a>
      <ul class="nav_submenu">
        <li class="nav_submenu-item"> <a href="http://localhost:8080/DessertHouseWeb/AgeServlet">会员统计</a></li>
        <li class="nav_submenu-item"> <a href="http://localhost:8080/DessertHouseWeb/MarketServlet">销售统计</a></li>
      </ul>
      </li>
    <li class="nav_menu-item_exit"><a href="http://localhost:8080/DessertHouseWeb/common/specialLogin.jsp">退出</a></li>
  </ul>
</nav>
</body>
</html>