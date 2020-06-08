package com.marcos.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.marcos.hiber.Country;
import com.marcos.hiber.Employee;


public class DBConn {
	private static SessionFactory sf = null;

	public static SessionFactory getSessionFacory() {
		Configuration cfg = new Configuration();
		cfg.configure().addAnnotatedClass(Employee.class);
		cfg.configure().addAnnotatedClass(Country.class);
		sf = cfg.buildSessionFactory();
		return sf;
	}
}