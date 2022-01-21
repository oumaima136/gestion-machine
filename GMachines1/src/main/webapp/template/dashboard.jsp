<%@page import="beans.Marque"%>
<%@page import="service.MarqueService"%>
<div class="main-panel">
	<div class="content-wrapper">
		<div class="col-sm-12 mb-4 mb-xl-0">
			<h4 class="font-weight-bold text-dark">Hi, welcome back!</h4>
		</div>
		<div class="row mt-3">
			<div class="col-lg-6 grid-margin stretch-card">
				<div class="card">
					<div class="card-body">
						<div class="chartjs-size-monitor">
							<div class="chartjs-size-monitor-expand">
								<div class=""></div>
							</div>
							<div class="chartjs-size-monitor-shrink">
								<div class=""></div>
							</div>
						</div>
						<h4 class="card-title">nombre de d'achat par marque</h4>
						<canvas id="barChart"
							style="display: block; height: 12px; width: 24px;" width="30"
							height="15" class="chartjs-render-monitor"></canvas>
					</div>
				</div>
			</div>
			<div class="col-lg-6 grid-margin grid-margin-lg-0 stretch-card">
				<div class="card">
					<div class="card-body">
						<div class="chartjs-size-monitor">
							<div class="chartjs-size-monitor-expand">
								<div class=""></div>
							</div>
							<div class="chartjs-size-monitor-shrink">
								<div class=""></div>
							</div>
						</div>
						<h4 class="card-title">les 5 premiers marques achetés</h4>
						<canvas id="pieChart" width="371" height="185"
							style="display: block; height: 148px; width: 297px;"
							class="chartjs-render-monitor"></canvas>
					</div>
				</div>
			</div>

		</div>
		<div class="row mt-3">
			<div class="col-6 grid-margin stretch-card">

				<div class="card">
					<div class="card-body">
						<h4 class="card-title">nombre d'achat d'une marque par mois</h4>
						<form class="form-sample" method="POST" id="form">
							<div class="col-md-6">
								<div class="form-group row">

									<label class="col-sm-3 col-form-label">Marque</label>
									<div class="col-sm-9">
										<select class="form-control" id="select">

											<%
											MarqueService mrs = new MarqueService();
											for (Marque m : mrs.findAll()) {
											%>
											<option name="marque" id="marque"><%=m.getLibelle()%></option>
											<%
											}
											%>
										</select>

									</div>
									<button type="button"
										class="btn btn-outline-primary btn-icon-text" id="add">
										<i class="mdi mdi-file-check btn-icon-prepend"></i> Submit
									</button>
								</div>

							</div>
						</form>
						<div class="chartjs-size-monitor">
							<div class="chartjs-size-monitor-expand">
								<div class=""></div>
							</div>
							<div class="chartjs-size-monitor-shrink">
								<div class=""></div>
							</div>
						</div>

						<canvas id="lineChart" width="371" height="185"
							style="display: block; height: 148px; width: 297px;"
							class="chartjs-render-monitor" hidden="true"></canvas>
					</div>
				</div>
			</div>

		</div>


	</div>
</div>


