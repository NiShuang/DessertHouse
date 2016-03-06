<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../source/nav.jsp"/> 
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
		<jsp:useBean id="consumeRecordList"
			type="action.ConsumeRecordListBean"
			scope="request"></jsp:useBean>
			
		<jsp:useBean id="item" class="model.ConsumeRecord" 
			scope="page"></jsp:useBean>
<div class="frame">
	<span class="title">消费记录</span>
	<br></br>
	<div class="commodityList">
	<table class="bordered">
    <thead>

    <tr>
        <th>#</th>        
        <th>店铺</th>
        <th>商品</th>
        <th>单价(元)</th>
        <th>数量</th>
        <th>折扣</th>
        <th>总价(元)</th>
        <th>日期</th>
    </tr>
    </thead>
       <%
    	int num = consumeRecordList.getConsumeRecordList().size();
		for (int i = 0; i < num; i++) {
			pageContext.setAttribute("item", consumeRecordList.getConsumeRecordList(num-1-i));
			int index = i+1;
			String store = consumeRecordList.getConsumeRecordList(num-1-i).getStore().getName();
			String commodity = consumeRecordList.getConsumeRecordList(num-1-i).getCommodity().getName();
			double discount = consumeRecordList.getConsumeRecordList(num-1-i).getDiscount();
			  String discount1 = String.valueOf(discount*10)+" 折";
			  if(discount==1.0)
				  discount1 = "无";
			double total_price = consumeRecordList.getConsumeRecordList(num-1-i).getPrice()*consumeRecordList.getConsumeRecordList(num-1-i).getQuantity()*discount;
			String totalPrice =	String .format("%.2f",total_price);
	%>
    <tr>
        <td><%=index%></td>    
        <td><%=store%></td>    
        <td><%=commodity%></td>
        <td><jsp:getProperty name="item" property="price"/></td>
        <td><jsp:getProperty name="item" property="quantity"/></td>
        <td><%=discount1 %></td>  
        <td><%=totalPrice %></td>  
        <td><jsp:getProperty name="item" property="create_time"/></td>
       
    </tr>    
    <%} %>   
</table>
</div>
</div>
</body>
</html>