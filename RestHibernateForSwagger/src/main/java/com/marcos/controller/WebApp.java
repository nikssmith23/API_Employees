package com.marcos.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcos.hiber.Country;
import com.marcos.hiber.Employee;

@RequestMapping("/api")
@CrossOrigin
@RestController
public class WebApp {

	@Autowired
	SessionFactory sessionFactory;

	@GetMapping("/test")
	public ArrayList<A> test() {
		System.out.println("testing ....OK");
		ArrayList<A> a=new ArrayList<>();
		a.add(new A(1, "Nikit"));
		a.add(new A(2, "Rahul"));
		return a;
		
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/showallemployee")
	public ResponseEntity<List<Employee>> allEmployee() {
		System.out.println("allEmployee called.....");
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Employee.class);
		List<Employee> employees = criteria.list();
		System.out.println(employees);
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);

	}

	@SuppressWarnings("unchecked")
	@GetMapping("/showemployeesbyid/{id}")
	public ResponseEntity<List<Employee>> getEmployeeById(@PathVariable("id") int id) {
		System.out.println("showemployeesbyid called..........");
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("id", id));
		List<Employee> employees = criteria.list();
		System.out.println(employees);
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);

	}

	@SuppressWarnings("unchecked")
	@GetMapping("/showemployeesbyname/{name}")
	public ResponseEntity<List<Employee>> getEmployeeByName(@PathVariable("name") String name) {
		System.out.println("showemployeesbyname called......");
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("name", name));
		List<Employee> employees = criteria.list();
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);

	}

	@SuppressWarnings("unchecked")
	@GetMapping("/status/{status}")
	public ResponseEntity<List<Employee>> getFilterByStatus(@PathVariable("status") String status) {

		System.out.println(status+"Status called.....");
		if (status.equals("active") || status.equals("Active")) {
			Session session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Employee.class);
			criteria.add(Restrictions.eq("status", status));
			List<Employee> employees = criteria.list();
			return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
		} else if (status.equals("inactive") || status.equals("Inactive")) {
			Session session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Employee.class);
			criteria.add(Restrictions.eq("status", status));
			List<Employee> employees = criteria.list();
			return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);

		} else if (status.equals("suspended") || status.equals("Suspended")) {
			Session session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Employee.class);
			criteria.add(Restrictions.eq("status", status));
			List<Employee> employees = criteria.list();
			return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);

		} else {
			System.out.println("Failed");
			return null;
		}
	}

	@PostMapping("/addemployee")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
		System.out.println("AddEmployee called.....");
		System.out.println(employee.getName());
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		System.out.println(employee.getCountry());
		Country country = new Country();
		country.setCid(employee.getCountry().getCid());
		country.setCname(getStateName(employee.getCountry().getCid()));
		employee.setCountry(country);
		session.save(employee);
		transaction.commit();
		return new ResponseEntity<String>("Employee added in db successfully", HttpStatus.OK);
	}
	// ---------------------Extra Code suportive-------------------

	@SuppressWarnings("unchecked")
	private String getStateName(int cid) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Country.class);
		criteria.add(Restrictions.eq("cid", cid));
		List<Country> list = criteria.list();
		String countryName = null;
		for (Country country : list) {
			countryName = country.getCname();
		}
		return countryName;
	}
	// -------------------------------------------------------------

	@PostMapping("/addcountry")
	public ResponseEntity<String> addCountry(@RequestBody Country country) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(country);
		transaction.commit();
		return new ResponseEntity<String>("Country added in db successfully", HttpStatus.OK);
	}

	@PutMapping("/updatecountryname")
	public ResponseEntity<String> updateCountryName(@RequestBody Country country) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(country);
		transaction.commit();
		return new ResponseEntity<String>("Country updated in db successfully", HttpStatus.OK);
	}

	@SuppressWarnings("unchecked")
	@DeleteMapping("/deletebycountryname/{cname}")
	public ResponseEntity<String> deleteByCountryName(@PathVariable String cname) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Country.class);
		criteria.add(Restrictions.eq("cname", cname));
		List<Country> countrys = criteria.list();
		for (Country country : countrys) {
			session.delete(country);
		}
		transaction.commit();
		return new ResponseEntity<String>("Country deleted from db successfully", HttpStatus.OK);
	}

	@DeleteMapping("/deleteemployeebyid/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("id", id));
		Employee employee = (Employee) criteria.uniqueResult();
		session.delete(employee);
		transaction.commit();
		return new ResponseEntity<String>("Country deleted from db successfully", HttpStatus.OK);
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/listofempbeforetoday")
	public ResponseEntity<List<Employee>> listOfEmpBeforeToday(Date dateTo) {
		final Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		Date sqlDate = new Date(cal.getTime().getTime());
		dateTo = sqlDate;
		Date dateFrom = new Date(1970 - 01 - 01);
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("select e from Employee e where e.createddtm between :start and :end ");
		query.setDate("start", dateFrom);
		query.setDate("end", dateTo);
		List<Employee> employees = query.list();
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);

	}
}
