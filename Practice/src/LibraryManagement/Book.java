package LibraryManagement;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;


public class Book implements Serializable {
	
	private int bookid;
	private int labid;
	private String name;
	private String author;
	private LocalDate rdate;
	private static int id;
	static {
		id=150;
	}
	public Book(int bookid, String name, String author, LocalDate rdate) {
		super();
		this.labid=id;
		this.bookid = bookid;
		this.name = name;
		this.author = author;
		this.rdate = rdate;
		id++;
	}
	@Override
	public String toString() {
		return "Book [Labid="+labid+"bookid=" + bookid + ", name=" + name + ", author=" + author + ", rdate=" + rdate + "]";
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public LocalDate getRdate() {
		return rdate;
	}
	public void setRdate(LocalDate rdate) {
		this.rdate = rdate;
	}
	
	

}
