package sv.edu.ues.igf115.grupo11.negocio;

import java.math.BigDecimal;

import sv.edu.ues.igf115.grupo11.datos.TipoClienteDAO;
import sv.edu.ues.igf115.grupo11.dominio.TipoCliente;

public class CtrlTipoCliente {

	TipoClienteDAO daotipo = new TipoClienteDAO();

	public boolean guardarTipoCliente(String idTipocliente,
			String desp, BigDecimal desc) {
		
		if (daotipo.daTipoClienteById(idTipocliente) == null) {
			TipoCliente nuevo = new TipoCliente(idTipocliente, desp,desc);
			daotipo.guardaActualiza(nuevo);
			return true;
		} else {
			return false;
		}

	}// fin del metodo guardar

	public boolean elminarTipoCliente(String idTipocliente) {

		if (daotipo.daTipoClienteById(idTipocliente) != null) {
			TipoCliente tp = daotipo.daTipoClienteById(idTipocliente);
			daotipo.eliminar(tp);
			return true;
		} else {
			return false;
		}
	}// fin del metodo eliminar

	public TipoCliente consultarTipoCliente(String idTipocliente) {

		if (daotipo.daTipoClienteById(idTipocliente) != null) {
			TipoCliente consultado = new TipoCliente();
			consultado = daotipo.daTipoClienteById(idTipocliente);
			return consultado;
		} else {
			return null;
		}
	}// fin del metodo consultar

	public boolean modificarTipoCliente(String idTipocliente,
			String desp, BigDecimal desc) {

		if (daotipo.daTipoClienteById(idTipocliente) != null) {
			
			TipoCliente tc = daotipo.daTipoClienteById(idTipocliente);
			
			tc.setDesp(desp);
			tc.setDesc(desc);
			daotipo.guardaActualiza(tc);
			
			return true;
		} else {
			return false;
		}
	}

}
