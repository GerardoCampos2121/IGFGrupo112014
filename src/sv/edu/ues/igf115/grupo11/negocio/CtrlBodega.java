package sv.edu.ues.igf115.grupo11.negocio;

import sv.edu.ues.igf115.grupo11.datos.BodegaDAO;
import sv.edu.ues.igf115.grupo11.dominio.Bodega;

public class CtrlBodega {

	BodegaDAO daobodega = new BodegaDAO();

	public boolean guardarBodega(String id_bodega, String nombre_bodega,
			String direccion) {

		if (daobodega.daBodegaById(id_bodega) == null) {

			Bodega nueva = new Bodega(id_bodega, nombre_bodega, direccion);
			daobodega.guardaActualiza(nueva);
			return true;
		} else {
			return false;
		}

	}// fin del metodo guardar

	
	public boolean eliminarBodega(String id_bodega){
		
		if(daobodega.daBodegaById(id_bodega) != null){
			
			Bodega borrar = daobodega.daBodegaById(id_bodega);
			daobodega.eliminar(borrar);
			return true;			
		}else{
			return false;
		}		
	}
	
	
	public Bodega consultarBodega(String id_bodega){
		
		if(daobodega.daBodegaById(id_bodega) != null){
			
			Bodega cons = daobodega.daBodegaById(id_bodega);
			return cons;			
		}else{
			return null;			
		}
		
	}
	
	
	public boolean modificarBodega(String id_bodega, String nombre_bodega,
			String direccion) {

		if (daobodega.daBodegaById(id_bodega) != null) {

			Bodega nueva = daobodega.daBodegaById(id_bodega);
			
			//actualizamos campos
			nueva.setNombre_bodega(nombre_bodega);
			nueva.setDireccion(direccion);
			
			daobodega.guardaActualiza(nueva);
			return true;
		} else {
			return false;
		}

	}// fin del metodo modificar
	
	
}
