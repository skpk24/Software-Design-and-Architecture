
public class App {

	public static void main(String[] args) {
		Manager manager = new Manager();
		
		manager.setEmployee(new Developer());
		manager.manage();
		
		manager.setEmployee(new Architect());
		manager.manage();
		
	}

}
