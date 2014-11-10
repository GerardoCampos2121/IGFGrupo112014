<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="sv.edu.ues.igf115.grupo11.negocio.CtrlCliente" %>
    
    <%
    String idCliente = request.getParameter("idCliente");
    
    CtrlCliente eliminar = new CtrlCliente();
    
    boolean exito = eliminar.eliminarClienteById(idCliente);
    String mensaje="";
    if(exito){
    	mensaje = "eliminado";    	
    }else{
    	mensaje ="no encontrado";
    }
    
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%=mensaje %>
</body>
</html>