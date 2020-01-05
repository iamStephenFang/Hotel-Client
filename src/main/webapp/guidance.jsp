<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>服务指南</title>
    <link rel="shortcut icon" type="image/x-icon" href="favicon.ico" class="ico"/>
    <link rel="stylesheet" href="css/base.css"/>
    <link rel="stylesheet" href="css/serve.css"/>
    <script src="js/jquery-1.11.1.min.js"></script>
    <script src="js/common.js"></script>
    <script src="js/public.js"></script>
</head>
<body>
<!--顶部导航部分-->
<%@include file="header.jsp" %>

<!--中间部分-->
<!--<div class="middle"></div>-->
<!--中间部分-->
<!--<div class="middle">-->
<!--</div>-->
<!--开头内容-->
<div class="header">
    <h3>
        SERVICE<br/>
        INFORMATION
    </h3>
</div>

<!--内容栏-->
<div class="content clearfix">
    <!--左边服务指南-->
    <div class="guide">
        <h6>服务指南</h6>
        <div id="guide-nav" class="guide-nav clearfix">
            <ul>
                <li class="guide-nav-default"><i class="Garrows"></i>欢迎来到哈啤酒店</li>
                <li><i></i>开启一段探索之旅</li>
                <li><i></i>了解我们</li>
                <li><i></i>电话信息</li>
                <li><i></i>客房内24小时送餐</li>
                <li><i></i>运动和短途旅游</li>
                <li><i></i>环境和安全</li>
            </ul>
        </div>
    </div>
    <!--右边介绍栏-->
    <div class="sidebar">
        <p class="sidebar-title">欢迎来到哈啤酒店</p>
        <p class="sidebar-blank"></p>
        <p class="sidebar-content">
            本《宾客服务指南》旨在向您提供实用信息，让您充分享受在酒店的美好时光。<br/>
            度过几天丰富多彩的探索旅程之后，不妨来到我们这里，尽享奢华美食与休闲体验。<br/>
            谨致问候
        </p>
        <p class="sidebar-foot">
            酒店管理层
        </p>
    </div>
</div>

<%@include file="dock.jsp" %>

<%@include file="footer.jsp" %>
<%@include file="nav.jsp" %>
</body>
</html>