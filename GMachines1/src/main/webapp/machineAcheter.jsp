<%@page import="beans.Marque"%>
<%@page import="service.MarqueService"%>
<%@page import="beans.Machine"%>
<%@page import="service.MachineService"%>
<%@page import="controller.MachineController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Regal Admin</title>
<!-- base:css -->
<link rel="stylesheet"
	href="style/vendors/mdi/css/materialdesignicons.min.css">
<link rel="stylesheet" href="style/vendors/feather/feather.css">
<link rel="stylesheet" href="style/vendors/base/vendor.bundle.base.css">
<!-- endinject -->
<!-- plugin css for this page -->
<link rel="stylesheet"
	href="style/vendors/flag-icon-css/css/flag-icon.min.css" />
<link rel="stylesheet"
	href="style/vendors/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="style/vendors/jquery-bar-rating/fontawesome-stars-o.css">
<link rel="stylesheet"
	href="style/vendors/jquery-bar-rating/fontawesome-stars.css">
<!-- End plugin css for this page -->
<!-- inject:css -->
<link rel="stylesheet" href="style/css/style.css">
<!-- endinject -->
<link rel="shortcut icon" href="style/images/favicon.png" />

<title>Insert title here</title>
</head>
<script type="text/javascript">
function Checklogout(){

	if(document.cookie ===('')){
		window.location = "Login.jsp";
	}
    
} </script>
<body id="main" onload="Checklogout()">
<body id="main">
	<div class="container-scroller">
		<header>
			<%@include file="template/Header.jsp"%>
		</header>
		<div class="container-fluid page-body-wrapper">
			<%@include file="template/menu.jsp"%>
			<div class="main-panel">
				<div class="content-wrapper">
					<div class="row">
						<div class="col-12 grid-margin">
							<div class="card">
								<div class="card-body">
									<h4 class="card-title">Machine Achetée</h4>
									<form class="form-sample" method="POST" id="form">
										<div class="row">
											<div class="col-md-6">
												<div class="form-group row">
													<label class="col-sm-3 col-form-label">Premiere
														Date</label>
													<div class="col-sm-9">
														<input class="form-control" required type="date"
															name="dateAchat" id="dateAchat"
															value="<%=request.getParameter("dateAchat") == null ? "" : request.getParameter("dateAchat")%>">
													</div>
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group row">
													<label class="col-sm-3 col-form-label">Deuxieme
														Date</label>
													<div class="col-sm-9">
														<input class="form-control" required type="date"
															name="dateAchat" id="dateAchat1"
															value="<%=request.getParameter("dateAchat") == null ? "" : request.getParameter("dateAchat")%>">
													</div>
												</div>
											</div>
										</div>

										<button type="button"
											class="btn btn-outline-primary btn-icon-text" id="add">
											<i class="mdi mdi-file-check btn-icon-prepend"></i> Submit
										</button>
									</form>
								</div>
							</div>
						</div>
						<div class="col-12 grid-margin">
							<div class="card">
								<div class="card-body">
									<h4 class="card-title">Liste des machines</h4>
									<p class="card-description"></p>
									<div class="table-responsive">
										<table class="table table-striped" id="table_cont">
											<thead>
												<tr>
													<th>Id</th>
													<th>Références</th>
													<th>Date Achat</th>
													<th>Prix</th>
													<th>Marque</th>

												</tr>
											</thead>
											<tbody id="content">
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>

					</div>

				</div>
			</div>
		</div>
	</div>
	<!-- base:js -->
	<script src="style/vendors/base/vendor.bundle.base.js" defer></script>
	<!-- endinject -->
	<!-- Plugin js for this page-->
	<!-- End plugin js for this page-->
	<!-- inject:js -->
	<script src="script/js/off-canvas.js" defer></script>
	<script src="script/js/hoverable-collapse.js" defer></script>
	<script src="script/js/template.js" defer></script>
	<!-- endinject -->
	<!-- plugin js for this page -->
	<script src="style/vendors/chart.js/Chart.min.js" defer></script>
	<script src="style/vendors/jquery-bar-rating/jquery.barrating.min.js"
		defer></script>
	<!-- End plugin js for this page -->
	<!-- Custom js for this page-->
	<script src="script/js/dashboard.js" defer></script>
	<script src="script/jquery-3.3.1.min.js" type="text/javascript" defer></script>
	<script src="script/machineAcheter.js" type="text/javascript" defer></script>
	<!-- End custom js for this page-->
</body>
</html>
