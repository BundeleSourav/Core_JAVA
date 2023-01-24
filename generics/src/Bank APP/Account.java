package bank;

import java.io.Serializable;
import java.time.LocalDate;
import static bank.IoUtils.*;

public class Account implements Serializable {
	
	private int actno;
	private String name;
	private ACType actype;
	private double balance;
	private Address adress;
	private LocalDate date;
	private String password;
	private static int id;
	static 
	{
		id=201;
	}
	public Account(int actno)
	{
		this.actno=actno;
	}
	public Account(String name, ACType actype, double balance, LocalDate date,String password) {
		super();
		this.actno = id++;
		this.name = name;
		this.actype = actype;
		this.balance = balance;
		this.date = date;
		this.password=password;
	}
	@Override
	public String toString() {
		return "Account [actno=" + actno + ", name=" + name + ", actype=" + actype + ", balance=" + balance + ", date="
				+ date +", password= "+password+ "]";
	}
	
	public void deposit(double amount)
	{
		this.balance+=amount;
	}
	public void withdraw(double amount) throws BankException
	{
		validatebal(this.balance-amount);
		this.balance-=amount;
	}
	
	public void transferfunds(double amount,Account actno) throws BankException
	{
		this.withdraw(amount);
		actno.deposit(amount);
	}
	public int getActno() {
		return actno;
	}
//	public void setActno(int actno) {
//		this.actno = actno;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ACType getActype() {
		return actype;
	}
	public void setActype(ACType actype) {
		this.actype = actype;
	}
	public Address getAdress() {
		return adress;
	}
	public void setAdress(Address adress) {
		this.adress = adress;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getpassword()
	{
		return password;
	}
	public void setpassword(String password)
	{
		this.password=password;
	}
	
	public void linkadrs(String adrs, String city, String state, String country, int zipcode)
	{
		this.adress=new Address(adrs, city, state, country, zipcode);
		System.out.println("Address assigned successfully");
	}
	
	
	public class Address{
		private String adrs;
		private String city;
		private String state;
		private String country;
		private int zipcode;
		public Address(String adrs, String city, String state, String country, int zipcode) {
			super();
			this.adrs = adrs;
			this.city = city;
			this.state = state;
			this.country = country;
			this.zipcode = zipcode;
		}
		@Override
		public String toString() {
			return "Address [adrs=" + adrs + ", city=" + city + ", state=" + state + ", country=" + country
					+ ", zipcode=" + zipcode + "]";
		}
		
		
	}
	

}
