<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no, width=device-width">
    <title></title>
    <link href="plug-in/www/css/ionic.app.css" rel="stylesheet">
    <link href="plug-in/www/css/style.css" rel="stylesheet">
    <!-- ionic/angularjs js -->
    <script src="plug-in/www/lib/ionic/js/ionic.bundle.js"></script>
    <link href="plug-in/www/lib/ionic-toast/src/ionic-toast.css" rel="stylesheet">
    <script src="plug-in/www/lib/ionic-toast/dist/ionic-toast.bundle.min.js"></script>
    <!-- cordova script (this will be a 404 during development) -->
    <!--<script src="cordova.js"></script>-->
    <!-- your app's js -->
    <script src="plug-in/www/js/app.js"></script>
    <script src="plug-in/www/js/controllers.js"></script>
    <script src="plug-in/www/js/routes.js"></script>
    <script src="plug-in/www/js/services.js"></script>
    <script src="plug-in/www/js/directives.js"></script>
    <script src="plug-in/www/js/elastic.js"></script>

</head>

<body ng-app="wechat">
    <ion-nav-view animation="slide-left-right">
    </ion-nav-view>
    <div id="allmap"></div>
    <script type="text/javascript"  src="plug-in-ui/hplus/js/jquery.min.js?v=2.1.4"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=NZyfpqnDBNM1IzC6j4ZhdyKbp7ac0hdc"></script>
    <script type="text/javascript" src="http://developer.baidu.com/map/jsdemo/demo/convertor.js"></script>
    <script type="application/javascript">
        // 百度地图API功能
        var map = new BMap.Map("allmap");
        var point = new BMap.Point(106.7091771,26.62990674);
        map.centerAndZoom(point,12);

        var geolocation = new BMap.Geolocation();
        geolocation.getCurrentPosition(function(r){
            if(this.getStatus() == BMAP_STATUS_SUCCESS){
                var mk = new BMap.Marker(r.point);
//                map.addOverlay(mk);
//                map.panTo(r.point);
                aaa(r);
//                showPosition(r);
            }
            else {
                alert('failed'+this.getStatus());
            }
        },{enableHighAccuracy: true})
        //百度地图WebAPI 坐标转地址
        function showPosition(r) {
            // ak = appkey 访问次数流量有限制
            var urlAddr = 'http://api.map.baidu.com/geocoder/v2/?ak=NZyfpqnDBNM1IzC6j4ZhdyKbp7ac0hdc&callback=?&location=' + r.result[0].y + ',' + r.result[0].x + '&output=json&pois=1';
            $.getJSON(urlAddr, function (res) {
                alert(res.result.addressComponent.city);
            });
        }
        function  aaa(r)
        {
            //http://api.map.baidu.com/geoconv/v1/?coords=114.21892734521,29.575429778924;114.21892734521,29.575429778924&from=1&to=5&ak=NZyfpqnDBNM1IzC6j4ZhdyKbp7ac0hdc
            //http://api.map.baidu.com/geoconv/v1/?coords=114.21892734521,29.575429778924;114.21892734521,29.575429778924&from=1&to=5&ak=NZyfpqnDBNM1IzC6j4ZhdyKbp7ac0hdc
            var urlAddr = 'http://api.map.baidu.com/geoconv/v1/?coords=' + r.point.lng + ',' + r.point.lat + '&from=1&to=5&ak=NZyfpqnDBNM1IzC6j4ZhdyKbp7ac0hdc&callback=?';
            $.getJSON(urlAddr, function (res) {
                showPosition(res);
//                alert(res.result.addressComponent.city);
            });
        }
    </script>
</body>

</html>