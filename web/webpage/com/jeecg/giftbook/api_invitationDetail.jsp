<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>请帖详情</title>
    <meta name="description" content="A responsive coming soon template, un template HTML pour une page en cours de construction">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, maximum-scale=1, user-scalable=0">
    <link rel="stylesheet" href="plug-in/wedding/css/normalize.css">
    <link rel="stylesheet" href="plug-in/wedding/css/pageloader.css">
    <link rel="stylesheet" href="plug-in/wedding/fonts/opensans/stylesheet.css">
    <link rel="stylesheet" href="plug-in/wedding/fonts/asap/stylesheet.css">
    <link rel="stylesheet" href="plug-in/wedding/css/ionicons.min.css">
    <link rel="stylesheet" href="plug-in/wedding/css/foundation.min.css">
    <link rel="stylesheet" href="plug-in/wedding/js/vendor/jquery.fullPage.css">
    <link rel="stylesheet" href="plug-in/wedding/js/vegas/vegas.min.css">
    <link rel="stylesheet" href="plug-in/wedding/css/main.css">
    <link rel="stylesheet" href="plug-in/wedding/css/main_responsive.css">
    <link rel="stylesheet" href="plug-in/wedding/css/style-color1.css">
    <script src="plug-in/wedding/js/vendor/modernizr-2.7.1.min.js"></script>
    <style>
        #jp_container_1 { position: fixed; top: 5%; left: 2% }
        #jp_container_1 a { font-size: 26px; color: #ffffff }
        #jp_container_1 a:hover { color: #f4645f }
    </style>
</head>
<body id="menu" class="alt-bg">
<!--[if lt IE 8]>
<p class="browsehappy">You are using an <strong>outdated</strong> browser. Please
    <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
<![endif]-->

<!-- Page Loader -->
<div class="page-loader" id="page-loader">
    <div><i class="ion ion-loading-d"></i>
        <p>美丽值得期待...</p>
    </div>
</div>

<!-- BEGIN OF site cover -->
<div class="page-cover" id="s-cover">
    <!-- Cover Background -->
    <div class="cover-bg pos-abs full-size bg-img" data-image-src="plug-in/wedding/img/bg-slide3.jpg"></div>

    <!-- BEGIN OF Slideshow Background -->
    <div class="cover-bg pos-abs full-size slide-show">
        <i class='img' data-src='plug-in/wedding/img/bg-slide3.jpg'></i>
        <i class='img' data-src='plug-in/wedding/img/bg-slide2.jpg'></i>
        <i class='img' data-src='plug-in/wedding/img/bg-slide1.jpg'></i>
    </div>
    <!-- END OF Slideshow Background -->

    <div class="cover-bg-mask pos-abs full-size bg-color" data-bgcolor="rgba(0, 0, 0, 0.41)"></div>
</div>
<!--END OF site Cover -->

<!-- Begin of timer pane -->
<div class="pane-when " id="s-when">
    <div class="content">
        <!-- Clock -->
        <div class="clock clock-countdown">
            <div  class="site-config"
                 data-date="1/1/2010 0:00:00"
                 data-date-timezone="+8"
            ></div>
            <div class="elem-center">
                <div class="digit"> <span class="days">0</span> <span class="txt">天</span> </div>
            </div>
            <div class="elem-bottom">
                <div class="deco"></div>

                <!--						<span class="days">12</span><span class="thin">D</span>-->
                <span class="hours">0</span><span class="thin">小时</span> <span class="minutes">0</span><span class="thin">分钟</span> <span class="seconds">0</span><span class="thin">秒</span> </div>
        </div>
        <footer>
            <p id="FeastDate">2010年 <strong>1月15日</strong></p>
        </footer>
    </div>
</div>
<!-- End of timer pane -->

