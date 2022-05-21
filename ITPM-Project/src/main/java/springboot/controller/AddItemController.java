package springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.exception.ResourceNotFoundException;
import springboot.model.AddItem;
import springboot.repository.AddItemRepository;


@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping ("/api/v1/")
public class AddItemController {
	
	@Autowired
	private AddItemRepository additemRepository ;
	
	// get all items
	@GetMapping ("/additems")
	public List<AddItem> getAllAddItems(){
		return additemRepository.findAll();
	}
	
	//create add item rest API
	@PostMapping("/additems")
	public AddItem createAddItem( @RequestBody  AddItem additem) {
		return  additemRepository.save(additem);
	}
	 
	//get employee by id rest API
		@GetMapping("/additems/{id}")
		 public ResponseEntity <AddItem> getAddItemById(@PathVariable Long id) {
			
			AddItem additem =additemRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("AddItem not exist with id: "+id));
			return ResponseEntity.ok(additem);
			 
		 } 
}
