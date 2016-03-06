<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>


<jsp:include  page="../source/managerNav.jsp"/> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dessert House</title>
<link href="<%=request.getContextPath()%>/css/tab.css" rel="stylesheet" type="text/css" />

<link href="<%=request.getContextPath()%>/css/manage.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/chart.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/jquery-1.7.2.min.js"></script>
<script src="<%=request.getContextPath()%>/js/highcharts.js"></script>
</head>
<body>
<%
List result=null ;
if(request.getAttribute("age")==null) 
      request.getRequestDispatcher("/AgeServlet").forward(request, response);
  else 
	   result = (List)request.getAttribute("age");
  	%>
<div class="frame">


<div class="commodityList">
<div class="menu">
	<ul>
    	<li class="selected"><a href="http://localhost:8080/DessertHouseWeb/AgeServlet">年龄段分布</a></li>
        <li class="select"><a href="http://localhost:8080/DessertHouseWeb/SexServlet">性别比例</a></li>
        <li class="select"><a href="http://localhost:8080/DessertHouseWeb/PlaceServlet">居住地分布</a></li>
        <li class="select"><a href="http://localhost:8080/DessertHouseWeb/ConsumeServlet">消费情况</a></li>
        <li class="select"><a href="http://localhost:8080/DessertHouseWeb/CardServlet">会员卡情况</a></li>

    
    </ul>
</div>

<div id="container" style="width: 550px; height: 300px; margin: 0 auto"></div>
</div>
</div>
<script language="JavaScript">


$(function () {
    $('#container').highcharts({
        title: {
            text: '年龄段统计图',
            x: -20 //center
        },

        xAxis: {
            categories: [<%    for(Iterator iterator1=result.iterator();iterator1.hasNext();){
                Object[] obj1=(Object[])iterator1.next();%> '<%=obj1[0] %>'  ,
                <%}%>]
        },
        yAxis: {
            title: {
                text: '人数(个)'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: '个'
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [{
        	name: '人数',
            data: [<%    for(Iterator iterator1=result.iterator();iterator1.hasNext();){
                Object[] obj1=(Object[])iterator1.next();%> <%=obj1[1]%>,
                <%}%>]
        }]
    });
});
</script>
</body>
</html>