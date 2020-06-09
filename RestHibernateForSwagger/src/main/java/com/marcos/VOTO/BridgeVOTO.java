package com.marcos.VOTO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.marcos.hiber.Country;
import com.marcos.hiber.Employee;
import com.marcos.pojo.CountryVo;
import com.marcos.pojo.EmployeeVo;

public class BridgeVOTO {

	@Autowired
	SessionFactory sessionFactory;

	public Country savecountry(CountryVo countryVo) {
		Country country = new Country();
		country.setCname(countryVo.getCname());
		return country;
	}

	public Employee saveEmployee(EmployeeVo vo) {
		Employee employee = new Employee();
		employee.setName(vo.getName());
		employee.setPhoneno(vo.getPhoneno());
		employee.setStatus(vo.getStatus());
		employee.setDepartment(vo.getDepartment());
		employee.setCreatedby(vo.getCreatedby());
		employee.setCreateddtm(vo.getCreateddtm());
		employee.setUpdatedby(vo.getUpdatedby());
		employee.setUpdateddtm(vo.getUpdateddtm());
		return employee;
	}

}
