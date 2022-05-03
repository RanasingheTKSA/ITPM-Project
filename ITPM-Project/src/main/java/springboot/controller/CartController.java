package springboot.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;

import springboot.exception.ResourceNotFoundException;
import springboot.model.Cart;
import springboot.model.CartPDFExporter;
import springboot.repository.CartRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping ("/api/v1/")
public class CartController {

	@Autowired
	private  CartRepository cartrepository;
	
	// get all cart items
	@GetMapping ("cartModels")
	public List<Cart> getAllCartModels(){
		return cartrepository.findAll();
	}
	
	//delete cart items 
	@DeleteMapping("/cartModels/{id}")
	public ResponseEntity < Map<String, Boolean>> deleteCartItems (@PathVariable Long id){
		Cart cartItem = cartrepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cart item not exist with id : " +id));
		
		cartrepository.delete(cartItem);
		Map<String , Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	// generate pdf
	@GetMapping("/cardDetails/export/pdf")
	public void exportToPDF (HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		String currentDateTime = dateFormatter.format(new Date());
		
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename= item_list_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);
		
		List<Cart> cartItemList = getAllCartModels();
		CartPDFExporter expoter = new CartPDFExporter(cartItemList);
		expoter.export(response);
		
	}
}
