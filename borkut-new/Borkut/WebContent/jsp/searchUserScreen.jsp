
<%@ page import="java.util.List"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="com.cts.domain.Users"%>
<%
		List userList=(List)request.getAttribute("userList");
		

%>
<BODY>

<form  id="frmSearchUser" name="frmSearchUser" action="submitSearchUser.do" >

<table width="80%" height="100%" border="1" cellpadding="2"
			cellspacing="3" >
<TR >
	<TD width="20%" class="columnName">First name</TD>
	<TD>:&nbsp;<input type="hidden" name="searchUser" value="yes"><input type="text" name="txtFirstname" style="width:124px;"
			 maxlength="20" /></TD>
</TR>
<TR>
	<TD class="columnName" >Last name</TD>
	<TD>:&nbsp;<input type="text" name="txtLastname" style="width:124px;"
			 maxlength="20" /></TD>
</TR>
<TR>
	<TD class="columnName">City </TD>
	<TD>:&nbsp;<input type="text" name="txtCity" style="width:124px;"
			 maxlength="20" /></TD>
</TR>

<TR>
	
	<TD colspan="2" align="center"><input type="submit" name="submit" style="width:124px;"
			value="Search User" maxlength="20" />&nbsp;&nbsp;(You can do blank search also)</TD>
			
			
</TR>



</TABLE>
</form>

<%

if(userList!=null){%>

<table width="80%"height="100%" border="1" cellpadding="2"
			cellspacing="3" >
<TR><TD align="center" ><h4>Search Result</h4></TD></TR>
<%

	if(userList.size()!=0){
  if(userList!=null){
	  
	    Iterator userIterator= userList.iterator();
	    while(userIterator.hasNext()){
	    	
	    	Users userparam=(Users)userIterator.next();
	    %>
	    
	    
	    <TR>
	<TD><TABLE table="1">
	<TR>
	<%if(userparam.getImage()!=null) {%>
		<TD rowspan="5"><IMG SRC="<%=userparam.getImage() %>" WIDTH="100" HEIGHT="100" BORDER="2" ALT=""></TD>
		<%}else{ %>
		
			<TD rowspan="5"><IMG SRC="selfImage/BlankImage.jpg" WIDTH="100" HEIGHT="100" BORDER="2" ALT=""></TD>
			<%} %>
		<TD  width="300" class="Bucket" ><a href="friendProfile.do?frUsernum=<%=userparam.getUsernum() %>"><b><%=userparam.getFirstname() %>&nbsp;<%=userparam.getLastname()%></b></a></TD>
	</TR>
	<TR>
		
		<TD class="Bucket" ><%=userparam.getCity() %></TD>
	</TR>
	<TR>
		
		<TD class="Bucket" ><%=userparam.getCountry() %></TD>
	</TR>
	<tr><td>&nbsp;</td></tr>
	<tr><td>&nbsp;</td></tr>
	</TABLE></TD>
</TR>
	    
	    <%	
	    	
	    }
  }}else{

%>
 <tr>
    <td colspan="7">
 	<div class="fail_ld">
								    	<div class="fail_rd">
										<div class="fail_lt">
										<div class="fail_rt">
										<div class="fail_tb">
										<div class="fail_lr">
										<div class="fail_con" id="failContent">No matching record found.Please try again</div>
										</div>
										</div>
										</div>
										</div>
										</div>
										</div>	
 	</td>
  </tr>	

<%} %>

<TR>
	<TD></TD>
</TR>
</TABLE>
<%} %>
</BODY>

