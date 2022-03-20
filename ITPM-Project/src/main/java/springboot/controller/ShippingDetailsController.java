package springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.model.ShippingDetails;
import springboot.repository.ShippingDetailsRepository;

@RestController
@RequestMapping ("/api/v2/")
public class ShippingDetailsController {
	
	@Autowired
	private ShippingDetailsRepository shippingDetailsRepository; 
	
	//get address of the client
	@GetMapping("shippingDetils")
	public List<ShippingDetails> getShippingDetails(){
		return shippingDetailsRepository.findAll();
	}
}