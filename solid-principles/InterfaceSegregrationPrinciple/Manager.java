public class Manager {
	
	private Employee employee;
	
	private EmployeeWorkInterface work;
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public void setEmployeeWorkInterface(EmployeeWorkInterface work) {
		this.work = work;
	}
		
	public void manageEmployee() {
		employee.work();
		employee.applyForLeave();
	}
	
	public void assignWork() {
		work.work();
	}
	
}
