package springboot_Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cartModels")
public class cartModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "Item_Name")
	private String itemName;
	
	@Column(name = "Item_Description")
	private String description;
	
	@Column(name = "Item_Size")
	private String size;
	
	@Column(name = "Item_Colour")
	private String colour;
	
	@Column(name = "Item_Price")
	private float price;
	
	
	public cartModel(){
		
	}
	
	public cartModel(String itemName, String description, String size, String colour, float price) {
		super();
		this.itemName = itemName;
		this.description = description;
		this.size = size;
		this.colour = colour;
		this.price = price;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}	
}
