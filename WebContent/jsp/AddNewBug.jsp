<%@page import="com.utils.Constant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Bug</title>
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
	<jsp:include page="../HTML/tester_menu.html"></jsp:include>


	<div id="page-wrapper">

		<div class="container-fluid">
			<div class="row">


				<!-- <form role="form">
						<div class="form-group">
							<label>Project Id</label> <input
								class="form-control" placeholder="Enter text">
						</div>
					</form> -->
				<div class="col-lg-6">
					<!-- HTML Form (wrapped in a .bootstrap-iso div) -->


					<div class="bootstrap-iso">
						<div class="container-fluid">
							<div class="row">

								<form method="post" action="../AddNewBugSlave">
									<div class="form-group ">
										<label class="control-label requiredField" for="txtName">
											Bug Description <span class="asteriskField"> * </span>
										</label>
										<textarea required="true" rows="3" class="form-control"
											id="txtDesc" name="txtDesc" placeholder="Enter Bug description"></textarea>
										<span class="help-block" id="hint_txtName">Color of
											tool bar is not fixed </span>
									</div>
									<div class="form-group ">
										<label class="control-label requiredField" for="txtEmail">
											Project Name<span class="asteriskField"> * </span>
										</label> Muzila Firefox
									</div>
									<div class="form-group ">
										<label class="control-label requiredField" for="txtEmail">
											Version <span class="asteriskField"> * </span>
										</label> 
										<select id="ver" name="ver" tabindex="2"
											placeholder="Category Name">
											<%
											String [] version = Constant.version;
												for (int i = 0; i < version.length; i++) {
											%>
											<option><%=version[i]%></option>
											<%
												}
											%>
										</select>
									</div>
									<div class="form-group ">
										<label class="control-label requiredField" for="txtTeam">
											Team <span class="asteriskField"> * </span>
										</label> <select id="team" name="team" tabindex="2"
											placeholder="">
											<%
											int [] team = Constant.team;
												for (int i = 0; i < team.length; i++) {
											%>
											<option><%=team[i]%></option>
											<%
												}
											%>
										</select>
										<span class="help-block" id="hint_txtTeam"> team - 2  </span>
									</div>
									<div class="form-group ">
										<label class="control-label requiredField" for="txtEmail">
											Bug State/Status <span class="asteriskField"> * </span>
										</label>  <select id="status" name="status" tabindex="2"
											placeholder="">
											<%
											int status []  = Constant.status;
												for (int i = 0; i < status.length; i++) {
											%>
											<option><%=status[i]%></option>
											<%
												}
											%>
										</select> <span
											class="help-block" id="hint_txtEmail"> 1. new bug,2. known bug,3. discussed bug, 4. all ready fixed</span>
									</div>
									<div class="form-group ">
										<label class="control-label requiredField" for="txtTeam">
										Operating System
										 <span class="asteriskField"> * </span>
										</label> <select id="os" name="os" tabindex="2"
											placeholder="Category Name">
											<%
											String [] os = Constant.os;
												for (int i = 0; i < os.length; i++) {
											%>
											<option><%=os[i]%></option>
											<%
												}
											%>
										</select>
										<span class="help-block" id="hint_txtTeam"> Windows, unix, Mac </span>
									</div>
									<div class="form-group ">
										<label class="control-label requiredField" for="txtTeam">
											Proarity <span class="asteriskField"> * </span>
										</label> <select id="pro" name="pro" tabindex="2"
											placeholder="">
											<%
											int [] pro = Constant.status;
												for (int i = 0; i < pro.length; i++) {
											%>
											<option><%=pro[i]%></option>
											<%
												}
											%>
										</select>
										<span class="help-block" id="hint_txtTeam">1 high, 2 mediam ,3 low , 4 no wary  </span>
									</div>
									
									<div class="form-group ">
										<label class="control-label requiredField" for="txtName">
										Expected Bug Reasion <span class="asteriskField"> * </span>
										</label>
										<textarea required="true" rows="3" class="form-control"
											id="txtReas" name="txtRes" placeholder="Expected Bug Reasion"></textarea>
										<span class="help-block" id="hint_txtName">Color of
											tool bar is not fixed, beacuse of old bug is come again </span>
									</div>
									
									<div class="form-group">
										<div>
											<button class="btn btn-primary " name="submit" type="submit">
												Submit</button>
										</div>
									</div>
								</form>
							</div>

						</div>
					</div>


				</div>

			</div>

		</div>
	</div>
</body>
</html>