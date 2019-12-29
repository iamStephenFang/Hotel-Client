<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>客房预订</title>
    <link rel="shortcut icon" type="image/x-icon" href="favicon.ico" class="ico"/>
    <!--<link rel="stylesheet" href="css/response.css"/>-->
    <link rel="stylesheet" href="css/base.css"/>
    <link rel="stylesheet" href="css/客房预订.css"/>
    <script src='js/jquery-1.11.1.min.js'></script>
    <script src="js/common.js"></script>
    <script src="js/public.js"></script>
</head>
<body>
<%@include file="header.jsp" %>
<!--中间部分-->


<div class="middle">
    <div class="banner">
        <img src="images/20161291428114995.jpg" alt=""/>
    </div>
    <p class="banner-side">
        <span class="text-img">
            <img src="images/jz_t3.png" alt=""/>
        </span>
        <span class="side-text">客房预定</span>
    </p>
</div>
<div class="roombox" id="roombox">
    <div class="roomlist">
        <div class="list-left">
            <a href="#"><img src="images/20161291749211642.jpg" alt=""/></a>
            <div class="shield">
                <p class="details"><span>查看详情</span></p>
                <p class="booking"><span>立即预定</span></p>
                <a href="#" class="shield-link"></a>
            </div>
        </div>
        <div class="list-right">
            <div class="list-right-1">
                <h3>豪华园景房</h3>
                <p class="money">
                    <span>￥</span>
                    <span class="price">3600</span>
                    <span>/晚起</span>
                </p>
                <a href="#" class="list-right-link"></a>
            </div>
            <div class="list-right-2">
                <p class="name">豪华园景房</p>
                <p class="money-h">
                    <span>现价：￥</span>
                    <span class="price">3600</span>
                    <span>/晚起</span>
                </p>
                <p class="description">
                    从58㎡的超大私享空间望出去，刻画远方天际线的不再是钢筋水泥的森林城市，而是绵延...
                </p>
                <span class="icon"></span>
                <a href="#" class="list-right-link"></a>
            </div>
            <a href="#" class="list-right-link"></a>
        </div>
    </div>
    <div class="roomlist">
        <div class="list-left">
            <a href="#"><img src="images/20161291747208695.jpg" alt=""/></a>
            <div class="shield">
                <p class="details"><span>查看详情</span></p>
                <p class="booking"><span>立即预定</span></p>
                <a href="#" class="shield-link"></a>
            </div>
        </div>
        <div class="list-right">
            <div class="list-right-1">
                <h3>豪华湖景房</h3>
                <p class="money">
                    <span>￥</span>
                    <span class="price">4000</span>
                    <span>/晚起</span>
                </p>
            </div>
            <div class="list-right-2">
                <p class="name">豪华湖景房</p>
                <p class="money-h">
                    <span>现价：￥</span>
                    <span class="price">4000</span>
                    <span>/晚起</span>
                </p>
                <p class="description">
                    映照天地的山湖其实是心中的宁镜，在这里你不仅看到飞鸟外物，更明鉴心中最真实的自己...
                </p>
                <span class="icon"></span>

            </div>
            <a href="#" class="list-right-link"></a>

        </div>
    </div>
    <div class="roomlist">
        <div class="list-left">
            <a href="#"><img src="images/20161291736456321.jpg" alt=""/></a>
            <div class="shield">
                <p class="details"><span>查看详情</span></p>
                <p class="booking"><span>立即预定</span></p>
                <a href="#" class="shield-link"></a>
            </div>
        </div>
        <div class="list-right">
            <div class="list-right-1">
                <h3>豪华园景驷马屋</h3>
                <p class="money">
                    <span>￥</span>
                    <span class="price">5800</span>
                    <span>/晚起</span>
                </p>
            </div>
            <div class="list-right-2">
                <p class="name">豪华园景驷马屋</p>
                <p class="money-h">
                    <span>现价：￥</span>
                    <span class="price">5800</span>
                    <span>/晚起</span>
                </p>
                <p class="description">
                    这是山的邀请，62平米超大私享空间盛放属于你的旅行与体验。这是山的礼遇，峨眉最宁...
                </p>
                <span class="icon"></span>

            </div>
            <a href="#" class="list-right-link"></a>

        </div>
    </div>
    <div class="roomlist">
        <div class="list-left">
            <a href="#"><img src="images/20161291727575343.jpg" alt=""/></a>
            <div class="shield">
                <p class="details"><span>查看详情</span></p>
                <p class="booking"><span>立即预定</span></p>
                <a href="#" class="shield-link"></a>
            </div>
        </div>
        <div class="list-right">
            <div class="list-right-1">
                <h3>豪华湖景驷马屋</h3>
                <p class="money">
                    <span>￥</span>
                    <span class="price">6200</span>
                    <span>/晚起</span>
                </p>
            </div>
            <div class="list-right-2">
                <p class="name">豪华湖景驷马屋</p>
                <p class="money-h">
                    <span>现价：￥</span>
                    <span class="price">6200</span>
                    <span>/晚起</span>
                </p>
                <p class="description">
                    智者乐山，仁者乐水。在湖光山色的潋滟之中，唤醒内心对于美好的渴望，62平米超大私...
                </p>
                <span class="icon"></span>

            </div>
            <a href="#" class="list-right-link"></a>

        </div>
    </div>
    <div class="roomlist">
        <div class="list-left">
            <a href="#"><img src="images/20161291718326046.jpg" alt=""/></a>
            <div class="shield">
                <p class="details"><span>查看详情</span></p>
                <p class="booking"><span>立即预定</span></p>
                <a href="#" class="shield-link"></a>
            </div>
        </div>
        <div class="list-right">
            <div class="list-right-1">
                <h3>豪华温泉别墅</h3>
                <p class="money">
                    <span>￥</span>
                    <span class="price">8800</span>
                    <span>/晚起</span>
                </p>
            </div>
            <div class="list-right-2">
                <p class="name">豪华温泉别墅</p>
                <p class="money-h">
                    <span>现价：￥</span>
                    <span class="price">8800</span>
                    <span>/晚起</span>
                </p>
                <p class="description">
                    60平米超大室内私享空间，148平米私人户外休闲区域，让内在与外在不分彼此。徜徉...
                </p>
                <span class="icon"></span>

            </div>
            <a href="#" class="list-right-link"></a>

        </div>
    </div>
    <div class="roomlist">
        <div class="list-left">
            <a href="#"><img src="images/2016129176596773.jpg" alt=""/></a>
            <div class="shield">
                <p class="details"><span>查看详情</span></p>
                <p class="booking"><span>立即预定</span></p>
                <a href="#" class="shield-link"></a>
            </div>
        </div>
        <div class="list-right">
            <div class="list-right-1">
                <h3>总统别墅</h3>
                <p class="money">
                    <span>￥</span>
                    <span class="price">28800</span>
                    <span>/晚起</span>
                </p>
            </div>
            <div class="list-right-2">
                <p class="name">总统别墅</p>
                <p class="money-h">
                    <span>现价：￥</span>
                    <span class="price">28800</span>
                    <span>/晚起</span>
                </p>
                <p class="description">
                    您是我们最珍视的贵宾，所以值得这一方山水的最高礼节。我们将峨眉山水的精粹尽汇于此...
                </p>
                <span class="icon"></span>

            </div>
            <a href="#" class="list-right-link"></a>

        </div>
    </div>
</div>




<%@include file="footer.jsp" %>
<%@include file="nav.jsp" %>
</body>
</html>