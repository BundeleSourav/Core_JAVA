package libraryMan;

import java.io.Serializable;
import java.time.LocalDate;

public class Book implements Serializable {
	
	/*
	 * 
	 */
	
	private static final long serialversionUID=1L;
	private String name;
	private String author;
	private double price;
	private int bookid;
	private LocalDate date;
	private int count;
	public Book(String name, String author, double price, int bookid,LocalDate date,int count) {
		super();
		this.name = name;
		this.author = author;
		this.price = price;
		this.bookid = bookid;
		this.date=date;
		this.count=count;
	}
	@Override
	public String toString() {
		return "Book [name=" + name + ", author=" + author + ", price=" + price + ", bookid=" + bookid +" Date= "+date+ ",Quantity="+count+ "]";
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setDate(LocalDate date)
	{
		this.date=date;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public LocalDate getdate()
	{
		return date;
	}
	
	

}
