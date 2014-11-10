package sv.edu.ues.igf115.grupo11.negocio;

import sv.edu.ues.igf115.grupo11.datos.ClienteDAO;
import sv.edu.ues.igf115.grupo11.dominio.Cliente;
import sv.edu.ues.igf115.grupo11.dominio.TipoCliente;

public class CtrlCliente {
	
	ClienteDAO daocliente = new ClienteDAO();
	
	
	public boolean guardarCliente(String idCliente, String nombCliente,
			String apCliente, String domCliente, String telCliente,
			String e_mail, TipoCliente tipocliente){
		
		if(daocliente.daClienteById(idCliente)==null){
			
			Cliente nuevo = new Cliente(idCliente, nombCliente,
					apCliente, domCliente, telCliente,
					e_mail, tipocliente);
			
			daocliente.guardaActualiza(nuevo);
			return true;
		}
		return false;		
	}
	
	
	public Cliente daClienteById(String idCliente){
		
		if(daocliente.daClienteById(idCliente) != null){
			
			Cliente buscado = daocliente.daClienteById(idCliente);
			return buscado;
		}else{
			return null;			
		}		
	}//fin de metodo daClienteById
	
	
	public boolean eliminarClienteById(String idCliente){
		
		if(daocliente.daClienteById(idCliente) != null){
			
			Cliente buscado = daocliente.daClienteById(idCliente);
			daocliente.eliminar(buscado);
			return true;
		}else{
			return false;
		}
		
	}
	public boolean ModificarCliente(String idCliente, String nombCliente,
			String apCliente, String domCliente, String telCliente,
			String e_mail, TipoCliente tipocliente){
		
		if(daocliente.daClienteById(idCliente) != null){
			
			Cliente modificado = daocliente.daClienteById(idCliente);
			
			modificado.setNombCliente(nombCliente);
			modificado.setApCliente(apCliente);
			modificado.setDomCliente(domCliente);
			modificado.setTelCliente(telCliente);
			modificado.setE_mail(e_mail);
			modificado.setTipocliente(tipocliente);
			
			daocliente.guardaActualiza(modificado);
			return true;
		}
		return false;		
	}
	

}
