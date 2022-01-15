
$(document).ready(function() {
	$.ajax({
		url: "MachineParMarqueController",
		data: { op: "load" },
		type: 'POST',
		success: function(data, textStatus, jqXHR) {
			remplir(data);
		},
		error: function(jqXHR, textStatus, errorThrown) {

			console.log(textStatus);
		}
	});
	$("#form").on('click', '#add', function() {
		var marque = ($("#select option:selected").text());
		$.ajax({
			url: "MachineParMarqueController",
			data: { marque: marque, op: "add" },
			type: 'POST',
			success: function(data, textStatus, jqXHR) {
		
				remplir(data);

			},
			error: function(jqXHR, textStatus, errorThrown) {

				console.log(textStatus);
			}
		});


	});


	function remplir(data) {
		var ligne = "";
		for (var i = 0; i < data.length; i++) {
			ligne += "<tr id=\"ligne" + i + "\"><td class=\"py-1\ id=\"id\">" + data[i].id + "</td><td>" + data[i].reference + "</td><td>" + data[i].dateAchat + "</td><td>" + data[i].prix + "</td><td>" + data[i].marque.libelle + "</td></tr>";
		}
		$("#content").html(ligne);

	}


}
);



