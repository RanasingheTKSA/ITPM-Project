package springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.model.cartModel;
import springboot.repository.cartRepository;

@RestController
@RequestMapping ("/api/v1/")
public class cartController {

	@Autowired
	private  cartRepository cartrepository;
	
	// get all cart items
	@GetMapping ("cartModels")
	public List<cartModel> getAllcaCartModels(){
		return cartrepository.findAll();
	}
}
