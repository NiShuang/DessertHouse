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
if(request.getAttribute("card")==null) 
      request.getRequestDispatcher("/CardServlet").forward(request, response);
  else 
	   result = (List)request.getAttribute("card");
  	%>
<div class="frame">


<div class="commodityList">
<div class="menu">
	<ul>
    	<li class="select"><a href="http://localhost:8080/DessertHouseWeb/AgeServlet">年龄段分布</a></li>
        <li class="select"><a href="http://localhost:8080/DessertHouseWeb/SexServlet">性别比例</a></li>
        <li class="select"><a href="http://localhost:8080/DessertHouseWeb/PlaceServlet">居住地分布</a></li>
        <li class="select"><a href="http://localhost:8080/DessertHouseWeb/ConsumeServlet">消费情况</a></li>
        <li class="selected"><a href="http://localhost:8080/DessertHouseWeb/CardServlet">会员卡情况</a></li>

    
    </ul>
</div>

<div id="container" style="width: 550px; height: 300px; margin: 0 auto"></div>
</div>
</div>
<script language="JavaScript">
$(document).ready(function() {  
   var chart = {
       plotBackgroundColor: null,
       plotBorderWidth: null,
       plotShadow: false
   };
   var title = {
      text: '会员卡使用情况分布图'   
   };      
   var tooltip = {
      pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
   };
   var plotOptions = {
      pie: {
         allowPointSelect: true,
         cursor: 'pointer',
         dataLabels: {
            enabled: true,
            format: '<b>{point.name}</b>: {point.percentage:.1f} %',
            style: {
               color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
            }
         }
      }
   };
   var series= [{
      type: 'pie',
      name: 'Browser share',
      data: [       <%    for(Iterator iterator=result.iterator();iterator.hasNext();){
          Object[] obj=(Object[])iterator.next();         
          String state = "无效";
          if(String.valueOf(obj[0]).equals("1"))
          	state="有效";
          else if(String.valueOf(obj[0]).equals("2"))
          	state="暂停";
          else if(String.valueOf(obj[0]).equals("3"))
            	state="停止";	%>

          ['<%=state%>',  <%=Integer.parseInt(String.valueOf(obj[1]))%> ],
       <%}%>


      ]
   }];     
      
   var json = {};   
   json.chart = chart; 
   json.title = title;     
   json.tooltip = tooltip;  
   json.series = series;
   json.plotOptions = plotOptions;
   $('#container').highcharts(json);  
});
</script>
</body>
</html>