public class App {

	public static void main(String[] args) {
		Manager manager = new Manager();
		
		manager.setEmployee(new Architect());
		manager.manageEmployee();
		
		manager.setEmployee(new Developer());
		manager.manageEmployee();
		
		manager.setEmployeeWorkInterface(new Robot());
		manager.assignWork();
	}

}
