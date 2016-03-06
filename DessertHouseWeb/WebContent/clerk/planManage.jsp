<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../source/topNav.jsp"/> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dessert House</title>
<link href="<%=request.getContextPath()%>/css/tab.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/table.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/manage.css" rel="stylesheet" type="text/css" />
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
		java.sql.Date date =  java.sql.Date.valueOf(String.valueOf(request.getAttribute("date")));%>
<div class="frame">
	<span class="title">产品计划</span>
	<br></br>
	<a class="submit" href="http://localhost:8080/DessertHouseWeb/SubmitPlanServlet?store=<%=store_id%>&date=<%=date%>">提交</a>
	<a class="add" href="http://localhost:8080/DessertHouseWeb/FillPlanItemServlet?store=<%=store_id%>&date=<%=date%>">添加</a>

	<br></br>
<span class="word">店面</span><div class="tab">
  <ul class="tab_menu">
   <%
    	int num1 = storeList.getStoreList().size();
		for (int i = 0; i < num1; i++) {
			pageContext.setAttribute("item1", storeList.getStoreList(i));
	%>
	<li class="tab_menu-item" <%if(storeList.getStoreList(i).getId()==store_id){ %>style="background-color: #9b59b6"<%} %>><a href="http://localhost:8080/DessertHouseWeb/ShowPlanServlet?store=<jsp:getProperty name="item1" property="id"/>&date=<%=date%>"><jsp:getProperty name="item1" property="name"/></a></li>
    <%} %> 
  </ul>
</div>
<br></br>
  <form name="date" method="post" action="http://localhost:8080/DessertHouseWeb/ShowPlanServlet?store=<%=store_id%>" >
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
        <th>店铺</th>
        <th>日期</th>
        <th>商品</th>
        <th>价格</th>
        <th>数量</th>
        <th>已售</th>
        <th>预定</th>
        <th>状态</th>
        <th>操作</th>
        
    </tr>
    </thead>
    <%
    	int num2 = planItemList.getPlanItemList().size();
		for (int i = 0; i < num2; i++) {
			pageContext.setAttribute("item", planItemList.getPlanItemList(i));
			String store = planItemList.getPlanItemList(i).getStore().getName();
			String commodity = planItemList.getPlanItemList(i).getCommodity().getName();
			int index = i+1;
			int myState = planItemList.getPlanItemList(i).getState();
			String state="未提交";
			if(myState==1)
				state="已提交 ";
			else if(myState==2)
				state="已批准";
			else if(myState==3)
				state="未批准";
	%>
    <tr>
        <td><%=index %></td>    
        <td><%=store %></td>    
        <td><jsp:getProperty name="item" property="date"/></td>
        <td><%=commodity %></td>
        <td><jsp:getProperty name="item" property="price"/></td>
        <td><jsp:getProperty name="item" property="quantity"/></td>
        <td><jsp:getProperty name="item" property="sold"/></td>
        <td><jsp:getProperty name="item" property="reserve"/></td>
        <td><%=state %></td>
        <%if(!(myState==1||myState==2)){ %>
        <td><a class="order" href="http://localhost:8080/DessertHouseWeb/ShowOnePlanItemServlet?id=<jsp:getProperty name="item" property="id"/>">修改</a> <a class="order" href="http://localhost:8080/DessertHouseWeb/DeletePlanItemServlet?id=<jsp:getProperty name="item" property="id"/>&store=<%=store_id%>&date=<%=date%>">删除</a></td>
    <%} else{%><td>无</td><%} %>
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