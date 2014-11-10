package sv.edu.ues.igf115.grupo11.datos;

import java.util.List;

import org.hibernate.*;
import sv.edu.ues.igf115.grupo11.dominio.Producto;
import sv.edu.ues.igf115.grupo11.utilidades.*;

import org.hibernate.*;
import sv.edu.ues.igf115.grupo11.dominio.Producto;
import sv.edu.ues.igf115.grupo11.utilidades.HibernateUtil;

public class ProductoDAO {
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

	public void guardaActualiza(Producto producto) {
		try {
			iniciaOperacion();
			sesion.saveOrUpdate(producto);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}

	public void eliminar(Producto producto) {
		try {
			iniciaOperacion();
			sesion.delete(producto);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}

	public List daProductos() {
		sesion = sessionFactory.openSession();
		Query query = sesion.getNamedQuery("Productos.findAll");
		List productos = query.list();
		sesion.close();
		return productos;
	}

	public List daProductosByProveedor(String idProveedor) {
		sesion = sessionFactory.openSession();
		String condicion = "select e from Producto e join fetch e.proveedor d where d.idProveedor = :id_prov";
		Query query = sesion.createQuery(condicion);
		query.setParameter("id_prov", idProveedor);
		List listado = query.list();
		sesion.close();
		return listado;
	}

	public Producto daProductoByIdProducto(String id) {
		sesion = sessionFactory.openSession();
		Query consulta = sesion.getNamedQuery("Productos.findById");
		consulta.setParameter("idProducto", id);
		Producto producto = (Producto) consulta.uniqueResult();
		sesion.close();
		return producto;
	}
	public Producto daProductoByPrecio(String precio) {
		sesion = sessionFactory.openSession();
		Query consulta = sesion.getNamedQuery("Productos.findByPrecio");
		consulta.setParameter("precioUnitario", precio);
		Producto producto = (Producto) consulta.uniqueResult();
		sesion.close();
		return producto;
	}
	public Producto daProductoByDescripcion(String descripcion) {
		sesion = sessionFactory.openSession();
		Query consulta = sesion.getNamedQuery("Productos.findByDescripcion");
		consulta.setParameter("descripcion", descripcion);
		Producto producto = (Producto) consulta.uniqueResult();
		sesion.close();
		return producto;
	}
}