<!-- BEGIN OF site main content content here  主页面开始 -->
<main class="page-main" id="mainpage">

    <!-- Begin of home page -->
    <div class="section page-home page page-cent" id="s-home">

        <!-- Content -->
        <section class="content">
            <header class="header">
                <div class="h-left">
                    <h2 id="feastTypeTitle">诚邀<strong>见证</strong></h2>
                </div>
                <div class="h-right">
                    <h3><span id="WomanName">女方</span> & <br>
                        <span id="ManName">男方</span></h3>
                    <h4 class="subhead"><a href="#register" id="feastType">婚礼庆典</a></h4>
                </div>
            </header>
        </section>

        <!-- Scroll down button -->
        <footer class="p-footer p-scrolldown"> <a href="#register">
            <div class="arrow-d">
                <div class="before">Scroll</div>
                <div class="after">Down</div>
                <div class="circle"><i class="ion ion-mouse"></i></div>
            </div>
        </a> </footer>
    </div>
    <!-- End of home page -->

    <!-- End of register page -->

    <!-- Begin of Contact page   -->
    <div class="section page-contact page page-cent  bg-color" data-bgcolor="rgba(95, 25, 208, 0.88)s" id="s-contact">
        <!-- Begin of contact information -->
        <div class="slide" id="s-information" data-anchor="information">
            <section class="content">
                <%--<header class="p-title">--%>
                    <%--<h3>地址<i class="ion ion-location"> </i> </h3>--%>
                    <%--<ul class="buttons">--%>
                        <%--<li class="show-for-medium-up"> <a title="About" href="#about-us" ><i class="ion ion-android-information"></i></a> </li>--%>
                        <!--<li>
                                                <a title="Contact" href="#contact/information"><i class="ion ion-location"></i></a>
                                            </li>-->
                        <%--<li> <a title="Message" href="#contact/message"><i class="ion ion-email"></i></a> </li>--%>
                    <%--</ul>--%>
                <%--</header>--%>
                <!-- Begin Of Page SubSction -->
                <div class="contact">
                    <div class="row">
                        <div class="medium-6 columns left">
                            <ul>
                                <li>
                                    <h4>宴会地点：</h4>
                                    <p id="FeastHotel">某某某国际酒店</p>
                                </li>
                                <li>
                                    <h4>地址：</h4>
                                    <p id="FeastAddress">人民东路88888号</p>
                                </li>
                                <li>
                                    <h4>联系电话</h4>
                                    <p id="InviterPhone"> 010-123456789</p>
                                </li>
                            </ul>
                        </div>
                        <div class="medium-6 columns social-links right">
                            <ul>

                                <!-- legal notice -->
                                <%--<li class="show-for-medium-up">--%>
                                    <%--<h4>查看地图</h4>--%>
                                    <%--<p><a href="http://map.baidu.com/?newmap=1&s=inf%26uid%3Da61500c52fa38761f72310b0%26wd%3D%E5%BA%B7%E5%9F%8E%E5%9B%BD%E9%99%85%26all%3D1%26c%3D86&from=alamap&tpl=map_singlepoint" target="_blank">点击查看在线地图</a></p>--%>
                                <%--</li>--%>
                                <!--li  class="show-for-medium-up">
                                                            <h4>Find us on</h4>
                                                            <!-- Begin of Social links -->
                                <!--div class="socialnet">
                                                                <a href="#"><i class="ion ion-social-facebook"></i></a>
                                                                <a href="#"><i class="ion ion-social-instagram"></i></a>
                                                                <a href="#"><i class="ion ion-social-twitter"></i></a>
                                                                <a href="#"><i class="ion ion-social-pinterest"></i></a>
                                                                <a href="#"><i class="ion ion-social-tumblr"></i></a>
                                                            </div>
                                                            <!-- End of Social links -->
                                </li>
                                <li>
                                    <!--p><img src="img/logo_large.png" alt="Logo" class="logo"></p-->
                                    <p class="small"><strong>期待您的到场！</strong></p>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!-- End of page SubSection -->
            </section>
        </div>
        <!-- end of contact information -->

        <!-- begin of contact message -->
        <div class="slide" id="s-message" data-anchor="message">
            <section class="content">
                <header class="p-title">
                    <h3>宾客寄语：<i class="ion ion-email"> </i> </h3>
                    <ul class="buttons">
                        <li class="show-for-medium-up"> <a title="About" href="#about-us"><i class="ion ion-android-information"></i></a> </li>
                        <li> <a title="Contact" href="#contact/information"><i class="ion ion-location"></i></a> </li>
                        <!--<li>
                                                <a title="Message" href="#contact/message"><i class="ion ion-email"></i></a>
                                            </li>-->
                    </ul>
                </header>
                <!-- Begin Of Page SubSction -->

                <div class="page-block c-right v-zoomIn">
                    <div class="wrapper">
                        <div>
                            <form class="message form send_message_form" method="get" action="ajaxserver/serverfile.php">
                                <div class="fields clearfix">
                                    <div class="input">
                                        <label for="mes-name">姓名</label>
                                        <input id="mes-name" name="name" type="text" placeholder="您的名字" required>
                                    </div>
                                    <div class="buttons">
                                        <button id="submit-message" class="button email_b" name="submit_message">发送</button>
                                    </div>
                                </div>
                                <div class="fields clearfix">
                                    <div class="input">
                                        <label for="mes-email">邮箱： </label>
                                        <input id="mes-email" type="email" placeholder="邮箱地址" name="email" required>
                                    </div>
                                </div>
                                <div class="fields clearfix no-border">
                                    <label for="mes-text">留言： </label>
                                    <textarea id="mes-text" placeholder="您写下的祝福将被送出" name="message" required></textarea>
                                    <div>
                                        <p class="message-ok invisible">您的祝福已经送出，谢谢！.</p>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <!-- End Of Page SubSction -->
            </section>
        </div>
        <!-- End of contact message -->
    </div>





    <!-- End of Contact page  -->    <!-- Begin of register page -->
    <%--<div class="section page-register page page-cent"  id="s-register">--%>
        <%--<section class="content">--%>
            <%--<header class="p-title">--%>
                <%--<h3>庆宴时间：<i class="ion ion-compose"></i></h3>--%>
                <%--<h4 class="subhead">2018年1月15日</h4>--%>
            <%--</header>--%>
            <%--<div>--%>
                <%--<form id="mail-subscription" class="form magic send_email_form" method="get" action="ajaxserver/serverfile.php">--%>
                    <%--<p class="invite"><br/>--%>
                        <%--请在下方输入到场宾客姓名我们将提前为您安排坐席：</p>--%>
                    <%--<div class="fields clearfix">--%>
                        <%--<div class="input">--%>
                            <%--<label for="reg-email">姓名： </label>--%>
                            <%--<input id="reg-email" class="email_f"  name="email" type="text" required placeholder="嘉宾姓名" data-validation-type="text">--%>
                        <%--</div>--%>
                        <%--<div class="buttons">--%>
                            <%--<button id="submit-email" class="button email_b" name="submit_email">确认</button>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<p class="email-ok invisible"><strong>等一场千年雨歇，侯一人如约而至！</strong> </p>--%>
                <%--</form>--%>
            <%--</div>--%>
        <%--</section>--%>
        <%--<footer class="p-footer p-scrolldown"> <a href="#about-us">--%>
            <%--<div class="arrow-d">--%>
                <%--<div class="before">About</div>--%>
                <%--<div class="after">Lorem</div>--%>
                <%--<div class="circle"><i class="ion ion-mouse"></i></div>--%>
            <%--</div>--%>
        <%--</a> </footer>--%>
    <%--</div>--%>





