
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
<style>
.font {
	color: red;
	font-family: cambria;
	font-weight: bold;
}
</style>
<script type="text/javascript">
function Checklogout(){
	if(document.cookie !=('')){
		window.history.forward();
	}
    
} </script>
<body id="main" onload="Checklogout()">
<body>
	<div class="container-scroller">
		<div class="container-fluid page-body-wrapper full-page-wrapper">
			<div
				class="content-wrapper d-flex align-items-stretch auth auth-img-bg">
				<div class="row flex-grow">
					<div
						class="col-lg-6 d-flex align-items-center justify-content-center">
						<div class="auth-form-transparent text-left p-3">
							<div class="brand-logo">
								<img src="style/images/logo-dark.svg" alt="logo">
							</div>
							<h4>Welcome back!</h4>
							<h6 class="font-weight-light">Happy to see you again!</h6>
							<h5 class="font-weight-light font" hidden="true" id="message">
								Email/Mot de passe incorrecte</h5>
							<form class="pt-3" action="LoginController" method="POST">
								<div class="form-group">
									<label for="exampleInputEmail">Username</label>
									<div class="input-group">
										<div class="input-group-prepend bg-transparent">
											<span class="input-group-text bg-transparent border-right-0">
												<i class="mdi mdi-account-outline text-primary"></i>
											</span>
										</div>
										<input type="email" name="email"
											class="form-control form-control-lg border-left-0" id="email"
											placeholder="Username" required>
									</div>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword">Password</label>
									<div class="input-group">
										<div class="input-group-prepend bg-transparent">
											<span class="input-group-text bg-transparent border-right-0">
												<i class="mdi mdi-lock-outline text-primary"></i>
											</span>
										</div>
										<input type="password" name="mdp"
											class="form-control form-control-lg border-left-0" id="mdp"
											placeholder="Password" required>
									</div>
								</div>

								<div class="my-3">
									<button type="submit"
										class="btn btn-block btn-info btn-lg font-weight-medium auth-form-btn"
										id="login">LOGIN</button>
								</div>
								<div class="text-center mt-4 font-weight-light">
									Don't have an account? <a href="Register.jsp"
										class="text-primary">Create</a>
								</div>
							</form>
						</div>
					</div>
					<div class="col-lg-6 login-half-bg d-flex flex-row">
						<p
							class="text-white font-weight-medium text-center flex-grow align-self-end">Copyright
							&copy; 2020 All rights reserved.</p>
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

