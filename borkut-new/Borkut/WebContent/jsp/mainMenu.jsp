<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<%@ page language="java"%>
<%@ page session="true"%>




<title>Welcome to Borkut</title>
<meta name="Language" content="English language" />		
<meta name="Sensitivity_class" content="Business confidential" />
<LINK href="css/merckstyle.css" type=text/css rel=stylesheet>
<script language="JavaScript" src="js/common.js"
	type="text/javascript"></script>
<script language="JavaScript" src="js/popcalendar.js"
	type="text/javascript"></script>
<script language="JavaScript" src="portal/wrapperadd.js"
	type="text/javascript"></script>
<script language="JavaScript" src="portal/portaldefaults.js"
	type="text/javascript"></script>
	
	<script language="javascript">
window.history.forward();
</script>
</head>
<body>
<%@ page import="com.cts.domain.Users"%>

<%
String detailPage1 = (String) request.getAttribute("detailPage");
Users user=(Users)session.getValue("myUser") ;



%>
<table width="100%" height="100%" border="0"  bgcolor="#CCFFFF" cellpadding="2"
	cellspacing="2">
	<% 
	if("../jsp/accountCreatedMessage.jsp".equalsIgnoreCase(detailPage1))
{
	%>
	
	<tr><td colspan="5" valign="top"><!-- body Table --> 
		<jsp:include page="<%=detailPage1%>" /> <!--End of body Table --></td></tr>
			<tr><td height="1000" colspan="9"></td></tr>
			
	
	<% 
}else if("../jsp/invalidPasswordMessage.jsp".equalsIgnoreCase(detailPage1))
{
	%>
	
	<tr><td colspan="5" valign="top"><!-- body Table --> 
		<jsp:include page="<%=detailPage1%>" /> <!--End of body Table --></td></tr>
			<tr><td height="1000" colspan="9"></td></tr>
			

<% 
}else if("../jsp/accountNotExists.jsp".equalsIgnoreCase(detailPage1))
{
	%>
	
	<tr><td colspan="5" valign="top"><!-- body Table --> 
		<jsp:include page="<%=detailPage1%>" /> <!--End of body Table --></td></tr>
			<tr><td height="1000" colspan="9"></td></tr>
			
			
<% 
}else if("../jsp/databaseException.jsp".equalsIgnoreCase(detailPage1))
{
	%>
	
	<tr><td colspan="5" valign="top"><!-- body Table --> 
		<jsp:include page="<%=detailPage1%>" /> <!--End of body Table --></td></tr>
			<tr><td height="1000" colspan="9"></td></tr>
	
	
	
	<% 
}else if("../jsp/usernameExists.jsp".equalsIgnoreCase(detailPage1))
{
	%>
	
	<tr><td colspan="5" valign="top"><!-- body Table --> 
		<jsp:include page="<%=detailPage1%>" /> <!--End of body Table --></td></tr>
			<tr><td height="1000" colspan="9"></td></tr>
	
	
		
	<% 
}else{
	%>

	<tr>
		<td width="15%" >&nbsp;</td>

		<td width="9%" class="borkutHeader" align="center" ><MARQUEE DIRECTION="LEFT" BGCOLOR="#FF9999" INFINITE WIDTH="100">Borkut</MARQUEE></td>
		<td width="7%" class="userMenuHeader" align="center"><a href="login.do" class="MRLMenu" >Home</a></td>
		<td width="7%" class="userMenuHeader" align="center" ><a href="readOnlyProfile.do?usernum=<%=user.getUsernum()%>" class="MRLMenu">Profile</a></td>
		<td width="10%" class="userMenuHeader" align="center" ><a href="viewScrapbook.do?usernum=<%=user.getUsernum()%>" class="MRLMenu">Scrapbook</a></td>
		<td width="12%" class="userMenuHeader" align="center"  ><a href="searchUser.do" class="MRLMenu">Search Users</td>
		<td width="20%" class="userMenuHeader" align="center"><%=user.getFirstname() %>&nbsp;&nbsp;<%=user.getLastname() %></td>
		<td width="10%" class="userMenuHeader" align="center"><a href="logout.jsp" class="MRLMenu">Logout</a></td>
		<td width="10%" >&nbsp;</td>
	</tr>
	

<tr>
		<td>&nbsp;</td>

		
		<td colspan="3" valign="top"><!-- menu table--> <%String leftPage = (String) request.getAttribute("leftPage");%>
		<jsp:include page="<%= leftPage%>" /> <!-- End of Menu Table--></td>
		
		<td colspan="6" align="left" valign="top"><!-- body Table --> <%String rightPage = (String) request.getAttribute("rightPage");%>
		<jsp:include page="<%=rightPage%>" /> <!--End of body Table --></td>
		
		<td >&nbsp;</td>
		
	</tr>
	<tr><td height="1000" colspan="9"></td></tr>

	<%} %>
	

	

	
	
</table>

</body>
</html>

