package sv.edu.ues.igf115.grupo11.datos;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import sv.edu.ues.igf115.grupo11.dominio.Bodega;
import sv.edu.ues.igf115.grupo11.utilidades.HibernateUtil;

public class BodegaDAO {
	
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

	
	public void guardaActualiza(Bodega bodega) {
		try {
			iniciaOperacion();
			sesion.saveOrUpdate(bodega);			
			tx.commit();			
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}
	
	
	public void eliminar(Bodega bodega) {
		try {
			iniciaOperacion();
			sesion.delete(bodega);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}
	
	
public Bodega daBodegaById(String id_bodega) {
		
		sesion = sessionFactory.openSession();
		
		Query query = sesion.getNamedQuery("Bodega.findById");
		query.setParameter("id_bodega", id_bodega);
		Bodega tpc = (Bodega) query.uniqueResult();
		
		sesion.close();
		return tpc;
	}

}
