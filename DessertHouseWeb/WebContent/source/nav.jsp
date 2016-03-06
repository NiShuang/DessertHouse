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
    <li class="nav_menu-item"><a href="http://localhost:8080/DessertHouseWeb/ShowMenuServlet">预定</a></li>
    <li class="nav_menu-item"><a href="http://localhost:8080/DessertHouseWeb/ShowReserveServlet">我的预定</a></li>
    <li class="nav_menu-item"><a href="http://localhost:8080/DessertHouseWeb/ShowInformationServlet">会员</a>
      <ul class="nav_submenu">
      	<li class="nav_submenu-item"> <a href="http://localhost:8080/DessertHouseWeb/ShowInformationServlet" >注册信息</a></li>
        <li class="nav_submenu-item"> <a href="http://localhost:8080/DessertHouseWeb/ShowCardServlet" >会员卡</a></li>
        <li class="nav_submenu-item"> <a href="http://localhost:8080/DessertHouseWeb/customer/recharge.jsp">缴费</a></li>
        <li class="nav_submenu-item"> <a href="http://localhost:8080/DessertHouseWeb/customer/changePassword.jsp">修改密码</a></li>
      </ul>
    </li>
    
    <li class="nav_menu-item"><a >记录</a>
      <ul class="nav_submenu">
        <li class="nav_submenu-item"> <a href="http://localhost:8080/DessertHouseWeb/ShowConsumeRecordServlet">消费记录</a></li>
        <li class="nav_submenu-item"> <a href="http://localhost:8080/DessertHouseWeb/ShowPaymentRecordServlet">缴费记录</a></li>
      </ul>
     </li>
    <li class="nav_menu-item_exit"><a href="http://localhost:8080/DessertHouseWeb/common/login.jsp">退出</a></li>
  </ul>
</nav>
</body>
</html>