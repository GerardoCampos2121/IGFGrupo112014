<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="sv.edu.ues.igf115.grupo11.negocio.CtrlTipoCliente" %>
    <%@ page import="java.math.BigDecimal;" %>
    
    <%
    
    /*Capturar datos*/
    String idTipocliente = request.getParameter("id_tipocliente");
    String despn = request.getParameter("descripcion");
    BigDecimal desc = new BigDecimal(request.getParameter("descuento"));
    
    CtrlTipoCliente nuevo = new CtrlTipoCliente();
    
    boolean exito = nuevo.guardarTipoCliente(idTipocliente, despn, desc);
    
    String mensaje="";
    if(exito){
    	mensaje = "Tipo de Cliente Registrado Exitosamente!";    	
    }
    else{
    	mensaje = "Tipo de Cliente ya existe o No se ha podido registrar!";
    }    
    
    %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tipos de Clientes</title>
</head>
<body>

 <h2><%=mensaje %></h2>

</body>
</html>