package Showroom;

import java.time.LocalDate;
/*
 * 
 */

public class Vehicle //implements Comparable<Vehicle> 
{
	
	private String chasino;
	private String name;
	private Color color;
	private double price;
	private int custid;
	private LocalDate mdate;
	private String company;
	private static int chno;
	private static String csno;
	static
	{
		chno=151;
		csno="DCP-";
	}
	public Vehicle( String name, Color color, double price, LocalDate mdate, String company) {
		super();
		this.chasino = csno+chno;
		this.name = name;
		this.color = color;
		this.price = price;
		this.mdate = mdate;
		this.company = company;
		chno++;
	}
	public Vehicle(String chasino)
	{
		this.chasino=chasino;
	}
	public String getChasino() {
		return chasino;
	}
	public void setChasino(String chasino) {
		this.chasino = chasino;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public LocalDate getMdate() {
		return mdate;
	}
	public void setMdate(LocalDate mdate) {
		this.mdate = mdate;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "Vehicle [chasino=" + chasino + ", name=" + name + ", color=" + color + ", price=" + price + ", mdate="
				+ mdate + ", company=" + company + "]";
	}
	
	@Override
	public boolean equals(Object anovehicle)
	{
		if(anovehicle instanceof Vehicle)
			return this.chasino.equals(((Vehicle)anovehicle).chasino);
		
		return false;
	}
	
//	public int compareto(Vehicle anovehicle)
//	{
//		return this.chasino.compareTo(anovehicle.chasino);
//	}
//	

}
