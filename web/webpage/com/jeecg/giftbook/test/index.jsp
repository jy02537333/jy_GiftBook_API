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

    <div class="container" >
        <div class="tab-content">
            <div role="tabpanel" class="tab-pane fade in active" id="demo" aria-labelledby="demo-tab">

                <div class="row" >
                    <input type="hidden" id="domain" value="libudata">
                    <input type="hidden" id="uptoken_url" value="/jeecg/apiQiNiuUptokenCtrl.do?uptoken">
                    <div class="col-md-12">
                        <div id="container">
                            <a class="btn btn-default btn-lg " id="pickfiles" href="#" >
                                <i class="glyphicon glyphicon-plus"></i>
                                <span>选择文件</span>
                            </a>
                            <img id="showImg" style="margin-left:30px;width:50px;height:50px;" src="data:image/jpeg;base64,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">
                        </div>
                    </div>
                    <div style="display:none" id="success" class="col-md-12">
                        <div class="alert-success">
                            队列全部文件处理完毕
                        </div>
                    </div>
                    <div class="col-md-12 ">
                        <table class="table table-striped table-hover text-left"   style="display:none">
                            <thead>
                              <tr>
                                <th class="col-md-4">上传文件名称</th>
                                <th class="col-md-2">上传文件大小</th>
                                <th class="col-md-6">返回地址</th>
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




<script type="text/javascript">

</script>

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
