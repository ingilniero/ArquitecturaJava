function validacion(){
		var isbn = document.getElementById("isbn");
		var miformulario = document.getElementById("miformulario");
		
		if(isbn.value == ""){
			alert("Datos no v�lidos.");
			return false;
		}else{
			miformulario.submit();
		}
	}