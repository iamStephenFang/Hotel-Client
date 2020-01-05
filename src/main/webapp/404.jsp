<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>404错误</title>
  <link rel="shortcut icon" type="image/x-icon" href="favicon.ico" class="ico"/>
  <link rel="stylesheet" href="css/base.css"/>
  <link rel="stylesheet" type="text/css" href="css/style.css"/>
  <link rel="stylesheet" href="css/新闻咨询.css"/>
  <script src="js/jquery-1.11.1.min.js"></script>
  <script src="js/common.js"></script>
  <script src="js/public.js"></script>
  <script src="js/news.js"></script>
</head>
<body>
<!--顶部导航部分-->
<%@include file="header.jsp" %>

<!--中间部分-->
<div class="middle clearfix">
  <div class="banner">
    <div class="banner-inner">
      <div class="words">
        <p class="en">遇到了问题</p>
        <p class="jz-zh">404错误</p>
      </div>
    </div>
  </div>
</div>

<dl class="room-page bgdc ledmore-room">
  <dt class="t">所有房间</dt>
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

<%@include file="dock.jsp" %>

<%@include file="footer.jsp" %>
<%@include file="nav.jsp" %>
</body>
</html>