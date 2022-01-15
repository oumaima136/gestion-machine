<nav class="sidebar sidebar-offcanvas" id="sidebar">
	<div class="user-profile">
		<div class="user-image">
			<a href="./Profile.jsp"><img src="style/images/faces/face28.png"></a>
		</div>
		<div class="user-name">${nom}</div>

		<div class="user-designation">
			<% if((boolean) session.getAttribute("type")==true){%>Super User<%} else{%>User<%} %>
		</div>
	</div>
	<ul class="nav">
		<li class="nav-item"><a class="nav-link" href="./machines.jsp">
				<i class="icon-box menu-icon"></i> <span class="menu-title">Dashboard</span>
		</a></li>
		<li class="nav-item"><a class="nav-link"
			href="./gestion_machine.jsp"> <i class="icon-file menu-icon"></i>
				<span class="menu-title">Gestion de machines</span>
		</a></li>
		<li class="nav-item"><a class="nav-link"
			href="./gestion_marque.jsp"> <i class="icon-pie-graph menu-icon"></i>
				<span class="menu-title">Gestion de marques</span>
		</a></li>
		<li class="nav-item"><a class="nav-link"
			href="./machineAcheter.jsp"> <i class="icon-command menu-icon"></i>
				<span class="menu-title">Machines achetés</span>
		</a></li>
		<li class="nav-item"><a class="nav-link"
			href="./machineParMarque.jsp"> <i class="icon-help menu-icon"></i>
				<span class="menu-title">Machines par marque</span>
		</a></li>
		<% if((boolean) session.getAttribute("type")==true){%>
		<li class="nav-item"><a class="nav-link"
			href="./GestionUtilisateur.jsp"> <i class="icon-help menu-icon"></i>
				<span class="menu-title">Gestion Utilisateur</span>
		</a></li>
		<%}%>


	</ul>
</nav>