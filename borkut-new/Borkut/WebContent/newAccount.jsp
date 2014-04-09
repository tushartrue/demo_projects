
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<LINK href="css/merckstyle.css" type=text/css rel=stylesheet>
<title>Create Account</title>
</head>

<script language="javascript">



		function validate(){
		
		var Username=document.frmAccount.textUsername.value;
		var firstname=document.frmAccount.textFirstName.value;
		var lastname=document.frmAccount.textLastName.value;
		var confirmpassword=document.frmAccount.textPassword.value;
		var retypepassword=document.frmAccount.textRePassword.value;
		var City=document.frmAccount.textCity.value;
		var Country=document.frmAccount.textCountry.value;
		var Organisation=document.frmAccount.textOrganisation.value;
		var Gender1=document.frmAccount.radioGender[0].checked;
		var Gender2=document.frmAccount.radioGender[1].checked;
		
		
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
				var fname = document.frmAccount.textFirstName.value;
				
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
				var lname = document.frmAccount.textLastName.value;
				
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
			document.frmAccount.textPassword.value="";
			 return false;
		    }
		    else if (illegalChars.test(strng)) {
		      alert( "The password contains illegal characters.\n");
			  document.frmAccount.textPassword.value="";
			  return false;
		    }
			
			else if (!((strng.search(/[a-z]+/) > -1) && (strng.search(/[A-Z]+/) > -1) && (strng.search(/[0-9]+/) > -1))) {
		  alert( "The password must contain at least one uppercase letter, one lowercase letter, and one numeral.\n");
		  document.frmAccount.textPassword.value="";
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
		
		if(City==null || City=="")
		{
		alert("Please enter the city ");
		return false;
		}else {
				var fname = document.frmAccount.textCity.value;
				
				//NEED TO TRIM THE VARIBLE BEFORE PASSING IT TO THE FUNCTION
		
				var valFirstname;
				if(fname !=undefined){
		            valFirstname = isValid(fname,lwr+upr);
				}
		
				if(!valFirstname){
					alert("A valid city can have alphabets only");
					return false;
				}
			}
			
			
			
				if(Gender1==false & Gender2==false){
				
				alert("Please select gender");
				
				return false;
				
				}
		
		
			
			
			if(Country==null || Country=="")
		{
		alert("Please enter the Country ");
		return false;
		}else {
				var fname = document.frmAccount.textCountry.value;
				
				//NEED TO TRIM THE VARIBLE BEFORE PASSING IT TO THE FUNCTION
		
				var valFirstname;
				if(fname !=undefined){
		            valFirstname = isValid(fname,lwr+upr);
				}
		
				if(!valFirstname){
					alert("A valid Country can have alphabets only");
					return false;
				}
			}
			
			
			
			if(Organisation!=null || Organisation!="")
		{
		
				var fname = document.frmAccount.textOrganisation.value;
				
				//NEED TO TRIM THE VARIBLE BEFORE PASSING IT TO THE FUNCTION
		
				var valFirstname;
				if(fname !=undefined){
		            valFirstname = isValid(fname,lwr+upr);
				}
		
				if(!valFirstname){
					alert("A valid Organisation can have alphabets only");
					return false;
				}
			}
			
		
		
		return true;
		
		
		}



</script>
<body>

<form id="frmAccount" name="frmAccount" method="post"
	action="newAccount.do" onsubmit="return validate()">

<table width="80%" border="0" align="center" cellpadding="0"
	cellspacing="2" class="gradiant">
	<tr>
		<td colspan="5" class="userMenuHeader">
		<div align="center">Create Account</div>
		</td>
	</tr>
	
	<tr>
		<td width="30%" rowspan="10"><IMG SRC="selfImage/friendCircle.jpg" WIDTH="300" HEIGHT="300" BORDER="0" ;"></td>
		<td width="25%">&nbsp;</td>
		<td width="5%">&nbsp;</td>
		<td width="25%">&nbsp;</td>
		<td width="15%">&nbsp;</td>
		
		
	</tr>
	<tr>
		
		<td class="Bucket"><B>Username</B></td>
		<td class="columnSeparater">:</td>
		<td><input type="text" name="textUsername" style="width:124px;"
			maxlength="20" /></td>
		
	</tr>
	
	<tr>
		
		<td class="Bucket"><B>First Name</B></td>
		<td class="columnSeparater">:</td>
		<td><input type="text" name="textFirstName" style="width:124px;"
			maxlength="20" /></td>
		
	</tr>
	<tr>
		
		<td class="Bucket"><B>Last Name</B></td>
		<td class="columnSeparater">:</td>
		<td><input type="text" name="textLastName" style="width:124px;"
			maxlength="20" /></td>
		
		
	</tr>
	<tr>
		
		<td class="Bucket"><B>Confirm Password</B></td>
		<td class="columnSeparater">:</td>
		<td><input type="password" name="textPassword" style="width:124px;"
			maxlength="20" /></td>
		
	</tr>
	<tr>
		
		
		<td class="Bucket"><B>Re-type Password</B></td>
		<td class="columnSeparater">:</td>
		<td><input type="password" name="textRePassword" style="width:124px;"
			maxlength="20" /></td>
		
	</tr>
	<tr>
		
		<td class="Bucket"><B>City</B></td>
		<td class="columnSeparater">:</td>
		<td><input type="text" name="textCity" style="width:124px;"
			maxlength="20" /></td>
		
		
	</tr>
	<tr>
		
		<td class="Bucket"><B>Gender</B></td>
		<td class="columnSeparater">:</td>
		<td><input type="radio"  name="radioGender"    value="M"/>Male
		<input type="radio" name="radioGender" value="F"/>Female</td>
		
		
	</tr>
	<tr>
		
		<td class="Bucket"><B>Country</B></td>
		<td class="columnSeparater">:</td>
		<td><input type="text" name="textCountry" style="width:124px;"
			maxlength="20" /></td>
		
		
	</tr>
	<tr>
		
		<td class="Bucket"><B>Organisation</B></td>
		<td class="columnSeparater">:</td>
		<td><input type="text" name="textOrganisation" style="width:124px;"
			maxlength="20" /></td>
		
		
	</tr>

	<tr>
		
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td align="right"><input name="submit" type="submit"
			class="buttonPagin" id="submit" value="Submit" /></td>
		<td>&nbsp;</td>
		
	</tr>
	<tr>
		<td colspan="8">&nbsp;</td>
	</tr>
</table>
</form>
</BODY>

 <!--End of body Table --></td>
	</tr>
	
	
	</table>

</body>
</html>