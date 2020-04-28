package org.capg.controller;

import java.util.List;

import org.capg.dto.CustomerDto;
import org.capg.entities.Customer;
import org.capg.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerRestController {
	
	@Autowired
	private ICustomerService service;
	
	@GetMapping("/customers/find/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") int id){
		Customer customer=service.findById(id);
		if (customer==null) {
			ResponseEntity<Customer> response=new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return response;
		}
		else
		{
			ResponseEntity<Customer> response=new ResponseEntity<>(HttpStatus.OK);
			return response;
		}		
	}
	
	@PostMapping("/customers/add")
	public  ResponseEntity<Customer> addCustomer(@RequestBody CustomerDto dto){
		Customer customer=new Customer();
		customer.setCustomerId(dto.getCustomerId());
		customer.setCustomerName(dto.getCustomerName());
		
		customer=service.save(customer);
		ResponseEntity<Customer> response=new ResponseEntity<>(HttpStatus.OK);
		return response;
	}
	@GetMapping("/employees")
	public  ResponseEntity<List<Customer>> fetchAll(){
		List<Customer> customers=service.fetchAll();
		ResponseEntity<List<Customer>> response=new ResponseEntity<>(customers,HttpStatus.OK);
		return response;
	}
	
	@DeleteMapping("/customers/delete/{id}")
	public  ResponseEntity<Boolean> deleteCustomer(@PathVariable int id){
		boolean result= service.remove(id);
	    ResponseEntity<Boolean>response=new ResponseEntity<>(result, HttpStatus.OK);
	    return response;
	}
	
	
	@PutMapping("customers/update/{id}")
	public  ResponseEntity<Customer> updateCustomer(@RequestBody CustomerDto dto,@PathVariable("id") int id){
		Customer customer=new Customer();
		customer.setCustomerId(dto.getCustomerId());
		customer.setCustomerName(dto.getCustomerName());
		customer.setCustomerId(id);
		customer=service.save(customer);
		ResponseEntity<Customer> response=new ResponseEntity<>(HttpStatus.OK);
		return response;
	}
}
