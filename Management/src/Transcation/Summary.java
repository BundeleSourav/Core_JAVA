package Transcation;

import java.time.LocalDate;

public class Summary {
	
	private LocalDate date;
	private Narration task;
	private double wdraw;
	private double deposit;
	public Summary( LocalDate date, Narration task, double wdraw, double deposit) {
		super();
		this.date = date;
		this.task = task;
		this.wdraw = wdraw;
		this.deposit = deposit;
	}
	
	public Summary()
	{
		
	}

	@Override
	public String toString() {
		return "Summary [" + " date=" + date + ", task=" + task + ", wdraw=" + wdraw + ", deposit="
				+ deposit + "]";
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Narration getTask() {
		return task;
	}

	public void setTask(Narration task) {
		this.task = task;
	}

	public double getWdraw() {
		return wdraw;
	}

	public void setWdraw(double wdraw) {
		this.wdraw = wdraw;
	}

	public double getDeposit() {
		return deposit;
	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
	
	
	
	
}
