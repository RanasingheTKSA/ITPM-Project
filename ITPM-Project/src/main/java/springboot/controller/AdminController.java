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
import springboot.model.Admin;
import springboot.repository.AdminRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class AdminController {
	

	@Autowired
    private AdminRepository adminRepository;
	
	//get all admins
	
	@GetMapping("/admins")
	public List<Admin> getAllAdmins(){
		return adminRepository.findAll();
	}
	
	//create admin rest api
	@PostMapping("/admins")
	public Admin createAdmin(@RequestBody Admin admin) {
		return adminRepository.save(admin);
	}
	
	//get admin by id rest api
	@GetMapping("/admins/{id}")
	public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {
		Admin admin = adminRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("admin not exist with id : " +id));
		return ResponseEntity.ok(admin);
	}
	
	//update admin rest api
	@PutMapping("/admins/{id}")
	public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody Admin adminDetails){
		Admin admin = adminRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("admin not exist with id : " +id));
		
		
		admin.setFullName(adminDetails.getFullName());
		admin.setNIC(adminDetails.getNIC());
		admin.setGender(adminDetails.getGender());
		admin.setBirthday(adminDetails.getBirthday());
		admin.setAddress(adminDetails.getAddress());
		admin.setEmail(adminDetails.getEmail());
		admin.setPhoneNo(adminDetails.getPhoneNo());
		
		Admin updatedAdmin = adminRepository.save(admin);
		return ResponseEntity.ok(updatedAdmin);
		
	}
	
	//delete admin rest api
	@DeleteMapping("/admins/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteAdmin(@PathVariable Long id){
		Admin admin = adminRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("admin not exist with id : " +id));
		
		adminRepository.delete(admin);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
}

