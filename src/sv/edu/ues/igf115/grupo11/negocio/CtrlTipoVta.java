package sv.edu.ues.igf115.grupo11.negocio;

import java.util.Date;

import sv.edu.ues.igf115.grupo11.datos.TipoVtaDAO;
import sv.edu.ues.igf115.grupo11.dominio.TipoVta;

public class CtrlTipoVta {
	// Atributos de la clase

	// ESTA LINEA DEBERIA DE DESAPARECER CUANDO HAGA USO DE SPRING
	// ....................................
	private TipoVtaDAO daoTipoVenta = new TipoVtaDAO();

	// ...............................................................................................

	// Metodos de la clase

	// Crear un nuevo tipo de venta
	public boolean crearTipoVenta(String idTipoVenta, String descTipoVenta,
			Date fechaIngreso) {
		if (daoTipoVenta.daTipoVentaById(idTipoVenta) == null) {
			TipoVta tipoVenta = new TipoVta(idTipoVenta, descTipoVenta,
					fechaIngreso);
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
	public boolean modificarTipoVenta(String idTipoVentaAnt,
			String idTipoVenta, String descTipoVenta, Date fechaIngreso) {
		if (daoTipoVenta.daTipoVentaById(idTipoVentaAnt) != null) {
			TipoVta tipoVenta = daoTipoVenta.daTipoVentaById(idTipoVentaAnt);
			tipoVenta.setDescTipoVenta(descTipoVenta);
			tipoVenta.setFechaIngreso(fechaIngreso);
			daoTipoVenta.guardaActualiza(tipoVenta);
			return true;
		} else
			return false;
	}

	// Se obtiene el tipo de venta por id
	public TipoVta daTipoVentaById(String id) {
		return daoTipoVenta.daTipoVentaById(id);
	}

}
