package sv.edu.ues.igf115.grupo11.negocio;

import java.util.List;

import sv.edu.ues.igf115.grupo11.datos.ProveedorDAO;
import sv.edu.ues.igf115.grupo11.dominio.Cliente;
import sv.edu.ues.igf115.grupo11.dominio.Proveedor;


public class CtrlProveedor {
	private ProveedorDAO daoDepto= new ProveedorDAO();

	public boolean crearProveedor(String idPro, String nombreProveedor,String direccion, String telefono, String email) {
		if (daoDepto.daProveedorByIdProveedor(idPro) == null) {
			Proveedor proveedor = new Proveedor(idPro,nombreProveedor,direccion, telefono, email);
			daoDepto.guardaActualiza(proveedor);
			return true;
		} else
			return false;
	}

	public boolean eliminarProveedor(String id) {
		if (daoDepto.daProveedorByIdProveedor(id) != null) {
			Proveedor proveedor = daoDepto.daProveedorByIdProveedor(id);
			daoDepto.eliminar(proveedor);
			return true;
		} else
			return false;
	}

	public boolean modificarProveedor(String idPro, String nombreProveedor,String direccion, String telefono, String email) {
		if (daoDepto.daProveedorByIdProveedor(idPro) != null) {
			Proveedor proveedor = daoDepto.daProveedorByIdProveedor(idPro);
			
			proveedor.setNombreProveedor(nombreProveedor);
			proveedor.setDireccion(direccion);
			proveedor.setTelefono(telefono);
			proveedor.setEmail(email);
			
			daoDepto.guardaActualiza(proveedor);
			return true;
		} else
			return false;
	}
public Proveedor daProveedorById(String idProveedor){
		if(daoDepto.daProveedorByIdProveedor(idProveedor) != null){
			Proveedor buscado = daoDepto.daProveedorByIdProveedor(idProveedor);
			return buscado;
		}else{
			return null;			
		}		
	}//fin de metodo daClienteById
	

	public List<Proveedor> daProveedores() {
		return daoDepto.daProveedores();
	}

	public Proveedor daProveedorByIdProveedor(String id) {
		return daoDepto.daProveedorByIdProveedor(id);
	}

	public Proveedor daProveedorByNombre(String nombre) {
		return daoDepto.daProveedorByNombre(nombre);
	}
}
