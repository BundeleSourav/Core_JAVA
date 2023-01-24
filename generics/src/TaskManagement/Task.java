package TaskManagement;

import java.time.LocalDate;

@SuppressWarnings("rawtypes")
public class Task implements Comparable {
	
	private int taskid;
	private String name;
	private String desc;
	private Status status;
	private boolean active;
	private LocalDate date;
	private static int id;
	//private static Status st;
	private static boolean state;
	static 
	{
		id=21;
		state=true;
	}
	public Task() {
		// TODO Auto-generated constructor stub
	}
	public Task(int taskid)
	{
		this.taskid=taskid;
	}
	public Task(String name, String desc,LocalDate date) {
		super();
		this.taskid=id;
		this.name = name;
		this.desc = desc;
		this.date=date;
		this.status=Status.PENDING;
		this.active=state;
		id++;
	}
	
	@Override
	public String toString() {
		return "Task [taskid=" + taskid + ", name=" + name + ", desc=" + desc + ", status=" + status + ", active="
				+ active +", date=" + date + "]";
	}
	public int getTaskid() {
		return taskid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public LocalDate getdate()
	{
		return date;
	}
	public void setdate(String date)
	{
		this.date=LocalDate.parse(date);
	}
	
//	public int compare(Task m,Task n)
//	{
//		return m.getdate().compareTo(n.getdate());
//	}
	@Override
	public int compareTo(Object o) {
		
	return this.date.compareTo(((Task)o).date);
	}

}
