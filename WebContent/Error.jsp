<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<title>Error</title>
</head>
<body>
	Ha ocurrido un error en la aplicacion:
	<%=exception.getMessage()%>
	
	Error interno:
	<%=exception.getMessage()%>
</body>
</html>