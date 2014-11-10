<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="sv.edu.ues.igf115.grupo11.negocio.*" %>
    <%@ page import="sv.edu.ues.igf115.grupo11.dominio.*" %>
    <%@ page import="sv.edu.ues.igf115.grupo11.datos.*" %>
   
    <%
        	String idProducto = request.getParameter("idProducto");
             
    		CtrlProducto consulta = new CtrlProducto();
            Producto buscado = consulta.daProductoById(idProducto);
            
            String mensaje="";
            
            if(buscado != null){
            	
            			mensaje += "IdProducto: " + buscado.getIdProducto()
        				+ "<br> Descripcion: " + buscado.getDescripcion()
        				+ "<br>FechaInicio:" + buscado.getFechaInicio()
        				+ "<br>PrecioUnitario:" + buscado.getPrecioUnitario()
        			    + "<br>IdProveedor:" + buscado.getProveedor().getIdProveedor();
        	} else {
        		mensaje ="Producto no encontrado";
        	}
        %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consultar Producto</title>
</head>
<body>
<br><br>
<h1>Consulta de Producto</h1><br><br>
 <center>
<%=mensaje %>
</center>
  <center><br><br>                 
 <a href="../MenuProducto.html">Menu Producto</a>
</center> 
</body>
</html>