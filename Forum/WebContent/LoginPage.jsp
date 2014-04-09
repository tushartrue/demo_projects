<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- DW6 -->
<head>
<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->
<title>LoginPage of Discussion Forum - Product Page</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" href="file:///D|/Program%20Files/Macromedia/Dreamweaver%208/Configuration/BuiltIn/StarterPages/mm_lodging1.css" type="text/css" />
<style type="text/css">
<!--
.style1 {
	font-size: 14px;
	font-weight: bold;
	color: #666600;
}
.style2 {color: #0000FF}
.style3 {
	font-size: 12px;
	font-style: italic;
	color: #0000FF;
}
.style4 {
	color: #666600;
	font-weight: bold;
}
.style5 {font-family: "Times New Roman", Times, serif}
-->
</style>

<script language="javascript">
function validate(){
var username=document.frmLogin.username.value;
var password=document.frmLogin.password.value;

if(username=="" | username==null){
alert("Please enter the username");
return false;

}
if(password=="" | password==null){
alert("Please enter the password");
return false;

}
return true;



}

</script>
</head>
<body bgcolor="#999966">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
	<td width="15" nowrap="nowrap">&nbsp;</td>
	<td height="60" colspan="2" class="logo" nowrap="nowrap"><br />
	Welcome to Discussion Forum </td>
	<td width="100%">&nbsp;</td>
	</tr>

	<tr bgcolor="#ffffff">
	<td colspan="4"><img src="file:///D|/Program%20Files/Macromedia/Dreamweaver%208/Configuration/BuiltIn/StarterPages/mm_spacer.gif" alt="" width="1" height="1" border="0" /></td>
	</tr>

	<tr bgcolor="#a4c2c2">
	<td width="15" nowrap="nowrap">&nbsp;</td>
	<td height="36" id="navigation" class="navText"><a href="javascript:;"></a></td>
	<td>&nbsp;</td>
	<td width="100%">&nbsp;</td>
	</tr>

	<tr bgcolor="#ffffff">
	<td colspan="4"><img src="file:///D|/Program%20Files/Macromedia/Dreamweaver%208/Configuration/BuiltIn/StarterPages/mm_spacer.gif" alt="" width="1" height="1" border="0" /></td>
	</tr>

	<tr bgcolor="#ffffff">
	<td valign="top" width="15"><img src="file:///D|/Program%20Files/Macromedia/Dreamweaver%208/Configuration/BuiltIn/StarterPages/mm_spacer.gif" alt="" width="15" height="1" border="0" /></td>
	<td valign="top" width="35"><img src="file:///D|/Program%20Files/Macromedia/Dreamweaver%208/Configuration/BuiltIn/StarterPages/mm_spacer.gif" alt="" width="35" height="1" border="0" /></td>
	<td width="710" valign="top"><br />
	<form id="frmLogin" name="frmLogin" method="post" action="authenticate.do" onsubmit="return validate();">
	<table border="0" cellspacing="0" cellpadding="2" width="610">
        <tr bgcolor="#FF99CC">
          <td colspan="3" class="pageName style2">Cognizant Technology Solution </td>
        </tr>
       <tr>
         <td width="260" class="subHeader" valign="bottom">&nbsp;</td>
		 <td width="30" rowspan="2">&nbsp;</td>
		 <td width="320" height="100" rowspan="2"><img src="images/Cognizant-Building.jpg" alt="large product photo" width="319" height="214" border="0" /></td>
        </tr>
        <tr bgcolor="#FFCCCC">
        
       
        
          <td valign="top" class="bodyText"><p class="style1"> 
          <%
        String flag=(String)request.getAttribute("flag");
        if(flag!=null)  
        if(flag.equalsIgnoreCase("invalidPassword"))
        {
        %>
          <span><font size="2" color="#9966FF" face="arial">Entered password is invalid.</font></span>
          <%}else if(flag.equalsIgnoreCase("noAccount")){ %>
          
          <span><font size="2" color="#9966FF" face="arial">You don't have account.</font></span>
          <%}  %>
          <span class="style5">Username</span>:<input name="username" type="text" size="20" maxlength="15" /></p>
            <p class="style1"><span class="style5">Password </span>:<input name="password" type="password" size="20" maxlength="15" /></p>
            <p><strong><input name="submit" type="submit" value="submit" />
            </strong> <span class="style4">New User?</span><a href="new account.jsp" class="style2"><em>Sign Up </em></a></p></td>
        </tr>
      </table>
      </form>
	   <br />
	  &nbsp;<br />	</td>
	<td>&nbsp;</td>
	</tr>

	<tr>
	<td width="15">&nbsp;</td>
    <td width="35">&nbsp;</td>
    <td width="710"><strong>Designed and Developed by</strong>:<span class="style3">Tushar Fasate and Ketan Vasaikar </span></td>
	<td width="100%">&nbsp;</td>
  </tr>
</table>
</body>
</html>