</main>
<script src="plug-in/wedding/js/jquery.min.js"></script>
<script src="plug-in/wedding/js/vendor/all.js"></script>
<script src="plug-in/wedding/js/jquery.downCount.js"></script>
<script src="plug-in/wedding/js/form_script.js"></script>
<script src="plug-in/wedding/js/main.js"></script>
<script type="text/javascript" src="plug-in/wedding/js/jquery.jplayer.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        $("#jquery_jplayer_1").jPlayer({
            ready: function () {
                $(this).jPlayer("setMedia", {
                    mp3: "plug-in/wedding/music.mp3",

                }).jPlayer("play");
            },
            ended: function() { // The $.jPlayer.event.ended event
                $(this).jPlayer("play"); // Repeat the media
            },
            swfPath: "/js",
            supplied: "mp3"
        });
        var id=getQueryString("invitationid");
        var childId=getQueryString();
        $("#testid").html(id);
        var url1="apiInvitationController.do?byid&invitationid="+id+"&invitationChildId="+childId;
        $.ajax({
            type : "GET",
            async: true,
            url:url1,
            dataType: "jsonp",
            jsonp: "callback",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(一般默认为:callback)
            jsonpCallback:"callbackm",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名，也可以写"?"，jQuery会自动为你处理数据
            success: function(json){
                window.console.log(json);
            },
            error: function(e){
                window.console.log(e)
            }
        });
        var htmlStr = "";
    });
