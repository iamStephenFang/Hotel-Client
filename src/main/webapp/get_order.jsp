<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>查看订单</title>
    <link rel="shortcut icon" type="image/x-icon" href="favicon.ico" class="ico"/>
    <link rel="stylesheet" href="css/base.css"/>
    <link rel="stylesheet" href="css/vipindex.css"/>
    <script src="js/jquery-1.11.1.min.js"></script>
    <script src="js/common.js"></script>
    <script src="js/public.js"></script>
    <script src="js/vipcenter.js"></script>
</head>
<body>
<%@include file="header.jsp" %>
<div class="vip">
    <div class="vip-message">
        <p class="vip-message-title">
            <span class="vip-title-card">查看订单</span>
        </p>
    </div>
</div>
<!--中间会员卡部分结束，介绍内容部分开始-->
<div class="cont clearfix">
    <ul id="cont_ul">
        <s:iterator value="#request.orders">
        <li>
            <div class="cont-li-box">
                <h3><s:property value="orderId"/></h3>
                <s:if test="%{orderStatus==true}">
                <h3>订单未完成</h3>
                </s:if>
                <s:else>
                    <h3>订单已完成</h3>
                </s:else>
                <p><s:property value="checkInTime"/>-<s:property value="leaveTime"/></p>
            </div>
        </li>
        </s:iterator>
    </ul>
</div>

<%@include file="footer.jsp" %>
<%@include file="nav.jsp" %>
</body>
</html>