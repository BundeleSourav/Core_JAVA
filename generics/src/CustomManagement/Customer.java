package CustomManagement;

import java.time.LocalDate;

public class Customer {
	
	private int cid;
	private String name;
	private String email;
	private String pswd;
	private LocalDate date;
	private Services plan;
	private static int idgenerator;
	
	static 
	{
		idgenerator=1;
		
	}

	public Customer( String name, String email, String pswd, LocalDate date, Services plan) {
		super();
		this.cid = idgenerator++;
		this.name = name;
		this.email = email;
		this.pswd = pswd;
		this.date = date;
		this.plan = plan;
	}
	
	public Customer(String email)
	{
		this.email=email;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", name=" + name + ", email=" + email + ", pswd=" + pswd + ", date=" + date
				+ ", plan=" + plan + "]";
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(o instanceof Customer)
		{
			Customer ct=(Customer)o;
			return this.email.equals(ct.email);
		}
		else
			return false;
	}

	public int getCid() {
		return cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Services getPlan() {
		return plan;
	}

	public void setPlan(Services plan) {
		this.plan = plan;
	}
	
	
	
	
}
