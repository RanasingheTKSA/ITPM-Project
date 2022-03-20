package springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.model.Customer;
import springboot.repository.CustomerRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping ("/api/v1/")


public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	//sample
	//get all customers
	@GetMapping("/customer")
	public List<Customer> getAllCustomer(){
		return customerRepository.findAll();
	}
	
}
