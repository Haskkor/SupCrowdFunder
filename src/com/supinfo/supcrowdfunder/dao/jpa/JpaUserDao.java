package com.supinfo.supcrowdfunder.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.supinfo.supcrowdfunder.dao.UserDao;
import com.supinfo.supcrowdfunder.entity.User;

public class JpaUserDao implements UserDao {

	private EntityManagerFactory emf;

	public JpaUserDao(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public User addUser(User user) {
		User result = null;
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
			result = user;
		} finally {
			if(em.getTransaction().isActive()) em.getTransaction().rollback();
			em.close();
		}
		return result;
	}

	@Override
	public User getUserById(Long userId) {
		EntityManager em = emf.createEntityManager();
		try {
			return em.find(User.class, userId);
		} finally {
			em.close();
		}
	}
	
	@Override
	public User getUserByEmail(String mailAddress) {
		EntityManager em = emf.createEntityManager();
		try {
			Query query = em.createQuery("FROM User as u WHERE mailAddress='"+mailAddress+"'");
			try {
				return (User) query.getSingleResult();
			} catch (NoResultException e) {
				return null;
			}
		} finally {
			em.close();
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		EntityManager em = emf.createEntityManager();
		try {
			Query query = em.createQuery("SELECT u FROM User u");
			return query.getResultList();
		} finally {
			em.close();
		}
	}
	
	@Override
	public void removeUser(Long userId) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			
			em.createQuery("DELETE FROM User u WHERE u.id = :userId")
				.setParameter("userId", userId)
				.executeUpdate();
			
			em.getTransaction().commit();
		} finally {
			if(em.getTransaction().isActive()) em.getTransaction().rollback();
			em.close();
		}
	}
	
	@Override
	public void removeUser(User user) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(em.merge(user));
			em.getTransaction().commit();
		} finally {
			if(em.getTransaction().isActive()) em.getTransaction().rollback();
			em.close();
		}
	}

	@Override
	public void updateUser(User user) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(user);
			em.getTransaction().commit();
		
		} finally {
			if(em.getTransaction().isActive()) em.getTransaction().rollback();
			em.close();
		}
	}
}
