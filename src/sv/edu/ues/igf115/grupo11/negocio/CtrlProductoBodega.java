package sv.edu.ues.igf115.grupo11.negocio;

import java.math.BigDecimal;

import sv.edu.ues.igf115.grupo11.datos.ProductoBodegaDAO;
import sv.edu.ues.igf115.grupo11.dominio.ProductoBodega;

public class CtrlProductoBodega {
	//Atributos de la clase
	private ProductoBodegaDAO daoDepto = new ProductoBodegaDAO();

	//Metodos de la clase
	
	//Insertar un nuevo ProductoBodega
	public boolean crearProductoBodega(String idProducto, String idBodega, BigDecimal cantidadBodega) {
		if (daoDepto.daProductoBodegaByIds(idProducto, idBodega) == null) {
			ProductoBodega prodBod = new ProductoBodega(idProducto, idBodega, cantidadBodega);
			daoDepto.guardaActualiza(prodBod);
			return true;
		} else
			return false;
	}

	//Eliminar un ProductoBodega
	public boolean eliminarProductoBodega(String idProducto, String idBodega) {
		if (daoDepto.daProductoBodegaByIds(idProducto, idBodega) != null) {
			ProductoBodega prodBod = daoDepto.daProductoBodegaByIds(idProducto, idBodega);
			daoDepto.eliminar(prodBod);
			return true;
		} else
			return false;
	}

	//Modificar los datos de un producto bodega
	public boolean modificarProductoBodega(String idProducto, String idBodega, BigDecimal cantidad) {
		if (daoDepto.daProductoBodegaByIds(idProducto, idBodega) != null) {
			ProductoBodega prodBod = daoDepto.daProductoBodegaByIds(idProducto, idBodega);
			prodBod.setCantidadBodega(cantidad);
			daoDepto.guardaActualiza(prodBod);
			return true;
		} else
			return false;
	}

	public ProductoBodega daProductoBodegaByIds(String idProducto, String idBodega) {
		return daoDepto.daProductoBodegaByIds(idProducto, idBodega);
	}

}
