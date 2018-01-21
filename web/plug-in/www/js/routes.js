angular.module('wechat.routes', [])

.config(function($stateProvider, $urlRouterProvider) {

    $stateProvider
        .state("tab", {
            url: "/tab",
            abstract: true,
            templateUrl: "plug-in/www/templates/tabs.html",
        })
        .state('tab.message', {
            url: '/message',
            views: {
                'tab-message': {
                    templateUrl: 'plug-in/www/templates/tab-message.html',
                    controller: "messageCtrl"
                }
            }
        })
        .state('messageDetail', {
            url: '/messageDetail/:messageId',
            templateUrl: "plug-in/www/templates/message-detail.html",
            controller: "messageDetailCtrl"
        })
        .state('tab.friends', {
            url: '/friends',
            views: {
                'tab-friends': {
                    templateUrl: 'plug-in/www/templates/tab-friends.html',
                    controller: "friendsCtrl"
                }
            }
        })
        .state('tab.find', {
            url: '/find',
            views: {
                'tab-find': {
                    templateUrl: 'plug-in/www/templates/tab-find.html',
                    controller: "findCtrl"
                }
            },
        })
        .state('tab.findtruck', {
            url: '/findtruck',
            views: {
                'tab-findtruck': {
                    templateUrl: 'plug-in/www/templates/tab-find-truck.html',
                    controller: "truckCtrl"
                }
            },
        })
        .state('tab.findtruck2', {
            url: '/findtruck2',
            views: {
                'tab-findtruck2': {
                    templateUrl: 'plug-in/www/templates/tab-find-truck-2.html',
                    controller: "truck2Ctrl"
                }
            },
        })
        .state('tab.transporter', {
            url: '/transporter',
            views: {
                'tab-transporter': {
                    templateUrl: 'plug-in/www/templates/tab-find-transporter.html',
                    controller: "transporterCtrl"
                }
            },
        })
        .state('tab.transporter2', {
            url: '/transporter2',
            views: {
                'tab-transporter2': {
                    templateUrl: 'plug-in/www/templates/tab-find-transporter2.html',
                    controller: "transporter2Ctrl"
                }
            },
        })
        .state('tab.findtruck.truckAdd', {
            url: '/findtruck/truckAdd',
            views: {
                'tab-findtruck-truckAdd': {
                    templateUrl: 'plug-in/www/templates/truck-add.html',
                    controller: "truckCtrl"
                }
            },
        })
        .state('truckAdd', {
            url: '/truckAdd/:typeId',
            templateUrl: "plug-in/www/templates/truck-add.html",
            controller: "truckAddCtrl"
        })
        .state('transporterAdd', {
            url: '/transporterAdd/:typeId',
            templateUrl: "plug-in/www/templates/transporter-add.html",
            controller: "transporterAddCtrl"
        })
        .state('transporterAdd2', {
            url: '/transporterAdd2/:typeId',
            templateUrl: "plug-in/www/templates/transporter-add2.html",
            controller: "transporterAddCtrl"
        })
        .state('tab.setting', {
            url: '/setting',
            views: {
                'tab-setting': {
                    templateUrl: 'plug-in/www/templates/tab-setting.html',
                    controller: "settingCtrl"
                }
            }
        });

    $urlRouterProvider.otherwise("/tab/transporter");
});