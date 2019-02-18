package com.prathamesh.other;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.prathamesh.entity.Customer;

public class CustomerUtil {

	Configuration cfg = new Configuration().configure("/hibernate.cfg.xml");
	SessionFactory sf = cfg.buildSessionFactory();

	public Customer addCustomer(Customer c) {

		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();
		s.save(c);
		s.flush();
		tr.commit();
		return c;
	}

	public Customer updateCustomer(Customer c) {
		CustomerUtil cUtil = new CustomerUtil();
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();
		int cId = c.getCustomerId();
		Customer ce = cUtil.getCustomer(cId);
		if (cId == ce.getCustomerId()) {
			s.merge(c);
		}
		if (cId != ce.getCustomerId()) {
			s.save(c);
		}
		s.flush();
		tr.commit();
		return c;
	}

	public Customer getCustomer(int id) {
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();
		Customer c = s.get(Customer.class, id);
		s.flush();
		tr.commit();
		return c;
	}

	public List<Customer> getAllCustomers() {
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();
		List<Customer> cList = s.createQuery("from Customer").list();
		s.flush();
		tr.commit();
		return cList;
	}

	public Customer deleteCustomer(int id) {
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();
		Customer c = s.get(Customer.class, id);
		s.delete(c);
		s.flush();
		tr.commit();
		return c;
	}

}
