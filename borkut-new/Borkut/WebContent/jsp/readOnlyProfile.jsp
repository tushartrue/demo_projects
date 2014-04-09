
<%@ page import="java.util.Iterator"%>
<%@ page import="com.cts.domain.Users"%>


<%
	Users userparam=null;
	 userparam=(Users)request.getAttribute("userparam");

	if(userparam==null){
		userparam=(Users)session.getValue("myFriend");
		
	}
	
%>

<form id="frmEditProfile" name="frmEditProfile" method="post"
	enctype="multipart/form-data" action="editProfile.do" onsubmit="return validate()">

<TABLE border="0" width="65%">
	
	
	<tr>
		
		
		<td width="50%">&nbsp;</td>
		<td width="5%">&nbsp;</td>
		<td width="45%">&nbsp;</td>
		
		
	</tr>
	
	<tr>
		
		<td class="Bucket"><B>First Name</B></td>
		<td class="columnSeparater">:</td>
		<td class="readOnlyProfile" ><%=userparam.getFirstname() %></td>
		
	</tr>
	<tr>
		
		<td class="Bucket"><B>Last Name</B></td>
		<td class="columnSeparater">:</td>
		<td class="readOnlyProfile" ><%=userparam.getLastname() %></td>
		
		
	</tr>
	
	<%
	if(userparam.getAboutme()!=null){
		%>
	
	<tr>		
		<td class="Bucket"><B>About Me</B></td>
		<td class="columnSeparater">:</td>
		<td class="readOnlyProfile" ><%=userparam.getAboutme() %></td>
		
	</tr>
	<%} %>
	<tr>
		
		<td class="Bucket"><B>City</B></td>
		<td class="columnSeparater">:</td>
		<td class="readOnlyProfile" ><%=userparam.getCity() %></td>
		
		
	</tr>
	<tr>
		<%
		String sel1=null;
		if(userparam.getGender().equalsIgnoreCase("M")){
		sel1="Male";
		}else{
		
		sel1="Female";
		}
		
		%>
		<td class="Bucket"><B>Gender</B></td>
		<td class="columnSeparater">:</td>
		<td class="readOnlyProfile" ><%=sel1 %></td>
		
		
	</tr>
	<tr>
		
		<td class="Bucket"><B>Country</B></td>
		<td class="columnSeparater">:</td>
		<td class="readOnlyProfile" ><%=userparam.getCountry() %></td>
		
		
	</tr>
	<tr>
		
		<td class="Bucket"><B>Organisation</B></td>
		<td class="columnSeparater">:</td>
		<td class="readOnlyProfile" ><%=userparam.getOrganisation() %></td>
		
		
	</tr>

	
	<tr>
		<td colspan="8">&nbsp;</td>
	</tr>
</table>
</form>

