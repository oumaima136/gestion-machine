<!DOCTYPE html>
<html lang="en">

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
<!-- End plugin css for this page -->
<!-- inject:css -->
<link rel="stylesheet" href="style/css/style.css">
<!-- endinject -->
<link rel="shortcut icon" href="style/images/favicon.png" />
</head>

<script type="text/javascript">
function Checklogout(){
	if(document.cookie ===('')){
		window.location = "Login.jsp";
	}
    
} </script>
<body id="main" onload="Checklogout()">
	<div class="container-scroller">
		<div class="container-fluid page-body-wrapper full-page-wrapper">
			<div
				class="content-wrapper d-flex align-items-center auth lock-full-bg">
				<div class="row w-100">
					<div class="col-lg-4 mx-auto">
						<div class="auth-form-transparent text-left p-5 text-center">
							<img src="style/images/faces/face13.jpg" class="lock-profile-img"
								alt="img">
							<form class="pt-5"
								action="LockController?referer=<%= request.getHeader("referer") %>"
								method="POST">
								<div class="form-group">
									<label for="examplePassword1">${nom}</label> <input
										type="password" class="form-control text-center"
										id="examplePassword1" name="mdp" placeholder="Password">
								</div>
								<div class="mt-5">
									<button
										class="btn btn-block btn-info  btn-lg font-weight-medium"
										type="submit">Unlock</button>
								</div>
								<div class="mt-3 text-center">
									<a href="#" class="auth-link text-white">Sign in using a
										different account</a>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
			<!-- content-wrapper ends -->
		</div>
		<!-- page-body-wrapper ends -->
	</div>
	<!-- container-scroller -->
	<!-- base:js -->
	<script src="style/vendors/base/vendor.bundle.base.js"></script>
	<!-- endinject -->
	<!-- inject:js -->
	<script src="script/js/off-canvas.js"></script>
	<script src="script/js/hoverable-collapse.js"></script>
	<script src="script/js/template.js"></script>
	<!-- endinject -->
</body>

</html>