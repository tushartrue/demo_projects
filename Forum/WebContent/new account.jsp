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
.style11 {font-size: 16px; color: #330066; font-family: "Times New Roman", Times, serif; }
.style12 {
	color: #0000CC;
	font-style: italic;
}
-->
</style>
<script language="javascript">

		function validate(){
		// alert("HI");
		
		var Username=document.frmNewAccount.username.value;
		var firstname=document.frmNewAccount.firstname.value;
		var lastname=document.frmNewAccount.lastname.value;
		var confirmpassword=document.frmNewAccount.password.value;
		var retypepassword=document.frmNewAccount.retypepassword.value;
		
		
		var numb = '0123456789';
		var lwr = 'abcdefghijklmnopqrstuvwxyz';
		var upr = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
		var hypen = '-';
		var plus = '+';
		
		function isValid(parm,val) {
		                if (parm == "") return true;
		                                for (i=0; i<parm.length; i++) {
		                                                if (val.indexOf(parm.charAt(i),0) == -1) return false;
		                                }
		                return true;
		}
		
		
		//alert(empid);
		
		//alert(firstname);
		
		
		
		if(Username==null || Username=="")
		{
		alert("Please enter the Username ");
		return false;
		}
		
		
		if(firstname==null || firstname=="")
		{
		alert("Please enter the First Name ");
		return false;
		}else {
				var fname = document.frmNewAccount.firstname.value;
				
				//NEED TO TRIM THE VARIBLE BEFORE PASSING IT TO THE FUNCTION
		
				var valFirstname;
				if(fname !=undefined){
		            valFirstname = isValid(fname,lwr+upr);
				}
		
				if(!valFirstname){
					alert("A valid First Name can have alphabets only");
					return false;
				}
			}
			
			
			
		//alert(lastname);
		if(lastname==null || lastname=="")
		{
		alert("Please enter the Last Name");
		return false;
		}else {
				var lname = document.frmNewAccount.lastname.value;
				
				//NEED TO TRIM THE VARIBLE BEFORE PASSING IT TO THE FUNCTION
		
				var valLasttname;
				if(fname !=undefined){
		            valLasttname = isValid(lname,lwr+upr);
				}
		
				if(!valLasttname){
					alert("A valid Last Name can have alphabets only");
					return false;
				}}
				
				
		//alert(confirmpassword);
		if(confirmpassword==null || confirmpassword=="")
		{
		alert("Please enter the Confirm Password");
		return false;
		}else{
		
		var strng=confirmpassword;
		 var error = "";
		 
		 
		    var illegalChars = /[\W_]/; // allow only letters and numbers
		    if (strng.length < 6){
		     alert("Password length should be more than 6.");
			document.frmNewAccount.password.value="";
			 return false;
		    }
		    else if (illegalChars.test(strng)) {
		      alert( "The password contains illegal characters.\n");
			  document.frmNewAccount.password.value="";
			  return false;
		    }
			
			else if (!((strng.search(/[a-z]+/) > -1) && (strng.search(/[A-Z]+/) > -1) && (strng.search(/[0-9]+/) > -1))) {
		  alert( "The password must contain at least one uppercase letter, one lowercase letter, and one numeral.\n");
		  document.frmNewAccount.password.value="";
		   return false;
		  }
		  
		
		}
		//alert(retypepassword);
		if(retypepassword==null || retypepassword=="")
		{
		alert("Please enter the Re-type Password");
		return false;
		}
		
		if((retypepassword!=null || retypepassword!="")&&(confirmpassword!=null || confirmpassword!=""))
		{
			if(confirmpassword!=retypepassword){
			alert("Entered confirm password and re-type password doesn't match,Please enter password correctly.");
			confirmpassword=="";
			retypepassword=="";
			return false;
			}
		}
		document.frmNewAccount.submit();
		
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
	<table border="0" cellspacing="0" cellpadding="2" width="610">
        <tr bgcolor="#FF99CC">
          <td colspan="3" class="pageName style2">Cognizant Technology Solution </td>
        </tr>
       <tr>
         <td width="260" class="subHeader" valign="bottom">&nbsp;</td>
		 <td width="30" rowspan="2">&nbsp;</td>
		 <td width="320" height="100" rowspan="2"><img src="images/Cognizant-Building.jpg" alt="large product pho
" width="319" height="214" border="0" /></td>
        </tr>
        <tr bgcolor="#FFCCCC">
          <td valign="top" class="bodyText">
          
          <form id="frmNewAccount" name="frmNewAccount" method="post" action="newAccount.do" >
	
          <table width="270" border="0">
          

            <tr>
              <td width="123"><span class="style11">Username</span></td>
              <td width="10"><strong>:</strong></td>
              <td width="130">
                <input name="username" type="text" size="20" maxlength="15" /></td>
            </tr>
            <tr>
              <td><span class="style11">First Name </span></td>
              <td><strong>:</strong></td>
              <td> <input name="firstname" type="text" size="20" maxlength="20" />&nbsp;</td>
            </tr>
            <tr>
              <td><span class="style11">Last Name </span></td>
              <td><strong>:</strong></td>
              <td><input name="lastname" type="text" size="20" maxlength="20" />&nbsp;</td>
            </tr>
            <tr>
              <td height="40"><span class="style11">Password</span></td>
              <td><strong>:</strong></td>
              <td><input name="password" type="password" size="20" maxlength="15" />&nbsp;</td>
            </tr>
            <tr>
              <td><span class="style11">Retype Password </span></td>
              <td><strong>:</strong></td>
              <td><input name="retypepassword" type="password" size="20" maxlength="15" />&nbsp;</td>
            </tr>
          </table> 
           </form>           
            <p class="style1">&nbsp; <input name="submit" type="submit" value="Create Account" onclick="validate();" /> 
              <a href="LoginPage.jsp" class="style12">back</a></p>
          </td>
         
        </tr>
      </table>
     
       <br />
	  &nbsp;<br />	</td>
	<td>&nbsp;</td>
	</tr>

	<tr>
	<td width="15">&nbsp;</td>
    <td width="35">&nbsp;</td>
    <td width="710"><strong>Designed and Developed by</strong>:<span class="style3">Tushar and Ketan </span></td>
	<td width="100%">&nbsp;</td>
  </tr>
</table>
</body>
</html>
