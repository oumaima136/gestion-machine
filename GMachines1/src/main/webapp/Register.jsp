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
		window.location.forward();
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
							<h4>New here?</h4>
							<h6 class="font-weight-light">Join us today! It takes only
								few steps</h6>
							<h5 class="font-weight-light font" hidden="true" id="message">
								Veuillez Remplir tous les champs!</h5>
							<h5 class="font-weight-light font" hidden="true" id="message2">
								Utilisateur deja existant!</h5>
							<form class="pt-3">
								<div class="form-group">
									<label>Username</label>
									<div class="input-group">
										<div class="input-group-prepend bg-transparent">
											<span class="input-group-text bg-transparent border-right-0">
												<i class="mdi mdi-account-outline text-primary"></i>
											</span>
										</div>
										<input type="text"
											class="form-control form-control-lg border-left-0"
											placeholder="Username" id="nom">
									</div>
								</div>
								<div class="form-group">
									<label>Email</label>
									<div class="input-group">
										<div class="input-group-prepend bg-transparent">
											<span class="input-group-text bg-transparent border-right-0">
												<i class="mdi mdi-email-outline text-primary"></i>
											</span>
										</div>
										<input type="email"
											class="form-control form-control-lg border-left-0"
											placeholder="Email" id="email">
									</div>
								</div>
								<div class="form-group">
									<label>Country</label> <select
										class="form-control form-control-lg" id="select">
										<option>Femme</option>
										<option>Homme</option>
									</select>
								</div>
								<div class="form-group">
									<label>Password</label>
									<div class="input-group">
										<div class="input-group-prepend bg-transparent">
											<span class="input-group-text bg-transparent border-right-0">
												<i class="mdi mdi-lock-outline text-primary"></i>
											</span>
										</div>
										<input type="password"
											class="form-control form-control-lg border-left-0" id="mdp"
											placeholder="Password">
									</div>
								</div>
								<div class="mb-4">
									<div class="form-check"></div>
								</div>
								<div class="mt-3">
									<button type="button"
										class="btn btn-block btn-info btn-lg font-weight-medium auth-form-btn"
										id="register">SIGN UP</button>
								</div>
								<div class="text-center mt-4 font-weight-light">
									Already have an account? <a href="Login.jsp"
										class="text-primary">Login</a>
								</div>
							</form>
						</div>
					</div>
					<div class="col-lg-6 register-half-bg d-flex flex-row">
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
	<script src="script/login.js"></script>
	<!-- endinject -->
</body>

</html>