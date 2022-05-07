package springboot.model;

import java.io.File;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "cart_items")
public class Cart {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column (name = "Item_Name")
	private String itmeName;
	
	@Column (name = "Item_Description")
	private String itemDescription;
	
	@Column (name = "Item_Size")
	private String itemSize;
	
	@Column (name = "Item_Colour")
	private String itemColour;
	
	@Column (name = "Item_Price")
	private float itemPrice;
	
	@Column (name = "Image")
	private File image;
	
	
	public Cart() {}
	public Cart(String itmeName, String itemDescription, String itemSize, String itemColour, float itemPrice, File image) {
		super();
		this.itmeName = itmeName;
		this.itemDescription = itemDescription;
		this.itemSize = itemSize;
		this.itemColour = itemColour;
		this.itemPrice = itemPrice;
		this.image = image;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getItmeName() {
		return itmeName;
	}
	public void setItmeName(String itmeName) {
		this.itmeName = itmeName;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public String getItemSize() {
		return itemSize;
	}
	public void setItemSize(String itemSize) {
		this.itemSize = itemSize;
	}
	public String getItemColour() {
		return itemColour;
	}
	public void setItemColour(String itemColour) {
		this.itemColour = itemColour;
	}
	public float getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}
	public File getImage() {
		return image;
	}
	public void setImage(File image) {
		this.image = image;
	}
	
}
