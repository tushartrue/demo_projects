
<%@ page import="com.cts.domain.Users"%>
<%@ page import="com.cts.domain.Scrapbook"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Set"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="com.cts.dao.BaseDAO"%>


<script language="javascript">

function validate(){
if(document.frmPostScrap.aboutMe.value=="")

{
//alert("Hi");
alert("Please enter the scrap");
return false;
}
}

function validateReply(){
if(document.frmReply.myReply.value=="")

{
//alert("Hi");
alert("Please enter the Reply");
return false;
}

}
</script>

	<%
	
	
	Users users=null,userCheck=null,userfriend=null,FriendCkeck=null;
	String dis=null;
	users=(Users)request.getAttribute("userparam");
	
	userCheck=(Users)session.getAttribute("myUser");
	
	
	
	
	FriendCkeck=(Users)session.getValue("myFriend");
	
	List scrapsList=(List)request.getAttribute("scraps");

	if(users==null){
		users=(Users)session.getValue("myFriend");
		
		 userfriend=(Users)session.getValue("myFriend");
		
	}
	if(userfriend!=null & userCheck!=null)
	if(userCheck.getUsernum()==userfriend.getUsernum())
	{
		dis="disabled";
	}
	
	if(userfriend==null){
		dis="disabled";
	}
	
	Iterator scrapItr=null;
	if(scrapsList!=null)
	 scrapItr=scrapsList.iterator();
	
		%>


	
<TABLE border="0" width="30%">
<form id="frmPostScrap" name="frmPostScrap" method="post"
	 action="postScrap.do" onsubmit="return validate()">
	<tr>
		<td colspan="7" >
		<div align="center"><h3>Scrapbook</h3>
		<%if(users.getUsernum().equals(userCheck.getUsernum())){ %>
		
		<a href="viewScrapbook.do?usernum=<%=users.getUsernum() %>" >(Refresh scraps)</a><%} %></div>
		</td>
	</tr>
	
	<tr>
		
		<td width="25%" rowspan="3" valign="top" ><b>Scraps(<%=scrapsList.size() %>)</b></td>
		<td width="40%">&nbsp;</td>
		
		<td width="20%">&nbsp;</td>	
		
		
	</tr>
	
	<td>
					 
	<textarea name="aboutMe" style='width:343px;height=100px;' maxlength="50"></textarea></td>
	
	<tr>
		
	
		<td align="right"><input name="submit" type="submit"
			class="buttonPagin" id="submit" <%=dis %> value="Post scrap" /></td>
			<td>&nbsp;</td>
	</tr>
</form>


	<tr>
	
	<%
	
		if(scrapItr!=null)
		while(scrapItr.hasNext()){
		
		Scrapbook scrapbook =(Scrapbook)scrapItr.next();
		
	
	if(scrapbook.getFriend().getImage()==null){ %>
	<td ><IMG SRC="selfImage/BlankImage.jpg" WIDTH="100" HEIGHT="100" BORDER="2" ALT="&nbsp;"></td>
	<%}else{ %>
	<td ><IMG SRC="<%=scrapbook.getFriend().getImage()%>" WIDTH="100" HEIGHT="100" BORDER="2" ALT="&nbsp;"></td>
	<%} %>
	<td>
	<table border="0" width="100%" height="100%">
	<tr><td  align="left" class="readOnlyProfile" ><a href="friendProfile.do?frUsernum=<%=scrapbook.getFriend().getUsernum() %>">
	<%=scrapbook.getFriend().getFirstname()%>&nbsp;<%=scrapbook.getFriend().getLastname()%></a>&nbsp;&nbsp;&nbsp;&nbsp;
	</td>
	<%
	String crDate=BaseDAO.dateConvertor(scrapbook.getCreateddate().toString());
	%>
	<td align="right"><%=crDate %></td>
	<%if(users.getUsernum().equals(userCheck.getUsernum())){ %>
	<td align="right" ><a href="deleteScrap.do?sn=<%=scrapbook.getSn() %>&usernum=<%=scrapbook.getUsernum().getUsernum() %>"><b>Delete</b></a></td><%} %></tr>
	<tr><td align="left" colspan="3" class="scrapBookData" height="90"><%=scrapbook.getScraps() %></td></tr>

	</table>
	
	</td>
	<td>&nbsp;</td>
	</tr>
	<% if(users.getUsernum().equals(userCheck.getUsernum())){ %>
	<tr><td>&nbsp;</td><td><a href="viewScrapbook.do?usernum=<%=scrapbook.getUsernum().getUsernum() %>&sn=<%=scrapbook.getSn() %>">Reply</a></td></tr>
	<%
	Integer SN=scrapbook.getSn();
	String number=(String)request.getAttribute("Number");
	if(number!=null)
	if(SN.equals(Integer.valueOf(number))){ %>
	<form id="frmReply"  name="frmReply"  action="postReply.do" method="post"  onsubmit="return validateReply()">
	<tr><td>&nbsp;<input type="hidden" name="usernum" value="<%=scrapbook.getUsernum().getUsernum()%>" />
	<input type="hidden" name="friend" value="<%=scrapbook.getFriend().getUsernum()%>" />
	</td>
	<td><textarea name="myReply" style='width:250px;height=50px;' maxlength="30"></textarea><input type="submit" value="Post" />&nbsp;&nbsp;<a href="viewScrapbook.do?usernum=<%=scrapbook.getUsernum().getUsernum() %>">Cancel</a></td>
	
	</tr></form>
	<%}}} %>



	
</table>



