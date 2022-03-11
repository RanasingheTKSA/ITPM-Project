package springboot_Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot_Model.cartModel;
import springboot_Repository.cartRepository;

@RestController
@RequestMapping("api/v1/")
public class cartController {
	
	@Autowired
	private cartRepository cartrepository;
	
	//get all cart items
	@GetMapping("cartItems")
	public List<cartModel> getAllCartItems(){
		return cartrepository.findAll();
	}
}
