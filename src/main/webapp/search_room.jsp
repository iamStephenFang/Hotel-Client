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
  <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
  <title>房间预订</title>
</head>
<body>
<%@include file="header.jsp" %>

<div class="pusher-black"></div>
<div class="mtop"></div>
<div class="room-pbanner" ><span class="black-70"></span>
  <p class="title"><s:property value="#request.roomType.type"/></p></div><!--room-pbanner end-->
<dl class="room-page room-paging clearfix">
  <dd class="item1">
    <s:if test="#request.roomType.type == '双床房'">
      <div class="room-deom"><p class="img"><img src="images/sc.jpg"/></p></div>
    </s:if>
    <s:if test="#request.roomType.type == '大床房'">
      <div class="room-deom"><p class="img"><img src="images/dc.jpg"/></p></div>
    </s:if>
    <s:if test="#request.roomType.type == '家庭房'">
      <div class="room-deom"><p class="img"><img src="images/qz.jpg"/></p></div>
    </s:if>
    <s:if test="#request.roomType.type == '总统套房'">
      <div class="room-deom"><p class="img"><img src="images/zt.jpg"/></p></div>
    </s:if>
  </dd>
  <dd class="item2">
    <div class="room-info-box">
      <div class="room-i-t"><p class="rprice-bot jz-promise">
        <span class="name">当前价格<i class="sico" data-con="为确保您时刻享有最优惠价格，己庄保障本网址登载客房价格是互联网公布的最低价格。您于本网址以最低房价预订客房后24小时内，如发现另一网址提供比本网址公布的最低房价更低的价格，我们将会按该较低房价收费，并额外再给予九折优惠。"></i></span>
      </p>
        <p class="rprice-box">￥<span class="price"><s:property value="#request.roomType.roomPrice"/></span>/晚起</p>
<%--        <p class="rprice-line"><span class="n">&nbsp;&nbsp;原价：￥3600/晚起&nbsp;&nbsp;</span></p><span class="sj"></span>--%>
      </div>
      <form name="from" method="post">
      <div class="search_room" style="padding:20px 5%;text-align: center;display: block;">
        来店时间：<input id="checkInTime" type="date"  name="checkInTime" value="<s:property value="#request.checkInTime"/>" style="width: 370px;background-color: #9b6946;height: 36px;line-height: 36px;color: #FFFFFF">
        离店时间：<input id="leaveTime" type="date"  name="leaveTime" value="<s:property value="#request.leaveTime"/>" style="margin-top:7px;width: 370px;background-color: #9b6946;height: 36px;line-height: 36px;color: #FFFFFF">
      </div>
      <div class="room-i-c" style="padding: 20px 5%;">
        房型：<s:property value="#request.roomType.type"/><br/>
        入住人数：≤<s:property value="#request.roomType.checkInNum"/>人<br/>
        <s:if test="#request.leftRoom!= null">
        剩余房间数量：<s:property value="#request.leftRoom"/><br/>
        </s:if>
        <s:hidden name="leftRoom" value="%{#request.leftRoom}"/>
        <s:hidden name="type" value="%{#request.roomType.type}"/>
      </div>
      <input type="button" onclick="searchAction()" class="room-i-btn jz-yd-btn" value="立即检索" data-img="img/erm.jpg" style="font-size: 14px">
        <s:if test="#request.leftRoom!= null">
        <input type="button" onclick="orderAction()" class="room-i-btn jz-yd-btn" value="立即预订" data-img="img/erm.jpg" style="font-size: 14px;margin-top:7px;background-color: #8B0008">
        </s:if>
      </form>
    </div>
  </dd>
</dl><!--room-page end-->
<div class="room-page room-paging bgdc clearfix">
  <s:if test="#request.roomType.type == '双床房'">
    <div class="pageC room-pageC">极致简约<br/>格局虽小，却有着无比精致的布置<br/>私人定制<br/>尽享自由空间<br/></div>
  </s:if>
  <s:if test="#request.roomType.type == '大床房'">
    <div class="pageC room-pageC">宽敞空间<br/>完美隔音保证精致睡眠<br/>私人阳台<br/>尽享独特美景<br/></div>
  </s:if>
  <s:if test="#request.roomType.type == '家庭房'">
    <div class="pageC room-pageC">其乐融融<br/>为家族专门设计的极大空间<br/>附带厨房与迷你吧台<br/>通过活动享受家族之乐<br/></div>
  </s:if>
  <s:if test="#request.roomType.type == '总统套房'">
    <div class="pageC room-pageC">极致享受<br/>为您送上最周全的服务<br/>面朝大海<br/>日出的第一缕光从这儿开始<br/></div>
  </s:if>
</div><!--room-page end-->
<div class="room-page room-paging clearfix">
  <div class="pageC room-pageC"><h3>设施</h3>
    <p><strong>便利设施</strong>：雨伞、多种规格电源插座、中央空调、书桌、熨衣设备、房内保险箱、沙发、衣柜/衣橱、220V电压插座、电子秤、闹钟、针线包、不间断插座、遮光窗帘、手动窗帘、床具:鸭绒被、床具:毯子或被子、备用床具、房间内高速上网、客房WIFI覆盖免费
    </p>
    <p><br/></p>
    <p><strong>媒体/科技</strong>：国内长途电话、国际长途电话、音响、有线频道、液晶电视机、电视机、电话、iPod音乐基座</p>
    <p><br/></p>
    <p><strong>食品和饮品</strong>：电热水壶、免费瓶装水、小冰箱、迷你吧</p>
    <p><br/></p>
    <p><strong>浴室</strong>：24小时热水、拖鞋、浴室化妆放大镜、浴衣、浴缸、独立淋浴间、吹风机、电热水器、淋浴、洗浴间电话、免费洗漱用品</p>
    <p><br/></p>
    <p><strong>室外/景观</strong>：阳台、湖景</p>
    <p><br/></p>
    <p><strong>服务及其他</strong>：唤醒服务</p>
    <p><br/></p></div>
</div><!--room-page end-->
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
<script type="text/javascript">
    function searchAction(){
        document.from.action="getRestRoomNum.action";
        document.from.submit();
    }

    function orderAction(){
        document.from.action="checkOrder.action";
        document.from.submit();
    }
</script>
</body>
</html>