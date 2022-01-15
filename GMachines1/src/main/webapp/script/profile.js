

$(document).ready(function() {


$("#add").click(function() {
		$("#message").attr("hidden",true);
		var id = $("#id").val();
		var nom = $("#nom").val();
		var email = $("#email").val();
		var mdp = $("#mdp").val();
		var idU = $("#idU").val();
		var sexe = $("#sexe").val();
		$.ajax({
			url: "ProfileController",
			data: { id: id, nom:nom,email:email,mdp:mdp,idU : idU,sexe:sexe},
			type: 'POST',
			success: function(data, textStatus, jqXHR) {
				 if(data.type=="0"){
					$("#message").attr("hidden",false);
					remplirUser(data);
					console.log(data);
				}
				else{
					remplir(data);
				}
			},
			error: function(jqXHR, textStatus, errorThrown) {
				console.log(textStatus);
			}
		});

	});
	
	function remplir(data) {
		for(var i =0; i<data.length; i++){
			if(data[i].id == $("#id").val()){
		$("#id").val(data[i].id);
		$("#nom").val(data[i].nom);
		$("#mdp").val(data[i].mdp);
		$("#email").val(data[i].email);
		$("#sexe").val(data[i].sexe);
		break;
			}
		}
		
	}
	function remplirUser(data) {
		for(var i =0; i<data.length; i++){
			if(data[i].id == $("#id").val()){
				$("#id").val(data.machine[i].id);
				$("#nom").val(data.machine[i].nom);
				$("#mdp").val(data.machine[i].mdp);
				$("#email").val(data.machine[i].email);
				$("#sexe").val(data.machine[i].sexe);
				break;
			}
		}
		
	}

});

