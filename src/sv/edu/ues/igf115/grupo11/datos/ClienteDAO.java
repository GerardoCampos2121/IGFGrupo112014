package sv.edu.ues.igf115.grupo11.datos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import sv.edu.ues.igf115.grupo11.dominio.Cliente;
import sv.edu.ues.igf115.grupo11.utilidades.HibernateUtil;

public class ClienteDAO {
	
	
	private HibernateUtil hibernateUtil = new HibernateUtil();
	private SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
	private Session sesion;
	private Transaction tx;

	private void iniciaOperacion() throws HibernateException {
		sesion = sessionFactory.openSession();
		tx = sesion.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he)
			throws HibernateException {
		tx.rollback();
		throw new HibernateException("Ocurrió un error en la capa DAO", he);
	}

	public void guardaActualiza(Cliente cliente) {
		try {
			iniciaOperacion();
			sesion.saveOrUpdate(cliente);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}

	public void eliminar(Cliente cliente) {
		try {
			iniciaOperacion();
			sesion.delete(cliente);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}
	
	
	public List<Cliente> daClientes() {
		sesion = sessionFactory.openSession();
		Query query = sesion.getNamedQuery("Cliente.findAll");
		List<Cliente> clientes = query.list();
		sesion.close();
		return clientes;
	}
	
	
	public Cliente daClienteById(String idCliente){
		
		sesion = sessionFactory.openSession();
		
		Query query = sesion.getNamedQuery("Cliente.findById");
		query.setParameter("idCliente", idCliente);
		Cliente cte = (Cliente)query.uniqueResult();
		
		sesion.close();
		return cte;
		
		
	}
	

}
