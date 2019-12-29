<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>己庄酒店官方网站</title>
    <link rel="shortcut icon" type="image/x-icon" href="favicon.ico" class="ico"/>
    <!--<link rel="stylesheet" href="css/response.css"/>-->
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
                    <p class="by1">心之所往</p>
                    <p class="by2">身之所在</p>
                    <span class="jz-ico"></span>
                    <span class="jz-en"></span>
                </div>
                <p class="jz-zh">己庄酒店</p>
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
                    <p class="by1">一方梦田</p>
                    <p class="by2">自在心间</p>
                    <span class="jz-ico"></span>
                    <span class="jz-en"></span>
                </div>
                <p class="jz-zh">己庄酒店</p>
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
                    <p class="by1">心之所往</p>
                    <p class="by2">身之所在</p>
                    <span class="jz-ico"></span>
                    <span class="jz-en"></span>
                </div>
                <p class="jz-zh">己庄酒店</p>
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

<!--风景图片展示部分-->
<div class="bge6 clearfix">
    <div class="bge6-l">
        <p class="describe">收拾好心情，正是出行好时节 <span class="more"></span></p>
        <div class="beauty">
            <img class="pic-1" src="images/in1.jpg" alt=""/>
            <p class="name">池畔BBQ</p>
        </div>
        <a href="#" class="beauty-link"></a>
    </div>
    <div class="bge6-l">
        <p class="describe">带上孩子来一场说走就走的轻松之旅 <span class="more"></span></p>
        <div class="beauty">
            <img class="pic-1" src="images/in2.jpg" alt=""/>
            <p class="name">池畔BBQ</p>
        </div>
        <a href="#" class="beauty-link"></a>
    </div>
    <div class="bge6-l bge6-last">
        <p class="describe">峨眉视角 <span class="more"></span></p>
        <div class="beauty">
            <img class="pic-1" src="images/in3.jpg" alt=""/>
            <p class="name">池畔BBQ</p>
        </div>
        <a href="#" class="beauty-link"></a>
    </div>
</div>

<!--房间展示部分-->
<div class="roombox" id="roombox">

</div>





<%@include file="footer.jsp" %>
<%@include file="nav.jsp" %>
</body>
</html>