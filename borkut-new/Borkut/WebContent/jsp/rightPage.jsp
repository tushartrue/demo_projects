
<%@ page import="com.cts.domain.Users"%>
<%@ page import="com.cts.domain.Friends"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Set"%>
<%@ page import="java.util.Iterator"%>
<%

String myaccount=(String)request.getAttribute("myaccount");
Users users=null;

if(myaccount==null){
	
	users=(Users)session.getAttribute("myFriend");
}
else{
	users=(Users)session.getValue("myUser");
	
}
	
//if(users==null){
	//users=(Users)session.getValue("myUser");
	
//}
Users userparam=(Users)session.getValue("myUser");
%>
<TABLE border="0"  bordercolor="#996600"  width="65%">
<TR>

<%if(userparam.getUsernum().equals(users.getUsernum())){ %>
	<TD colspan="3" color="#339900" ><B><H3><MARQUEE DIRECTION="LEFT" BGCOLOR="#CCFFFF" INFINITE WIDTH="400">Welcome <%=users.getFirstname() %>&nbsp;&nbsp;<%=users.getLastname() %>&nbsp;!</MARQUEE></H3></B></TD>
<%}else{ %>	
<TD colspan="3" color="#339900" ><B><H3><%=users.getFirstname() %>&nbsp;&nbsp;<%=users.getLastname() %>&nbsp; Account!</H3></B></TD>
<%} %>

</TR>

<tr><td colspan="3">Search users to find your friends.</td></tr>
<TR>

	<TD colspan="3"><b>Friends</b>(<%=users.getFriends().size() %>)</TD>
	
</TR>

	
		<%		
	 	Set friendsSet=(Set)users.getFriends();
		int setSize=friendsSet.size();
		Iterator friendIterator=friendsSet.iterator();
		
		%>
		
			<%
			for(int i=0;i<setSize;i=i+3){
				Friends friends=null;
			%>
			<TR>
			<% 
			
			for(int j=0;j<3;j++){
				
				if(friendIterator.hasNext()){
				 friends=(Friends)friendIterator.next();
				}else{
					
					break;
				}
			%>
		
		<td align="center">
	<table border="2" bordercolor="#0000CC"  cellpadding="2" cellspacing="2">
	<%
	
	if(friends.getFriendnum().getImage()!=null){%>
	<tr><TD align="center"><IMG SRC="<%=friends.getFriendnum().getImage() %>" WIDTH="130" HEIGHT="130" BORDER="0" ALT=""></TD></tr>
	<%}else{ %>
	
	<tr><TD align="center"><IMG SRC="selfImage/BlankImage.jpg" WIDTH="130" HEIGHT="130" BORDER="0" ALT=""></TD></tr>
	<%} %>
	<tr><TD class="readOnlyProfile" align="center"><a href="friendProfile.do?frUsernum=<%=friends.getFriendnum().getUsernum() %>" class="MRLMenu" ><%=friends.getFriendnum().getFirstname() %>&nbsp;<%=friends.getFriendnum().getLastname() %></a></TD></tr>
	</table>
	
	</td>
		<%
			}
		%>
		</TR>
		<%} %>	

</TABLE>
