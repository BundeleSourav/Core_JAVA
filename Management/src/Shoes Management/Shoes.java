package ShoesManagement;

import java.io.Serializable;
import java.time.LocalDate;

public class Shoes implements Serializable {
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
	
	
	private int sid;
	private Category type;
	private LocalDate listdate;
	private int quantity;
	private LocalDate update;
	private float size;
	private double price;
	private String Color;
	private float percentage;
	private static int id;
	
	static
	{
		id=101;
	}

	public Shoes( Category type, LocalDate listdate, int quantity, LocalDate update, float size, double price,
			String color, float percentage) {
		super();
		this.sid = id;
		this.type = type;
		this.listdate = listdate;
		this.quantity = quantity;
		this.update = update;
		this.size = size;
		this.price = price;
		this.Color = color;
		this.percentage = percentage;
		id++;
	}

	@Override
	public String toString() {
		return "Shoes [sid=" + sid + ", type=" + type + ", listdate=" + listdate + ", quantity=" + quantity
				+ ", update=" + update + ", size=" + size + ", price=" + price + ", Color=" + Color + ", percentage="
				+ percentage + "]";
	}

	public int getSid() {
		return sid;
	}

//	public void setSid(int sid) {
//		this.sid = sid;
//	}

	public Category getType() {
		return type;
	}

	public void setType(Category type) {
		this.type = type;
	}

	public LocalDate getListdate() {
		return listdate;
	}

	public void setListdate(LocalDate listdate) {
		this.listdate = listdate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public LocalDate getUpdate() {
		return update;
	}

	public void setUpdate(LocalDate update) {
		this.update = update;
	}

	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}

	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}
	
	
	
	
	
}
