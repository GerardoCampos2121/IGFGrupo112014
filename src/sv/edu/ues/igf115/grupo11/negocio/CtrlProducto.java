package sv.edu.ues.igf115.grupo11.negocio;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import sv.edu.ues.igf115.grupo11.datos.ProductoDAO;
import sv.edu.ues.igf115.grupo11.dominio.Producto;
import sv.edu.ues.igf115.grupo11.dominio.Proveedor;
import sv.edu.ues.igf115.grupo11.dominio.TipoCliente;

public class CtrlProducto {
	private ProductoDAO daoEmp = new ProductoDAO();
	public boolean crearProducto(String idProducto, String descripcion,Date fecha, BigDecimal preciounitario, Proveedor proveedor) {
		if (daoEmp.daProductoByIdProducto(idProducto)== null) {
			if (proveedor != null) {
				Producto producto = new Producto(idProducto, descripcion, fecha, preciounitario, proveedor);
				producto.setProveedor(proveedor);
				daoEmp.guardaActualiza(producto);
				return true;
			} else
				return false;
		} else
			return false;
	}
	
	public boolean borrarProductoByIdProducto(String id) {
		if (daoEmp.daProductoByIdProducto(id) != null) {
			Producto producto = daoEmp.daProductoByIdProducto(id);
			daoEmp.eliminar(producto);
			return true;
		} else
			return false;
	}
	public boolean modificarProducto(String idProducto, String descripcion,Date fecha, BigDecimal preciounitario, Proveedor proveedor) {
		if (daoEmp.daProductoByIdProducto(idProducto) != null) {
			Producto producto = daoEmp.daProductoByIdProducto(idProducto);
			
			producto.setDescripcion(descripcion);
			producto.setFechaInicio(fecha);
			producto.setPrecioUnitario(preciounitario);
			producto.setProveedor(proveedor);
			daoEmp.guardaActualiza(producto);
			
			return true;
		} else
			return false;
	}
	public Producto daProductoById(String id) {
		if (daoEmp.daProductoByIdProducto(id) != null) {
			Producto consultado = daoEmp.daProductoByIdProducto(id);
			return consultado;
		} else {
			return null;
		}
	}//
	public List<Producto> daProductos() {
		return daoEmp.daProductos();
	}

	public List daProductosByProveedor(String idProveedor) {
		return daoEmp.daProductosByProveedor(idProveedor);
	}

	
	public Producto daProductoByIdProducto(String idP) {
		return daoEmp.daProductoByIdProducto(idP);
	}
}
