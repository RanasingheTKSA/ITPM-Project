package springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.exception.ResourceNotFoundException;
import springboot.model.ShippingDetails;
import springboot.repository.ShippingDetailsRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping ("/api/v2/")
public class ShippingDetailsController {
	
	@Autowired
	private ShippingDetailsRepository shippingDetailsRepository; 
	
	//get shipping details of the client
	@GetMapping("shippingDetails")
	public List<ShippingDetails> getShippingDetails(){
		return shippingDetailsRepository.findAll();
	}
	
	//add shipping details
	@PostMapping ("/shippingDetails")
	public ShippingDetails addShippingDetails(@RequestBody ShippingDetails shippingDetails) {
		return shippingDetailsRepository.save(shippingDetails);
	}
	
	//get shipping details by rest api
	@GetMapping("/shippingDetails/{id}")
	public ResponseEntity<ShippingDetails> getShippingDetailsById(@PathVariable Long id){
		ShippingDetails shippingDetails = shippingDetailsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Shipping details not exist with id : " +id));
		
		return ResponseEntity.ok(shippingDetails);
	}
	
	//update shipping details by rest api
	@PutMapping ("/shippingDetails/{id}")
	public ResponseEntity<ShippingDetails> updatShippingDetails (@PathVariable Long id, @RequestBody ShippingDetails update_shipping_details){
		
		ShippingDetails shippingDetails = shippingDetailsRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Shipping details not exist with id : " +id));
		
		shippingDetails.setOwnerName(update_shipping_details.getOwnerName());
		shippingDetails.setPhoneNumber(update_shipping_details.getPhoneNumber());
		shippingDetails.setEmail(update_shipping_details.getEmail());
		shippingDetails.setShippingAddress(update_shipping_details.getShippingAddress());
		shippingDetails.setZipCode(update_shipping_details.getZipCode());
		
		ShippingDetails shipping_details = shippingDetailsRepository.save(shippingDetails);
		return ResponseEntity.ok(shipping_details);
	}
}