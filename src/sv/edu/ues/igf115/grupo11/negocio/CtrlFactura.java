package sv.edu.ues.igf115.grupo11.negocio;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import sv.edu.ues.igf115.grupo11.datos.FacturaDAO;
import sv.edu.ues.igf115.grupo11.dominio.Cliente;
import sv.edu.ues.igf115.grupo11.dominio.Factura;
import sv.edu.ues.igf115.grupo11.dominio.TipoVta;

public class CtrlFactura {
	
	FacturaDAO daoFactura = new FacturaDAO();

	//Metodo para guardar una factura
	public boolean guardarFactura(String idFactura, Date fechaFactura, BigDecimal ventaTotal, Cliente cliente, TipoVta tipoVta) {

		if (daoFactura.daFacturaById(idFactura) == null) {
			Factura nueva = new Factura(idFactura, fechaFactura, ventaTotal, cliente, tipoVta);
			daoFactura.guardaActualiza(nueva);
			return true;
		} else {
			return false;
		}
	}

	//Metodo para eliminar una factura
	public boolean eliminarFactura(String idFactura){		
		if(daoFactura.daFacturaById(idFactura) != null){			
			Factura borrar = daoFactura.daFacturaById(idFactura);
			daoFactura.eliminar(borrar);
			return true;			
		}else{
			return false;
		}		
	}
	
	//Metodo para consultar una factura
	public Factura consultarFactura(String idFactura){		
		if(daoFactura.daFacturaById(idFactura) != null){			
			Factura cons = daoFactura.daFacturaById(idFactura);
			return cons;			
		}else{
			return null;			
		}		
	}
	
	//Metodo para modificar una factura
	public boolean modificarFactura(String idFactura, Date fechaFactura, BigDecimal ventaTotal, Cliente cliente, TipoVta tipoVta) {
		if (daoFactura.daFacturaById(idFactura) != null) {
			Factura factura = daoFactura.daFacturaById(idFactura);
			factura.setFechaFactura(fechaFactura);
			factura.setVentaTotal(ventaTotal);
			factura.setCliente(cliente);
			factura.setTipoVta(tipoVta);
			daoFactura.guardaActualiza(factura);
			return true;
		} else {
			return false;
		}
	}// fin del metodo modificar

}
