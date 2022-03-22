package springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admins")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "full_name")
	private String fullName;
	
	@Column(name = "nic")
	private String NIC;
	
	@Column(name = "birthday")
	private String Birthday;
	
	@Column(name = "gender")
	private String Gender;
	
	@Column(name = "address")
	private String Address;
	
	@Column(name = "phone_no")
	private String phoneNo;
	
	@Column(name = "email_id")
	private String email;
	
	public Admin() {
		
	}
	
	public Admin(String fullName, String nIC, String birthday, String gender, String address, String phoneNo,
			String email) {
		super();
		this.fullName = fullName;
		NIC = nIC;
		Birthday = birthday;
		Gender = gender;
		Address = address;
		this.phoneNo = phoneNo;
		this.email = email;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getNIC() {
		return NIC;
	}
	public void setNIC(String nIC) {
		NIC = nIC;
	}
	public String getBirthday() {
		return Birthday;
	}
	public void setBirthday(String birthday) {
		Birthday = birthday;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	

}
