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
	<%String errorMessage = (String) request.getAttribute("errorMessage");
			if (null != errorMessage) {
				String nextPage = (String) request.getAttribute("nextPage");

				%>
	<tr>
		<td align="center">
		<div class="fail_ld">
		<div class="fail_rd">
		<div class="fail_lt">
		<div class="fail_rt">
		<div class="fail_tb">
		<div class="fail_lr">
		<div class="fail_con" id="failContent"><%=errorMessage%></div>
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
		</td>


	</tr>
	<%}%>
</table>
