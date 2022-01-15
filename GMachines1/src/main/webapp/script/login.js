$(document).ready(function() {
	var idU = $("#idU").val();
	$.ajax({
		url: "UserController",
		data: { op: "load", idU: idU },
		type: 'POST',
		success: function(data, textStatus, jqXHR) {
			remplir(data);
		}
	});

	$("#add").click(function() {

		$("#message").attr("hidden", true);

		var nom = $("#nom").val();
		var email = $("#email").val();
		var mdp = $("#mdp").val();
		var id = $("#id").val();
		var idU = $("#idU").val();
		var type = $('input#sAdmin').prop('checked');
		var sexe = ($("#select option:selected").text());
		$.ajax({
			url: "UserController",
			data: { nom: nom, email: email, mdp: mdp, sexe: sexe, type: type, id: id, idU: idU  },
			type: 'POST',
			success: function(data, textStatus, jqXHR) {
				if (data.type ==  "0") {
					("#message").attr("hidden", false);
					remplirUser(data);
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
		$("#nom").val("");
		$("#email").val("");
		$("#mdp").val("");
		$("#sexe").val("");
		$("#sAdmin").prop('checked', false);

	});

	$("#register").click(function() {
		var nom = $("#nom").val();
		var email = $("#email").val();
		var mdp = $("#mdp").val();
		var sexe = ($("#select option:selected").text());
		if (nom == "" || email == "" || mdp == "" || sexe == "")  {
			$("#message").attr("hidden", false);
			$("#message2").attr("hidden", true);
		} else {
			$.ajax({
				url: "UserController",
				data: { op: "register", nom: nom, email: email, mdp: mdp, sexe: sexe },
				type: 'POST',
				success: function(data, textStatus, jqXHR) {
					if (data !=  "0") {

				$("#message2").attr("hidden", false);
				$("#message").attr("hidden", true);
			}
			else {
				window.location = "Login.jsp";

			}

		},
		error: function(jqXHR, textStatus, errorThrown) {
			console.log(textStatus);
		}
	});
}


	});

$("#login").click(function() {

	var email = $("#email").val();

	var mdp = $("#mdp").val();
	$.ajax({
		url: "UserController",
		data: { email: email, mdp: mdp, op: "connex" },
		type: 'POST',
		success: function(data, textStatus, jqXHR) {

			if (data != "01") {
				$("#message").attr("hidden",  false);
			} else {

				window.replace = "machines.jsp";
			}
		},
		error: function(jqXHR, textStatus, errorThrown) {
			console.log(textStatus);
		}
	});
	$("#email").val("");
});
$("#tableContent").on('click', '#delete', function() {

	$.ajax({
		url: "UserController",
		data: { op: "delete", id: $(this).attr('indice') },
		type: 'POST',
		success: function(data, textStatus, jqXHR) {
			remplir(data);
		},
		error: function(jqXHR, textStatus, errorThrown) {
			console.log(textStatus);
		}
	});

});

$("#tableContent").on('click', '#update', function() {

	var val = $(this).attr('indice6');
	$("#id").val(($(this).attr('indice1')));
	$("#nom").val(($(this).attr('indice2')));
	$("#email").val(($(this).attr('indice3')));
	$("#mdp").val(($(this).attr('indice4')));
	$("#select").val(($(this).attr('indice5')));
	if (val  === ('true')) {
	$("#sAdmin").prop('checked', true);
}
		else if (val === ('false')) {
	$("#sAdmin").prop('checked', false);
}

	});

function remplir(data) {
	var ligne = "";
	for (var i = 0; i < data.length; i++) {
		ligne += "<tr><td>" + data[i].id + "</td><td>" + data[i].nom + "</td><td>" + data[i].email + "</td><td>" + data[i].mdp + "</td> <td>" + data[i].sexe + "</td><td>" + data[i].type + "</td><td><button type=\"button\" indice1=\"" + data[i].id + "\" indice2=\"" + data[i].nom + "\" indice3=\"" + data[i].email + "\" indice4=\"" + data[i].mdp + "\" indice5=\"" + data[i].sexe + "\" indice6=\"" + data[i].type + "\" class=\"btn btn-outline-secondary btn-icon-text\" id=\"update\">Modifier</button> </td> <td><button indice=\"" + data[i].id + "\"  type=\"button\" class=\"btn btn-primary supprimer\" id=\"delete\"> Supprimer</button></td></tr>";
	}
	$("#listeUsers").html(ligne);
}

function remplirUser(data) {
	var ligne = "";
	for (var i = 0; i < data.machine.length; i++) {
		ligne += "<tr id=\"ligne" + i + "\"><td class=\"py-1\ id=\"id\">" + data.machine[i].id + "</td><td>" + data.machine[i].nom + "</td><td>" + data.machine[i].email + "</td><td>" + data.machine[i].mdp + "</td><td>" + data.machine[i].sexe + "</td><td>" + data.machine[i].type + "</td><td><button type=\"button\" indice1=\"" + data.machine[i].id + "\" indice2=\"" + data.machine[i].reference + "\" indice3=\"" + data.machine[i].dateAchat + "\" indice4=\"" + data.machine[i].prix + "\" indice5=\"" + data.machine[i].marque.libelle + "\" class=\"btn btn-primary modifier\" id=\"update\">Modifier</button>  <button indice=\"" + data.machine[i].id + "\"  type=\"button\" class=\"btn btn-primary supprimer\" id=\"delete\"> Supprimer</button></td><td></tr>";
	}
	$("#listeMachine").html(ligne);
}
});