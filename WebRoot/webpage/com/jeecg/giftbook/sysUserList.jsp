<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="sysUserList" checkbox="true" fitColumns="false" title="用户" actionUrl="sysUserController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="自动编号"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="手机号码"  field="userphone"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="用户头像"  field="portrait"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="真实姓名"  field="username"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="登录账号"  field="loginname"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="登录密码"  field="loginpassword"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="电子邮箱"  field="useremail"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属省Id"  field="provinceid"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属省"  field="province"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属市Id"  field="cityid"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属市"  field="city"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属区/县Id"  field="districtid"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属区/县"  field="district"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="详细地址"  field="detailaddress"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="使用状态(1启用2停用）"  field="loginflag"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="qqopenid"  field="qqopenid"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="wxopenid"  field="wxopenid"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="sinaopenid"  field="sinaopenid"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建时间"  field="createDate" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人编号"  field="createBy"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人姓名"  field="createName"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新时间"  field="updateDate" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新人编号"  field="updateBy"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更信任姓名"  field="updateName"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="sysUserController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="sysUserController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="sysUserController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="sysUserController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="sysUserController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/giftbook/sysUserList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#sysUserListtb").find("input[name='createDate_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#sysUserListtb").find("input[name='createDate_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#sysUserListtb").find("input[name='updateDate_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#sysUserListtb").find("input[name='updateDate_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'sysUserController.do?upload', "sysUserList");
}

//导出
function ExportXls() {
	JeecgExcelExport("sysUserController.do?exportXls","sysUserList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("sysUserController.do?exportXlsByT","sysUserList");
}
 </script>