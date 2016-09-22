<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>资产信息</title>
	<link rel="stylesheet" type="text/css" href="jsp/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="jsp/css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="jsp/css/style.css" />
    <script type="text/javascript" src="jsp/js/jquery2.js"></script>
    <script type="text/javascript" src="jsp/js/jquery2.sorted.js"></script>
    <script type="text/javascript" src="jsp/js/bootstrap.js"></script>
    <script type="text/javascript" src="jsp/js/ckform.js"></script>
    <script type="text/javascript" src="jsp/js/common.js"></script>

    <style type="text/css">
        body {font-size: 20px;
            padding-bottom: 40px;
            background-color:#e9e7ef;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }


    </style>
  </head>
  
  <body>
  <form class="form-inline definewidth m20" action="select" method="post">
     <font color="#777777"><strong>关键字查询：</strong></font>
    <input type="text" name="keyword" id="" class="abc input-default" placeholder="" value="">&nbsp;&nbsp; 
    <button type="submit" class="btn btn-primary">查询</button> 
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>资产编号</th>
        <th>资产名称</th>
        <th>型号</th>
        <th>借用日期</th>
        
       
        <th>所属部门</th>
		 <th>借用人</th>

     </tr>
    </thead>
    <c:forEach items="${list}" var="asset">
        <tr>
                <td>${asset.getAssetNumber()}</td>
                <td>${asset.getAssetName()}</td>
                <td>${asset.getModel()}</td>
                
                <td>${asset.getDateOfAcquisition()}</td>
				<td>${asset.getUseDepartment()}</td>
				<td>${asset.getWarehouseman()}</td>
          
        </tr>
        </c:forEach>
           
       
       </table>
    
  </body>
</html>
