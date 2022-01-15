

$(document).ready(function() {
	$.ajax({
		url: "MarqueController",
		data: { op: "load" },
		type: 'POST',
		success: function(data, textStatus, jqXHR) {

			remplir(data);
		},
		error: function(jqXHR, textStatus, errorThrown) {

			console.log(textStatus);
		}
	});
	$("#add").click(function() {
		$("#message").attr("hidden", true);
		var id = $("#id").val();
		var code = $("#code").val();
		var libelle = $("#libelle").val();
		$.ajax({
			url: "MarqueController",
			data: { code: code, libelle: libelle, id: id },
			type: 'POST',
			success: function(data, textStatus, jqXHR) {
				console.log(data);
				if (data.type == "0") {
					$("#message").attr("hidden", false);
					remplirMarque(data);
				}
				else {
					remplir(data);
				}
			},
			error: function(jqXHR, textStatus, errorThrown) {
				console.log(textStatus);
			}
		});
		$("#id").val("");
		$("#code").val("");
		$("#libelle").val("");

	});
	$("#table_cont").on('click', '#supp', function() {
		$.ajax({
			url: "MarqueController",
			data: { op: "delete", id: ($(this).attr('indice')) },
			type: 'POST',
			success: function(data, textStatus, jqXHR) {
				remplir(data);
			},
			error: function(jqXHR, textStatus, errorThrown) {
				console.log(textStatus);
			}
		});

	});

	$("#table_cont").on('click', '#mod', function() {
		$.ajax({
			url: "MarqueController",
			data: { id: ($(this).attr('indice')), op: "update" },
			type: 'POST',
			success: function(data, textStatus, jqXHR) {

				$("#main").html(data);
			},
			error: function(jqXHR, textStatus, errorThrown) {
				console.log(textStatus);
			}
		});


	});

	$("#reset").click(function() {
		$("#id").val("");
		$("#code").val("");
		$("#libelle").val("");

	});

	function remplir(data) {
		var ligne = "";
		for (var i = 0; i < data.length; i++) {
			ligne += "<tr id=\"ligne" + i + "\"><td class=\"py-1\ id=\"id\">" + data[i].id + "</td><td>" + data[i].code + "</td><td>" + data[i].libelle + "</td><td><button indice=\"" + data[i].id + "\" type=\"button\" class=\"btn btn-outline-primary btn-icon-text\" id=\"supp\"><i class=\"mdi mdi-file-check btn-icon-prepend\"></i> Supprimer</button></td><td><button type=\"button\" indice=\"" + data[i].id + "\"  class=\"btn btn-outline-secondary btn-icon-text\" id=\"mod\"><i class=\"mdi mdi-file-check btn-icon-append\"></i>Modifier</button></td></tr>";
		}
		$("#content").html(ligne);
	}

	function remplirMarque(data) {
		var ligne = "";
		for (var i = 0; i < data.machine.length; i++) {
			ligne += "<tr id=\"ligne" + i + "\"><td class=\"py-1\ id=\"id\">" + data.machine[i].id + "</td><td>" + data.machine[i].code + "</td><td><button type=\"button\" indice=\"" + data.machine[i].id + "\" indice2=\"" + data.machine[i].reference + "\" indice3=\"" + data.machine[i].dateAchat + "\" indice4=\"" + data.machine[i].prix + "\" indice5=\"" + data.machine[i].marque.libelle + "\" class=\"btn btn-primary modifier\" id=\"update\">Modifier</button>  <button indice=\"" + data.machine[i].id + "\"  type=\"button\" class=\"btn btn-primary supprimer\" id=\"delete\"> Supprimer</button></td><td></tr>";
		}
		$("#listeMachine").html(ligne);
	}

});

