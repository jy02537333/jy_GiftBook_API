<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>测试表1</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="testinfoController.do?doAdd" tiptype="1" >
				<input id="id" name="id" type="hidden" value="${testinfoPage.id }">
				<input id="createName" name="createName" type="hidden" value="${testinfoPage.createName }">
				<input id="createBy" name="createBy" type="hidden" value="${testinfoPage.createBy }">
				<input id="createDate" name="createDate" type="hidden" value="${testinfoPage.createDate }">
				<input id="updateName" name="updateName" type="hidden" value="${testinfoPage.updateName }">
				<input id="updateBy" name="updateBy" type="hidden" value="${testinfoPage.updateBy }">
				<input id="updateDate" name="updateDate" type="hidden" value="${testinfoPage.updateDate }">
				<input id="bpmStatus" name="bpmStatus" type="hidden" value="${testinfoPage.bpmStatus }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">标题:</label>
		     	 <input id="title" name="title" type="text" style="width: 150px" class="inputxt" >
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">内容:</label>
		     	 <input id="content" name="content" type="text" style="width: 150px" class="inputxt" >
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">备注:</label>
		     	 <input id="remark" name="remark" type="text" style="width: 150px" class="inputxt" >
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>
  <script src = "webpage/com/hxyc/test3/testinfo.js"></script>	
	