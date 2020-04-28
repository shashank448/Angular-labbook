package org.capg.controller;
import java.util.List;


import org.capg.entities.Customer;
import org.capg.service.ICustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
    private static Logger Log= LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private ICustomerService customerService;
    
    
    @GetMapping("/find")
    public ModelAndView findPage() {
    	return new ModelAndView("findcustomer");
    }
    @GetMapping("/processfindcustomer")
    public ModelAndView customerDetails(@RequestParam("custid") int id)
    {
    	System.out.println("Inside CustomerDetails");
    	Customer customer=customerService.findById(id);
    	return new ModelAndView("customerdetails","customer",customer);
    }
    
    @GetMapping("/register")
    public ModelAndView registerCustomer() {
    	return new ModelAndView("customerregister");
    }
    
    @GetMapping("/processregister")
    public ModelAndView registerCustomer(@RequestParam("custname") String custName) {
        Customer customer=new Customer();
        customer.setCustomerName(custName);
        customer=customerService.save(customer);
        return new ModelAndView("customerdetails","customer",customer);
    }
      
    @GetMapping("/displayall")
    public ModelAndView displayAll(){
        List<Customer> customers= customerService.fetchAll();
        ModelAndView modelAndView=new ModelAndView("listcustomers","customers",customers);
        return modelAndView;
    }
       
     


}
