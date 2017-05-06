package com.supinfo.supcrowdfunder.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.supinfo.supcrowdfunder.util.PersistenceManager;

@WebListener
public class PersistenceAppListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {}
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		PersistenceManager.closeEntityManagerFactory();
	}
}