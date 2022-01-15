
<%@page import="beans.Marque"%>
<%@page import="service.MarqueService"%>
<%@page import="beans.Machine"%>
<%@page import="service.MachineService"%>
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
<title>Insert title here</title>
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
	function Checklogout() {
		console.log(document.cookie)
		if (document.cookie === ('')) {
			window.location = "Login.jsp";
		}

	}
</script>
<body id="main" onload="Checklogout()">
	<div class="container-scroller">
		<header>
			<%@include file="template/Header.jsp"%>
		</header>
		<div class="container-fluid page-body-wrapper">
			<%@include file="template/menu.jsp"%>
			<div class="main-panel">
				<div class="content-wrapper">
					<div class="page-header">
						<h3 class="page-title">Gestion des Utilisateurs</h3>
					</div>
					<div class="row">
						<div class="col-lg-12 grid-margin stretch-card">
							<div class="card">
								<div class="card-body">
									<div class="table-responsive">
										<table class="table table-striped" id="tableContent">
											<thead>
												<tr>
													<th>id</th>
													<th>Nom</th>
													<th>E-mail</th>
													<th>Mot de Passe</th>
													<th>Sexe</th>
													<th>Super Admin</th>
													<th>Modifier</th>
													<th>Supprimer</th>

												</tr>
											</thead>
											<tbody id="listeUsers">
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
						<div class="col-12 grid-margin stretch-card">
							<div class="card">
								<div class="card-body">
									<h5 class="font-weight-light font" hidden="true" id="message">Erreur
										de Saisie !!!!! Email déjà Existant!!!</h5>
									<form class="forms-sample" id="form">
										<input type="hidden" name="id" id="id"
											value="<%=request.getParameter("id") == null ? "" : request.getParameter("id")%>"
											size="id" /> <input type="hidden" name="idU" id="idU"
											value="${id}" size="id" />
										<div class="form-group">
											<label for="exampleInputName1">Nom</label> <input type="text"
												class="form-control" id="nom" placeholder="Name"
												value="<%=request.getParameter("nom") == null ? "" : request.getParameter("nom")%>"
												required>
										</div>
										<div class="form-group">
											<label for="exampleInputEmail3">Email </label> <input
												type="email" class="form-control" id="email"
												placeholder="Email"
												value="<%=request.getParameter("email") == null ? "" : request.getParameter("email")%>"
												required>
										</div>
										<div class="form-group">
											<label for="exampleInputPassword4">Mot de passe</label> <input
												type="password" class="form-control" id="mdp"
												placeholder="Password"
												value="<%=request.getParameter("mdp") == null ? "" : request.getParameter("mdp")%>"
												required>
										</div>
										<div class="form-group">
											<label for="exampleSelectGender">Sexe</label> <select
												class="form-control" required id="select">
												<option>Homme</option>
												<option>Femme</option>
											</select>
										</div>
										<div class="form-group">
											<label for="exampleSelectGender">Super Admin</label> <br>
											<input class="form-check-label" type="checkbox" id="sAdmin"
												value="<%=request.getParameter("sAdmin") == null ? "" : request.getParameter("sAdmin")%>"
												required>
										</div>
										<button type="submit" class="btn btn-primary mr-2" id="add">
											Ajouter Utilisateur</button>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- page-body-wrapper ends -->
			</div>
		</div>
	</div>
</body>
<!-- container-scroller -->
<script src="style/vendors/base/vendor.bundle.base.js"></script>
<!-- endinject -->
<!-- Plugin js for this page-->
<!-- End plugin js for this page-->
<!-- inject:js -->
<script src="script/js/off-canvas.js"></script>
<script src="script/js/hoverable-collapse.js"></script>
<script src="script/js/template.js"></script>
<script src="script/login.js"></script>
<!-- endinject -->
<!-- plugin js for this page -->
<script src="style/vendors/chart.js/Chart.min.js"></script>
<script src="style/vendors/jquery-bar-rating/jquery.barrating.min.js"></script>
</html>

