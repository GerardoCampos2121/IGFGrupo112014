<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import="sv.edu.ues.igf115.grupo11.negocio.*" %>
       <%@ page import="sv.edu.ues.igf115.grupo11.utilidades.*" %>
         <%@ page import="java.math.BigDecimal" %>
    <%@ page import=" java.util.Date" %>
    <%@ page import="java.util.*" %>
    <%@ page import="java.text.SimpleDateFormat;" %>
  
<%
	String idproducto  = request.getParameter("id");
	String descripcion = request.getParameter("nombre");
	
	String fechacapturada = request.getParameter("fecha");
    SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
    Date fecha = null; //iniciamos fecha
    fecha = formatoDelTexto.parse(fechacapturada);   
	
	
	BigDecimal precio =new BigDecimal(request.getParameter("precio"));
	String idproveedor=request.getParameter("idproveedor");
	
	CtrlProducto producto = new CtrlProducto();
	CtrlProveedor prov = new CtrlProveedor();
	
	boolean exito=producto.crearProducto(idproducto, descripcion, fecha, precio, prov.daProveedorById(idproveedor));
	String mensaje;
	if(exito)
		mensaje = "El producto fue ingresado";
	else
		mensaje = "No se pudo ingresar el Producto";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insertar Producto</title>
<%=mensaje%>
</head>
<body>

</body>
</html>