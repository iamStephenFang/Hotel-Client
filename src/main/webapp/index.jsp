<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head lang="en">
  <meta charset="UTF-8">
  <title>哈啤酒店</title>
  <link rel="shortcut icon" type="image/x-icon" href="favicon.ico" class="ico"/>
  <link rel="stylesheet" href="css/base.css"/>
  <link rel="stylesheet" href="css/客房预订.css"/>
  <link rel="stylesheet" href="css/index.css"/>
  <script src="js/jquery-1.11.1.min.js"></script>
  <script src="js/common.js"></script>
  <script src="js/public.js"></script>
  <script src="js/index.js"></script>
</head>
<body>
<%@include file="header.jsp" %>

<!--中间部分-->
<div class="middle-banner">
  <div class="banner-lunbo">
    <div class="middle-banner-pic" style="display: block">
      <img class="pic-1" src="images/banner1.jpg" alt=""/>
      <div class="binbox">
        <div class="bybox">
                        <span class="boxt">
                    <span class="boxt-s0"></span>
                        <span class="boxt-line boxt-s1"></span>
                        <span class="boxt-line boxt-s2"></span>
                        <span class="boxt-line boxt-s3"></span>
                        <span class="boxt-line boxt-s4"></span>
                        </span>
          <p class="by1">注册会员</p>
          <p class="by2">享受服务</p>

        </div>
        <p class="jz-zh">哈啤酒店</p>
      </div>
    </div>
    <div class="middle-banner-pic" style="display: none">
      <img class="pic-1" src="images/201612121437277463.jpg" alt=""/>
      <div class="binbox">
        <div class="bybox">
                        <span class="boxt">
                    <span class="boxt-s0"></span>
                        <span class="boxt-line boxt-s1"></span>
                        <span class="boxt-line boxt-s2"></span>
                        <span class="boxt-line boxt-s3"></span>
                        <span class="boxt-line boxt-s4"></span>
                        </span>
          <p class="by1">注册会员</p>
          <p class="by2">获得奖励</p>

        </div>
        <p class="jz-zh">哈啤酒店</p>
      </div>
    </div>
    <div class="middle-banner-pic" style="display: none">
      <img class="pic-1" src="images/2016129142531342.jpg" alt=""/>
      <div class="binbox">
        <div class="bybox">
                        <span class="boxt">
                    <span class="boxt-s0"></span>
                        <span class="boxt-line boxt-s1"></span>
                        <span class="boxt-line boxt-s2"></span>
                        <span class="boxt-line boxt-s3"></span>
                        <span class="boxt-line boxt-s4"></span>
                        </span>
          <p class="by1">注册会员</p>
          <p class="by2">获得积分</p>

        </div>
        <p class="jz-zh">哈啤酒店</p>
      </div>
    </div>
  </div>
  <ul class="slick-dots">
    <li></li>
    <li></li>
    <li></li>
  </ul>
  <span class="mouseIco"></span>
</div>

<!--房间展示部分-->
<div class="roombox" id="roombox">
  <div class="roomlist">
    <div class="list-left">
      <a href="http://localhost:8080/hotel_client_war_exploded/findByType.action?type=总统套房"><img src="images/zt.jpg" alt=""/></a>
    </div>
    <div class="list-right">
      <div class="list-right-1">
        <h3>总统套房</h3>
        <p class="money">
          HAPE <br/>Hotel
        </p>
        <a href="#" class="list-right-link"></a>
      </div>
      <div class="list-right-2">
        <p class="name">总统套房</p>
        <p class="money-h">
          150方，私享空间
        </p>
        <p class="description">
          我们以私密的客房、国际化的标准、人性化的服务，打造一个只属于您和家人的独立私享空间。
        </p>
        <span class="line"></span>
        <span class="icon"></span>
        <a href="#" class="list-right-link"></a>
      </div>
      <a href="http://localhost:8080/hotel_client_war_exploded/findByType.action?type=总统套房" class="list-right-link"></a>
    </div>
  </div>
  <div class="roomlist">
    <div class="list-left">
      <a href="http://localhost:8080/hotel_client_war_exploded/findByType.action?type=家庭房"><img src="images/qz.jpg" alt=""/></a>
    </div>
    <div class="list-right">
      <div class="list-right-1">
        <h3>亲子房</h3>
        <p class="money">
          HAPE <br/>Hotel
        </p>
      </div>
      <div class="list-right-2">
        <p class="name">家庭房</p>
        <p class="money-h">
          举家出游，多方自在
        </p>
        <p class="description c">
          您只需享受旅游的快乐，至于拖家带口的疲惫，我们帮您处理。
        </p>
        <span class="line"></span>
        <span class="icon"></span>

      </div>
      <a href="http://localhost:8080/hotel_client_war_exploded/findByType.action?type=家庭房" class="list-right-link"></a>

    </div>
  </div>
  <div class="roomlist">
    <div class="list-left">
      <a href="http://localhost:8080/hotel_client_war_exploded/findByType.action?type=大床房"><img src="images/dc.jpg" alt=""/></a>
    </div>
    <div class="list-right">
      <div class="list-right-1">
        <h3>大床房</h3>
        <p class="money">
          HAPE <br/>Hotel
        </p>
      </div>
      <div class="list-right-2">
        <p class="name">大床房</p>
        <p class="money-h">
          品质大床，品质之选
        </p>
        <p class="description c">
          我们承诺床够大，您不需要亲身测试床铺高度与梦境的距离。
        </p>
        <span class="line"></span>
        <span class="icon"></span>
      </div>
      <a href="http://localhost:8080/hotel_client_war_exploded/findByType.action?type=大床房" class="list-right-link"></a>
    </div>
  </div>
  <div class="roomlist">
    <div class="list-left">
      <a href="http://localhost:8080/hotel_client_war_exploded/findByType.action?type=双床房"><img src="images/sc.jpg" alt=""/></a>
    </div>
    <div class="list-right">
      <div class="list-right-1">
        <h3>双床房</h3>
        <p class="money">
          HAPE <br/>Hotel
        </p>
      </div>
      <div class="list-right-2">
        <p class="name">双床房</p>
        <p class="money-h">
          经济实惠，最佳选择
        </p>
        <p class="description c">
          经济实惠的不二之选，附带叫醒服务，让您不再错过火车飞机和等您的人
        </p>
        <span class="line"></span>
        <span class="icon"></span>
      </div>
      <a href="http://localhost:8080/hotel_client_war_exploded/findByType.action?type=双床房" class="list-right-link"></a>
    </div>
  </div>
</div>

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