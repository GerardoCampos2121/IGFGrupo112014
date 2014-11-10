package sv.edu.ues.igf115.grupo11.negocio;

import java.util.Date;
import java.util.List;

import sv.edu.ues.igf115.grupo11.datos.TipoVtaDAO;
import sv.edu.ues.igf115.grupo11.dominio.Cliente;
import sv.edu.ues.igf115.grupo11.dominio.TipoVta;

public class CtrlTipoVta {
	// Atributos de la clase

	// ESTA LINEA DEBERIA DE DESAPARECER CUANDO HAGA USO DE SPRING
	// ....................................
	private TipoVtaDAO daoTipoVenta = new TipoVtaDAO();

	// ...............................................................................................

	// Metodos de la clase

	// Crear un nuevo tipo de venta
	public boolean crearTipoVenta(String idTipoVenta, String descTipoVenta,	Date fechaIngreso) {
		if (daoTipoVenta.daTipoVentaById(idTipoVenta) == null) {
			TipoVta tipoVenta = new TipoVta(idTipoVenta, descTipoVenta,	fechaIngreso);
			daoTipoVenta.guardaActualiza(tipoVenta);
			return true;
		} else
			return false;
	}

	// Eliminar un tipo de venta
	public boolean eliminarTipoVenta(String id) {
		if (daoTipoVenta.daTipoVentaById(id) != null) {
			TipoVta tipoVenta = daoTipoVenta.daTipoVentaById(id);
			daoTipoVenta.eliminar(tipoVenta);
			return true;
		} else
			return false;
	}

	// Modificar los datos de un tipo de venta
	public boolean modificarTipoVenta(String idTipoVenta, String descTipoVenta, Date fechaIngreso) {
		if (daoTipoVenta.daTipoVentaById(idTipoVenta) != null) {
			TipoVta tipoVenta = daoTipoVenta.daTipoVentaById(idTipoVenta);
			tipoVenta.setDescTipoVenta(descTipoVenta);
			tipoVenta.setFechaIngreso(fechaIngreso);
			daoTipoVenta.guardaActualiza(tipoVenta);
			return true;
		} else
			return false;
	}

	// Se obtiene el tipo de venta por id
	public TipoVta daTipoVentaById(String idTipoVenta) {
		System.out.println("************************************");
		System.out.println("************CtrlTipoVta*************");
		 System.out.println("Id de tipo de venta a buscar: ["+idTipoVenta+"]");
		 System.out.println("***********************************");
		 System.out.println("***********************************");
		if (daoTipoVenta.daTipoVentaById(idTipoVenta) != null) {
			TipoVta buscado =daoTipoVenta.daTipoVentaById(idTipoVenta);
			return buscado;
		} else {
			return null;
		}
	}
	
	public List<TipoVta> listaTipoVta(){
		return daoTipoVenta.daTipoVta();
	}
	

}
