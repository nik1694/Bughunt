<%@page import="com.bean.BugBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.BugDao"%>
<%@page import="com.dao.ProjectDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tester Buges</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">



<!-- Bootstrap Core CSS -->
<link href="../css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="../css/sb-admin.css" rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="../css/plugins/morris.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<jsp:include page="../HTML/manager_menu.html"></jsp:include>


		<div id="page-wrapper">

			<div class="container-fluid">
			<%
		     BugDao dao = new BugDao();
			ArrayList<BugBean> buges = dao.getNewBuges() ;
			%>
			
			<table class="table">
				<tr>
					<th>Temp Bug ID</th>
					<th>OS</th>
					<th>Version</th>
					<th>Status</th>
					<th>Details</th>
					<th>Action</th>
				</tr>
				<%
					for (int i = 0; i < buges.size(); i++) {
				%>
				<tr>
					<td><%=buges.get(i).getId()%></td>
					<td><%=buges.get(i).getOs()%></td>
					<td><%=buges.get(i).getVsersion()%></td>
					<td><%=buges.get(i).getStatus()%></td>
					<td><%=buges.get(i).getBugDisc()%></td>
					<td><form action="../AssignBugToDeveloper" method="get"> <input type="submit" value="Assgin Developer" ><% 
					HttpSession httpSession = request.getSession();
					httpSession.setAttribute("bugbean", buges.get(i));
					%></form></td>
				</tr>
				<%
					}
				%>

			</table>
			</div>
		</div>
</body>
</html>