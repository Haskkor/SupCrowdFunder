package com.supinfo.supcrowdfunder.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.supinfo.supcrowdfunder.dao.ProjectDao;
import com.supinfo.supcrowdfunder.entity.Project;

public class JpaProjectDao implements ProjectDao {

	private EntityManagerFactory emf;


	public JpaProjectDao(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public Project addProject(Project project) {
		Project result = null;
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(project);
			em.getTransaction().commit();
			result = project;
		} finally {
			if(em.getTransaction().isActive()) em.getTransaction().rollback();
			em.close();
		}
		return result;
	}

	@Override
	public Project getProjectById(Long projectId) {
		EntityManager em = emf.createEntityManager();
		try {
			return em.find(Project.class, projectId);
		} finally {
			em.close();
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Project> getAllProjects() {
		EntityManager em = emf.createEntityManager();
		try {
			Query query = em.createQuery("SELECT p FROM Project p");
			return query.getResultList();
		} finally {
			em.close();
		}
	}
	
	@Override
	public void removeProject(Long projectId) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			
			em.createQuery("DELETE FROM Project p WHERE p.id = :projectId")
				.setParameter("projectId", projectId)
				.executeUpdate();
			em.getTransaction().commit();
		} finally {
			if(em.getTransaction().isActive()) em.getTransaction().rollback();
			em.close();
		}
	}
	
	@Override
	public void removeProject(Project project) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(em.merge(project));
			em.getTransaction().commit();
		} finally {
			if(em.getTransaction().isActive()) em.getTransaction().rollback();
			em.close();
		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Project> getProjectsByCategory(Long categoryId) {
		EntityManager em = emf.createEntityManager();
		try {
			Query query = em.createQuery("SELECT p FROM Project p WHERE p.category.catId = '"+categoryId+"'");
			return query.getResultList();
		} finally {
			em.close();
		}
	}

	@Override
	public void updateProject(Project project) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(project);
			em.getTransaction().commit();
		} finally {
			if(em.getTransaction().isActive()) em.getTransaction().rollback();
			em.close();
		}
	}
}