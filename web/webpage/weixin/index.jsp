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

    </script>
</body>

</html>