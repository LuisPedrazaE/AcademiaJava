<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Lista de Huespedes</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>ARH - Administrador de Relacion de Huespedes</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
		
			<input type="button" value="Agregar Huesped"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Email</th>
					<th>Accion</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempHuesped" items="${huespedes}">
				
					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/huesped/showFormForUpdate">
						<c:param name="huespedId" value="${tempHuesped.id}" />
					</c:url>					

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/huesped/delete">
						<c:param name="huespedId" value="${tempHuesped.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempHuesped.nombre} </td>
						<td> ${tempHuesped.apellido} </td>
						<td> ${tempHuesped.email} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Actualizar</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this huesped?'))) return false">Eliminar</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









