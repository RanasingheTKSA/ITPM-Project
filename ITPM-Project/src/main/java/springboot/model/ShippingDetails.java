package springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "shipping_details")
public class ShippingDetails {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column (name = "Owner_Name")
	private String ownerName;
	
	@Column (name = "Phone_Number")
	private String phoneNumber;
	
	@Column (name = "Shipping_Address")
	private String shippingAddress;
	
	@Column (name = "Zip_Code")
	private String zipCode;
	
	public ShippingDetails() {
		
	}

	public ShippingDetails(String ownerName, String phoneNumber, String shippingAddress, String zipCode) {
		super();
		this.ownerName = ownerName;
		this.phoneNumber = phoneNumber;
		this.shippingAddress = shippingAddress;
		this.zipCode = zipCode;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	
	
	
}
