<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Impresion</title>
</head>
<body>
<h1>Imprimir resultados</h1>
<%	String nombre = request.getParameter("nom");
	String dir = request.getParameter("direc");
	String pass = request.getParameter("passw");
	String prov = request.getParameter("provincia");
	String[] her = request.getParameterValues("herr");
	%>
	
	<%out.println("Nombre: "+nombre);%><br><br>
	<%out.println("Direccion: "+dir);%><br><br>
	<%out.println("Contraseña: "+pass);%><br><br>
	<%out.println("Provincia: "+prov);%><br><br>
	<%out.println("herramientas:");
	for(int i=0; i<her.length; i++){
		out.println("<br>"+her[i]);
	}
	%>
</body>
</html>