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
<link href="<%=request.getContextPath()%>/css/order.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/laydate.js"></script>
</head>
<body>
		<jsp:useBean id="planItemList"
			type="action.PlanItemListBean"
			scope="request"></jsp:useBean>
			
		<jsp:useBean id="item" class="model.PlanItem" 
			scope="page"></jsp:useBean>
			
		<jsp:useBean id="storeList"
			type="action.StoreListBean"
			scope="request"></jsp:useBean>
			
		<jsp:useBean id="item1" class="model.Store" 
			scope="page"></jsp:useBean>
		<% int store_id = Integer.parseInt(String.valueOf(request.getAttribute("store_id")));
		String store_name = String.valueOf(request.getAttribute("store_name"));
		java.sql.Date date =  java.sql.Date.valueOf(String.valueOf(request.getAttribute("date")));%>
<div class="frame">
<div class="row">
<span class="title"><%=store_name %></span>
</div>

<br></br>
  <form name="date" method="post" action="http://localhost:8080/DessertHouseWeb/ShowClerkMenuServlet?store=<%=store_id%>" >
<div class="demo6">
   <input readonly class="layinput" id="hello1" name="date" value="<%=date%>"></input>
   <div class="laydate-icon " onClick="laydate({elem: '#hello1'});" style="width:30px;display:inline-block;border:none;	"></div>
   <input id="check_btn" type="submit" name="check" value="查询"/>
</div>
</form>
<div class="commodityList">
<table class="bordered">
    <thead>

    <tr>
        <th>#</th>        
        <th>名称</th>
        <th>单价</th>
        <th>可售</th>
        <th>操作</th>
    </tr>
    </thead>
     <%
    	int num2 = planItemList.getPlanItemList().size();
		for (int i = 0; i < num2; i++) {
			pageContext.setAttribute("item", planItemList.getPlanItemList(i));
			String store = planItemList.getPlanItemList(i).getStore().getName();
			String commodity = planItemList.getPlanItemList(i).getCommodity().getName();
			int num = i+1;
			int sale = planItemList.getPlanItemList(i).getQuantity()-planItemList.getPlanItemList(i).getSold()-planItemList.getPlanItemList(i).getSchedule();
	%>
    <tr>
        <td><%=num %></td>       
        <td><%=commodity %></td>
        <td><jsp:getProperty name="item" property="price"/></td>
        <td><%=sale %></td>
        <td><a class="order" href="http://localhost:8080/DessertHouseWeb/ShowOneSaleServlet?id=<jsp:getProperty name="item" property="id"/>">购买</a> </td>
    </tr>    
    <%} %> 
</table>
</div>
</div>
<script>
!function(){
laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
laydate({elem: '#demo'});//绑定元素
}();
//日期范围限制
var start = {
    elem: '#start',
    format: 'YYYY-MM-DD',
    min: laydate.now(), //设定最小日期为当前日期
    max: '2099-06-16', //最大日期
    istime: true,
    istoday: false,
    choose: function(datas){
         end.min = datas; //开始日选好后，重置结束日的最小日期
         end.start = datas //将结束日的初始值设定为开始日
    }
};
var end = {
    elem: '#end',
    format: 'YYYY-MM-DD',
    min: laydate.now(),
    max: '2099-06-16',
    istime: true,
    istoday: false,
    choose: function(datas){
        start.max = datas; //结束日选好后，充值开始日的最大日期
    }
};
laydate(start);
laydate(end);
//自定义日期格式
laydate({
    elem: '#test1',
    format: 'YYYY年MM月DD日',
    festival: true, //显示节日
    choose: function(datas){ //选择日期完毕的回调
        alert('得到：'+datas);
    }
});
//日期范围限定在昨天到明天
laydate({
    elem: '#hello3',
    min: laydate.now(-1), //-1代表昨天，-2代表前天，以此类推
    max: laydate.now(+1) //+1代表明天，+2代表后天，以此类推
});
</script>
</body>
</html>