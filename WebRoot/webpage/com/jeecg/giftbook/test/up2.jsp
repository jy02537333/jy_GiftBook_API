<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>七牛云存储 - JavaScript SDK</title>
    <link href="images/favicon.ico" rel="shortcut icon">
    <link rel="stylesheet" href="http://192.168.6.149:8080/jeecg/plug-in/ace/css/bootstrap.css">
    <link rel="stylesheet" href="plug-in/plupload/styles/main.css">
    <link rel="stylesheet" href="plug-in/plupload/styles/highlight.css">

    <!--[if lt IE 9]>
      <script src="bower_components/respond/dest/respond.min.js"></script>
    <![endif]-->
</head>
<body>
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" 
          data-toggle="collapse" data-target="#bs-example-navbar-collapse-6"
           aria-expanded="false">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-6">
          <ul class="nav navbar-nav">
          </ul>
        </div>
      </div>
    </nav>

    <div class="container" style="padding-top: 60px;">
        <div class="tab-content">
            <div role="tabpanel" class="tab-pane fade in active" id="demo" aria-labelledby="demo-tab">

                <div class="row" style="margin-top: 20px;">
                    <input type="hidden" id="domain" value="libudata">
                    <input type="hidden" id="uptoken_url" value="/jeecg/apiQiNiuUptokenCtrl.do?uptoken">
                    <div class="col-md-12">
                        <div id="container">
                            <a class="btn btn-default btn-lg " id="pickfiles" href="#" >
                                <i class="glyphicon glyphicon-plus"></i>
                                <span>选择文件</span>
                            </a>
                        </div>
                    </div>
                    <div style="display:none" id="success" class="col-md-12">
                        <div class="alert-success">
                            队列全部文件处理完毕
                        </div>
                    </div>
                    <div class="col-md-12 ">
                        <table class="table table-striped table-hover text-left"   style="margin-top:40px;display:none">
                            <thead>
                              <tr>
                                <th class="col-md-4">Filename</th>
                                <th class="col-md-2">Size</th>
                                <th class="col-md-6">Detail</th>
                              </tr>
                            </thead>
                            <tbody id="fsUploadProgress">
                            </tbody>
                        </table>
                    </div>
                </div>

            </div>
            <div role="tabpanel" class="tab-pane fade" id="code" aria-labelledby="code-tab">

                <div class="row" style="margin-top: 20px;">
                    <div class="col-md-12">
                        <pre><code>

                        </code></pre>
                    </div>
                </div>

            </div>
            <div role="tabpanel" class="tab-pane fade" id="log" aria-labelledby="log-tab">
                <pre id="qiniu-js-sdk-log"></pre>
            </div>
        </div>
    </div>






<script type="text/javascript" src="http://192.168.6.149:8080/jeecg/plug-in-ui/hplus/js/jquery.min.js?v=2.1.4"></script>
<script type="text/javascript" src="plug-in/plupload/scripts/bootstrap.min.js"></script>
<script type="text/javascript" src="plug-in/plupload/scripts/plupload/js/moxie.js"></script>
<script type="text/javascript" src="plug-in/plupload/scripts/plupload/js/plupload.dev.js"></script>
<!-- <script type="text/javascript" src="bower_components/plupload/js/plupload.full.min.js"></script> -->
<script type="text/javascript" src="plug-in/plupload/scripts/plupload/js/i18n/zh_CN.js"></script>
<script type="text/javascript" src="plug-in/plupload/scripts/ui.js"></script>
<script type="text/javascript" src="plug-in/plupload/scripts/qiniu.js"></script>
<script type="text/javascript" src="plug-in/plupload/scripts/highlight.js"></script>
<script type="text/javascript" src="plug-in/plupload/scripts/main.js"></script>
<!--<script type="text/javascript">hljs.initHighlightingOnLoad();</script>-->
</body>
</html>
