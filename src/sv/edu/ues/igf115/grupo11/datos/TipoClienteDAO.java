package sv.edu.ues.igf115.grupo11.datos;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import sv.edu.ues.igf115.grupo11.dominio.TipoCliente;
import sv.edu.ues.igf115.grupo11.utilidades.HibernateUtil;

public class TipoClienteDAO {
	
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

	
	public void guardaActualiza(TipoCliente tipocliente) {
		try {
			iniciaOperacion();
			sesion.saveOrUpdate(tipocliente);			
			tx.commit();			
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}
	
	
	public void eliminar(TipoCliente tipocliente) {
		try {
			iniciaOperacion();
			sesion.delete(tipocliente);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}
		
	
	public TipoCliente daTipoClienteById(String idTipocliente) {
		
		sesion = sessionFactory.openSession();
		
		Query query = sesion.getNamedQuery("TipoCliente.findById");
		query.setParameter("idTipocliente", idTipocliente);
		TipoCliente tpc = (TipoCliente) query.uniqueResult();
		
		sesion.close();
		return tpc;
	}

	

}