</script>
<div id="jquery_jplayer_1"></div>
<div id="jp_container_1"> <a href="#" class="jp-play">
    <li class="ion-music-note" data-pack="default" data-tags="songs"></li>
</a> <a href="#" class="jp-pause">
    <li class="ion-headphone" data-pack="default" data-tags="music, earbuds, beats"></li>
</a> </div>

<script>
    function initDate() {
        $('.clock-countdown').downCount({
            date: $('.site-config').attr('data-date'),
            offset: +10
        }, function () {
            //callback here if finished
            //alert('YES, done!');
            var zerodayText = 'An upcoming date';
            if ($('.site-config').attr('data-zeroday-text') && ($('.site-config').attr('data-zeroday-text') != '')) {
                $('.timeout-day').text('');
                zerodayText = $('.site-config').attr('data-zeroday-text');
            }
            $('.timeout-day').text(zerodayText);
        });
    }
    function getQueryString(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]); return null;
    }
    function callbackm(data)
    {
        if(data.result==1) {
            $("#WomanName").html(data.data.womanname);
            $("#ManName").html(data.data.manname);
            $("#FeastHotel").html(data.data.feasthotel);
            $("#FeastAddress").html(data.data.feastaddress);
            $("#InviterPhone").html(data.data.inviterphone);
            var date=fmtDate(data.data.feastdate);
            if(date.isBeOverdue)
            {
                $("#FeastDate").html(""+date.year+"年<strong>"+date.month+"月"+date.day+"日</strong>");
                $(".days").html(0);
                $(".site-config").attr("data-date",date.month+"//"+date.day+"//"+date.year+" "+
                    date.hour+":"+date.Minute+":"+date.second);
                $(".elem-bottom>hours").html(0);
                $(".elem-bottom>minutes").html(0);
                $(".elem-bottom>seconds").html(0);
            }else {
                $("#FeastDate").html(""+date.year+"年<strong>"+date.month+"月"+date.day+"日</strong>");
                $(".days").html(date.timeDifferenceDay);
                $(".site-config").attr("data-date",date.month+"//"+date.day+"//"+date.year+" "+
                    date.hour+":"+date.Minute+":"+date.second);
            }
            initDate();
            if(data.data.feasttype==1)
            {
                $("#feastType").html("婚礼庆典");
                $("#feastTypeTitle").html("诚邀<strong>见证</strong>");
            }
            else if(data.data.feasttype==2)
            {
                $("#feastType").html("百日宴");
                $("#feastTypeTitle").html("诚邀<strong>参加</strong>");
            }

            var baseImgUrl='http://images.libugj.cn/';
            $("#s-contact").after("<div class='section page-register page page-cent'  data-anchor='contact'  >  <div> <img style='height:100%;' src='"+baseImgUrl+data.data.coverimg+"'></div> </div>");
            var imgs=data.data.photoalbum.split(",");
            for(var i=0;imgs!=null&&imgs.length>0&&i<imgs.length;i++)
            {
                if(imgs[i].length>0)
                     $("#s-contact").after("<div class='section page-register page page-cent'  data-anchor='contact'  >  <div> <img style='height:100%;' src='"+baseImgUrl+imgs[i]+"'></div> </div>");
            }
            initPage();
        }
    }

    function fmtDate(obj){
        var date =  new Date(obj);
        var y = 1900+date.getYear();
        var m =0;
        if(date.getMonth()+1<10)
        {
            m = "0"+(date.getMonth()+1)
        }else
            m =  date.getMonth()+1;
        var d = "0"+date.getDate();
        if(date.getDate()<10)
        {
            d = "0"+(date.getDate())
        }else
            d =  date.getDate();
        //计算时间差
        var date3 =  parseInt(obj)- new Date().getTime();
        var timeDifferenceDay =Math.floor(date3/(24*3600*1000));
        var isBeOverdue=false;
        if(date3<0)
            isBeOverdue=true;
//        return y+"-"+m.substring(m.length-2,m.length)+"-"+d.substring(d.length-2,d.length);
        return {year:y,month:m,day:d,hour:date.getHours(),Minute:date.getMinutes(),second:date.getSeconds()
        ,'timeDifferenceDay':timeDifferenceDay,'isBeOverdue':isBeOverdue}
    }

</script>
</body>
</html>

