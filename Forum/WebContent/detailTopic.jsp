<html version="-//W3C//DTD HTML 4.01 Transitional//EN">

<head>
<style type="text/css">    
            .pg-normal {
                color: black;
                font-weight: normal;
                text-decoration: none;    
                cursor: pointer;    
            }
            .pg-selected {
                color: black;
                font-weight: bold;        
                text-decoration: underline;
                cursor: pointer;
            }
        </style>

<script type="text/javascript" src="paging.js"> 
</script>

</head>

<%@page import="cts.domain.Topic"%>
<%@page import="cts.dao.HibernateUtil"%>
<%Topic topicObj = (Topic) request.getAttribute("topicObj");
			java.util.List repliesList = (java.util.List) request
					.getAttribute("repliesList");
%>



<table width="584" border="0">
	<tr>
		<td width="218" bgcolor="#FFCCFF" class="MRLMenu"><strong>Topic</strong>
		(Posted By <span class="style7"><%=topicObj.getUser().getName()%></span>)
		</td>
		<td width="153" bgcolor="#FFCCFF"><strong>Category</strong>:<span
			class="style8"><%=topicObj.getCategory()%></span></td>

		<th width="95" bgcolor="#FFCCFF">Action</th>
		<th width="82" bgcolor="#FFCCFF">Started date</th>
	</tr>
	<tr bordercolor="#FFCCCC" bgcolor="#FFFFFF">
		<td>&gt;<font color="#9900FF" size="3"><%=topicObj.getTopic_name()%>
		</font></td>
		<td class="pageName style1 style2 style4">&nbsp;</td>

		<td align="center"><a
			href="detailTopic.do?reply_id=1&t_id=<%=topicObj.getTopic_id()%>&category=<%=topicObj.getCategory()%>">Reply</a>
			
			<% 
			
			cts.domain.Users user=(cts.domain.Users)session.getValue("user") ;
			if(topicObj.getUser().getUsernum().equals(user.getUsernum())){
			%>
			
			|<a href="deleteTopic.do?topic_id=<%=topicObj.getTopic_id() %>&category=<%=topicObj.getCategory() %>">Delete</a>
			
			<%} %>
			
			</td>
		<td><span class="style6"><%=HibernateUtil.dateConvertor2(topicObj.getStarted_date()
							.toString())%></span></td>
	</tr>
	<tr bordercolor="#FFCCCC" bgcolor="#FFFFFF">
		<td colspan="2"><span class="style9"><%=topicObj.getBody()%></span> <br />
		</td>
		<hr />

		<td width="95" class="Bucket style5">&nbsp;</td>
		<td width="82">&nbsp;</td>
	</tr>
</table>

<hr size="2" color="#330099" />
<%String show_reply = (String) request.getAttribute("show_reply");
			if (show_reply != null)
				if (show_reply.equalsIgnoreCase("yes")) {

					%>
<form action="postReply.do?topic_id=<%=topicObj.getTopic_id()%>"
	" name="frmReply" id="frmReply" method="post">
<table width="200" border="0">
	<tr>
		<td><span class="style33"><b>Post your Message</b></span>:</td>
	</tr>
	<tr>
		<td><textarea name="reply" cols="70" rows="5"></textarea>&nbsp;</td>
	</tr>
	<tr>
		<td><input type="hidden" name="category" value="<%= topicObj.getCategory()%>"/>&nbsp;
		<input name="submit" type="submit" value="Submit" /> &nbsp; <input
			name="clear" type="reset" /> <span class="style32"><a
			href="detailTopic.do?reply_id=0&t_id=<%=topicObj.getTopic_id()%>&category=<%=topicObj.getCategory()%>">Hide</a></span></td>
	</tr>

</table>
<hr size="2" color="#330099" />


</form>

<%}
			if (repliesList != null) {
				java.util.Iterator repliesItr = repliesList.iterator();

				while (repliesItr.hasNext()) {
					cts.domain.TopicReply topicReply = (cts.domain.TopicReply) repliesItr
							.next();

					%>

<form action="" method="get" enctype="application/x-www-form-urlencoded">
<table id="results">

	<tr>
		<td width="291"><FONT COLOR=#3333CC FACE="Geneva, Arial" SIZE=2><%=topicReply.getReplied_user().getName()%></FONT>
		| <font color="#336633" FACE="Arial" size="1""><%=HibernateUtil.dateConvertor2(topicReply
									.getLast_posted().toString())%></font>
		</td>
	</tr>
	<tr>
		<td>&gt;<%=topicReply.getReply()%></td>
	</tr>


</table>

<%}
			}%>
<div id="pageNavPosition"></div>

</form>

<a href="backPage.do?category=<%=topicObj.getCategory() %>">Back</a>

<script type="text/javascript">
        var pager = new Pager('results', 1); 
        pager.init(); 
        pager.showPageNav('pager', 'pageNavPosition'); 
        pager.showPage(1);
   </script>