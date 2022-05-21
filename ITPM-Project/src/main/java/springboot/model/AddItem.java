package springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="add_items")
public class AddItem {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="item_name")
	private String itemname;
	
	@Column(name="product_id")
	private String productid;
	
	@Column(name="description")
	private String description;
	
	@Column(name="price")
	private int price;
	
	@Column(name="size")
	private String  size;
	
	@Column(name="color")
	private String color;
	
	@Column(name="category")
	private String category;
	
	@Column(name="published_date")
	private int publisheddate;

	
	public AddItem() {
		
	}
	
	public AddItem(Long id, String itemname, String productid, String description, int price, String size,
			String color, String category, int publisheddate) {
		super();
		this.id=id;
		this.itemname = itemname;
		this.productid = productid;
		this.description= description;
		this.price = price;
		this.size = size;
		this.color = color;
		this.category = category;
		this.publisheddate = publisheddate;
		
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPublisheddate() {
		return publisheddate;
	}
	public void setPublisheddate(int publisheddate) {
		this.publisheddate = publisheddate;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	
} 
