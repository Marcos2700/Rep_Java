<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="estilo.css">
<title>Registro</title>
</head>
<body>
<h1>Registro de usuario</h1>

<form method="post" action="Impresion.jsp">
	<div class="inputs">
	<label for="nombre">  Nombre  </label><br>
	<input type="text" id="nombre" name="nom"><br>
	</div>
	<div class="inputs">
	<label for="direccion">  Direccion  </label><br>
	<input type="text" id="dir" name="direc"><br>
	</div>
	<div class="inputs">
	<label for="password">  Contraseña  </label><br>
	<input type="password" id="pass" name="passw">
	</div>
	<div class="inputs">
	<label>Seleccione la provincia en la cual se encuentra</label><br>
	<select name="provincia" id="provincia">
		<option selected>Elija una opcion</option>
		<option value="Panama">Panama</option>
		<option value="Colon">Colon</option>
		<option value="Cocle">Cocle</option>
		<option value="Veraguas">Veraguas</option>
		<option value="Bocas del toro">Bocas del toro</option>
		<option value="Darien">Darien</option>
		<option value="Panama Oeste">Panama Oeste</option>
		<option value="Herrera">Herrera</option>
		<option value="Los Santos">Los Santos</option>
	</select>
	</div>
	<div class="inputs">
		<label>Seleccione las herramientas que maneja</label><br>
		<input type="checkbox" id="word" name="herr" value="MS Word">
			<label for="word">MS Word</label><br>
		<input type="checkbox" id="excel" name="herr" value="MS Excel">
			<label for="excel">MS Excel</label><br>
		<input type="checkbox" id="power" name="herr" value="MS Power">
			<label for="power">MS Power</label><br>
		<input type="checkbox" id="power" name="herr" value="MS Power Point">
			<label for="power">MS Power Point</label><br>
		<input type="checkbox" id="photo" name="herr" value="Photoshop">
			<label for="photo">Photoshop</label><br>
		<input type="checkbox" id="movie" name="herr" value="MS Movie Maker">
			<label for="movie">MS Movie Maker</label><br>
		<input type="checkbox" id="insc" name="herr" value="Inscape">
			<label for="insc">Inscape</label><br>
		<input type="checkbox" id="blender" name="herr" value="Blender">
			<label for="blender">Blender</label><br>
		<input type="checkbox" id="ws" name="herr" value="WireShark">
			<label for="ws">WireShark</label><br>
	</div>
	<br><br>
	<div class="botton">
		<input type="submit" value="Enviar">
	</div>
</form>
</body>
</html>