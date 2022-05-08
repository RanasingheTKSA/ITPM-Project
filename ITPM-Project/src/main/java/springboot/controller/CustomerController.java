package springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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

import springboot.exception.ResourceNotFoundException;
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
	
	
	//create employee rest api
	@PostMapping("/customer")
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}
	
	//get customer by id rest api
	@GetMapping("customer/{id}")
	public ResponseEntity<Customer>getCustomerById( @PathVariable Long id) {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException ("Customer not found with id num: " +id ));
		return ResponseEntity.ok(customer);
	}
	
	//update customer rest api
	@PutMapping("/customer/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customerProfile){
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException ("Customer not found with id num: " +id ));
		
		customer.setCfullName(customerProfile.getCfullName());
		customer.setCaddress(customerProfile.getCaddress());
		customer.setCphone(customerProfile.getCphone());
		customer.setCemail(customerProfile.getCemail());
		customer.setCpassword(customerProfile.getCpassword());
		customer.setCuserName(customerProfile.getCuserName());
		
		
		Customer updateCustomer = customerRepository.save(customer);
		return ResponseEntity.ok(updateCustomer);
	}
	
	//DELETE customer
	
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<Map<String, Boolean >> deleteCustomer(@PathVariable Long id){
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException ("Customer not found with id num: " + id ));
		
		customerRepository.delete(customer);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
