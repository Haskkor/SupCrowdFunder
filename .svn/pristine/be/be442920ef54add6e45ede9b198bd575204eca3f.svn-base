package com.supinfo.supcrowdfunder.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.supinfo.supcrowdfunder.dao.DonateDao;
import com.supinfo.supcrowdfunder.entity.Donate;

public class JpaDonateDao implements DonateDao {

	private EntityManagerFactory emf;

	public JpaDonateDao(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public Donate addDonate(Donate donate) {
		Donate result = null;
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(donate);
			em.getTransaction().commit();
			result = donate;
		} finally {
			if(em.getTransaction().isActive()) em.getTransaction().rollback();
			em.close();
		}
		return result;
	}

	@Override
	public Donate getDonateById(Long donateId) {
		EntityManager em = emf.createEntityManager();
		try {
			return em.find(Donate.class, donateId);
		} finally {
			em.close();
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Donate> getAllDonates() {
		EntityManager em = emf.createEntityManager();
		try {
			Query query = em.createQuery("SELECT d FROM Donate d");
			return query.getResultList();
		} finally {
			em.close();
		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Donate> getDonationsByProject(Long projectId) {
		EntityManager em = emf.createEntityManager();
		try {
			Query query = em.createQuery("SELECT d FROM Donate d WHERE d.project.projectId = '"+projectId+"'");
			return query.getResultList();
		} finally {
			em.close();
		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Donate> getDonationsByUser(Long userId) {
		EntityManager em = emf.createEntityManager();
		try {
			Query query = em.createQuery("SELECT d FROM Donate d WHERE d.user.userId = '"+userId+"'");
			return query.getResultList();
		} finally {
			em.close();
		}
	}
}
