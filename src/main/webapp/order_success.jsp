<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"/>
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
  <meta name="HandheldFriendly" content="true"/>
  <link href="favicon.ico" rel="shortcut icon" type="image/x-icon"/>
  <link rel="stylesheet" href="css/base.css"/>
  <link rel="stylesheet" type="text/css" href="css/style.css"/>
  <link rel="stylesheet" href="lib/layui-v2.5.4/css/layui.css" media="all">
  <link rel="stylesheet" href="css/layuimini.css" media="all">
  <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
  <title>房间预订</title>
</head>
<body>
<%@include file="header.jsp" %>

<div class="pusher-black"></div>
<div class="mtop"></div>
<div class="room-pbanner" style="background-image: url(img/room_bg.jpg);"><span class="black-70"></span>
  <p class="title">预订已完成</p><span class="sj"></span></div><!--room-pbanner end-->
<dl class="room-page room-paging clearfix">
  <dd class="item1">
    <div class="room-deom"><p class="img"><img src="images/in.jpg"/></p></div>
  </dd>
  <dd class="item2">
    <div class="room-info-box">
      <div class="room-i-t">
        <p class="rprice-box"><span class="price">预订成功</span></p>
      </div>
      <div style="text-align: center;">
        <img src="images/ok.png" style="padding: 80px;max-width: 128px;max-height: 128px">
      </div>
      <a href="findOrderByPhone.action" class="room-i-btn jz-yd-btn" data-img="img/erm.jpg">查看订单</a></div>
  </dd>
</dl><!--room-page end-->

<dl class="room-page bgdc ledmore-room">
  <dt class="t">所有房型</dt>
  <dd>
    <ul class="clearfix ledmore-room-list">
      <li><a href="http://localhost:8080/hotel_client_war_exploded/findByType.action?type=总统套房"><img src="images/zt.jpg"
                                                                                                     class="img"/>
        <div class="txt">总统套房</div>
      </a></li>
      <li><a href="http://localhost:8080/hotel_client_war_exploded/findByType.action?type=家庭房"><img src="images/qz.jpg"
                                                                                                    class="img"/>
        <div class="txt">亲子套房</div>
      </a></li>
      <li><a href="http://localhost:8080/hotel_client_war_exploded/findByType.action?type=大床房"><img src="images/dc.jpg"
                                                                                                    class="img"/>
        <div class="txt">大床房</div>
      </a></li>
      <li><a href="http://localhost:8080/hotel_client_war_exploded/findByType.action?type=双床房"><img src="images/sc.jpg"
                                                                                                    class="img"/>
        <div class="txt">双床房</div>
      </a></li>
    </ul>
  </dd>
</dl>

<div class="dock">
  <ul class="dockCon">
    <li class="first">
      <a href="#">
        <i class="i1"></i>
      </a>
    </li>
    <li class="second">
      <a href="sign_in.jsp">
        <i class="i4"></i>
      </a>
    </li>
  </ul>
</div>

<%@include file="footer.jsp" %>
<%@include file="nav.jsp" %>
</body>
</html>