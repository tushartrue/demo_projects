


<script language="javascript">

//window.history.foward()
function validate_form()
{
//alert("hi");

var label=document.frmPhoto.textLabel.value;

if(label=="")
{
alert("Please enter the label");
return false;

}
//alert(label);

var photo=document.frmPhoto.albumImage.value;
//alert(photo);
if(photo=="")
{
alert("Please upload the photo");
return false;

}else{

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

<TABLE border="0" width="70%">


<%@ page import="com.cts.domain.Users"%>
<%@ page import="com.cts.domain.Photos"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Set"%>
<%@ page import="java.util.Iterator"%>

	<%
	
	Users users=null;
	String identifier=(String)request.getAttribute("identifier");
	Users myselfUser=(Users)session.getValue("myUser");
	
	List photosList=(List)request.getAttribute("photos");
	if(identifier!=null){
		users=(Users)session.getValue("myFriend");
		
		session.setAttribute("fromFriendPage","friend");
		
	}else{
	 users=(Users)session.getValue("myUser");	
	}
	Set albumSet=(Set)users.getPhotos();
	%>

	<TR>
		<TD colspan="3" align="center">
		<H3>Album</H3>
		</TD>

	</TR>

	<tr>
		<td width="33%" color="#0033FF"><b>Photos(<%=photosList.size() %>)</b></td>
		<td width="33%">&nbsp;</td>
		<td width="33%">&nbsp;</td>

	</tr>

	<tr>
	<td colspan="3">
	
		
		<%
		if(myselfUser.getUsernum().equals(users.getUsernum())){
		%>
		
		<form  id="frmPhoto"  name="frmPhoto"  method="post" action="upLoadPhoto.do"  enctype="multipart/form-data"  onsubmit="return validate_form()">
		<table align="center" width="100%"   border="0" >
			<tr>
				<td><B>Upload Image</B>:<input type="hidden" name="usernum" value="<%=users.getUsernum()%>"
					 /></td>
				<td><input type="file" name="albumImage" style="width:250px;"
			maxlength="50" /></td>
			</tr>

			<tr>
				<td><B>Label:</B></td>
				<td><input type="text" name="textLabel" style="width:124px;"
					maxlength="20" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="submit" type="submit"
			class="buttonPagin" id="submit" value="Submit" /></td>
			</tr>

		</table>
		<%} %>
		</form>
		</td>
	</tr>
	<%	
		
	
	
		Iterator photoIterator=photosList.iterator();
		
	int listSize=albumSet.size();
		Iterator albumIterator=albumSet.iterator();
		
		%>
		
			<%
			for(int i=0;i<listSize;i=i+3){
				Photos photos=null;
			%>
			<TR>
			<% 
			
			for(int j=0;j<3;j++){
				
				if(photoIterator.hasNext()){
					photos=(Photos)photoIterator.next();
				}else{
					
					break;
				}
			%>
		<td>
		<table border="1">
			<tr>
				<TD align="center"><IMG SRC="<%=photos.getPhotos() %>" WIDTH="100"
					HEIGHT="100" BORDER="2" ALT=""></TD>
			</tr>
			<tr>
				<TD align="center"><%=photos.getLabel() %></TD>
			</tr>
			<tr>
				<td align="center"><a href="<%=photos.getPhotos() %>" target="#" ><IMG SRC="selfImage/magnifier.jpg"
					WIDTH="50" HEIGHT="50" BORDER="0" ALT=""></a>&nbsp;&nbsp;
					
					<%
		if(myselfUser.getUsernum().equals(users.getUsernum())){
		%>
					
					<a href="deletePhoto.do?sn=<%=photos.getSn() %>&usernum=<%=photos.getUsernum().getUsernum() %>"><B>Delete</B></a></td>
					<%} %>
			</tr>
		</table>
		</td>

		<%
			}
		%>
		</TR>
		<%} %>	
	
</TABLE>
