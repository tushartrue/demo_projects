<LINK href="css/merckstyle.css" type=text/css rel=stylesheet>

<%@ page import="java.util.*, javax.servlet.*"  %>

<script language="javascript">
//window.history.forward();
</script>


<%
	try 
	{
			session.invalidate();
			session = null;
	}
	catch (Exception exc) 
	{
	}
%>

<table width="80%" border="0" align="center" cellpadding="0"
	cellspacing="2" class="gradiant">
	<tr>
		<td colspan="8" class="userMenuHeader">
		<div align="center"</div>
		</td>
	</tr>
	

	<tr>
		<td  width="15%"><IMG SRC="selfImage/logout.jpg" WIDTH="75" HEIGHT="75" BORDER="0" ALT="&nbsp;"></td>
		<td width="5%">&nbsp;</td>
		<td width="65%" class="Bucket"><B>You are successfully log-out.click <a href="borkutLogin.jsp">here</a> for login page</B></td>
		
		<td width="15%">&nbsp;</td>
		
		
		
		
	</tr>
	
	
	
	<tr>
		<td colspan="8">&nbsp;</td>
	</tr>
</table>

</HTML>