<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="utf-8" />
    <title>意见反馈</title>
    <!--<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">-->
    <!--<link href="css/froala_editor.min.css" rel="stylesheet" type="text/css">-->
    <style type="text/css">
        #preview {
            margin-left: 40px;
            width: 200px;
            height: 200px;
            border: 1px solid #E1E1E1;
        }

        #imghead {
            filter: progid: DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=image);
        }

        header {
            width: 100%;
            border: 1px solid #e1e1e1;
            margin: 0 auto;
            background: #fff;
        }


        h2 {
            margin: 20px 60px;
            color: #7c7c7c;
        }

        .left {
            float: left;
            width: 100%;
            border-right: 1px dashed #ccc;
        }

        .right {
            float: right;
            width: 30%;
            text-align: center;
            border-radius: 14px;
        }

        .right a {
            margin-top: 20px;
            margin-right: 90px;
            float: right;
            width: 70%;
            font-size: 18px;
            letter-spacing: 3px;
            padding: 2px;
        }

        #but {
            float: right;
            margin-top: 10px;
            margin-right: 25%;
            background: #7C7C7C;
            color: #fff;
            width: 250px;
            height: 50px;
            line-height: 50px;
            text-align: center;
            border-radius: 14px;
        }

        p {
            height: 340px;
            width: 500px;
            color: #7C7C7C;
        }

        .hover {
            background: #134364;
            color: #fff;
        }

        .hover:hover {
            background: #000;
        }
        .left_title_margin{margin-left: 40px;}
        .left_margin{margin-left: 40px;}
    </style>
</head>

<body>
<header>
        <div class="left">
            <h2>反馈内容:</h2>
            <!--<section id="editor" style="width: 90%;margin: auto;text-align: left;">-->
            <!--<div id='edit' style="margin-top: 30px;">-->
            <!--</div>-->
            <!--</section>-->
            <div><textarea id="feedback_txt" class="left_margin"  style="width:80%;height: 80px;"  >gaegaewg</textarea></div>
            <h2>图片提交:</h2>
            <div id="preview"  class="left_margin" >
                <img id="feedback_imghead" />
            </div>
            <div  class="left_margin"   style="margin-top: 20px;">
                <section style="margin-right: 30%;">
                    <input type="file" onchange="previewImage(this)" style="width: 200px;height: 70px;opacity: 0;-moz-opacity: 0; -webkit-opacity: 0;" />
                    <section style="width: 200px;height: 60px;margin-top: -70px;background: #134364;color: #fff;border-radius: 14px;text-align: center;line-height: 60px;">
                        <a>上传图片</a>
                    </section>

                </section>
                <section style="margin-right: 20%;">
                    <a style="color: #f48b0e;">1、图片尺寸不小于400*400，大小不超过500K</a><br />
                    <a style="color: #f48b0e;">2、图片尽量清晰</a>
                </section>
            </div>
            <h2>联系方式:</h2>

            <input name="searchkey" type="text" id="feedback_name" value="  用户名"  class="left_margin"  onFocus="this.value=''" style="width: 50%;height: 40px;color: #7c7c7c;" onblur="if(this.value.replace(/^ +| +$/g,'')=='')alert('用户名不能为空!')" /><br />
            <input name="searchkey" type="text" id="feedback_qq" value="  优先使用QQ，方便在线沟通"  class="left_margin"  onFocus="this.value=''" style="width: 80%;height: 40px;margin-top:10px;color: #7c7c7c;" onblur="if(this.value.replace(/^ +| +$/g,'')=='')alert('不能为空!')" />
            <br />
            <input type="submit" class="hover left_margin" value="提交" onclick="sub()"  style="border-radius: 14px;margin-top: 20px;width: 150px;height: 50px;" />
            <div style="margin-bottom: 50px;height:50px;"></div>
        </div>
        <!--<div class="right">-->
        <!--<input type="button" id="but" value="帮助中心" />-->
        <!--<a style="color: #7C7C7C;">如果您在使用的过程中遇到疑问，或者有任何的意见或者建议，欢迎随时向我们反馈，我们会尽快回复您的问题，并依据您的反馈，不断完善。</a>-->
        <!--</div>-->
</header>

</body>
<!--<script src="js/libs/jquery-1.11.1.min.js"></script>-->
<!--<script src="js/froala_editor.min.js"></script>-->
<!--<script src="js/plugins/tables.min.js"></script>-->
<!--<script src="js/plugins/lists.min.js"></script>-->
<!--<script src="js/plugins/colors.min.js"></script>-->
<!--<script src="js/plugins/media_manager.min.js"></script>-->
<!--<script src="js/plugins/font_family.min.js"></script>-->
<!--<script src="js/plugins/font_size.min.js"></script>-->
<!--<script src="js/plugins/block_styles.min.js"></script>-->
<!--<script src="js/plugins/video.min.js"></script>-->
<script type="text/javascript">
    function sub()
    {
        document.getElementById("feedback_txt").innerHTML="";
        document.getElementById("feedback_name").value="";
        document.getElementById("feedback_qq").value="";
        document.getElementById("feedback_imghead").src="";
        alert("您的反馈我们已经收到，感谢您宝贵的意见！");
    }
    function previewImage(file) {
        var MAXWIDTH = 200;
        var MAXHEIGHT = 200;
        var div = document.getElementById('preview');
        if (file.files && file.files[0]) {
            div.innerHTML = '<img id=imghead>';
            var img = document.getElementById('imghead');
            img.onload = function() {
                var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
                img.width = rect.width;
                img.height = rect.height;
                //                 img.style.marginLeft = rect.left+'px';
                img.style.marginTop = rect.top + 'px';
            }
            var reader = new FileReader();
            reader.onload = function(evt) {
                img.src = evt.target.result;
            }
            reader.readAsDataURL(file.files[0]);
        } else //兼容IE
        {
            var sFilter = 'filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="';
            file.select();
            var src = document.selection.createRange().text;
            div.innerHTML = '<img id=imghead>';
            var img = document.getElementById('imghead');
            img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src;
            var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
            status = ('rect:' + rect.top + ',' + rect.left + ',' + rect.width + ',' + rect.height);
            div.innerHTML = "<div id=divhead style='width:" + rect.width + "px;height:" + rect.height + "px;margin-top:" + rect.top + "px;" + sFilter + src + "\"'></div>";
        }
    }

    function clacImgZoomParam(maxWidth, maxHeight, width, height) {
        var param = {
            top: 0,
            left: 0,
            width: width,
            height: height
        };
        if (width > maxWidth || height > maxHeight) {
            rateWidth = width / maxWidth;
            rateHeight = height / maxHeight;
            if (rateWidth > rateHeight) {
                param.width = maxWidth;
                param.height = Math.round(height / rateWidth);
            } else {
                param.width = Math.round(width / rateHeight);
                param.height = maxHeight;
            }
        }
        param.left = Math.round((maxWidth - param.width) / 2);
        param.top = Math.round((maxHeight - param.height) / 2);
        return param;
    }
    $(function() {
        $('#edit').editable({
            inlineMode: false,
            alwaysBlank: true
        })
    });
</script>

</html>