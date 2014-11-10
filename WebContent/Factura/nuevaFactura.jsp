<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<HEAD>
<TITLE>Nueva Factura</TITLE>
</HEAD>
<BODY>
	<center>
		<div id="DatosFactura">
			<h3>Ingreso de una nueva factura</h3><br>
			<form action="Factura/facturaIngresada.jsp" method="post">
				Id del cliente : <input type="text" name="idCliente" id="idCliente"/><br>
				Id del tipo de venta: <input type="text" name="idTipoVta" id="idTipoVta"/><br>
				id factura: <input type="text" name="idFactura" id="idFactura"/><br>
				Fecha: <input type="text" name="fechaFactura" id="fechaFactura"/><br>
				<input type="submit" value="Intentar">
			</form>
		</div>		
	</center>
</BODY>

</html>