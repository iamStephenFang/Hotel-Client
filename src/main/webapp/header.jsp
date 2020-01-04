<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!--顶部导航部分-->
<div class="topnav clearfix" id="topnav">
  <p class="sider-link">
    <a href="最新优惠.html">最新优惠</a>
    <a href="#">客房预订</a>
  </p>
  <a href="index.jsp" class="logo"><img src="images/HAPE.png" alt=""/></a>
  <div class="sider-nav">
    <ul class="clearfix">
      <s:if test="#session.register == null">
        <li class="serach-toggle">
          <a href="sign_up.jsp" class="refresh-btn">
            <span class="ico">注册</span>
          </a>
        </li>
        <li class="user-toggle">
          <a class="menu-handle">
            <span class="ico">导航</span>
            <span class="buger buger-1 trans"></span>
            <span class="buger buger-3 trans"></span>
          </a>
        </li>
      <li class="btn-toggle">
        <a href="sign_in.jsp" class="quickBooking">
          <span class="">登录会员</span>
          <span class="css-box">
                        <span class="box1"></span>
                        <span class="box2"></span>
                        <span class="box3"></span>
          </span>
        </a>
      </li>
      </s:if>
      <s:else>
        <li class="serach-toggle">
          <a href="sign_in.jsp" class="refresh-btn">
            <span class="ico">退出</span>
          </a>
        </li>
        <li class="user-toggle">
          <a class="menu-handle">
            <span class="ico"><s:property value='#session.register.account'/></span>
            <span class="buger buger-1 trans"></span>
            <span class="buger buger-3 trans"></span>
          </a>
        </li>
        <li class="btn-toggle">
          <a href="findOrderByPhone.action" class="quickBooking">
            <span class="">查看订单</span>
            <span class="css-box">
                        <span class="box1"></span>
                        <span class="box2"></span>
                        <span class="box3"></span>
          </span>
          </a>
        </li>
      </s:else>
    </ul>
  </div>
</div>