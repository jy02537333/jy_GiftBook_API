angular.module('wechat.controllers', [])

.controller('findCtrl', function($scope, $state) {
    $scope.onSwipeLeft = function() {
        $state.go("tab.setting");
    };
    $scope.onSwipeRight = function() {
        $state.go("tab.friends");
    };
})

.controller('messageCtrl', function($scope, $state, $ionicPopup, localStorageService, messageService) {

})

.controller('friendsCtrl', function($scope, $state) {
    $scope.onSwipeLeft = function() {
        $state.go("tab.find");
    };
    $scope.onSwipeRight = function() {
        $state.go("tab.message");
    };
    $scope.contacts_right_bar_swipe = function(e){
        console.log(e);
    };
})

    .controller('settingCtrl', function($scope, $state) {
    $scope.onSwipeRight = function() {
        $state.go("tab.find");
    };
})

    .controller('truckCtrl', function($scope, $state,$http,ionicToast) {
        findTruck($scope, $state,$http,ionicToast,1)
    })
    .controller('truck2Ctrl', function($scope, $state,$http,ionicToast) {
        findTruck($scope, $state,$http,ionicToast,2)
    })
    .controller('transporterCtrl', function($scope, $state,$http,ionicToast) {
        findTransporter($scope, $state,$http,ionicToast,1)
    })
    .controller('transporter2Ctrl', function($scope, $state,$http,ionicToast) {
        findTransporter($scope, $state,$http,ionicToast,2)
    })

    .controller('truckAddCtrl', function($ionicHistory,$scope, $state,$http,ionicToast,$stateParams) {
        var chengeitem="拖车";
        var isGeting=false;
        $scope.getLocation=function (e)
        {
            if(isGeting)
                return ;
             isGeting=true;
            getBMapLocation(locationCellback);
        }
        $scope.$on('$ionicView.beforeEnter', function() {
            function locationCellback(res)
            {
                if(res!=null&&res.result!=undefined&&res.result.cityCode!=undefined&&res.result.cityCode>0){
                    $scope.location=res.result.formatted_address+"  " +res.result.sematic_description;
                    $scope.lngLat=res.result.location.lng+"," +res.result.location.lat;
                    $scope.locationVal=res.result.formatted_address+"  " +res.result.sematic_description;
                    $scope.lngLatVal=res.result.location.lng+"," +res.result.location.lat;
                }
                isGeting=false;
            }
            getBMapLocation(locationCellback);
            chengeitem="拖车";
            $scope.type="拖车";
            if($stateParams.typeId!=1)
            {
                chengeitem="小货车";
                $scope.type="小货车";
            }
            $scope.location="";
            $scope.phone="";
            $scope.licensePlate="";
            $scope.lngLat="";
        });

        $scope.typeData=[{"id":"拖车","name":"拖车"},{"id":"小货车","name":"小货车"},{"id":"大货车","name":"大货车"}];
        chengeitem="拖车";
        $scope.type="拖车";
        if($stateParams.typeId!=1)
        {
            chengeitem="小货车";
            $scope.type="小货车";
        }
        $scope.location="";
        $scope.phone="";
        $scope.licensePlate="";
        $scope.lngLat="";
        $scope.selectChange = function(){
            //获取被选中的值
             chengeitem = $scope.type;
        };
        $scope.save = function(e){
            // var aaa=new GB2312UTF8().Gb2312ToUtf8($scope.licensePlate);
            var data = {dtid: $scope.location,
                phone: $scope.phone,
                 licensePlate:$scope.licensePlate,
                vehicleType: chengeitem,
                latlng: $scope.lngLat
            };
            $http({
                method: 'POST',
                url: '/apiTruckController.do?doAdd&aa=',
                params:  data,
                contentType:"application/x-www-form-urlencoded; charset=utf-8",
                 headers:{
                    'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'

                }}).success(function(data,status,headers,config){
                if(data.result==1)
                {
                    ionicToast.show('发布成功！', 'top', false, 2500);
                   // $state.go(-1)
                    $ionicHistory.goBack();
                }else{
                    ionicToast.show('网络异常！', 'top', false, 2500);
                }
            }).error(function(data,status,headers,config){
                ionicToast.show('网络异常！', 'top', false, 2500);
            });
        };

    })
    .controller('transporterAddCtrl', function($ionicHistory,$scope, $state,$http,ionicToast,$stateParams) {
        var isGeting=false;
        $scope.getLocation=function (e)
        {
            if(isGeting)
                return ;
            isGeting=true;
            getBMapLocation(locationCellback);
        }
        $scope.$on('$ionicView.beforeEnter', function() {
            function locationCellback(res)
            {
                if(res!=null&&res.result!=undefined&&res.result.cityCode!=undefined&&res.result.cityCode>0){
                    $scope.location=res.result.formatted_address+"  " +res.result.sematic_description;
                    $scope.lngLat=res.result.location.lng+"," +res.result.location.lat;
                    $scope.locationVal=res.result.formatted_address+"  " +res.result.sematic_description;
                    $scope.lngLatVal=res.result.location.lng+"," +res.result.location.lat;
                }
                isGeting=false;
            }
            getBMapLocation(locationCellback);
            $scope.locationVal="";
            $scope.lngLatVal="";
        });

        $scope.locationVal="";
        $scope.lngLatVal="";
        $scope.save = function(e){
            var data = {
                type:$stateParams.typeId,
                addr: $scope.location,
                phone: $scope.phone,
                licensePlate:$scope.licensePlate,
                info: $scope.Info,
                startAddr: $scope.StartAddr,
                endAddr: $scope.EndAddr,
                latlng: $scope.lngLat
            };
            $http({
                method: 'POST',
                url: '/apiTruckRouteController.do?doAdd&aa=',
                params:  data,
                contentType:"application/x-www-form-urlencoded; charset=utf-8",
                headers:{  'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8' }})
                .success(function(data,status,headers,config){
                if(data.result==1)
                {
                    ionicToast.show('发布成功！', 'top', false, 2500);
                    // $state.go(-1)
                    $ionicHistory.goBack();
                }else{
                    ionicToast.show('网络异常！', 'top', false, 2500);
                }
            }).error(function(data,status,headers,config){
                ionicToast.show('网络异常！', 'top', false, 2500);
            });
        };

    })

