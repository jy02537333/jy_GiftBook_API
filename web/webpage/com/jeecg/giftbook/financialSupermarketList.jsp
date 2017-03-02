<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="financialSupermarketList" checkbox="true" fitColumns="false" title="金融超市" actionUrl="financialSupermarketController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="Id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="第三方公司名称"  field="thirdpartyname"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="第三方公司关键字"  field="thirdpartycode"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="第三方公司关键字2"  field="thirdpartycode2"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="第三方地址"  field="thirdpartyaddr"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="描述"  field="description"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="贷款额度"  field="moneylimit"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="logo"  field="logourl"    queryMode="group"  width="120"
    image="true" imageSize="100,100"   ></t:dgCol>
  
   <t:dgCol title="贷款利息"  field="moneyinterest"    queryMode="group"  width="120"
          ></t:dgCol>
   <t:dgCol title="创建时间"  field="createDate" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人编号"  field="createBy"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人姓名"  field="createName"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新时间"  field="updateDate" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新人编号"  field="updateBy"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新人姓名"  field="updateName"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="financialSupermarketController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="financialSupermarketController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="financialSupermarketController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="financialSupermarketController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="financialSupermarketController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/giftbook/financialSupermarketList.js"></script>		
 <script type="text/javascript">
 function filters(e)
 {
 alert(e.value);
 }
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#financialSupermarketListtb").find("input[name='createDate_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#financialSupermarketListtb").find("input[name='createDate_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#financialSupermarketListtb").find("input[name='updateDate_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#financialSupermarketListtb").find("input[name='updateDate_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'financialSupermarketController.do?upload', "financialSupermarketList");
}

//导出
function ExportXls() {
	JeecgExcelExport("financialSupermarketController.do?exportXls","financialSupermarketList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("financialSupermarketController.do?exportXlsByT","financialSupermarketList");
}
function convertVal()
{
var tds=$("td[field$='logourl']") ;
tds.each(function(i,obj){
 var imgObj=   $(obj).find("img");
 if(imgObj.length==0)
   return;
 var srcStr=imgObj.attr("src");
 if(srcStr.indexOf("http://")==-1&&srcStr.indexOf("https://")==-1)
 {
    if(srcStr.indexOf("www.libugj.cn")==-1){
        srcStr="www.libugj.cn"+srcStr;
    }
    srcStr="http://"+srcStr;
 }
  imgObj.attr("src",srcStr);
});
}
 </script>