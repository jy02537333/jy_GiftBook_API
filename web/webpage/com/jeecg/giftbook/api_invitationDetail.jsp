<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <style>
        .span_hidden{display:block;text-overflow:ellipsis;overflow:hidden;white-space: nowrap;}
        .div_root{border:1px solid  #cccccc;margin: 2vw 2vw 3vw 2vw;height:30.5vw;}
        .div_img{width: 20vw;float:left;}
        .item_img{width: 19vw;height:19vw;padding:6%;}
        .span_item_title{display:block;font-size:4vw;margin-bottom:1vw;}
        .span_item_content{display:block;color:#bbbbbb;font-size:3.2vw;margin-bottom:0.5vw;}
        .div_content{width: 58vw;float:left;padding:2vw 0 0 2vw ;}
        .div_right{float:right;padding-top: 7vw;width:6vw;}
        .item_right_img{width: 100%;}
        .div_bottom{padding:2vw;background-color:#fafafa;height:5vw;
            border-bottom:1px solid  #cccccc;border-top: 1px solid  #cccccc;font-size:3.6vw; }
        .div_bottom span{;width:100%;}
    </style>
</head>
<body>
<h1 id="title">详情</h1>
<span id="testid"></span>
<div id="root">
</div>
<script src="plug-in-ui/hplus/js/jquery.min.js?v=2.1.4"></script>
<script>
    function getQueryString(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]); return null;
    }
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
    function callbackm(data)
    {
        if(data.result==1) {
            if(data.data.length>0)
            {
                page++;
            }else
                return;
            for (var i = 0; i < data.data.length; i++) {
                htmlStr = htmlStr + "<div class=\"div_root\" onclick='goUrl(\"" + data.data[i].thirdpartyaddr+ "\")'>";
                htmlStr = htmlStr + "<div class=\"div_img\">";
                htmlStr = htmlStr + "<img class=\"item_img\" src=\"" + data.data[i].logourl + "\"  onerror=\"javascript:this.src='logo.png';\"    />";
                htmlStr = htmlStr + "</div>";
                htmlStr = htmlStr + " <div class=\"div_content\">";
                htmlStr = htmlStr + "<span class=\"span_item_title span_hidden\">" + data.data[i].thirdpartyname + "</span>";
                htmlStr = htmlStr + "<span class=\"span_item_content span_hidden\">" + data.data[i].moneylimit + "</span>";
                htmlStr = htmlStr + "<span class=\"span_item_content span_hidden\">" + data.data[i].moneyinterest + "</span>";
                htmlStr = htmlStr + "</div>";
                htmlStr = htmlStr + "<div class=\"div_right\">";
                htmlStr = htmlStr + "<img class=\"item_right_img\" src=\"images/aboutmore.png\" />";
                htmlStr = htmlStr + " </div>";
                htmlStr = htmlStr + "<div  style=\"clear:left;\"></div>";
                htmlStr = htmlStr + "<div class=\"div_bottom\"><span class=\"span_hidden\">" + data.data[i].description + "</span></div>";
                htmlStr = htmlStr + "</div>";
            }
            $("#title").html();
            $("#root").html(htmlStr);
        }
    }
    function goUrl(url)
    {
        if(url.indexOf("http://")==-1)
            url="http://"+url;
        location.href=url;
    }
</script>
</body>
</html>