.controller('messageDetailCtrl', ['$scope', '$stateParams',
    'messageService', '$ionicScrollDelegate', '$timeout',
    function($scope, $stateParams, messageService, $ionicScrollDelegate, $timeout) {
        var viewScroll = $ionicScrollDelegate.$getByHandle('messageDetailsScroll');
        // console.log("enter");
        $scope.doRefresh = function() {
            // console.log("ok");
            $scope.messageNum += 5;
            $timeout(function() {
                $scope.messageDetils = messageService.getAmountMessageById($scope.messageNum,
                    $stateParams.messageId);
                $scope.$broadcast('scroll.refreshComplete');
            }, 200);
        };

        $scope.$on("$ionicView.beforeEnter", function() {
            $scope.message = messageService.getMessageById($stateParams.messageId);
            $scope.message.noReadMessages = 0;
            $scope.message.showHints = false;
            messageService.updateMessage($scope.message);
            $scope.messageNum = 10;
            $scope.messageDetils = messageService.getAmountMessageById($scope.messageNum,
                $stateParams.messageId);
            $timeout(function() {
                viewScroll.scrollBottom();
            }, 0);
        });

        window.addEventListener("native.keyboardshow", function(e){
            viewScroll.scrollBottom();
        });
    }
])

function findTruck($scope, $state,$http,ionicToast,type){
    $scope.hasmore = true;
    $scope.isPost = false;
    $scope.dataValue={};
    $scope.dataValue.page=0;
    $scope.items=new Array();
    $scope.loadMore = function () {
        if(!$scope.isPost) {
            $scope.isPost = true;
            $scope.dataValue.page++;
            loadajax();
        }
    }
    function loadajax() {
        var dataValue = $scope.dataValue;
        var req = {
            method: 'POST', //请求的方式
            url: '/apiTruckController.do?datagrid&page='+$scope.dataValue.page+'&rows=10&vehicleType='+type, //请求的地址
            // headers: {
            //     'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8',
            //     'Accept': '*/*'
            // }, //请求的头，如果默认可以不写
            timeout: 5000, //超时时间，还没有测试
            data: {'page': $scope.dataValue.page,'curPage': $scope.dataValue.page,'vehicleType':type} //message 必须是a=b&c=d的格式
        };
        $http(req).success(function (data) {
            if (data.data==null||data.data.length == 0||data.totalCount<=$scope.dataValue.page*10) {
                $scope.hasmore = false;//这里判断是否还能获取到数据，如果没有获取数据，则不再触发加载事件
            }
            if(data.data!=null&&data.data.length>0)
                $scope.items = $scope.items.concat(data.data);
        }).error(function (err) {
            $scope.dataValue.page--;
            $scope.hasmore = false;
            console.log("err");
        }).finally(function () {
            $scope.isPost=false;
            $scope.$broadcast('scroll.infiniteScrollComplete');//这里是告诉ionic更新数据完成，可以再次触发更新事件
            $scope.$broadcast('scroll.refreshComplete');
        });
    }
    $scope.truckAdd = function(e){
        $state.go("truckAdd",{typeId:type,isCache:false});
        //$state.go("messageDetail");
    };
    $scope.$on('$ionicView.beforeEnter', function() {
        $scope.hasmore = true;
        $scope.dataValue.page=0;
        $scope.items=new Array();
        $scope.loadMore();
    });
}


