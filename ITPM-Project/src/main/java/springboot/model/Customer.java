package springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="customers")

public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	
	@Column(name = "cfullName")
	private String cfullName;
	
	@Column(name = "caddress")
	private String caddress;
	
	@Column(name = "cphone")
	private String cphone;
	
	@Column(name = "cpassword")
	private String cpassword;
	
	@Column(name = "cuserName")
	private String cuserName;
	
	@Column(name = "cemail")
	private String cemail;
	
	public Customer() {
		
	}
	
	
	public Customer(String cfullName, String caddress, String cphone, String cpassword, String cuserName,
			String cemail) {
		super();
		this.cfullName = cfullName;
		this.caddress = caddress;
		this.cphone = cphone;
		this.cpassword = cpassword;
		this.cuserName = cuserName;
		this.cemail = cemail;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCfullName() {
		return cfullName;
	}
	public void setCfullName(String cfullName) {
		this.cfullName = cfullName;
	}
	public String getCaddress() {
		return caddress;
	}
	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}
	public String getCphone() {
		return cphone;
	}
	public void setCphone(String cphone) {
		this.cphone = cphone;
	}
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	public String getCuserName() {
		return cuserName;
	}
	public void setCuserName(String cuserName) {
		this.cuserName = cuserName;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	
	
	
}
