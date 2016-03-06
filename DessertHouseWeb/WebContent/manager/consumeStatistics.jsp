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
if(request.getAttribute("consume")==null) 
      request.getRequestDispatcher("/ConsumeServlet").forward(request, response);
  else 
	   result = (List)request.getAttribute("consume");
  	%>
<div class="frame">


<div class="commodityList">
<div class="menu">
	<ul>
    	<li class="select"><a href="http://localhost:8080/DessertHouseWeb/AgeServlet">年龄段分布</a></li>
        <li class="select"><a href="http://localhost:8080/DessertHouseWeb/SexServlet">性别比例</a></li>
        <li class="select"><a href="http://localhost:8080/DessertHouseWeb/PlaceServlet">居住地分布</a></li>
        <li class="selected"><a href="http://localhost:8080/DessertHouseWeb/ConsumeServlet">消费情况</a></li>
        <li class="select"><a href="http://localhost:8080/DessertHouseWeb/CardServlet">会员卡情况</a></li>

    
    </ul>
</div>

<div id="container" style="width: 550px; height: 300px; margin: 0 auto"></div>
</div>
</div>
<script language="JavaScript">
$(function () {
    $('#container').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: '消费情况统计图'
        },

        xAxis: {
            categories: [
<%    for(Iterator iterator1=result.iterator();iterator1.hasNext();){
    Object[] obj1=(Object[])iterator1.next();%> '<%=obj1[0] %>'  ,
    <%}%>
            ],
            crosshair: true
        },
        yAxis: {
            min: 0,
            title: {
                text: '消费金额 (元)'
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                '<td style="padding:0"><b>{point.y:.1f} mm</b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },
        series: [{
        	name: '消费金额',
            data: [<%    for(Iterator iterator1=result.iterator();iterator1.hasNext();){
                Object[] obj1=(Object[])iterator1.next();%> <%=obj1[1]%>,
                <%}%>]
        }]
    });
});
</script>
</body>
</html>