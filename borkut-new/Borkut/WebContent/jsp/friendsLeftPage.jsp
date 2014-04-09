

<%@ page import="com.cts.domain.Users"%>
<%
	
	Users users=null;
	
	users=(Users)session.getAttribute("myFriend");
		
	


	
	
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
				<td class="Bucket" align="center" ><a class="MRLMenu" ><IMG SRC="<%=users.getImage() %>"  WIDTH="130" HEIGHT="130" BORDER="3" ALT="Home"></a>
				
				<%} %>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td  align="left" class="readOnlyProfile" ><a href="friendProfile.do?frUsernum=<%=users.getUsernum() %>" class="MRLMenu"><%=users.getFirstname() %>&nbsp;&nbsp;<%=users.getLastname() %></a></td>
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
				<td  align="left" class="readOnlyProfile" ><%=users.getCountry() %> 
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
				<td  align="left"><a href="friendsReadOnlyProfile.do?frUsernum=<%=users.getUsernum() %>" class="MRLMenu">
				Profile</a></td>
			</tr>
			
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>

				<td class="Bucket"><a href="friendsViewScrapbook.do?frUsernum=<%=users.getUsernum()%>" class="MRLMenu">Scrapbook</a></td>
			</tr>
			
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td class="Bucket"><a class="MRLMenu" href="myFriendsAlbum.do?frUsernum=<%=users.getUsernum() %>">Photos
				</a></td>
			</tr>
			
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td class="Bucket"><a class="MRLMenu" href="addFriend.do?frUsernum=<%=users.getUsernum() %>">Add as a friend
				</a></td>
			</tr>
			
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td class="Bucket"><a class="MRLMenu" href="logout.jsp">Logout</a></td>
			</tr>
			
			<tr>
				<td height="260">&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
		</table>
		
	
		
	
