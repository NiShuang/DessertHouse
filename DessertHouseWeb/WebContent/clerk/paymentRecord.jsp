<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../source/clerkNav.jsp"/> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dessert House</title>
<link href="<%=request.getContextPath()%>/css/tab.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/table.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/record.css" rel="stylesheet" type="text/css" />

</head>
<body>
		<jsp:useBean id="paymentRecordList"
			type="action.PaymentRecordListBean"
			scope="request"></jsp:useBean>
			
		<jsp:useBean id="item" class="model.PaymentRecord" 
			scope="page"></jsp:useBean>
<div class="frame">
	<span class="title">缴费记录</span>
	<br></br>
	<a class="add" href="http://localhost:8080/DessertHouseWeb/QueryMemberServlet?id=<%=request.getAttribute("id")%>">返回</a>
	<br></br>
	<div class="commodityList">
	<table class="bordered">
    <thead>

    <tr>
        <th>#</th>   
        <th>会员</th>      
        <th>金额</th>
        <th>日期</th>
    </tr>
    </thead>
    <%
    	int num = paymentRecordList.getPaymentRecordList().size();
		for (int i = 0; i < num; i++) {
			pageContext.setAttribute("item", paymentRecordList.getPaymentRecordList(num-1-i));
			int index = i+1;
	%>
    <tr>
        <td><%=index%></td>    
        <td><jsp:getProperty name="item" property="member_id"/></td>  
        <td><jsp:getProperty name="item" property="charge"/></td>    
        <td><jsp:getProperty name="item" property="create_time"/></td>
       
    </tr>    
    <%} %>    

</table>
</div>
</div>
</body>
</html>