<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>app_config</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="appConfigController.do?doAdd" tiptype="1" >
				<input id="id" name="id" type="hidden" value="${appConfigPage.id }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">createName:</label>
		     	 <input id="createName" name="createName" type="text" style="width: 150px" class="inputxt" datatype="*">
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">createBy:</label>
		     	 <input id="createBy" name="createBy" type="text" style="width: 150px" class="inputxt" >
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">createDate:</label>
					  <input id="createDate" name="createDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()">
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">updateBy:</label>
		     	 <input id="updateBy" name="updateBy" type="text" style="width: 150px" class="inputxt" >
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">updateDate:</label>
					  <input id="updateDate" name="updateDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()">
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">updateName:</label>
		     	 <input id="updateName" name="updateName" type="text" style="width: 150px" class="inputxt" >
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">是否显示app中间金融中心:</label>
		     	 <input id="isShowCenter" name="isShowCenter" type="text" style="width: 150px" class="inputxt" >
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/giftbook/appConfig.js"></script>	
	