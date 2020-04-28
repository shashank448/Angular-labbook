package org.capg.dao;

import java.util.List;

import org.capg.entities.Customer;

public interface ICustomerDao {
	Customer findById(int id);
	Customer save(Customer customer);
	List<Customer> fetchAll();
	boolean remove(int id);
	

}
