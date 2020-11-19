<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	
	
	<jsp:include page="includes/cabecera.jsp"/>
	
	
<h1>usted va a modificar la informacion de ${perro.nombre} </h1>


<form method="post" action="perro-modificar">
	<p>Esto envia datos por POST al controlador</p>
		<div class="form-group">
	<label for="id">id</label>
	<input value="${perro.id}" type="text" autofocus  name="id" placeholder="Nombre del perro" readonly>
	</div>
	<div class="form-group">
	<label for="nombre">Nombre:</label>
	<input value="${perro.nombre}" type="text" autofocus  name="nombre" placeholder="Nombre del perro" required>
	</div>
		
	<div class="form-group">
  <label for="raza">Raza:</label>
	<input value="${perro.raza}" type="text" id="nombre" name="raza" placeholder="Raza del perro" required>
	</div>
	
	<div class="form-group">
	<label for="peso">Peso:</label>
	<input type="text" value="${perro.peso}" name="peso"  id="nombre" placeholder="peso en kg" required>
		</div>

	<div class="form-group">
	<label for="vacunado">Vacunado:</label>
	<input type="checkbox" name="vacunado"  ${ (perro.vacunado) ? "checked" : ""} >
		</div>
	
	<div class="form-group">
	<label for="historia">Historia:</label>
	<textarea name="historia" cols="30" rows="5" placeholder="Cuentame la historia del perro"> ${perro.historia}</textarea>
		</div>
		
	<input class="boton" type="submit" value="Guardar datos"> 
   </form>
   
   <h2>${mensaje}!!!!</h2>
    
<jsp:include page="includes/pie.jsp"/>