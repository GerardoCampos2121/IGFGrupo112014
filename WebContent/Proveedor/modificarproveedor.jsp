<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="sv.edu.ues.igf115.grupo11.negocio.*" %>
    <%@ page import="sv.edu.ues.igf115.grupo11.dominio.*" %>

<%
String id  = request.getParameter("id");
String nombre = request.getParameter("nombre");
String direccion = request.getParameter("dir");
String tel = request.getParameter("tel");
String email = request.getParameter("email");
CtrlProveedor proveedor = new CtrlProveedor();
boolean exito = proveedor.modificarProveedor(id, nombre, direccion, tel, email);
String mensaje;
	if(exito)
		mensaje = "El proveedor fue modificado";
	else
		mensaje = "No se pudo modificar el Proveedor";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar Proveedor</title>
<%=mensaje%>
</head>
<body>

</body>
</html>