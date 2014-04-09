<LINK href="css/merckstyle.css" type=text/css rel=stylesheet>
<table width="96%" border="0" align="center" cellpadding="0"
	cellspacing="2">
	<tr>
		<td colspan="10" class="userMenuHeader">
		<div align="center">&nbsp;</div>
		<div align="right"></div>
		</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>
	<%String message = (String) request.getAttribute("message");
			Integer totalRecords = (Integer) request
					.getAttribute("totalRecords");
			String noOfRecords = null;

			if (totalRecords != null) {
				noOfRecords = totalRecords.toString() + " ";
			}

			if (null != message) {
				String nextPage = (String) request.getAttribute("nextPage");

				%>
	<tr>
		<td align="center">
		<div class="suc_ld">
		<div class="suc_rd">
		<div class="suc_lt">
		<div class="suc_rt">
		<div class="suc_tb">
		<div class="suc_lr">
		<div class="suc_con" id="SucContent"><strong><%if (noOfRecords != null) {

					%><%=noOfRecords%><%}%><%=message%></strong>
		<br>
		<br>
		<div><input type="button" value="OK" class="buttonPagin"
			onClick="window.location.href='<%=nextPage %>'"></div>
		</div>
		</div>
		</div>
		</div>
		</div>
		</div>
		</div>
		</td>


	</tr>
	<%}%>
</table>
