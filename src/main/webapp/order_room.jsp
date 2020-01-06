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
<div class="room-pbanner"><span class="black-70"></span>
  <p class="title"><s:property value="#request.roomType.type"/></p><span class="sj"></span></div><!--room-pbanner end-->
<dl class="room-page room-paging clearfix">
  <dd class="item1">
    <div class="room-deom"><p class="img"><img src="images/zt.jpg"/></p></div>
  </dd>
  <dd class="item2">
    <div class="room-info-box">
      <form name="from" method="post">
        <s:set var="checkInTime" value="%{#request.checkInTime}"/>
        <s:set var="leaveTime" value="%{#request.leaveTime}"/>
        <s:set var="type" value="%{#request.roomType.type}"/>

        <s:hidden name="order.register.phone" value="%{#session.register.phone}"/>
        <s:hidden name="checkInTime" value="%{#checkInTime}"/>
        <s:hidden name="leaveTime" value="%{#leaveTime}"/>
        <s:hidden name="order.roomType" value="%{#type}"/>
        <div class="room-i-t">
          <p class="rprice-bot jz-promise">
            <s:if test="#session.register != null">
              <span class="name">享受会员折扣</span>
            </s:if>
          </p>
          <p class="rprice-box">
            ￥<input type="text" id="discountPrice" name="order.payment" value="" class="price" style="background-color: rgba(255,255,255,0);color: #FFFFFF;text-align: center;width: 125px;" readonly/>
          </p>
          <p class="rprice-line">
            <span class="n" id="originalPrice"></span>
          </p>
          <span class="sj"></span>
        </div>

        <div class="room-i-c">
          时间：<s:property value="#checkInTime"/>&nbsp;至&nbsp;<s:property value="#leaveTime"/><br/>
          房型：<s:property value="#type"/><br/>
          每间入住人数：≤<s:property value="#request.roomType.checkInNum"/>人<br/>
          剩余房间数量：<s:property value="#request.leftRoom"/>间<br/>
          选择房间数量：<input id="roomNum" name="order.roomNum" type="number" max="<s:property value='#request.leftRoom'/>" min="1" value="1" style="max-width: 30px" onchange="priceChange()">间<br/>
          享受会员折扣：<s:property value="#session.register.member.discount"/> <br/>
          会员等级：<s:property value="#session.register.member.memberDetail"/> <br/>
        </div>

        <input type="button" onclick="backAction()" class="room-i-btn jz-yd-btn" value="返回检索" data-img="img/erm.jpg" style="font-size: 14px">
        <input type="button" onclick="orderAction()" class="room-i-btn jz-yd-btn" value="完成预订" data-img="img/erm.jpg" style="font-size: 14px;margin-top:7px;background-color: #8B0008">
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
      <li><a href="findByType.action?type=总统套房">
        <img src="images/zt.jpg" class="img"/>
        <div class="txt">总统套房</div>
      </a></li>
      <li><a href="findByType.action?type=家庭房">
        <img src="images/qz.jpg" class="img"/>
        <div class="txt">亲子套房</div>
      </a></li>
      <li><a href="findByType.action?type=大床房">
        <img src="images/dc.jpg" class="img"/>
        <div class="txt">大床房</div>
      </a></li>
      <li><a href="findByType.action?type=双床房">
        <img src="images/sc.jpg" class="img"/>
        <div class="txt">双床房</div>
      </a></li>
    </ul>
  </dd>
</dl>

<%@include file="dock.jsp" %>
<%@include file="footer.jsp" %>
<%@include file="nav.jsp" %>
<script type="text/javascript">
    window.onload=function () {
      priceChange();
    };

    function priceChange() {
        var discount = <s:property value="#session.register.member.discount"/>;
        var roomPrice = <s:property value="#request.roomType.roomPrice"/>;
        var days = <s:property value="#request.days"/>;
        var roomNum = document.getElementById("roomNum").value;
        var originalPrice = roomNum*days*roomPrice;
        var discountPrice = roomNum*days*roomPrice*discount;
        document.getElementById("discountPrice").setAttribute("value",discountPrice.toString());
        document.getElementById("originalPrice").innerText = "原价：￥"+originalPrice;
    }

    function backAction(){
        document.from.action="findByType.action?type=<s:property value='#type'/>";
        document.from.submit();
    }

    function orderAction(){
        document.from.action="insertOrder.action";
        document.from.submit();
    }
</script>
</body>
</html>
