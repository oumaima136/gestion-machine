<!DOCTYPE html>
<html>
<head>
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
</head>
<style>
.font {
	color: red;
	font-family: cambria;
	font-weight: bold;
}
</style>
<script type="text/javascript">
function Checklogout(){
	if(document.cookie ===('')){
		window.location = "Login.jsp";
	}
    
} </script>
<body id="main" onload="Checklogout()">
<body>

	<div class="container-scroller">
		<header>
			<%@include file="template/Header.jsp"%>
		</header>
		<div class="container-fluid page-body-wrapper">
			<%@include file="template/menu.jsp"%>
			<div class="main-panel">
				<div class="content-wrapper">
					<div class="page-header">
						<h3 class="page-title">Profile</h3>
						<br />
						<h5 class="font-weight-light font" hidden="true" id="message">Erreur
							de Saisie !!!!! Email déjà Existant!!!</h5>
					</div>
					<div class="row">
						<div class="col-md-6 grid-margin stretch-card">
							<div class="card">
								<div class="card-body">
									<h4 class="card-title">Default form</h4>
									<p class="card-description">Basic form layout</p>
									<form class="forms-sample">
										<input type="text" hidden="true" class="form-control" id="id"
											value="${id}">

										<div class="form-group">
											<label for="exampleInputUsername1">Username</label> <input
												type="text" class="form-control" id="nom" value="${nom}">
										</div>
										<div class="form-group">
											<label for="exampleInputEmail1">Email address</label> <input
												type="email" class="form-control" id="email"
												value="${email}">
										</div>
										<div class="form-group">
											<label for="exampleInputPassword1">Password</label> <input
												type="password" class="form-control" id="mdp" value="${mdp}">
										</div>
										<div class="form-group">
											<label for="exampleInputPassword1">sexe</label> <input
												class="form-control" id="select" value="${sexe}" />
										</div>

										<button type="button" class="btn btn-primary mr-2" id="add">Submit</button>
										<button class="btn btn-light">Cancel</button>
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
<!-- base:js -->
<script src="style/vendors/base/vendor.bundle.base.js"></script>
<!-- endinject -->
<!-- Plugin js for this page-->
<!-- End plugin js for this page-->
<!-- inject:js -->
<script src="script/js/off-canvas.js"></script>
<script src="script/js/hoverable-collapse.js"></script>
<script src="script/js/template.js"></script>
<!-- endinject -->
<!-- plugin js for this page -->
<script src="style/vendors/chart.js/Chart.min.js"></script>
<script src="style/vendors/jquery-bar-rating/jquery.barrating.min.js"></script>
<!-- End plugin js for this page -->
<!-- Custom js for this page-->
<script src="script/js/dashboard.js"></script>
<!-- End custom js for this page-->
<script src="script/js/chart.js"></script>
<script src="script/profile.js"></script>
<!-- End custom js for this page-->
</html>
