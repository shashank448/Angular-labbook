package org.capg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.capg.entities.Customer;
import org.springframework.stereotype.Repository;


@Repository
public class CustomerDaoImpl implements ICustomerDao{
	private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


	@Override
	public Customer findById(int id) {
		Customer customer=entityManager.find(Customer.class, id);
		return customer;
	}

	@Override
	public Customer save(Customer customer) {
		customer=getEntityManager().merge(customer);
		return customer;
	}

	@Override
	public List<Customer> fetchAll() {
		String jql="from customers";
		TypedQuery<Customer> query=entityManager.createQuery(jql, Customer.class);
		List<Customer> list=query.getResultList();
		return list;
	}

	@Override
	public boolean remove(int id) {
		Customer customer=findById(id);
		getEntityManager().remove(customer);
		return true;
	}

}
