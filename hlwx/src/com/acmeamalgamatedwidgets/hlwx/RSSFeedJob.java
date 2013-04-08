/**
 * 
 */
package com.acmeamalgamatedwidgets.hlwx;

import java.util.Vector;
import java.util.List;
import java.util.Iterator; 

import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


/**
 * @author ljheidel
 *
 */
public class RSSFeedJob extends GenericFeedJob {
	
	@SuppressWarnings("unused")
	private static SessionFactory factory;
	private static ServiceRegistry serviceRegistry;
	private Vector<GetRSS> iGetRSSVector = new Vector<GetRSS>();
	
	public RSSFeedJob(){
		/*
		iGetRSSVector.add(new GetRSS("http://www.spc.noaa.gov/products/spcrss.xml"));
	    iGetRSSVector.add(new GetRSS("http://w1.weather.gov/xml/current_obs/KJYO.rss"));
		this.proctrans();
		 */
		try{
			Configuration configuration = new Configuration();
			configuration.configure();
			serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry(); 
			factory = configuration.buildSessionFactory(serviceRegistry);
		}catch (Throwable ex) { 
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex); 
		}
	}
	
	public List listRSSFeeds(SessionFactory aSessionFactory) {
		Session session = aSessionFactory.openSession();
		Transaction tx = null;
		List rf = null;
		try {
			tx = session.beginTransaction();
			rf = session.createQuery("From RSSFeeds").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) {
				tx.rollback();
			}
				e.printStackTrace();
			} finally {
				session.close();
		}
		return rf;
	}
	
	public void proctrans() {
		try {
			for (GetRSS g : iGetRSSVector) {
				g.doFeed();
				System.out.println(g.toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
