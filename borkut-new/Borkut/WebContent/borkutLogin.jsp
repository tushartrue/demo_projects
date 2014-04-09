<%@ page language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
<head>
<title>Employee Management Service</title>
<meta name="Robots" content="All" />		
<meta name="Country" content="global" />
<meta name="Language" content="English language" />		
<meta name="Sensitivity_class" content="Business confidential" />
<meta name="Publisher" content="MRL; Other MRL" />
<meta name="Content_Type" content="computer applications" />
<meta name="Creation" content="24-Oct-2003" />
<LINK href="css/merckstyle.css" type=text/css rel=stylesheet>
<meta name="Expiration" content="24-Oct-2004" />
<meta name="description" content="Home page for the MRL Supplies Ordering System application." />
<meta name="keywords" content="Supplies Ordering System, MRLSOS, SOS" />
<script src="portal/wrapperadd.js" type="text/javascript"></script>
<script src="portal/portaldefaults.js" type="text/javascript"></script>

<SCRIPT LANGUAGE="javascript" type="text/javascript">

//window.history.forward();

function checkVal() {
 var Usname = document.frmLogin.UserName.value;
 var Pss = document.frmLogin.Password.value;

 if ( (Usname==null) || (Usname.length == 0)  || (Usname.indexOf(" ") > -1) ) {
   alert("Please Enter UserName.");
   return false;
 }
 if ( (Pss==null) || (Pss.length == 0) || (Pss.indexOf(" ") > -1) ) {
   alert("Please Enter Password.");
   return false;
 }
 return true;
}
</SCRIPT>

</head>
<body background="images/back_sub.gif" onLoad="document.frmLogin.UserName.focus();">


<hr size="4" noshade color="#008080">

<form method="post" name="frmLogin" action="login.do" onSubmit="return checkVal();">

<table border="0"  bgcolor="#CCFFFF">
	<tr>
		<td width="25%" height="112" rowspan="3">
			<tr>
				<td>&nbsp;</td>
			</tr>
			
			<div align="center"><IMG SRC="selfImage/loginImage.jpg" WIDTH="350" HEIGHT="70" BORDER="0" ALT=""></div>
		</td>
	</tr>
	
	<tr><td>&nbsp;</td>
        <td colspan="2"><div align="center"><center>
        <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr>	
		<td colspan="2"   class="userMenuHeader"><div align="center">Borkut Login</div></td>
		</tr>
		<table border="2"  class="gradiant" >
			<tr><td><table width="100%" border="0"  cellpadding="0" cellspacing="0" class="gradiant">
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td class="columnName">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>						
							<td class="columnName"><strong>Username:&nbsp;</strong></td>
							<td class="columnName"><input type="text" size="20" name="UserName" 
			maxlength="20"></td>
			</tr>
			<tr>
							<td class="columnName">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td class="columnName"><strong>Password:&nbsp;</strong></td>
							<td class="columnName"><input type="password" size="12" name="Password" ></td>
							<td class="columnName"></td>
						</tr>
						<tr><td colspan="7" align="center"><br>
							<input type="submit" name="Action" value="Sign In" class="buttonPagin"></td>
							
							<td class="columnName">New User?<a href="newAccount.jsp " >Sign Up</a>  </td>
						</tr>
						
					
					</table>
				</td>
			</tr>
			
		</table>
		</table>
		</center>
		</div>
		</td>
	</tr>
</table>

</form>


</BODY>
</HTML>