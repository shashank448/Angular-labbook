package org.capg.service;

import java.util.List;

import javax.transaction.Transactional;

import org.capg.dao.ICustomerDao;
import org.capg.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;


@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {
	
	private ICustomerDao customerDao;
	
	public ICustomerDao getCustomerDao() {
		return customerDao;
		
	}
	@Autowired
	public void setCustomerDao(ICustomerDao customerDao) {
		this.customerDao=customerDao;
	}
	
	
	@Override
	public Customer findById(int id) {
		return customerDao.findById(id);
	}

	@Override
	public Customer save(Customer customer) {
		return customerDao.save(customer);
	}

	@Override
	public List<Customer> fetchAll() {
		return customerDao.fetchAll();
	}

	@Override
	public boolean remove(int id) {
		return customerDao.remove(id);
	}

}