function findTransporter($scope, $state,$http,ionicToast,type){
    $scope.hasmore = true;
    $scope.isPost = false;
    $scope.dataValue={};
    $scope.dataValue.page=0;
    $scope.items=new Array();
    $scope.loadMore = function () {
        if(!$scope.isPost){
            $scope.isPost=true;
            $scope.dataValue.page++;
            loadajax();
        }
    }
    function loadajax() {
        var dataValue = $scope.dataValue;
        var req = {
            method: 'POST', //请求的方式
            url: '/apiTruckRouteController.do?datagrid&page='+$scope.dataValue.page+'&rows=10&type='+type, //请求的地址
            timeout: 5000, //超时时间，还没有测试
            data: {'page': $scope.dataValue.page,'curPage': $scope.dataValue.page,'type':type} //message 必须是a=b&c=d的格式
        };
        $http(req).success(function (data) {
            if (data.data==null||data.data.length == 0||data.totalCount<=$scope.dataValue.page*10) {
                $scope.hasmore = false;//这里判断是否还能获取到数据，如果没有获取数据，则不再触发加载事件
            }
            if(data.data!=null&&data.data.length>0)
                $scope.items = $scope.items.concat(data.data);
        }).error(function (err) {
            $scope.dataValue.page--;
            $scope.hasmore = false;
            console.log("err");
        }).finally(function () {
            $scope.isPost=false;
            $scope.$broadcast('scroll.infiniteScrollComplete');//这里是告诉ionic更新数据完成，可以再次触发更新事件
            $scope.$broadcast('scroll.refreshComplete');
        });
    }
    $scope.truckAdd = function(e){
        if(type==1)
            $state.go("transporterAdd",{typeId:type});
        else
            $state.go("transporterAdd2",{typeId:type});
        //$state.go("messageDetail");
    };
    $scope.$on('$ionicView.beforeEnter', function() {
        $scope.hasmore = true;
        $scope.dataValue.page=0;
        $scope.items=new Array();
        $scope.loadMore();
    });
}



