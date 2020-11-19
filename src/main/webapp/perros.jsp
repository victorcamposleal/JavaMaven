
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="includes/cabecera.jsp" />

<h2>${mensaje}</h2>

<table border="1">
	<caption>Perrera</caption>
	<thead>
		<tr>
			<th>id</th>
			<th>Nombre</th>
			<th>Raza</th>
			<th>Peso</th>
			<th>Vacunado</th>
			<th>Historia</th>
			<th>Acciones</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${perros}" var="perro">
			<tr>
				<td>${perro.id}</td>
				<td><a href="perro-modificar?id=${perro.id}">${perro.nombre}</a>
				</td>
				<td>${perro.raza}</td>
				<td>${perro.peso}</td>
				<td>${(perro.vacunado)==true?'si':'no'}</td>
				<td>${perro.historia}</td>
				<td class="iconos">
				<a href="perro-detalle?id=${perro.id}"><i class="fa fa-eye"></i></a> 
				<a href="perro-eliminar?id=${perro.id}"><i class="fa fa-trash"></i></a>
				</td>

			</tr>

		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="4">Total de perros X</td>
		</tr>
	</tfoot>

</table>

<jsp:include page="includes/pie.jsp" />


