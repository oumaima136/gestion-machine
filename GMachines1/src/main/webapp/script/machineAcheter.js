$(document).ready(function () {
    $.ajax({
        success: function (data, textStatus, jqXHR) {
        }
    });
	
    $("#add").click(function() {
		var date1 = $("#dateAchat").val();
		var date2 = $("#dateAchat1").val();
		$.ajax({
			url: "machineAcheterController",
			data: { date1 : date1 , date2 : date2 },
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
            ligne += "<tr><td>" + data[i].id + "</td><td>" + data[i].reference + "</td><td>" + data[i].dateAchat + "</td><td>" + data[i].prix + "</td><td>" + data[i].marque.libelle + "</td></tr>";
        }
        $("#content").html(ligne);
    }

});