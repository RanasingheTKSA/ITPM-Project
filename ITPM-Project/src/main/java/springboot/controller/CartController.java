package springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.model.Cart;
import springboot.repository.CartRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping ("/api/v1/")
public class CartController {

	@Autowired
	private  CartRepository cartrepository;
	
	// get all cart items
	@GetMapping ("cartModels")
	public List<Cart> getAllcaCartModels(){
		return cartrepository.findAll();
	}
}
