<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="sidekickergroupList" checkbox="true" fitColumns="false" title="亲友团" actionUrl="sidekickergroupController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="Id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="用户id"  field="userid"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="人员数量"  field="groupmembersnum"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="组名称"  field="groupname"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="状态(0=删除，1正常)"  field="state"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建时间"  field="createDate" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人编号"  field="createBy"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人姓名"  field="createName"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新时间"  field="updateDate" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新人编号"  field="updateBy"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更信任姓名"  field="updateName"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="sidekickergroupController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="sidekickergroupController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="sidekickergroupController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="sidekickergroupController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="sidekickergroupController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/giftbook/sidekickergroupList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#sidekickergroupListtb").find("input[name='createDate_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#sidekickergroupListtb").find("input[name='createDate_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#sidekickergroupListtb").find("input[name='updateDate_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#sidekickergroupListtb").find("input[name='updateDate_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'sidekickergroupController.do?upload', "sidekickergroupList");
}

//导出
function ExportXls() {
	JeecgExcelExport("sidekickergroupController.do?exportXls","sidekickergroupList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("sidekickergroupController.do?exportXlsByT","sidekickergroupList");
}
 </script>