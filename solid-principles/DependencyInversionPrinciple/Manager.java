public class Manager {
	
	private Employee employee;
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public void manage() {
		employee.work();
	}
	
}
