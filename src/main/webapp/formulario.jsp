<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <jsp:include page="includes/cabecera.jsp"/>
    
    
<form method="post" action="perroController">
	<p>Esto envia datos por POST al controlador</p>
	<div class="form-group">
	<label for="nombre">Nombre:</label>
	<input type="text" name="nombre" placeholder="Nombre del perro" required>
	</div>
		
	<div class="form-group">
  <label for="nombre">Raza:</label>
	<input type="text" name="raza" placeholder="Raza del perro" required>
	</div>
	
	<div class="form-group">
	<label for="nombre">Peso:</label>
	<input type="text" name="peso" placeholder="peso en kg" required>
		</div>

	<div class="form-group">
	<label for="nombre">Vacunado:</label>
	<input type="checkbox" name="vacunado">
		</div>
	
	<div class="form-group">
	<label for="nombre">Historia:</label>
	<textarea name="historia" cols="30" rows="5" placeholder="Cuentame la historia del perro"></textarea>
		</div>
		
	<input class="boton" type="submit" value="Guardar datos"> 
   </form>
    
    
    <jsp:include page="includes/pie.jsp"/>