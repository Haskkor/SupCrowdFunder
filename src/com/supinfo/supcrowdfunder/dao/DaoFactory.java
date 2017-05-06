package com.supinfo.supcrowdfunder.dao;

import com.supinfo.supcrowdfunder.dao.jpa.JpaCategoryDao;
import com.supinfo.supcrowdfunder.dao.jpa.JpaDonateDao;
import com.supinfo.supcrowdfunder.dao.jpa.JpaProjectDao;
import com.supinfo.supcrowdfunder.dao.jpa.JpaUserDao;
import com.supinfo.supcrowdfunder.util.PersistenceManager;

public final class DaoFactory {
	
	private static DaoFactory instance;	
	private CategoryDao categoryDao;
	private ProjectDao projectDao;
	private UserDao userDao;
	private DonateDao donateDao;
	
	public static DaoFactory getInstance() {
		if(instance == null) {
			instance = new DaoFactory();
		}
		return instance;
	}
	
	public CategoryDao getCategoryDao() {
		if(categoryDao == null) {
			categoryDao = new JpaCategoryDao(PersistenceManager.getEntityManagerFactory());
		}
		return categoryDao;
	}
	
	public ProjectDao getProjectDao() {
		if(projectDao == null) {
			projectDao = new JpaProjectDao(PersistenceManager.getEntityManagerFactory());
		}
		return projectDao;
	}
	
	public UserDao getUserDao() {
		if(userDao == null) {
			userDao = new JpaUserDao(PersistenceManager.getEntityManagerFactory());
		}
		return userDao;
	}
	public DonateDao getDonateDao() {
		if(donateDao == null) {
			donateDao = new JpaDonateDao(PersistenceManager.getEntityManagerFactory());
		}
		return donateDao;
	}
}
