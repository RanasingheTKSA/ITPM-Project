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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;

import springboot.exception.ResourceNotFoundException;
import springboot.model.CardDetails;
import springboot.model.Cart;
import springboot.repository.CardDetailsRepository;

@CrossOrigin (origins = "http://localhost:3000")
@RestController
@RequestMapping ("/api/v3/")

public class CardDetailsController {

	@Autowired
	private CardDetailsRepository carddetailsrepository;
	
	// get card details from the client
	@GetMapping ("cardDetails")
	public List<CardDetails> getCardDetails(){
		return carddetailsrepository.findAll();
	}
	
	// add card details
	@PostMapping ("/cardDetails")
	public CardDetails addCardDetails(@RequestBody CardDetails cardDetails) {
		return carddetailsrepository.save(cardDetails);
	}
	
	// get card details by rest api
	@GetMapping ("/cardDetails/{id}")
	public ResponseEntity<CardDetails> getCardDetailsById (@PathVariable Long id){
		CardDetails cardDetails = carddetailsrepository.findById(id)
				.orElseThrow (() -> new ResourceNotFoundException("Card Deatils not exist with id :" + id));
		
		return ResponseEntity.ok(cardDetails);
	}
	
	//update card details by rest api
	@PutMapping ("/cardDetails/{id}")
	public ResponseEntity<CardDetails> updateCardDetails (@PathVariable Long id, @RequestBody CardDetails card_deatils){
		
		CardDetails cardDetails = carddetailsrepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Card Deatils not exist with id :" + id));
		
		cardDetails.setCardHolderName(card_deatils.getCardHolderName());
		cardDetails.setCardNumber(card_deatils.getCardNumber());
		cardDetails.setDate(card_deatils.getDate());
		cardDetails.setCvv(card_deatils.getCvv());
//		cardDetails.setExpirationDate(card_deatils.getExpirationDate());
		
		CardDetails CARD_DETAILS = carddetailsrepository.save(cardDetails);
		return ResponseEntity.ok(CARD_DETAILS);
	}
	
	//delete card details
	@DeleteMapping ("/cardDetails/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCardDetails (@PathVariable Long id){
		CardDetails cardDetails = carddetailsrepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Card details not exiting : " +id));
		
		carddetailsrepository.delete(cardDetails);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);

	}
	
}
