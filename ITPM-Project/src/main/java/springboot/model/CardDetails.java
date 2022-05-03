package springboot.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "card_details")
public class CardDetails {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column (name = "Card_Holder_Name")
	private String cardHolderName;
	
	@Column (name = "Card_Number")
	private String cardNumber;
	
	@Column (name = "Expiration_Date")
	private Date expirationDate;
	
	public CardDetails() {}
	public CardDetails(String cardHolderName, String cardNumber, Date expirationDate) {
		super();
		this.cardHolderName = cardHolderName;
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	
}
