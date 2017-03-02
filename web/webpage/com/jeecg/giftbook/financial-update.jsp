<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>金融超市</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="financialController.do?doUpdate" tiptype="1" >
					<input id="id" name="id" type="hidden" value="${financialPage.id }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								第三方公司名称:
							</label>
						</td>
						<td class="value">
						     	 <input id="thirdpartyname" name="thirdpartyname" type="text" style="width: 150px" class="inputxt"  value='${financialPage.thirdpartyname}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">第三方公司名称</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								第三方公司关键字:
							</label>
						</td>
						<td class="value">
						     	 <input id="thirdpartycode" name="thirdpartycode" type="text" style="width: 150px" class="inputxt"  value='${financialPage.thirdpartycode}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">第三方公司关键字</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								第三方公司关键字2:
							</label>
						</td>
						<td class="value">
						     	 <input id="thirdpartycode2" name="thirdpartycode2" type="text" style="width: 150px" class="inputxt"  value='${financialPage.thirdpartycode2}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">第三方公司关键字2</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								第三方地址:
							</label>
						</td>
						<td class="value">
						     	 <input id="thirdpartyaddr" name="thirdpartyaddr" type="text" style="width: 150px" class="inputxt"  value='${financialPage.thirdpartyaddr}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">第三方地址</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								描述:
							</label>
						</td>
						<td class="value">
						     	 <input id="describe" name="describe" type="text" style="width: 150px" class="inputxt"  value='${financialPage.describe}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">描述</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								贷款额度:
							</label>
						</td>
						<td class="value">
						     	 <input id="moneylimit" name="moneylimit" type="text" style="width: 150px" class="inputxt"  value='${financialPage.moneylimit}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">贷款额度</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								贷款利息:
							</label>
						</td>
						<td class="value">
						     	 <input id="moneyinterest" name="moneyinterest" type="text" style="width: 150px" class="inputxt"  value='${financialPage.moneyinterest}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">贷款利息</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								创建时间:
							</label>
						</td>
						<td class="value">
									  <input id="createDate" name="createDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${financialPage.createDate}' type="date" pattern="yyyy-MM-dd"/>'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建时间</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								创建人编号:
							</label>
						</td>
						<td class="value">
						     	 <input id="createBy" name="createBy" type="text" style="width: 150px" class="inputxt"  value='${financialPage.createBy}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建人编号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								创建人姓名:
							</label>
						</td>
						<td class="value">
						     	 <input id="createName" name="createName" type="text" style="width: 150px" class="inputxt"  value='${financialPage.createName}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建人姓名</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								更新时间:
							</label>
						</td>
						<td class="value">
									  <input id="updateDate" name="updateDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${financialPage.updateDate}' type="date" pattern="yyyy-MM-dd"/>'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">更新时间</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								更新人编号:
							</label>
						</td>
						<td class="value">
						     	 <input id="updateBy" name="updateBy" type="text" style="width: 150px" class="inputxt"  value='${financialPage.updateBy}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">更新人编号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								更新人姓名:
							</label>
						</td>
						<td class="value">
						     	 <input id="updateName" name="updateName" type="text" style="width: 150px" class="inputxt"  value='${financialPage.updateName}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">更新人姓名</label>
						</td>
				<td align="right">
					<label class="Validform_label">
					</label>
				</td>
				<td class="value">
				</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/giftbook/financial.js"></script>		
