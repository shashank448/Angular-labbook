package org.capg.service;

import java.util.*;

import org.capg.entities.Customer;

public interface ICustomerService {
	Customer findById(int id);
	Customer save(Customer customer);
	List<Customer> fetchAll();
	boolean remove(int id);

}
