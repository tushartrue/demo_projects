<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- DW6 -->
<head>
<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->
<title>Discussion Forum - Home Page</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />


<link rel="stylesheet" href="images/mm_lodging1.css" type="text/css" />

<script language="JavaScript" src="js/popcalendar.js"
	type="text/javascript"></script>
	
	<script language="javascript">
	window.history.forward();
	</script>
	
	
	
	<script language=JavaScript>
<!--
 
//Disable right mouse click Script
//By Maximus (maximus@nsimail.com) w/ mods by DynamicDrive
//For full source code, visit http://www.dynamicdrive.com
 
var message="Right click allowed nahi re Mamu!!";
 
///////////////////////////////////
function clickIE4(){
if (event.button==2){
alert(message);
return false;
}
}
 
function clickNS4(e){
if (document.layers||document.getElementById&&!document.all){
if (e.which==2||e.which==3){
alert(message);
return false;
}
}
}
 
if (document.layers){
document.captureEvents(Event.MOUSEDOWN);
document.onmousedown=clickNS4;
}
else if (document.all&&!document.getElementById){
document.onmousedown=clickIE4;
}
 
document.oncontextmenu=new Function("alert(message);return false")
 
// --> 
</script>
	
	
</head>
<body bgcolor="#999966">


<%@ page import="cts.domain.Users"%>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
	<td width="15" nowrap="nowrap"><img src="images/mm_spacer.gif" alt="" width="15" height="1" border="0" /></td>
	<td height="60" colspan="3" class="logo" nowrap="nowrap"><br />
	  <br />
Welcome to Discussion Forum </td>
	<td width="40">&nbsp;</td>
	<td width="100%">&nbsp;<img src="images/logo-Cognizant[1].jpg" width="76" height="54" /></td>
	</tr>

	<tr bgcolor="#ffffff">
	<td colspan="6"><img src="images/mm_spacer.gif" alt="" width="1" height="1" border="0" /></td>
	</tr>

	<tr bgcolor="#a4c2c2">
	<td width="15" nowrap="nowrap">&nbsp;</td>
	<td height="36" colspan="3" id="navigation" class="navText"><a href="authenticate.do" title="Homepage">Home</a><a href="javascript:;"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="all_categories.do?category_id=0" >ALL Categories</a><a href="javascript:;"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="housing.do?category_id=1" title="Housing">Housing</a><a href="home2.html" title="Housing page"></a><a href="javascript:;"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="byeSell.do?category_id=2" title="Bye/Sell page">Bye/Sell</a>&nbsp;&nbsp;
      &nbsp;&nbsp;&nbsp;<a href="technicalIssue.do?category_id=3" title="Technical issue page">Technical Issue</a><a href="javascript:;"> </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="contactMe.do" title="Contact Me page">Contact Us </a><a href="javascript:;"></a></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="logout.jsp" title="userMenuHeader">LOG-OUT</a></td>
	<td width="40">&nbsp;</td>
	<td width="100%">&nbsp;</td>
	</tr>

	<tr bgcolor="#ffffff">
	<td colspan="6"><img src="mm_spacer.gif" alt="" width="1" height="1" border="0" /></td>
	</tr>

	<tr bgcolor="#ffffff">
	
	<%String sourceImage = (String) request.getAttribute("sourceImage");%>
	<td width="230" colspan="2" valign="top" bgcolor="#a4c2c2"><img src="<%=sourceImage %>" alt="Home Page Image" width="230" height="240" border="0" />
	<table border="0" cellspacing="0" cellpadding="0" width="230">
		<tr>
		<td width="15">&nbsp;</td>
		<td width="200" class="sidebarText" id="padding"><p>We are always with you.</p>
		  <p>Solution to your problem is just click away from you. <br />
  &nbsp;<br />		
	      </p></td>
		<td width="15">&nbsp;</td>
		</tr>
	</table>	</td>
	
	<td width="50" valign="top"><img src="images/mm_spacer.gif"  width="50" height="1" border="0" /></td>
	<td width="440" valign="top"><br />
	<br />
	<table border="0" cellspacing="0" cellpadding="0" width="440">
		<tr>
		<%Users users=(Users)session.getAttribute("user"); %>
		<td class="pageName"><p><marquee WIDTH=62% BEHAVIOR=ALTERNATE    >Welcome <%=users.getFirstname() %>&nbsp; <%=users.getLastname() %>! </marquee></p></td>
		</tr>

		<tr>
		<td class="bodyText">
		<%String detailPage = (String) request.getAttribute("detailPage");%>
		<jsp:include page="<%=detailPage%>" /> 
		
		<br />		</td>
		</tr>
	</table>	</td>
	<td width="40">&nbsp;</td>
	<td width="30%">&nbsp;</td>
	</tr>

	<tr bgcolor="#ffffff">
	<td colspan="6"><img src="mm_spacer.gif" alt="" width="1" height="1" border="0" /></td>
	</tr>

	<tr>
	<td width="15">&nbsp;</td>
	<td width="215">&nbsp;</td>
	<td width="50">&nbsp;</td>
	<td width="440"><font size="2" color="#000000"><marquee WIDTH=100%  >Designed and Developed by</font></strong>:<span class="style3"><font size="3" color="#FFFF99"><b><i>Tushar Fasate and Ketan Vasaikar</marquee></i></b></font></td>
	<td width="40">&nbsp;</td>
	<td width="100%">&nbsp;</td>
	</tr>
</table>
</body>
</html>