function getBMapLocation(callback) {
    // 百度地图API功能
    var map = new BMap.Map("allmap");
    var point = new BMap.Point(0,0);
    map.centerAndZoom(point,12);
    var geolocation = new BMap.Geolocation();
    geolocation.getCurrentPosition(function(r){
        if(this.getStatus() == BMAP_STATUS_SUCCESS){
            var mk = new BMap.Marker(r.point);
//                map.addOverlay(mk);
//                map.panTo(r.point);
//                aaa(r);
            showPosition(r,callback);
        }
        else {
//                    alert('failed'+this.getStatus());
        }
    },{enableHighAccuracy: true})
}
//百度地图WebAPI 坐标转地址
function showPosition(r,callback) {
    // ak = appkey 访问次数流量有限制
//            var urlAddr = 'http://api.map.baidu.com/geocoder/v2/?ak=NZyfpqnDBNM1IzC6j4ZhdyKbp7ac0hdc&callback=?&location=' + r.result[0].y + ',' + r.result[0].x + '&output=json&pois=1';
    var urlAddr = 'http://api.map.baidu.com/geocoder/v2/?ak=NZyfpqnDBNM1IzC6j4ZhdyKbp7ac0hdc&callback=?&location=' + r.latitude + ',' + r.longitude + '&output=json&pois=1';
    $.getJSON(urlAddr, function (res) {
        callback(res);
//                alert(res.result.addressComponent.city+"  " +res.result.business);
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


function GB2312UTF8(){
    this.Dig2Dec=function(s){
        var retV = 0;
        if(s.length == 4){
            for(var i = 0; i < 4; i ++){
                retV += eval(s.charAt(i)) * Math.pow(2, 3 - i);
            }
            return retV;
        }
        return -1;
    }
    this.Hex2Utf8=function(s){
        var retS = "";
        var tempS = "";
        var ss = "";
        if(s.length == 16){
            tempS = "1110" + s.substring(0, 4);
            tempS += "10" + s.substring(4, 10);
            tempS += "10" + s.substring(10,16);
            var sss = "0123456789ABCDEF";
            for(var i = 0; i < 3; i ++){
                retS += "%";
                ss = tempS.substring(i * 8, (eval(i)+1)*8);
                retS += sss.charAt(this.Dig2Dec(ss.substring(0,4)));
                retS += sss.charAt(this.Dig2Dec(ss.substring(4,8)));
            }
            return retS;
        }
        return "";
    }
    this.Dec2Dig=function(n1){
        var s = "";
        var n2 = 0;
        for(var i = 0; i < 4; i++){
            n2 = Math.pow(2,3 - i);
            if(n1 >= n2){
                s += '1';
                n1 = n1 - n2;
            }
            else
                s += '0';
        }
        return s;
    }

    this.Str2Hex=function(s){
        var c = "";
        var n;
        var ss = "0123456789ABCDEF";
        var digS = "";
        for(var i = 0; i < s.length; i ++){
            c = s.charAt(i);
            n = ss.indexOf(c);
            digS += this.Dec2Dig(eval(n));
        }
        return digS;
    }
    this.Gb2312ToUtf8=function(s1){
        var s = escape(s1);
        var sa = s.split("%");
        var retV ="";
        if(sa[0] != ""){
            retV = sa[0];
        }
        for(var i = 1; i < sa.length; i ++){
            if(sa[i].substring(0,1) == "u"){
                retV += this.Hex2Utf8(this.Str2Hex(sa[i].substring(1,5)));
                if(sa[i].length){
                    retV += sa[i].substring(5);
                }
            }
            else{
                retV += unescape("%" + sa[i]);
                if(sa[i].length){
                    retV += sa[i].substring(5);
                }
            }
        }
        return retV;
    }
    this.Utf8ToGb2312=function(str1){
        var substr = "";
        var a = "";
        var b = "";
        var c = "";
        var i = -1;
        i = str1.indexOf("%");
        if(i==-1){
            return str1;
        }
        while(i!= -1){
            if(i<3){
                substr = substr + str1.substr(0,i-1);
                str1 = str1.substr(i+1,str1.length-i);
                a = str1.substr(0,2);
                str1 = str1.substr(2,str1.length - 2);
                if(parseInt("0x" + a) & 0x80 == 0){
                    substr = substr + String.fromCharCode(parseInt("0x" + a));
                }
                else if(parseInt("0x" + a) & 0xE0 == 0xC0){ //two byte
                    b = str1.substr(1,2);
                    str1 = str1.substr(3,str1.length - 3);
                    var widechar = (parseInt("0x" + a) & 0x1F) << 6;
                    widechar = widechar | (parseInt("0x" + b) & 0x3F);
                    substr = substr + String.fromCharCode(widechar);
                }
                else{
                    b = str1.substr(1,2);
                    str1 = str1.substr(3,str1.length - 3);
                    c = str1.substr(1,2);
                    str1 = str1.substr(3,str1.length - 3);
                    var widechar = (parseInt("0x" + a) & 0x0F) << 12;
                    widechar = widechar | ((parseInt("0x" + b) & 0x3F) << 6);
                    widechar = widechar | (parseInt("0x" + c) & 0x3F);
                    substr = substr + String.fromCharCode(widechar);
                }
            }
            else {
                substr = substr + str1.substring(0,i);
                str1= str1.substring(i);
            }
            i = str1.indexOf("%");
        }

        return substr+str1;
    }
}