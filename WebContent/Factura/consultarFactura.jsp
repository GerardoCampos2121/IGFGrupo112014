<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="sv.edu.ues.igf115.grupo11.negocio.*"%>
<%@ page import="sv.edu.ues.igf115.grupo11.dominio.*"%>

<%
    String idFactura = request.getParameter("idFactura");
    
    CtrlFactura daoFactura = new CtrlFactura();
    Factura consultado = daoFactura.consultarFactura(idFactura);
    
    String mensaje="";
    if(consultado!=null){
    	mensaje += "<br>Id Factura: "+consultado.getIdFactura()+
    			   "<br> Fecha: "+consultado.getFechaFactura()+
    			   "<br>Venta Total: "+consultado.getVentaTotal()+
    			   "<br>Id Cliente: "+consultado.getCliente().getIdCliente()+
    			   "<br>Id Tipo Venta: "+ consultado.getTipoVta().getIdTipoVenta();	
    }else{
    	mensaje="no existe";
    }    
    
    %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consulta Factura</title>
</head>
<body>
<%=mensaje %>
</body>
</html>