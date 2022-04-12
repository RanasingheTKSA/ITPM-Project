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
import springboot.model.CardDetails;
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
		cardDetails.setExpirationDate(card_deatils.getExpirationDate());
		
		CardDetails CARD_DETAILS = carddetailsrepository.save(cardDetails);
		return ResponseEntity.ok(CARD_DETAILS);
	}
}
