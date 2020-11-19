<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<jsp:include page="includes/cabecera.jsp"/>
<h1>${perro.nombre}</h1>


*TODO maquetar el resto de campos del perro
<hr>
el perro ${perro.nombre} es de raza ${perro.raza}

<hr>
${perro.historia}



<hr>
<a href="perro-eliminar?id=${perro.id}">ELIMINAR PERRO, Cuidado no tiene vuelta atras!!!</a>
<jsp:include page="includes/pie.jsp"/>