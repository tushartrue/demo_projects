
<%@ page import="com.cts.domain.Users"%>
<%
	
	Users users=null;
	int flag=0;
	users=(Users)request.getAttribute("myFriend");
		
	if(users==null){
		users=(Users)session.getValue("myUser");
		flag=1;
		
		
	}
	
	System.out.println("Username= "+users.getUsername());
	
%>
	<table width="100%" height="100%" border="0" cellpadding="2"
			cellspacing="3" class="gradiant">
			
			<tr>
				<td height="13">&nbsp;</td>
				<td width="4%"><strong></td>
				<td align="left">&nbsp;</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<%
				if(users.getImage()==null){
				%>
				<td class="Bucket" align="center"><a class="MRLMenu"><IMG SRC="selfImage/BlankImage.jpg" WIDTH="130" HEIGHT="130" BORDER="3" ></a>
				</td>
				<%}else{ %>
				<td class="Bucket" align="center" ><a class="MRLMenu" ><IMG SRC="<%=users.getImage() %>"  WIDTH="130" HEIGHT="130" BORDER="3" ></a>
				
				<%} %>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td  align="left" class="readOnlyProfile" ><a href="login.do" class="MRLMenu" ><%=users.getFirstname() %>&nbsp;&nbsp;<%=users.getLastname() %></a></td>
			</tr>
			<tr>
			
			<%
			String str=null;
			if(users.getGender().equalsIgnoreCase("M")){
				str="Male";
				
			}else{
				
				str="Female";
			}
			
			
			%>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td  align="left" class="readOnlyProfile" ><%=str %>&#44;<%=users.getCity() %></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td  align="left" class="readOnlyProfile" ><%=users.getCountry() %> &nbsp; &nbsp; 
				
				
				<% if(flag==1){%>
				
				<a href="fetchProfile.do?usernum=<%=users.getUsernum() %>">Edit</a>
				
				<%} %>
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td> &nbsp;</td>
			</tr>
			
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td  align="left"><a href="readOnlyProfile.do?usernum=<%=users.getUsernum() %>" class="MRLMenu">
				Profile</a></td>
			</tr>
			
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>

				<td class="Bucket"><a href="viewScrapbook.do?usernum=<%=users.getUsernum()%>" class="MRLMenu">Scrapbook</a></td>
			</tr>
			
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td class="Bucket"><a class="MRLMenu" href="myAlbum.do?usernum=<%=users.getUsernum() %>">Photos
				</a></td>
			</tr>
			
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td class="Bucket"><a href="logout.jsp" class="MRLMenu">Logout</a></td>
			</tr>
			
			<tr>
				<td height="260">&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
		</table>
		
	
		
	
