<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
    <%@ page import="sv.edu.ues.igf115.grupo11.negocio.*" %>
    <%@ page import="sv.edu.ues.igf115.grupo11.dominio.*" %>
    <%@ page import="java.text.SimpleDateFormat"%>
    <%@ page import="java.util.*" %>
    
    <%
    /*Recuperar parametros*/
    String idTipoVta = request.getParameter("idTipoVta");
    String descripcion = request.getParameter("descripcion");
    String fechaIngreso = request.getParameter("fechaIngreso");
    
    /*vamos a programar guardar tipo venta*/
    CtrlTipoVta nuevoTipoVta = new CtrlTipoVta();
    
    SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
    Date fechaIng = null; //iniciamos fecha
    fechaIng = formatoDelTexto.parse(fechaIngreso);    
    
    String mensaje ="";
    boolean exito = nuevoTipoVta.modificarTipoVenta(idTipoVta, descripcion, fechaIng);    
    
    if(exito){
    	mensaje = "El nuevo tipo de venta ha sido actualizado";
    }else{
    	mensaje = "El error te persigue";
    }
    %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizacion de tipo de ventas</title>
</head>
<body>
<%= mensaje %>
</body>
</html>