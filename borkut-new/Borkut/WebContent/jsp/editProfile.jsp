
<script language="javascript">

function validate()
{


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


//alert("hi");

var firstname=document.frmEditProfile.textFirstName.value;
var LastName=document.frmEditProfile.textLastName.value;
var City=document.frmEditProfile.textCity.value;
var Country=document.frmEditProfile.textCountry.value;
var Organisation=document.frmEditProfile.textOrganisation.value;



if(firstname=="" || firstname==0)
{
alert('Please enter First Name');
return false;
}else {
		var fname = document.frmEditProfile.textFirstName.value;
		
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
	
	if(LastName=="" || LastName==0)
{
alert('Please enter Last Name');
return false;
}else {
		var fname = document.frmEditProfile.textLastName.value;
		
		//NEED TO TRIM THE VARIBLE BEFORE PASSING IT TO THE FUNCTION

		var valFirstname;
		if(fname !=undefined){
            valFirstname = isValid(fname,lwr+upr);
		}

		if(!valFirstname){
			alert("A valid Last Name can have alphabets only");
			return false;
		}
	}
	
	
	if(City=="" || City==0)
{
alert('Please enter city');
return false;
}else {
		var fname = document.frmEditProfile.textCity.value;
		
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
	
	
	if(Country=="" || Country==0)
{
alert('Please enter country ');
return false;
}else {
		var fname = document.frmEditProfile.textCountry.value;
		
		//NEED TO TRIM THE VARIBLE BEFORE PASSING IT TO THE FUNCTION

		var valFirstname;
		if(fname !=undefined){
            valFirstname = isValid(fname,lwr+upr);
		}

		if(!valFirstname){
			alert("A valid country can have alphabets only");
			return false;
		}
	}
	
	
if(Organisation=="" || Organisation==0)
{
alert('Please enter organisation');
return false;
}else {
		var fname = document.frmEditProfile.textOrganisation.value;
		
		//NEED TO TRIM THE VARIBLE BEFORE PASSING IT TO THE FUNCTION

		var valFirstname;
		if(fname !=undefined){
            valFirstname = isValid(fname,lwr+upr);
		}

		if(!valFirstname){
			alert("A valid organisation can have alphabets only");
			return false;
		}
	}
//alert(empname);

var photo=document.frmEditProfile.image.value;

if(photo!="")
{

//alert(photo.split("."));

var arr =photo.split(".");

//alert(arr[1]);
if(arr[1]=="gif" || arr[1]=="jpg"  || arr[1]=="png" ||  arr[1]=="bmp" ||  arr[1]=="GIF" )
{
}else{
alert("Please update photo with valid extension like gif,jpg,png,bmp");
return false;


}

//alert(photo);
return true;
}

}


</script>

<%@ page import="java.util.Iterator"%>
<%@ page import="com.cts.domain.Users"%>


<%Users userparam = (Users) request.getAttribute("userparam");
			Users user = (Users) session.getAttribute("userObj");
%>

<form id="frmEditProfile" name="frmEditProfile" method="post"
	enctype="multipart/form-data" action="editProfile.do"
	onsubmit="return validate()">

<TABLE border="0" width="65%">
	<tr>
		<td colspan="5" class="userMenuHeader">
		<div align="center">Edit Profile</div>
		</td>
	</tr>

	<tr>
		<td width="30%" rowspan="9">&nbsp;</td>
		<td width="25%">&nbsp;</td>
		<td width="5%">&nbsp;</td>
		<td width="25%">&nbsp;</td>
		<td width="15%">&nbsp;</td>


	</tr>

	<tr>

		<td class="Bucket"><B>First Name</B></td>
		<td class="columnSeparater">:</td>
		<td><input type="text" name="textFirstName" style="width:124px;"
			value="<%=userparam.getFirstname() %>" maxlength="20" /> <input
			type="hidden" name="textUsernum" value="<%=userparam.getUsernum() %>" /></td>

	</tr>
	<tr>

		<td class="Bucket"><B>Last Name</B></td>
		<td class="columnSeparater">:</td>
		<td><input type="text" name="textLastName" style="width:124px;"
			value="<%=userparam.getLastname() %>" maxlength="20" /></td>


	</tr>
	<tr>

		<%String abtme = null;
			if (userparam.getAboutme() == null) {
			} else {

				abtme = (String) userparam.getAboutme();

			}%>

		<td class="Bucket"><B>About Me</B></td>
		<td class="columnSeparater">:</td>
		<td><textarea name="aboutMe" cols="15" rows="4" maxlength="50"><%=abtme%></textarea></td>

	</tr>
	<tr>


		<td class="Bucket"><B>Image</B></td>
		<td class="columnSeparater">:</td>
		<td><input type="file" name="image" style="width:250px;"
			maxlength="20" value="<%=userparam.getImage() %>" /></td>

	</tr>
	<tr>

		<td class="Bucket"><B>City</B></td>
		<td class="columnSeparater">:</td>
		<td><input type="text" name="textCity" style="width:124px;"
			maxlength="20" value="<%=userparam.getCity() %>" /></td>


	</tr>
	<tr>
		<%String sel1 = null, sel2 = null;
			if (userparam.getGender().equalsIgnoreCase("M"))
				sel1 = "checked";

			if (userparam.getGender().equalsIgnoreCase("F"))
				sel2 = "checked";

			%>
		<td class="Bucket"><B>Gender</B></td>
		<td class="columnSeparater">:</td>
		<td><input type="radio" name="radioGender" <%=sel1%> value="M" />Male
		<input type="radio" name="radioGender" <%=sel2%> value="F" />Female</td>


	</tr>
	<tr>

		<td class="Bucket"><B>Country</B></td>
		<td class="columnSeparater">:</td>
		<td><input type="text" name="textCountry" style="width:124px;"
			maxlength="20" value="<%=userparam.getCountry() %>" /></td>


	</tr>
	<tr>

		<td class="Bucket"><B>Organisation</B></td>
		<td class="columnSeparater">:</td>
		<td><input type="text" name="textOrganisation" style="width:124px;"
			maxlength="20" value="<%=userparam.getOrganisation() %>" /></td>


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

