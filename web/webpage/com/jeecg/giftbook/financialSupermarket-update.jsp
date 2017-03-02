<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>financial_supermarket</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
    <link rel="stylesheet" href="plug-in/ace/css/bootstrap.css">
    <link rel="stylesheet" href="plug-in/plupload/styles/main.css">
    <link rel="stylesheet" href="plug-in/plupload/styles/highlight.css">
    <style>
  .hide_create_date{display: none}
  </style>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="financialSupermarketController.do?doUpdate" tiptype="1" >
				<input id="id" name="id" type="hidden" value="${financialSupermarketPage.id }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">第三方公司名称:</label>
		     	 <input id="thirdpartyname" name="thirdpartyname" type="text" style="width: 150px" class="inputxt"  value='${financialSupermarketPage.thirdpartyname}'>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">第三方公司关键字:</label>
		     	 <input id="thirdpartycode" name="thirdpartycode" type="text" style="width: 150px" class="inputxt"  value='${financialSupermarketPage.thirdpartycode}'>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">第三方公司关键字2:</label>
		     	 <input id="thirdpartycode2" name="thirdpartycode2" type="text" style="width: 150px" class="inputxt"  value='${financialSupermarketPage.thirdpartycode2}'>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">第三方地址:</label>
		     	 <input id="thirdpartyaddr" name="thirdpartyaddr" type="text" style="width: 150px" class="inputxt"  value='${financialSupermarketPage.thirdpartyaddr}'>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">描述:</label>
		     	 <input id="description" name="description" type="text" style="width: 150px" class="inputxt"  value='${financialSupermarketPage.description}'>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">贷款额度:</label>
		     	 <input id="moneylimit" name="moneylimit" type="text" style="width: 150px" class="inputxt"  value='${financialSupermarketPage.moneylimit}'>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">logo图片:</label>
		     		 <div class="container" >
        <div class="tab-content">
            <div role="tabpanel" class="tab-pane fade in active" id="demo" aria-labelledby="demo-tab">

                <div class="row" >
                	<input type="hidden" id="logourl"  name="logourl" value="">
                    <input type="hidden" id="domain" value="libudata">
                    <input type="hidden" id="uptoken_url" value="/apiQiNiuUptokenCtrl.do?uptoken">
                    <div class="col-md-12">
                        <div id="container">
                            <a class="btn btn-default btn-lg " id="pickfiles" href="#" >
                                <i class="glyphicon glyphicon-plus"></i>
                                <span>选择文件</span>
                            </a>
                            <img id="showImg" style="margin-left:30px;width:50px;height:50px;" src="${financialSupermarketPage.logourl}">
                        </div>
                    </div>
                    <div style="display:none" id="success" class="col-md-12">
                        <div class="alert-success">
                           		 图片上传完毕
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
		    </div>
			<div class="form">
		      <label class="Validform_label">贷款利息:</label>
		     	 <input id="moneyinterest" name="moneyinterest" type="text" style="width: 150px" class="inputxt"  value='${financialSupermarketPage.moneyinterest}'>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form hide_create_date" >
		      <label class="Validform_label">创建时间:</label>
					  <input id="createDate" name="createDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"
		      						 value='<fmt:formatDate value='${financialSupermarketPage.createDate}' type="date" pattern="yyyy-MM-dd"/>'>    
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form hide_create_date">
		      <label class="Validform_label">创建人编号:</label>
		     	 <input id="createBy" name="createBy" type="text" style="width: 150px" class="inputxt"  value='${financialSupermarketPage.createBy}'>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form hide_create_date">
		      <label class="Validform_label">创建人姓名:</label>
		     	 <input id="createName" name="createName" type="text" style="width: 150px" class="inputxt"  value='${financialSupermarketPage.createName}'>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form hide_create_date">
		      <label class="Validform_label">更新时间:</label>
					  <input id="updateDate" name="updateDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"
		      						 value='<fmt:formatDate value='${financialSupermarketPage.updateDate}' type="date" pattern="yyyy-MM-dd"/>'>    
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form hide_create_date">
		      <label class="Validform_label">更新人编号:</label>
		     	 <input id="updateBy" name="updateBy" type="text" style="width: 150px" class="inputxt"  value='${financialSupermarketPage.updateBy}'>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form hide_create_date">
		      <label class="Validform_label">更新人姓名:</label>
		     	 <input id="updateName" name="updateName" type="text" style="width: 150px" class="inputxt"  value='${financialSupermarketPage.updateName}'>
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
  <script type="text/javascript" src="plug-in/plupload/scripts/plupload/js/moxie.js"></script>
<script type="text/javascript" src="plug-in/plupload/scripts/plupload/js/plupload.dev.js"></script>
<script type="text/javascript" src="plug-in/plupload/scripts/plupload/js/i18n/zh_CN.js"></script>
<script type="text/javascript" src="plug-in/plupload/scripts/ui.js"></script>
<script type="text/javascript" src="plug-in/plupload/scripts/qiniu.js"></script>
<script type="text/javascript" src="plug-in/plupload/scripts/highlight.js"></script>
<script type="text/javascript" src="plug-in/plupload/scripts/main.js"></script>
 </body>
  <script src = "webpage/com/jeecg/giftbook/financialSupermarket.js"></script>		
