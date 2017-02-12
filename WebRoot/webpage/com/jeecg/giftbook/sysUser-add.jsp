<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>用户</title>
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="online/template/ledefault/css/vendor.css">
  <link rel="stylesheet" href="online/template/ledefault/css/bootstrap-theme.css">
  <link rel="stylesheet" href="online/template/ledefault/css/bootstrap.css">
  <link rel="stylesheet" href="online/template/ledefault/css/app.css">
  
  <link rel="stylesheet" href="plug-in/Validform/css/metrole/style.css" type="text/css"/>
  <link rel="stylesheet" href="plug-in/Validform/css/metrole/tablefrom.css" type="text/css"/>
  
  <script type="text/javascript" src="plug-in/jquery/jquery-1.8.3.js"></script>
  <script type="text/javascript" src="plug-in/tools/dataformat.js"></script>
  <script type="text/javascript" src="plug-in/easyui/jquery.easyui.min.1.3.2.js"></script>
  <script type="text/javascript" src="plug-in/easyui/locale/zh-cn.js"></script>
  <script type="text/javascript" src="plug-in/tools/syUtil.js"></script>
  <script type="text/javascript" src="plug-in/My97DatePicker/WdatePicker.js"></script>
  <script type="text/javascript" src="plug-in/lhgDialog/lhgdialog.min.js"></script>
  <script type="text/javascript" src="plug-in/tools/curdtools_zh-cn.js"></script>
  <script type="text/javascript" src="plug-in/tools/easyuiextend.js"></script>
  <script type="text/javascript" src="plug-in/Validform/js/Validform_v5.3.1_min_zh-cn.js"></script>
  <script type="text/javascript" src="plug-in/Validform/js/Validform_Datatype_zh-cn.js"></script>
  <script type="text/javascript" src="plug-in/Validform/js/datatype_zh-cn.js"></script>
  <script type="text/javascript" src="plug-in/Validform/plugin/passwordStrength/passwordStrength-min.js"></script>
  <link rel="stylesheet" href="plug-in/umeditor/themes/default/css/umeditor.css" type="text/css"></link>
  <script type="text/javascript" src="plug-in/umeditor/umeditor.config.js"></script>
  <script type="text/javascript" src="plug-in/umeditor/umeditor.min.js"></script>
  <script type="text/javascript" src="plug-in/umeditor/lang/zh-cn/zh-cn.js"></script>
  
   <script type="text/javascript">
  //编写自定义JS代码
  </script>
</head>

 <body>

	<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="sysUserController.do?doAdd" tiptype="1" >
			<input type="hidden" id="btn_sub" class="btn_sub"/>
			<input type="hidden" id="id" name="id"/>
			<div class="tab-wrapper">
			    <!-- tab -->
			    <ul class="nav nav-tabs">
			      <li role="presentation" class="active"><a href="javascript:void(0);">用户</a></li>
			    </ul>
			    <!-- tab内容 -->
			    <div class="con-wrapper" id="con-wrapper1" style="display: block;">
			      <div class="row form-wrapper">
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>手机号码：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="userphone" name="userphone" type="text" class="form-control"  >
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">手机号码</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>用户头像：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="portrait" name="portrait" type="text" class="form-control"  >
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">用户头像</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>真实姓名：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="username" name="username" type="text" class="form-control"  >
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">真实姓名</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>登录账号：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="loginname" name="loginname" type="text" class="form-control"  >
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">登录账号</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>登录密码：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="loginpassword" name="loginpassword" type="text" class="form-control"  >
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">登录密码</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>电子邮箱：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="useremail" name="useremail" type="text" class="form-control"  >
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">电子邮箱</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>所属省Id：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="provinceid" name="provinceid" type="text" class="form-control"  >
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">所属省Id</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>所属省：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="province" name="province" type="text" class="form-control"  >
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">所属省</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>所属市Id：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="cityid" name="cityid" type="text" class="form-control"  >
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">所属市Id</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>所属市：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="city" name="city" type="text" class="form-control"  >
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">所属市</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>所属区/县Id：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="districtid" name="districtid" type="text" class="form-control"  >
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">所属区/县Id</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>所属区/县：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="district" name="district" type="text" class="form-control"  >
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">所属区/县</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>详细地址：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="detailaddress" name="detailaddress" type="text" class="form-control"  >
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">详细地址</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>使用状态(1启用2停用）：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="loginflag" name="loginflag" type="text" class="form-control"  >
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">使用状态(1启用2停用）</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>qqopenid：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="qqopenid" name="qqopenid" type="text" class="form-control"  >
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">qqopenid</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>wxopenid：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="wxopenid" name="wxopenid" type="text" class="form-control"  >
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">wxopenid</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>sinaopenid：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="sinaopenid" name="sinaopenid" type="text" class="form-control"  >
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">sinaopenid</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>创建时间：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="createDate" name="createDate" type="text" style="width: 150px"  class="form-control" onClick="WdatePicker()"  type="date" pattern="yyyy-MM-dd"/>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">创建时间</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>创建人编号：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="createBy" name="createBy" type="text" class="form-control"  >
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">创建人编号</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>创建人姓名：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="createName" name="createName" type="text" class="form-control"  >
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">创建人姓名</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>更新时间：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="updateDate" name="updateDate" type="text" style="width: 150px"  class="form-control" onClick="WdatePicker()"  type="date" pattern="yyyy-MM-dd"/>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">更新时间</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>更新人编号：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="updateBy" name="updateBy" type="text" class="form-control"  >
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">更新人编号</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>更信任姓名：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="updateName" name="updateName" type="text" class="form-control"  >
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">更信任姓名</label>
			          </div>
							<div class="col-xs-2 text-center"><b></b></div>
			         		<div class="col-xs-4"></div>
							</div>
			          
			        

			       
			          <div class="row" id = "sub_tr" style="display: none;">
				        <div class="col-xs-12 layout-header">
				          <div class="col-xs-6"></div>
				          <div class="col-xs-6"><button type="button" onclick="neibuClick();" class="btn btn-default">提交</button></div>
				        </div>
				      </div>
			     </div>
			   </div>
			   
			   <div class="con-wrapper" id="con-wrapper2" style="display: block;"></div>
			 </div>
  </t:formvalid>

<script type="text/javascript">
   $(function(){
    //查看模式情况下,删除和上传附件功能禁止使用
	if(location.href.indexOf("load=detail")!=-1){
		$(".jeecgDetail").hide();
	}
	
	if(location.href.indexOf("mode=read")!=-1){
		//查看模式控件禁用
		$("#formobj").find(":input").attr("disabled","disabled");
	}
	if(location.href.indexOf("mode=onbutton")!=-1){
		//其他模式显示提交按钮
		$("#sub_tr").show();
	}
   });

  var neibuClickFlag = false;
  function neibuClick() {
	  neibuClickFlag = true; 
	  $('#btn_sub').trigger('click');
  }

</script>
 </body>
<script src = "webpage/com/jeecg/giftbook/sysUser.js"></script>		
</html>