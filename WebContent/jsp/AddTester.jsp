<%@page import="com.utils.Constant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Project</title>
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
								<div class="col-md-6 col-sm-6 col-xs-12">
									<form method="post" action="../AddTester">
										<div class="form-group ">
											<label class="control-label requiredField" for="txtName">
												Tester Name <span class="asteriskField"> * </span>
											</label> <input required="true" class="form-control" id="txtName" name="txtName"
												placeholder="Enter Employee Name" type="text"  /> <span
												class="help-block" id="hint_txtName"> Shekhar </span>
										</div>
										<div class="form-group ">
											<label class="control-label requiredField" for="txtEmail">
												Tester Email<span class="asteriskField"> * </span>
											</label> <input required="true" class="form-control"  id="txtEmail" name="txtEmail"
												placeholder="Enter Employee Email" type="email"  /> <span
												class="help-block" id="hint_txtName"> Shekhar@bughunt.com </span>
										</div>
										<div class="form-group ">
											<label class="control-label requiredField" for="txtTech">
												Technology <span class="asteriskField"> * </span>
											</label> <input required="true" class="form-control" id="txtTech" name="txtTech"
												placeholder="Enter technology names" type="text" /> <span
												class="help-block" id="hint_txtEmail"> Java, Mysql </span>
										</div>
										<div class="form-group ">
											<label class="control-label requiredField" for="txtPass">
												Experiance <span class="asteriskField"> * </span>
											</label> <input required="true" class="form-control" id="txtExp" name="txtExp"
												placeholder="Enter Exp" type="text" /> <span
												class="help-block" id="hint_txtExp">  </span>
										</div>
										<div class="form-group ">
										<label class="control-label requiredField" for="txtTeam">
											Team <span class="asteriskField"> * </span>
										</label> <select id="txtTeam" name="txtTeam" tabindex="2"
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
											<label class="control-label requiredField" for="txtPass">
												Password <span class="asteriskField"> * </span>
											</label> <input required="true" class="form-control" id="txtPAss" name="txtPass"
												placeholder="Enter Password" type="password" /> <span
												class="help-block" id="hint_txtExp">  </span>
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
	</div>
</body>
</html>