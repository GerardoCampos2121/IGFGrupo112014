<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="sv.edu.ues.igf115.grupo11.negocio.*" %>

<%
	String id  = request.getParameter("id");
	CtrlProveedor proveedor = new CtrlProveedor();
	boolean exito = proveedor.eliminarProveedor(id);
	String mensaje;
	if(exito)
		mensaje = "El proveedor fue eliminado";
	else
		mensaje = "No se pudo eliminar el Proveedor";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Eliminar Proveedor</title>
<%=mensaje%>
</head>
<body>

</body>
</html>