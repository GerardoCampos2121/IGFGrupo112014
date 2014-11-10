<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="sv.edu.ues.igf115.grupo11.negocio.*" %>
    <%@ page import="sv.edu.ues.igf115.grupo11.dominio.*" %>
    <%@ page import="sv.edu.ues.igf115.grupo11.datos.*" %>
    
    
    <%
        	String idProveedor = request.getParameter("idProveedor");
            CtrlProveedor consulta = new CtrlProveedor();
            Proveedor buscado = consulta.daProveedorById(idProveedor);
            
            String mensaje="";
            
            if(buscado != null){
            			mensaje += "Codigo: " + buscado.getIdProveedor()
        				+ "<br> Nombre: " + buscado.getNombreProveedor()
        				+ "<br>Direccion:" + buscado.getDireccion()
        				+ "<br>Telefono:" + buscado.getTelefono()
        				+ "<br>Email:" + buscado.getEmail();
            			} else {
        		mensaje ="Proveedor no encontrado";
        	}
        %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consultar Proveedor</title>
</head>
<body>
<%=mensaje %>
</body>
</html>