package br.com.senior.hotelproj.model.baserepository;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import br.com.senior.hotelproj.model.baseinterface.IBaseDaoInterface;
import br.com.senior.hotelproj.model.baseinterface.ICriteriaFiltro;
import br.com.senior.hotelproj.model.baseinterface.ICriteriaQueryJoin;
import br.com.senior.hotelproj.model.baseinterface.ICriteriaQueryJoinResultado;

public class BaseDaoRepository<T> implements IBaseDaoInterface<T> {
	private final Class<T> tipoClasse;
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public BaseDaoRepository() throws Exception {
		this.tipoClasse = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
		this.setUp();
	}

	protected void setUp() throws Exception {
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

	public <T1, T2, TResult> List<TResult> queryJoin(ICriteriaQueryJoin<T1, T2> fnCriterio,
			ICriteriaQueryJoinResultado<T1, T2, TResult> fnResposta, Class<T1> c1, Class<T2> c2,
			Class<TResult> cResult) {

		Session session = this.sessionFactory.openSession();
		try {
			session.beginTransaction();

			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);

			Root<T1> rootT1 = criteriaQuery.from(c1);
			Root<T2> rootT2 = criteriaQuery.from(c2);
			criteriaQuery.multiselect(rootT1, rootT2);

			fnCriterio.executar(builder, criteriaQuery, rootT1, rootT2);

			Query<Object[]> query = session.createQuery(criteriaQuery);

			List<TResult> retorno = new ArrayList<>();
			for (Object[] objetos : query.getResultList()) {
				retorno.add(fnResposta.executar(c1.cast(objetos[0]), c2.cast(objetos[1])));
			}

			return retorno;

		} catch (Exception ex) {
			return new ArrayList<>();
		}
	}

	@Override
	public void inserir(T model) {
		Session session = this.sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(model);
			session.getTransaction().commit();

		} catch (Exception ex) {
			session.getTransaction().rollback();
			throw ex;
		} finally {
//			session.flush();
			session.close();
		}
	}

	@Override
	public void alterar(T model) {
		Session session = this.sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(model);
			session.getTransaction().commit();

		} catch (Exception ex) {
			session.getTransaction().rollback();
			throw ex;
		} finally {
//			session.flush();
			session.close();
		}
	}

	@Override
	public void excluir(T model) {
		Session session = this.sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(model);
			session.getTransaction().commit();

		} catch (Exception ex) {
			session.getTransaction().rollback();
			throw ex;
		} finally {
//			session.flush();
			session.close();
		}
	}

	@Override
	public T obterPorChave(int parametros) {
		Session session = this.sessionFactory.openSession();
		try {
			session.beginTransaction();
			T model = (T) session.get(tipoClasse, parametros);

			return model;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public List<T> obter(ICriteriaFiltro<T> filtrar) {
		Session session = this.sessionFactory.openSession();
		try {
			session.beginTransaction();

			CriteriaBuilder builder = session.getCriteriaBuilder();

			CriteriaQuery<T> criterio = builder.createQuery(tipoClasse);

			Root<T> variableRoot = criterio.from(tipoClasse);
			criterio.select(variableRoot);

			filtrar.executar(builder, criterio, variableRoot);

			List<T> retorno = session.createQuery(criterio).getResultList();

			return retorno;
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}

	@Override
	public List<T> obterTodos() {
		Session session = this.sessionFactory.openSession();
		try {
			session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<T> criterio = builder.createQuery(tipoClasse);
			Root<T> variableRoot = criterio.from(tipoClasse);
			criterio.select(variableRoot);

			List<T> retorno = session.createQuery(criterio).getResultList();

			return retorno;
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}

}
