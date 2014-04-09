<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<%@page import="java.util.List"%>

<head>
<script language="javascript">

	function validate(){
	//alert("hi");
	var category=document.frmTopic.categoryList.value;
	var topic=document.frmTopic.topic.value;
	var message=document.frmTopic.message.value;
	
	if(category=="" | category==null)
	{
	alert("Please select the category");
	return false;
	
	}
	if(topic=="" | topic==null)
	{
	alert("Please enter the topic");
	return false;
	
	}
	if(message=="" | message==null)
	{
	alert("Please enter the message");
	return false;
	
	}
	return true;
	
	}



</script>

</head>


<form id="frmTopic" name="frmTopic" action="postTopic.do" method="post" onsubmit="return validate();">
<table width="416" border="0">
	<tr>
		<td bgcolor="#FFFFFF">&nbsp;</td>
		<td>&nbsp;</td>
		<td><span ><a
			href="all_categories.do?category_id=1&discussion_id=1 "><font
			size="2" color="#FF66FF" face="arial"> start a new discussion</font></a>
		| </span>
		
		<span ><a
			href="searchtopic.do?category_id=0"><font
			size="2" color="#FF66FF" face="arial"> Search</font></a>
		 </span>
		
		
		 </td>
	</tr>
	<%String show = (String) request.getAttribute("show");

			if (show != null)
				if (show.equalsIgnoreCase("yes")) {

				%>
	<tr>
		<td width="58" bgcolor="#FFFFFF"><span class="style33">category</span></td>
		<td width="4"><strong>:</strong></td>
		<td width="332"><select name="categoryList">
			<option value="general" SELECTED>General</option>
			<option value="housing">Housing</option>
			<option value="byesell">Bye/Sell</option>
			<option value="technical">Technical Issue</option>
		</select>&nbsp;</td>
	</tr>
	<tr>
		<td bgcolor="#FFFFFF"><span class="style33">Topic</span></td>
		<td><strong>:</strong></td>
		<td><input name="topic" type="text" size="50" maxlength="100" />&nbsp;
		<input type="hidden" name="general" value="0" /></td>
	</tr>
	<tr>
		<td bgcolor="#FFFFFF"><span class="style33">Message</span></td>
		<td><strong>:</strong></td>
		<td>
		
		<textarea name="message" style='width:250px;height=50px;' maxlength="30"></textarea>
		&nbsp;</td>
	</tr>

	<tr>
		<td bgcolor="#FFFFFF">&nbsp;</td>
		<td>&nbsp;</td>
		<td><input name="Submit" type="submit" value="Submit" /> &nbsp; <input
			name="Clear" type="reset" value="Clear" /> &nbsp;&nbsp;&nbsp;&nbsp;<a
			href="all_categories.do?category_id=1&discussion_id=0">Hide</a></td>
	</tr>
	<%}

			%>
</table>
</form>

 <%
            
            String search=(String)request.getAttribute("search");
            
            	if(search!=null)
            	if(search.equalsIgnoreCase("yes")){
            %>
 <form id="searchtopic" name="searchtopic" action="searchtopic.do?category_id=0&search_id=0" method="post" >  
    <table style="width: 498px">
        <tr>
            <td style="width: 94px; height: 21px">
                Topic:</td>
            <td style="width: 289px; height: 21px">
                <input name="topic" type="text" size="40" maxlength="100" />&nbsp;</td>
             </tr>
              <td style="width: 94px; height: 27px;">
                Posted By:</td>
            <td style="width: 289px; height: 27px;">
                <input name="postedby" type="text" size="15" maxlength="100" />&nbsp;</td>
            <td style="height: 27px">
            </td>
         <tr>
            <td style="width: 94px; height: 23px;">
                Started Date:</td>
            <td style="width: 289px; height: 23px;">
                <input name="startedDate" type="text" size="8" maxlength="100" /> <img src="images/calendar.gif" alt="Calender" width="30" height="30" align="absmiddle"  onclick="popUpCalendar(this, document.searchtopic.startedDate, 'mm/dd/yyyy', -195, 0)" />
                &nbsp;</td>
                
            <td style="height: 23px">
            </td>
        </tr>
        <tr>
            <td style="width: 94px">
            </td>
            <td style="width: 289px">
                <input id="bt_search" type="submit" value="Search" " />
                &nbsp;&nbsp;
                <input id="bt_search_clr" type="button" value="Clear" name="bt_search_clr" />
                &nbsp;&nbsp; <a href="searchtopic.do?category_id=0&hide=0" >Hide</a></td>
            <td>
            </td>
        </tr>
       
    </table>
    </form>
  <%} %>






<%
List topicList = (List) request.getAttribute("topicList");

%>
			
<display:table class="gradiant" name="topicList" id="row"
	excludedParams="*" cellpadding="6" cellspacing="0" export="false"
	sort="list" pagesize="2" requestURI="all_categories.do?category_id=0"
	style="width:100%">

	<display:column property="topic_name"
		href="detailTopic.do?category_id=0" paramId="t_id"
		paramProperty="topic_id" scope="request" title="Topic" sortable="true"
		style="width: 250px;text-align: left;" maxLength="20"/>

	<display:column property="user.name" title="Posted by" sortable="true"
		style="width: 100px;text-align: center;" />

	<display:column property="repliesSize" title="Posts" sortable="true"
		style="width: 50px;text-align: center;" />

	<display:column property="lastDate" title="Last Post" sortable="true"
		style="width: 100px;text-align: center;" />

	<display:column property="strDate" title="Started Date" sortable="true"
		style="width: 120px;text-align: center;" />


</display:table>

